package cn.foggyhillside.ends_delight.block;

import cn.foggyhillside.ends_delight.state.BlockStatePropertiesRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;

public class ChorusSucculentBlock extends BushBlock implements BonemealableBlock {

    public static final IntegerProperty Succulent = BlockStatePropertiesRegistry.SUCCULENT_1_3;
    protected static final VoxelShape ONE_SHAPE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 6.0D, 10.0D);
    protected static final VoxelShape TWO_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D);
    protected static final VoxelShape THREE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);

    public ChorusSucculentBlock(Properties proprieties) {
        super(proprieties);
        this.registerDefaultState(this.stateDefinition.any().setValue(Succulent, Integer.valueOf(1)));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.is(this)) {
            return blockstate.setValue(Succulent, Integer.valueOf(Math.min(3, blockstate.getValue(Succulent) + 1)));
        }
        return super.getStateForPlacement(context);
    }

    protected boolean mayPlaceOn(BlockState p_56127_, BlockGetter p_56128_, BlockPos p_56129_) {
        return !p_56127_.getCollisionShape(p_56128_, p_56129_).getFaceShape(Direction.UP).isEmpty() || p_56127_.isFaceSturdy(p_56128_, p_56129_, Direction.UP);
    }

    public boolean canSurvive(BlockState p_56109_, LevelReader p_56110_, BlockPos p_56111_) {
        BlockPos blockpos = p_56111_.below();
        return this.mayPlaceOn(p_56110_.getBlockState(blockpos), p_56110_, blockpos);
    }

    public boolean canBeReplaced(BlockState p_56101_, BlockPlaceContext p_56102_) {
        return !p_56102_.isSecondaryUseActive() && p_56102_.getItemInHand().is(this.asItem()) && p_56101_.getValue(Succulent) < 3 ? true : super.canBeReplaced(p_56101_, p_56102_);
    }

    public VoxelShape getShape(BlockState p_56122_, BlockGetter p_56123_, BlockPos p_56124_, CollisionContext p_56125_) {
        switch(p_56122_.getValue(Succulent)) {
            case 1:
            default:
                return ONE_SHAPE;
            case 2:
                return TWO_SHAPE;
            case 3:
                return THREE_SHAPE;
        }
    }

    public BlockState updateShape(BlockState p_56113_, Direction p_56114_, BlockState p_56115_, LevelAccessor p_56116_, BlockPos p_56117_, BlockPos p_56118_) {
        if (!p_56113_.canSurvive(p_56116_, p_56117_)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(p_56113_, p_56114_, p_56115_, p_56116_, p_56117_, p_56118_);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_256559_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_) {
        return true;
    }

    public boolean isBonemealSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_, BlockState p_220881_) {
        return true;
    }

    public void performBonemeal(ServerLevel p_220874_, RandomSource p_220875_, BlockPos p_220876_, BlockState p_220877_) {
        if (p_220874_.getBlockState(p_220876_.below()).is(Tags.Blocks.END_STONES)) {
            p_220874_.setBlock(p_220876_, p_220877_.setValue(Succulent, 3), 3);
        }
    }

    public boolean isPathfindable(BlockState p_56104_, BlockGetter p_56105_, BlockPos p_56106_, PathComputationType p_56107_) {
        return false;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56120_) {
        p_56120_.add(Succulent);
    }
}
