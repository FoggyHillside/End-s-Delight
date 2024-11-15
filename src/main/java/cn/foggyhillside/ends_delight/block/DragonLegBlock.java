package cn.foggyhillside.ends_delight.block;

import cn.foggyhillside.ends_delight.registry.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.utility.TextUtils;

@SuppressWarnings("deprecation")
public class DragonLegBlock extends HorizontalDirectionalBlock {

    public static final MapCodec<DragonLegBlock> CODEC = simpleCodec(DragonLegBlock::new);
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 6);

    protected static final VoxelShape[] SHAPES_NORTH_HEAD = new VoxelShape[]{
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(6.0D, 2.0D, 0.0D, 10.0D, 6.0D, 5.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 5.0D, 5.0D), Block.box(6.0D, 5.0D, 0.0D, 10.0D, 15.0D, 1.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 8.0D, 5.0D), Block.box(6.0D, 8.0D, 0.0D, 10.0D, 15.0D, 1.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 13.0D,3.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 13.0D,6.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 13.0D, 9.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 13.0D, 12.0D)),
    };

    protected static final VoxelShape[] SHAPES_NORTH_FOOT = new VoxelShape[]{
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(6.0D, 2.0D, 11.0D, 10.0D, 6.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 10.0D, 14.0D, 5.0D, 16.0D), Block.box(6.0D, 5.0D, 13.0D, 10.0D, 15.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 10.0D, 14.0D, 8.0D, 16.0D), Block.box(6.0D, 8.0D, 13.0D, 10.0D, 15.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 10.0D, 14.0D, 13.0D, 16.0D), Block.box(6.0D, 5.0D, 3.0D, 10.0D, 9.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 10.0D, 14.0D, 13.0D, 16.0D), Block.box(6.0D, 5.0D, 3.0D, 10.0D, 9.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 10.0D, 14.0D, 13.0D, 16.0D), Block.box(6.0D, 5.0D, 3.0D, 10.0D, 9.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 10.0D, 14.0D, 13.0D, 16.0D), Block.box(6.0D, 5.0D, 3.0D, 10.0D, 9.0D, 10.0D))
    };

    protected static final VoxelShape[] SHAPES_SOUTH_HEAD = new VoxelShape[]{
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(6.0D, 2.0D, 11.0D, 10.0D, 6.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 11.0D, 14.0D, 5.0D, 16.0D), Block.box(6.0D, 5.0D, 15.0D, 10.0D, 15.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 11.0D, 14.0D, 8.0D, 16.0D), Block.box(6.0D, 8.0D, 15.0D, 10.0D, 15.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 13.0D, 14.0D, 13.0D,16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 10.0D, 14.0D, 13.0D,16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 7.0D, 14.0D, 13.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 4.0D, 14.0D, 13.0D, 16.0D)),
    };

    protected static final VoxelShape[] SHAPES_SOUTH_FOOT = new VoxelShape[]{
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(6.0D, 2.0D, 0.0D, 10.0D, 6.0D, 5.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 5.0D, 6.0D), Block.box(6.0D, 5.0D, 0.0D, 10.0D, 15.0D, 3.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 8.0D, 6.0D), Block.box(6.0D, 8.0D, 0.0D, 10.0D, 15.0D, 3.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 13.0D, 6.0D), Block.box(6.0D, 5.0D, 6.0D, 10.0D, 9.0D, 13.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 13.0D, 6.0D), Block.box(6.0D, 5.0D, 6.0D, 10.0D, 9.0D, 13.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 13.0D, 6.0D), Block.box(6.0D, 5.0D, 6.0D, 10.0D, 9.0D, 13.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 14.0D, 13.0D, 6.0D), Block.box(6.0D, 5.0D, 6.0D, 10.0D, 9.0D, 13.0D))
    };

    protected static final VoxelShape[] SHAPES_WEST_HEAD = new VoxelShape[]{
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 6.0D, 5.0D, 6.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 5.0D, 5.0D, 14.0D), Block.box(0.0D, 5.0D, 6.0D, 1.0D, 15.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 5.0D, 8.0D, 14.0D), Block.box(0.0D, 8.0D, 6.0D, 1.0D, 15.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 3.0D, 13.0D,14.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 6.0D, 13.0D,14.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 9.0D, 13.0D, 14.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 12.0D, 13.0D, 14.0D)),
    };

    protected static final VoxelShape[] SHAPES_WEST_FOOT = new VoxelShape[]{
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(11.0D, 2.0D, 6.0D, 16.0D, 6.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(10.0D, 2.0D, 2.0D, 16.0D, 5.0D, 14.0D), Block.box(13.0D, 5.0D, 6.0D, 16.0D, 15.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(10.0D, 2.0D, 2.0D, 16.0D, 8.0D, 14.0D), Block.box(13.0D, 8.0D, 6.0D, 16.0D, 15.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(10.0D, 2.0D, 2.0D, 16.0D, 13.0D, 14.0D), Block.box(3.0D, 5.0D, 6.0D, 10.0D, 9.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(10.0D, 2.0D, 2.0D, 16.0D, 13.0D, 14.0D), Block.box(3.0D, 5.0D, 6.0D, 10.0D, 9.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(10.0D, 2.0D, 2.0D, 16.0D, 13.0D, 14.0D), Block.box(3.0D, 5.0D, 6.0D, 10.0D, 9.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(10.0D, 2.0D, 2.0D, 16.0D, 13.0D, 14.0D), Block.box(3.0D, 5.0D, 6.0D, 10.0D, 9.0D, 10.0D))
    };

    protected static final VoxelShape[] SHAPES_EAST_HEAD = new VoxelShape[]{
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(11.0D, 2.0D, 6.0D, 16.0D, 6.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(11.0D, 2.0D, 2.0D, 16.0D, 5.0D, 14.0D), Block.box(15.0D, 5.0D, 6.0D, 16.0D, 15.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(11.0D, 2.0D, 2.0D, 16.0D, 8.0D, 14.0D), Block.box(15.0D, 8.0D, 6.0D, 16.0D, 15.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(13.0D, 2.0D, 2.0D, 16.0D, 13.0D,14.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(10.0D, 2.0D, 2.0D, 16.0D, 13.0D,14.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(7.0D, 2.0D, 2.0D, 16.0D, 13.0D, 14.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(4.0D, 2.0D, 2.0D, 16.0D, 13.0D, 14.0D)),
    };

    protected static final VoxelShape[] SHAPES_EAST_FOOT = new VoxelShape[]{
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 6.0D, 5.0D, 6.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 6.0D, 5.0D, 14.0D), Block.box(0.0D, 5.0D, 6.0D, 3.0D, 15.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 6.0D, 8.0D, 14.0D), Block.box(0.0D, 8.0D, 6.0D, 3.0D, 15.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 6.0D, 13.0D, 14.0D), Block.box(6.0D, 5.0D, 6.0D, 13.0D, 9.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 6.0D, 13.0D, 14.0D), Block.box(6.0D, 5.0D, 6.0D, 13.0D, 9.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 6.0D, 13.0D, 14.0D), Block.box(6.0D, 5.0D, 6.0D, 13.0D, 9.0D, 10.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 6.0D, 13.0D, 14.0D), Block.box(6.0D, 5.0D, 6.0D, 13.0D, 9.0D, 10.0D))
    };


    public DragonLegBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(SERVINGS, 6).setValue(PART, BedPart.HEAD));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.getValue(PART) == BedPart.HEAD) {
            switch (pState.getValue(FACING)) {
                case NORTH:
                    return SHAPES_NORTH_HEAD[pState.getValue(SERVINGS)];
                case SOUTH:
                    return SHAPES_SOUTH_HEAD[pState.getValue(SERVINGS)];
                case WEST:
                    return SHAPES_WEST_HEAD[pState.getValue(SERVINGS)];
                case EAST:
                    return SHAPES_EAST_HEAD[pState.getValue(SERVINGS)];
            }
        }
        if (pState.getValue(PART) == BedPart.FOOT) {
            switch (pState.getValue(FACING)) {
                case NORTH:
                    return SHAPES_NORTH_FOOT[pState.getValue(SERVINGS)];
                case SOUTH:
                    return SHAPES_SOUTH_FOOT[pState.getValue(SERVINGS)];
                case WEST:
                    return SHAPES_WEST_FOOT[pState.getValue(SERVINGS)];
                case EAST:
                    return SHAPES_EAST_FOOT[pState.getValue(SERVINGS)];
            }
        }
        return SHAPES_NORTH_HEAD[pState.getValue(SERVINGS)];
    }

    private static Direction getNeighbourDirection(BedPart pPart, Direction pDirection) {
        return pPart == BedPart.FOOT ? pDirection : pDirection.getOpposite();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, SERVINGS, PART);
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pDirection == getNeighbourDirection(pState.getValue(PART), pState.getValue(FACING))) {
            return pState.canSurvive(pLevel, pPos) && pNeighborState.is(this) && pNeighborState.getValue(PART) != pState.getValue(PART) ? pState : Blocks.AIR.defaultBlockState();
        } else {
            return !pState.canSurvive(pLevel, pPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
        }
    }

    @Override
    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
            BedPart bedpart = pState.getValue(PART);
            if (bedpart == BedPart.FOOT) {
                BlockPos blockpos = pPos.relative(getNeighbourDirection(bedpart, pState.getValue(FACING)));
                BlockState blockstate = pLevel.getBlockState(blockpos);
                if (blockstate.is(this) && blockstate.getValue(PART) == BedPart.HEAD) {
                    pLevel.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                    pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
                }
            }
        }

        return super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getHorizontalDirection();
        BlockPos blockpos = pContext.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(direction);
        Level level = pContext.getLevel();
        return level.getBlockState(blockpos1).canBeReplaced(pContext) && level.getWorldBorder().isWithinBounds(blockpos1) ? this.defaultBlockState().setValue(FACING, direction) : null;
    }

    @Override
    public @Nullable PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide) {
            BlockPos facingPos = pPos.relative(pState.getValue(FACING));
            pLevel.setBlock(facingPos, pState.setValue(PART, BedPart.FOOT), 3);
            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);
        }
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        int servings = pState.getValue(SERVINGS);
        ItemStack heldStack = pPlayer.getItemInHand(pHand);

        if (!(servings == 0)) {
            if (heldStack.is(Items.BOWL)) {
                return takeServing(pLevel, pPos, pState, pPlayer, pHand, ModItems.DRAGON_LEG_WITH_SAUCE.get());
            } else {
                pPlayer.displayClientMessage(TextUtils.getTranslation("block.feast.use_container", new ItemStack(Items.BOWL).getHoverName()), true);
            }
        }
        if (servings == 0) {
            pLevel.playSound(null, pPos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
            pLevel.destroyBlock(pPos, true);
        }
        else {
            pPlayer.displayClientMessage(TextUtils.getTranslation("block.feast.use_container", new ItemStack(Items.BOWL).getHoverName()), true);
        }
        return ItemInteractionResult.SUCCESS;
    }

    protected ItemInteractionResult takeServing(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer, InteractionHand pHand, Item serving) {
        int servings = pState.getValue(SERVINGS);
        BedPart part = pState.getValue(PART);
        BlockPos pairPos = pPos.relative(getNeighbourDirection(part, pState.getValue(FACING)));
        BlockState pairState = pLevel.getBlockState(pairPos);
        ItemStack heldItem = pPlayer.getItemInHand(pHand);

        pLevel.setBlock(pairPos, pairState.setValue(SERVINGS, servings - 1), 3);
        pLevel.setBlock(pPos, pState.setValue(SERVINGS, servings - 1), 3);

        if (!pPlayer.isCreative()) {
            heldItem.shrink(1);
        }
        if (!pPlayer.getInventory().add(new ItemStack(serving))) {
            pPlayer.drop(new ItemStack(serving), false);
        }
        pLevel.playSound(null, pPos, SoundEvents.ARMOR_EQUIP_GENERIC.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
        return ItemInteractionResult.SUCCESS;
    }

}
