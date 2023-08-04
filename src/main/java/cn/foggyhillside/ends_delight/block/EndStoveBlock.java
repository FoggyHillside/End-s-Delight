package cn.foggyhillside.ends_delight.block;

import cn.foggyhillside.ends_delight.blockentity.EndStoveBlockEntity;
import cn.foggyhillside.ends_delight.registry.ModBlockEntity;
import com.nhoryzon.mc.farmersdelight.registry.DamageSourcesRegistry;
import com.nhoryzon.mc.farmersdelight.registry.SoundsRegistry;
import com.nhoryzon.mc.farmersdelight.util.MathUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EndStoveBlock extends BlockWithEntity {
    public static final DirectionProperty FACING;
    public static final BooleanProperty LIT;

    public EndStoveBlock() {
        super(FabricBlockSettings.copyOf(Blocks.BRICKS).luminance((state) -> {
            return Boolean.TRUE.equals(state.get(Properties.LIT)) ? 13 : 0;
        }));
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.getStateManager().getDefaultState()).with(FACING, Direction.NORTH)).with(LIT, false));
    }

    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntity.EndStove.instantiate(pos, state);
    }

    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntity.EndStove, EndStoveBlockEntity::tick);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!Boolean.TRUE.equals(state.get(LIT)) && this.tryLightUpByPlayerHand(state, world, pos, player, hand) == ActionResult.SUCCESS) {
            return ActionResult.SUCCESS;
        } else {
            BlockEntity var8 = world.getBlockEntity(pos);
            if (var8 instanceof EndStoveBlockEntity) {
                EndStoveBlockEntity stoveBlockEntity = (EndStoveBlockEntity)var8;
                return this.onUseByPlayerHand(stoveBlockEntity, state, world, pos, player, hand);
            } else {
                return ActionResult.PASS;
            }
        }
    }

    protected ActionResult onUseByPlayerHand(EndStoveBlockEntity stoveBlockEntity, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Optional<CampfireCookingRecipe> optional = stoveBlockEntity.findMatchingRecipe(itemStack);
        if (optional.isEmpty()) {
            return this.tryExtinguishByPlayerHand(state, world, pos, player, hand);
        } else if (!world.isClient() && !stoveBlockEntity.isStoveBlockedAbove() && stoveBlockEntity.addItem(player.getAbilities().creativeMode ? itemStack.copy() : itemStack, ((CampfireCookingRecipe)optional.get()).getCookTime())) {
            player.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.CONSUME;
        }
    }

    protected ActionResult tryLightUpByPlayerHand(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ActionResult actionResult = ActionResult.PASS;
        ItemStack stackHand = player.getStackInHand(hand);
        if (stackHand.getItem() instanceof FlintAndSteelItem) {
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, MathUtils.RAND.nextFloat() * 0.4F + 0.8F);
            stackHand.damage(1, player, (playerEntity) -> {
                playerEntity.sendToolBreakStatus(hand);
            });
            actionResult = ActionResult.SUCCESS;
        } else if (stackHand.getItem() instanceof FireChargeItem) {
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, (MathUtils.RAND.nextFloat() - MathUtils.RAND.nextFloat()) * 0.2F + 1.0F);
            if (!player.isCreative()) {
                stackHand.decrement(1);
            }

            actionResult = ActionResult.SUCCESS;
        }

        if (actionResult.isAccepted()) {
            world.setBlockState(pos, (BlockState)state.with(LIT, Boolean.TRUE), 11);
        }

        return actionResult;
    }

    protected ActionResult tryExtinguishByPlayerHand(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack stackHand = player.getStackInHand(hand);
        Item usedItem = stackHand.getItem();
        if (!stackHand.isIn(ConventionalItemTags.SHOVELS) && usedItem != Items.WATER_BUCKET) {
            return ActionResult.PASS;
        } else {
            this.extinguish(state, world, pos);
            if (!player.isCreative() && usedItem == Items.WATER_BUCKET) {
                player.setStackInHand(hand, new ItemStack(Items.BUCKET));
            }

            return ActionResult.SUCCESS;
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{FACING, LIT});
    }

    public @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        return (BlockState)((BlockState)this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite())).with(LIT, true);
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        boolean isLit = (Boolean)world.getBlockState(pos).get(LIT);
        if (isLit && !entity.isFireImmune() && entity instanceof LivingEntity livingEntity) {
            if (!EnchantmentHelper.hasFrostWalker(livingEntity)) {
                entity.damage(DamageSourcesRegistry.STOVE_BLOCK, 1.0F);
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (Boolean.TRUE.equals(state.get(CampfireBlock.LIT))) {
            double dx = (double)pos.getX() + 0.5;
            double dy = (double)pos.getY();
            double dz = (double)pos.getZ() + 0.5;
            if (random.nextInt(10) == 0) {
                world.playSound(dx, dy, dz, SoundsRegistry.BLOCK_STOVE_CRACKLE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = (Direction)state.get(FACING);
            Direction.Axis axis = direction.getAxis();
            double d0 = random.nextDouble() * 0.6 - 0.3;
            double d1 = axis == Direction.Axis.X ? (double)direction.getOffsetX() * 0.52 : d0;
            double d2 = random.nextDouble() * 6.0 / 16.0;
            double d3 = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * 0.52 : d0;
            world.addParticle(ParticleTypes.SMOKE, dx + d1, dy + d2, dz + d3, 0.0, 0.0, 0.0);
            world.addParticle(ParticleTypes.FLAME, dx + d1, dy + d2, dz + d3, 0.0, 0.0, 0.0);
        }

    }

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity var7 = world.getBlockEntity(pos);
            if (var7 instanceof EndStoveBlockEntity) {
                EndStoveBlockEntity stoveBlockEntity = (EndStoveBlockEntity)var7;
                ItemScatterer.spawn(world, pos, stoveBlockEntity.getInventory());
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }

    }

    private void extinguish(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, (BlockState)state.with(LIT, false));
        double dx = (double)pos.getX() + 0.5;
        double dy = (double)pos.getY();
        double dz = (double)pos.getZ() + 0.5;
        world.playSound(dx, dy, dz, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F, false);
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
        LIT = Properties.LIT;
    }
}