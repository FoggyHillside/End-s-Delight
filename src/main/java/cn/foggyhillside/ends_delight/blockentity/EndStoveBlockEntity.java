package cn.foggyhillside.ends_delight.blockentity;

import cn.foggyhillside.ends_delight.block.EndStoveBlock;
import cn.foggyhillside.ends_delight.registry.ModBlockEntity;
import com.nhoryzon.mc.farmersdelight.util.MathUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Clearable;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EndStoveBlockEntity extends BlockEntity implements Clearable {
    public static final String TAG_KEY_COOKING_TIMES = "CookingTimes";
    public static final String TAG_KEY_COOKING_TOTAL_TIMES = "CookingTotalTimes";
    private static final VoxelShape GRILLING_AREA = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 1.0, 13.0);
    private static final int MAX_STACK_SIZE = 6;
    private final int[] cookingTimes;
    private final int[] cookingTotalTimes;
    protected final DefaultedList<ItemStack> inventory;

    private EndStoveBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
        super(type, blockPos, blockState);
        this.cookingTimes = new int[6];
        this.cookingTotalTimes = new int[6];
        this.inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);
    }

    public EndStoveBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(ModBlockEntity.EndStove, blockPos, blockState);
    }

    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        this.inventory.clear();
        Inventories.readNbt(tag, this.inventory);
        int[] cookingTotalTimeRead;
        if (tag.contains("CookingTimes", 11)) {
            cookingTotalTimeRead = tag.getIntArray("CookingTimes");
            System.arraycopy(cookingTotalTimeRead, 0, this.cookingTimes, 0, Math.min(this.cookingTotalTimes.length, cookingTotalTimeRead.length));
        }

        if (tag.contains("CookingTotalTimes", 11)) {
            cookingTotalTimeRead = tag.getIntArray("CookingTotalTimes");
            System.arraycopy(cookingTotalTimeRead, 0, this.cookingTotalTimes, 0, Math.min(this.cookingTotalTimes.length, cookingTotalTimeRead.length));
        }

    }

    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        Inventories.writeNbt(tag, this.inventory, true);
        tag.putIntArray("CookingTimes", this.cookingTimes);
        tag.putIntArray("CookingTotalTimes", this.cookingTotalTimes);
    }

    public static void tick(World world, BlockPos pos, BlockState state, EndStoveBlockEntity blockEntity) {
        boolean isStoveLit = (Boolean)blockEntity.getCachedState().get(EndStoveBlock.LIT);
        boolean isStoveBlocked = blockEntity.isStoveBlockedAbove();
        if (world != null && world.isClient()) {
            if (isStoveLit) {
                blockEntity.addParticles();
            }
        } else {
            if (world != null && isStoveBlocked && !blockEntity.inventory.isEmpty()) {
                ItemScatterer.spawn(world, pos, blockEntity.inventory);
                blockEntity.inventoryChanged();
            }

            if (isStoveLit && !isStoveBlocked) {
                blockEntity.cookAndDrop();
            } else {
                blockEntity.fadeCooking();
            }
        }

    }

    public DefaultedList<ItemStack> getInventory() {
        return this.inventory;
    }

    public void clear() {
        this.inventory.clear();
    }

    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound nbtCompound = new NbtCompound();
        Inventories.writeNbt(nbtCompound, this.inventory, true);
        return nbtCompound;
    }

    public Optional<CampfireCookingRecipe> findMatchingRecipe(ItemStack itemStack) {
        return this.world != null && !this.inventory.stream().noneMatch(ItemStack::isEmpty) ? this.world.getRecipeManager().getFirstMatch(RecipeType.CAMPFIRE_COOKING, new SimpleInventory(new ItemStack[]{itemStack}), this.world) : Optional.empty();
    }

    public boolean isStoveBlockedAbove() {
        if (this.world != null) {
            BlockState above = this.world.getBlockState(this.pos.up());
            return VoxelShapes.matchesAnywhere(GRILLING_AREA, above.getOutlineShape(this.world, this.pos.up()), BooleanBiFunction.AND);
        } else {
            return false;
        }
    }

    private void addParticles() {
        World world = this.getWorld();
        if (world != null) {
            BlockPos blockpos = this.getPos();
            Random random = world.random;

            for(int j = 0; j < this.inventory.size(); ++j) {
                if (!((ItemStack)this.inventory.get(j)).isEmpty() && random.nextFloat() < 0.2F) {
                    double d0 = (double)blockpos.getX() + 0.5;
                    double d1 = (double)blockpos.getY() + 1.0;
                    double d2 = (double)blockpos.getZ() + 0.5;
                    Vec2f v1 = this.getStoveItemOffset(j);
                    Direction direction = (Direction)this.getCachedState().get(EndStoveBlock.FACING);
                    int directionIndex = direction.getHorizontal();
                    Vec2f offset = directionIndex % 2 == 0 ? v1 : new Vec2f(v1.y, v1.x);
                    double d5 = d0 - (double)((float)direction.getOffsetX() * offset.x) + (double)((float)direction.rotateYClockwise().getOffsetX() * offset.x);
                    double d7 = d2 - (double)((float)direction.getOffsetZ() * offset.y) + (double)((float)direction.rotateYClockwise().getOffsetZ() * offset.y);

                    for(int k = 0; k < 3; ++k) {
                        world.addParticle(ParticleTypes.SMOKE, d5, d1, d7, 0.0, 5.0E-4, 0.0);
                    }
                }
            }
        }

    }

    public Vec2f getStoveItemOffset(int index) {
        float xOffset = 0.3F;
        float yOffset = 0.2F;
        Vec2f[] offsets = new Vec2f[]{new Vec2f(0.3F, 0.2F), new Vec2f(0.0F, 0.2F), new Vec2f(-0.3F, 0.2F), new Vec2f(0.3F, -0.2F), new Vec2f(0.0F, -0.2F), new Vec2f(-0.3F, -0.2F)};
        return offsets[index];
    }

    private void inventoryChanged() {
        this.markDirty();
        if (this.world != null) {
            this.world.updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), 3);
        }

    }

    private void cookAndDrop() {
        for(int i = 0; i < this.inventory.size(); ++i) {
            ItemStack itemstack = (ItemStack)this.inventory.get(i);
            if (!itemstack.isEmpty()) {
                int var10002 = this.cookingTimes[i]++;
                if (this.cookingTimes[i] >= this.cookingTotalTimes[i]) {
                    if (this.world != null) {
                        Inventory cookInventory = new SimpleInventory(new ItemStack[]{itemstack});
                        ItemStack result = (ItemStack)this.world.getRecipeManager().getAllMatches(RecipeType.CAMPFIRE_COOKING, cookInventory, this.world).stream().map((recipe) -> {
                            return recipe.craft(cookInventory);
                        }).findAny().orElse(itemstack);
                        if (!result.isEmpty()) {
                            ItemEntity entity = new ItemEntity(this.world, (double)this.pos.getX() + 0.5, (double)this.pos.getY() + 1.0, (double)this.pos.getZ() + 0.5, result.copy());
                            entity.setVelocity(MathUtils.RAND.nextGaussian() * 0.009999999776482582, 0.10000000149011612, MathUtils.RAND.nextGaussian() * 0.009999999776482582);
                            this.world.spawnEntity(entity);
                        }
                    }

                    this.inventory.set(i, ItemStack.EMPTY);
                    this.inventoryChanged();
                }
            }
        }

    }

    private void fadeCooking() {
        for(int i = 0; i < this.inventory.size(); ++i) {
            if (this.cookingTimes[i] > 0) {
                this.cookingTimes[i] = MathHelper.clamp(this.cookingTimes[i] - 2, 0, this.cookingTotalTimes[i]);
            }
        }

    }

    public boolean addItem(ItemStack itemStack, int cookTime) {
        for(int i = 0; i < this.inventory.size(); ++i) {
            ItemStack itemstack = (ItemStack)this.inventory.get(i);
            if (itemstack.isEmpty()) {
                this.cookingTotalTimes[i] = cookTime;
                this.cookingTimes[i] = 0;
                this.inventory.set(i, itemStack.split(1));
                this.inventoryChanged();
                return true;
            }
        }

        return false;
    }
}
