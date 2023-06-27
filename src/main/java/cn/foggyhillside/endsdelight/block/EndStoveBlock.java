package cn.foggyhillside.endsdelight.block;

import cn.foggyhillside.endsdelight.registry.ModTileEntityTypes;
import cn.foggyhillside.endsdelight.tile.EndStoveTileEntity;
import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CampfireCookingRecipe;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import vectorwing.farmersdelight.registry.ModSounds;
import vectorwing.farmersdelight.utils.ItemUtils;
import vectorwing.farmersdelight.utils.MathUtils;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

public class EndStoveBlock extends HorizontalBlock {
    public static final DamageSource STOVE_DAMAGE = (new DamageSource("farmersdelight.stove")).setFireDamage();
    public static final BooleanProperty LIT;

    public EndStoveBlock(AbstractBlock.Properties builder) {
        super(builder);
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack heldStack = player.getHeldItem(handIn);
        Item heldItem = heldStack.getItem();
        if ((Boolean)state.get(LIT)) {
            if (heldStack.getToolTypes().contains(ToolType.SHOVEL)) {
                this.extinguish(state, worldIn, pos);
                heldStack.damageItem(1, player, (action) -> {
                    action.sendBreakAnimation(handIn);
                });
                return ActionResultType.SUCCESS;
            }

            if (heldItem == Items.WATER_BUCKET) {
                if (!worldIn.isRemote()) {
                    worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                this.extinguish(state, worldIn, pos);
                if (!player.isCreative()) {
                    player.setHeldItem(handIn, new ItemStack(Items.BUCKET));
                }

                return ActionResultType.SUCCESS;
            }
        } else {
            if (heldItem instanceof FlintAndSteelItem) {
                worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, MathUtils.RAND.nextFloat() * 0.4F + 0.8F);
                worldIn.setBlockState(pos, (BlockState)state.with(BlockStateProperties.LIT, Boolean.TRUE), 11);
                heldStack.damageItem(1, player, (action) -> {
                    action.sendBreakAnimation(handIn);
                });
                return ActionResultType.SUCCESS;
            }

            if (heldItem instanceof FireChargeItem) {
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, (MathUtils.RAND.nextFloat() - MathUtils.RAND.nextFloat()) * 0.2F + 1.0F);
                worldIn.setBlockState(pos, (BlockState)state.with(BlockStateProperties.LIT, Boolean.TRUE), 11);
                if (!player.isCreative()) {
                    heldStack.shrink(1);
                }

                return ActionResultType.SUCCESS;
            }
        }

        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (tileEntity instanceof EndStoveTileEntity) {
            EndStoveTileEntity stoveEntity = (EndStoveTileEntity)tileEntity;
            int stoveSlot = stoveEntity.getNextEmptySlot();
            if (stoveSlot < 0 || stoveEntity.isStoveBlockedAbove()) {
                return ActionResultType.PASS;
            }

            Optional<CampfireCookingRecipe> recipe = stoveEntity.getMatchingRecipe(new Inventory(new ItemStack[]{heldStack}), stoveSlot);
            if (recipe.isPresent()) {
                if (!worldIn.isRemote && stoveEntity.addItem(player.abilities.isCreativeMode ? heldStack.copy() : heldStack, (CampfireCookingRecipe)recipe.get(), stoveSlot)) {
                    return ActionResultType.SUCCESS;
                }

                return ActionResultType.CONSUME;
            }
        }

        return ActionResultType.PASS;
    }

    public void extinguish(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, (BlockState)state.with(LIT, false), 2);
        double x = (double)pos.getX() + 0.5;
        double y = (double)pos.getY();
        double z = (double)pos.getZ() + 0.5;
        worldIn.playSound(x, y, z, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F, false);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return (BlockState)((BlockState)this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite())).with(LIT, true);
    }

    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        boolean isLit = (Boolean)worldIn.getBlockState(pos).get(LIT);
        if (isLit && !entityIn.isImmuneToFire() && entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn)) {
            entityIn.attackEntityFrom(STOVE_DAMAGE, 1.0F);
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }

    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof EndStoveTileEntity) {
                ItemUtils.dropItems(worldIn, pos, ((EndStoveTileEntity)tileEntity).getInventory());
            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }

    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(new Property[]{LIT, HORIZONTAL_FACING});
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if ((Boolean)stateIn.get(CampfireBlock.LIT)) {
            double x = (double)pos.getX() + 0.5;
            double y = (double)pos.getY();
            double z = (double)pos.getZ() + 0.5;
            if (rand.nextInt(10) == 0) {
                worldIn.playSound(x, y, z, (SoundEvent) ModSounds.BLOCK_STOVE_CRACKLE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = (Direction)stateIn.get(HorizontalBlock.HORIZONTAL_FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double horizontalOffset = rand.nextDouble() * 0.6 - 0.3;
            double xOffset = direction$axis == Direction.Axis.X ? (double)direction.getXOffset() * 0.52 : horizontalOffset;
            double yOffset = rand.nextDouble() * 6.0 / 16.0;
            double zOffset = direction$axis == Direction.Axis.Z ? (double)direction.getZOffset() * 0.52 : horizontalOffset;
            worldIn.addParticle(ParticleTypes.SMOKE, x + xOffset, y + yOffset, z + zOffset, 0.0, 0.0, 0.0);
            worldIn.addParticle(ParticleTypes.FLAME, x + xOffset, y + yOffset, z + zOffset, 0.0, 0.0, 0.0);
        }

    }

    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ((TileEntityType) ModTileEntityTypes.END_STOVE.get()).create();
    }

    static {
        LIT = BlockStateProperties.LIT;
    }
}
