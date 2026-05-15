package com.plusls.EndsDelight.common.block.entity;

import com.google.common.collect.Lists;
import com.plusls.EndsDelight.common.block.EndStoveBlock;
import com.plusls.EndsDelight.common.capability.ItemHandlerHelper;
import com.plusls.EndsDelight.common.registry.BlockEntityRegistry;
import com.plusls.EndsDelight.common.registry.RecipeTypeRegistry;
import com.plusls.EndsDelight.common.registry.SoundEventRegistry;
import com.plusls.EndsDelight.common.util.ItemUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class EndStoveBlockEntity extends BlockEntity implements WorldlyContainer {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
    private final int[] cookingProgress = new int[4];
    private final int[] cookingTime = new int[4];
    private final RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> quickCheck;

    public EndStoveBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.END_STOVE.get(), pos, blockState);
        this.quickCheck = RecipeManager.createCheck(RecipeTypeRegistry.END_STOVE_COOKING.get());
    }

    public static void cookTick(Level level, BlockPos pos, BlockState state, EndStoveBlockEntity stove) {
        boolean flag = false;

        for (int i = 0; i < stove.inventory.size(); ++i) {
            ItemStack itemstack = stove.inventory.get(i);
            if (!itemstack.isEmpty()) {
                flag = true;
                ++stove.cookingProgress[i];

                if (stove.cookingProgress[i] >= stove.cookingTime[i]) {
                    SingleRecipeInput singleRecipeInput = new SingleRecipeInput(itemstack);
                    ItemStack itemstack1 = level.getRecipeManager()
                            .getRecipeFor(RecipeTypeRegistry.END_STOVE_COOKING.get(), singleRecipeInput, level)
                            .map(recipe -> recipe.value().assemble(singleRecipeInput, level.registryAccess()))
                            .orElse(itemstack);

                    if (itemstack1.isItemEnabled(level.enabledFeatures())) {
                        Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), itemstack1);
                        stove.inventory.set(i, ItemStack.EMPTY);
                        level.sendBlockUpdated(pos, state, state, 3);
                        level.gameEvent(null, net.minecraft.world.level.gameevent.GameEvent.BLOCK_CHANGE, pos);
                    }
                }
            }
        }

        if (flag) {
            setChanged(level, pos, state);
        }
    }

    public static void cooldownTick(Level level, BlockPos pos, BlockState state, EndStoveBlockEntity stove) {
        boolean flag = false;

        for (int i = 0; i < stove.inventory.size(); ++i) {
            if (stove.cookingProgress[i] > 0) {
                flag = true;
                stove.cookingProgress[i] = Mth.clamp(stove.cookingProgress[i] - 2, 0, stove.cookingTime[i]);
            }
        }

        if (flag) {
            setChanged(level, pos, state);
        }
    }

    public static void particleTick(Level level, BlockPos pos, BlockState state, EndStoveBlockEntity stove) {
        if (level.random.nextFloat() < 0.11F) {
            for (int i = 0; i < level.random.nextInt(2) + 2; ++i) {
                CampfireBlock.makeParticles(level, pos, state.getValue(EndStoveBlock.LIT), false);
            }
        }

        int direction = state.getValue(EndStoveBlock.FACING).get2DDataValue();

        for (int j = 0; j < stove.inventory.size(); ++j) {
            if (!stove.inventory.get(j).isEmpty() && level.random.nextFloat() < 0.2F) {
                Direction direction1 = Direction.from2DDataValue(Math.floorMod(j + direction, 4));
                float f = 0.3125F;
                double d0 = pos.getX() + 0.5D - direction1.getStepX() * 0.3125D + direction1.getClockWise().getStepX() * 0.3125D;
                double d1 = pos.getY() + 0.5D;
                double d2 = pos.getZ() + 0.5D - direction1.getStepZ() * 0.3125D + direction1.getClockWise().getStepZ() * 0.3125D;

                for (int k = 0; k < 4; ++k) {
                    level.addParticle(
                            ParticleTypes.SMOKE,
                            d0,
                            d1,
                            d2,
                            0.0D,
                            5.0E-4D,
                            0.0D
                    );
                }
            }
        }
    }

    public NonNullList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return new int[]{0, 1, 2, 3};
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, Direction direction) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return true;
    }

    @Override
    public int getContainerSize() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        return ItemUtils.doesInventoryHaveItems(this.inventory);
    }

    @Override
    public ItemStack getItem(int slot) {
        return this.inventory.get(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        return ContainerHelper.removeItem(this.inventory, slot, amount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(this.inventory, slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        this.inventory.set(slot, stack);
        stack.limitSize(this.getMaxStackSize());
    }

    @Override
    public boolean stillValid(@NotNull net.minecraft.world.entity.player.Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        this.inventory.clear();
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, this.inventory);

        if (tag.contains("CookingTimes", 11)) {
            int[] aint = tag.getIntArray("CookingTimes");
            System.arraycopy(aint, 0, this.cookingTime, 0, Math.min(this.cookingTime.length, aint.length));
        }

        if (tag.contains("CookingProgress", 11)) {
            int[] aint1 = tag.getIntArray("CookingProgress");
            System.arraycopy(aint1, 0, this.cookingProgress, 0, Math.min(this.cookingProgress.length, aint1.length));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.inventory, true);
        tag.putIntArray("CookingProgress", this.cookingProgress);
        tag.putIntArray("CookingTimes", this.cookingTime);
    }

    public Optional<RecipeHolder<CampfireCookingRecipe>> getCookableRecipe(ItemStack stack) {
        return this.quickCheck.getRecipeFor(new SingleRecipeInput(stack), this.level);
    }

    public boolean placeFood(@NotNull ItemStack stack, int cookingTimeIn) {
        for (int i = 0; i < this.inventory.size(); ++i) {
            ItemStack itemstack = this.inventory.get(i);

            if (itemstack.isEmpty()) {
                this.cookingTime[i] = cookingTimeIn;
                this.cookingProgress[i] = 0;
                this.inventory.set(i, stack.split(1));
                this.level.gameEvent(net.minecraft.world.level.gameevent.GameEvent.BLOCK_CHANGE, this.getBlockPos(), net.minecraft.world.level.gameevent.GameEvent.Context.of(this.getBlockState()));
                this.markUpdated();
                return true;
            }
        }

        return false;
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
}
