package cn.foggyhillside.endsdelight.tile;

import cn.foggyhillside.endsdelight.block.EndStoveBlock;
import cn.foggyhillside.endsdelight.registry.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CampfireCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraftforge.items.ItemStackHandler;
import vectorwing.farmersdelight.mixin.accessors.RecipeManagerAccessor;
import vectorwing.farmersdelight.tile.FDSyncedTileEntity;
import vectorwing.farmersdelight.utils.ItemUtils;

import java.util.Optional;

public class EndStoveTileEntity extends FDSyncedTileEntity implements ITickableTileEntity {
    private static final VoxelShape GRILLING_AREA = Block.makeCuboidShape(3.0, 0.0, 3.0, 13.0, 1.0, 13.0);
    private static final int INVENTORY_SLOT_COUNT = 6;
    private final ItemStackHandler inventory = this.createHandler();
    private final int[] cookingTimes = new int[6];
    private final int[] cookingTimesTotal = new int[6];
    private ResourceLocation[] lastRecipeIDs = new ResourceLocation[6];

    public EndStoveTileEntity() {
        super((TileEntityType) ModTileEntityTypes.END_STOVE.get());
    }

    public void read(BlockState state, CompoundNBT compound) {
        super.read(state, compound);
        if (compound.contains("Inventory")) {
            this.inventory.deserializeNBT(compound.getCompound("Inventory"));
        } else {
            this.inventory.deserializeNBT(compound);
        }

        int[] arrayCookingTimesTotal;
        if (compound.contains("CookingTimes", 11)) {
            arrayCookingTimesTotal = compound.getIntArray("CookingTimes");
            System.arraycopy(arrayCookingTimesTotal, 0, this.cookingTimes, 0, Math.min(this.cookingTimesTotal.length, arrayCookingTimesTotal.length));
        }

        if (compound.contains("CookingTotalTimes", 11)) {
            arrayCookingTimesTotal = compound.getIntArray("CookingTotalTimes");
            System.arraycopy(arrayCookingTimesTotal, 0, this.cookingTimesTotal, 0, Math.min(this.cookingTimesTotal.length, arrayCookingTimesTotal.length));
        }

    }

    public CompoundNBT write(CompoundNBT compound) {
        this.writeItems(compound);
        compound.putIntArray("CookingTimes", this.cookingTimes);
        compound.putIntArray("CookingTotalTimes", this.cookingTimesTotal);
        return compound;
    }

    private CompoundNBT writeItems(CompoundNBT compound) {
        super.write(compound);
        compound.put("Inventory", this.inventory.serializeNBT());
        return compound;
    }

    public void tick() {
        if (this.world != null) {
            boolean isStoveLit = (Boolean)this.getBlockState().get(EndStoveBlock.LIT);
            if (this.world.isRemote) {
                if (isStoveLit) {
                    this.addParticles();
                }
            } else if (this.isStoveBlockedAbove()) {
                if (!ItemUtils.isInventoryEmpty(this.inventory)) {
                    ItemUtils.dropItems(this.world, this.pos, this.inventory);
                    this.inventoryChanged();
                }
            } else if (isStoveLit) {
                this.cookAndOutputItems();
            } else {
                for(int i = 0; i < this.inventory.getSlots(); ++i) {
                    if (this.cookingTimes[i] > 0) {
                        this.cookingTimes[i] = MathHelper.clamp(this.cookingTimes[i] - 2, 0, this.cookingTimesTotal[i]);
                    }
                }
            }

        }
    }

    private void cookAndOutputItems() {
        if (this.world != null) {
            boolean didInventoryChange = false;

            for(int i = 0; i < this.inventory.getSlots(); ++i) {
                ItemStack stoveStack = this.inventory.getStackInSlot(i);
                if (!stoveStack.isEmpty()) {
                    int var10002 = this.cookingTimes[i]++;
                    if (this.cookingTimes[i] >= this.cookingTimesTotal[i]) {
                        IInventory inventoryWrapper = new Inventory(new ItemStack[]{stoveStack});
                        Optional<CampfireCookingRecipe> recipe = this.getMatchingRecipe(inventoryWrapper, i);
                        if (recipe.isPresent()) {
                            ItemStack resultStack = ((CampfireCookingRecipe)recipe.get()).getRecipeOutput();
                            if (!resultStack.isEmpty()) {
                                ItemUtils.spawnItemEntity(this.world, resultStack.copy(), (double)this.pos.getX() + 0.5, (double)this.pos.getY() + 1.0, (double)this.pos.getZ() + 0.5, this.world.rand.nextGaussian() * 0.009999999776482582, 0.10000000149011612, this.world.rand.nextGaussian() * 0.009999999776482582);
                            }
                        }

                        this.inventory.setStackInSlot(i, ItemStack.EMPTY);
                        didInventoryChange = true;
                    }
                }
            }

            if (didInventoryChange) {
                this.inventoryChanged();
            }

        }
    }

    public int getNextEmptySlot() {
        for(int i = 0; i < this.inventory.getSlots(); ++i) {
            ItemStack slotStack = this.inventory.getStackInSlot(i);
            if (slotStack.isEmpty()) {
                return i;
            }
        }

        return -1;
    }

    public boolean addItem(ItemStack itemStackIn, CampfireCookingRecipe recipe, int slot) {
        if (0 <= slot && slot < this.inventory.getSlots()) {
            ItemStack slotStack = this.inventory.getStackInSlot(slot);
            if (slotStack.isEmpty()) {
                this.cookingTimesTotal[slot] = recipe.getCookTime();
                this.cookingTimes[slot] = 0;
                this.inventory.setStackInSlot(slot, itemStackIn.split(1));
                this.lastRecipeIDs[slot] = recipe.getId();
                this.inventoryChanged();
                return true;
            }
        }

        return false;
    }

    public Optional<CampfireCookingRecipe> getMatchingRecipe(IInventory recipeWrapper, int slot) {
        if (this.world == null) {
            return Optional.empty();
        } else {
            if (this.lastRecipeIDs[slot] != null) {
                IRecipe<IInventory> recipe = (IRecipe)((RecipeManagerAccessor)this.world.getRecipeManager()).getRecipeMap(IRecipeType.CAMPFIRE_COOKING).get(this.lastRecipeIDs[slot]);
                if (recipe instanceof CampfireCookingRecipe && recipe.matches(recipeWrapper, this.world)) {
                    return Optional.of((CampfireCookingRecipe)recipe);
                }
            }

            return this.world.getRecipeManager().getRecipe(IRecipeType.CAMPFIRE_COOKING, recipeWrapper, this.world);
        }
    }

    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    public boolean isStoveBlockedAbove() {
        if (this.world != null) {
            BlockState above = this.world.getBlockState(this.pos.up());
            return VoxelShapes.compare(GRILLING_AREA, above.getShape(this.world, this.pos.up()), IBooleanFunction.AND);
        } else {
            return false;
        }
    }

    public Vector2f getStoveItemOffset(int index) {
        float X_OFFSET = 0.3F;
        float Y_OFFSET = 0.2F;
        Vector2f[] OFFSETS = new Vector2f[]{new Vector2f(0.3F, 0.2F), new Vector2f(0.0F, 0.2F), new Vector2f(-0.3F, 0.2F), new Vector2f(0.3F, -0.2F), new Vector2f(0.0F, -0.2F), new Vector2f(-0.3F, -0.2F)};
        return OFFSETS[index];
    }

    private void addParticles() {
        if (this.world != null) {
            for(int i = 0; i < this.inventory.getSlots(); ++i) {
                if (!this.inventory.getStackInSlot(i).isEmpty() && this.world.rand.nextFloat() < 0.2F) {
                    Vector2f stoveItemVector = this.getStoveItemOffset(i);
                    Direction direction = (Direction)this.getBlockState().get(EndStoveBlock.HORIZONTAL_FACING);
                    int directionIndex = direction.getHorizontalIndex();
                    Vector2f offset = directionIndex % 2 == 0 ? stoveItemVector : new Vector2f(stoveItemVector.y, stoveItemVector.x);
                    double x = (double)this.pos.getX() + 0.5 - (double)((float)direction.getXOffset() * offset.x) + (double)((float)direction.rotateY().getXOffset() * offset.x);
                    double y = (double)this.pos.getY() + 1.0;
                    double z = (double)this.pos.getZ() + 0.5 - (double)((float)direction.getZOffset() * offset.y) + (double)((float)direction.rotateY().getZOffset() * offset.y);

                    for(int k = 0; k < 3; ++k) {
                        this.world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0, 5.0E-4, 0.0);
                    }
                }
            }

        }
    }

    public CompoundNBT getUpdateTag() {
        return this.writeItems(new CompoundNBT());
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(6) {
            public int getSlotLimit(int slot) {
                return 1;
            }
        };
    }
}

