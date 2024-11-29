package cn.foggyhillside.ends_delight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.shapes.CollisionContext;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.function.Supplier;

public class GrilledShulkerBlock extends FeastBlock {

    protected static final net.minecraft.world.phys.shapes.VoxelShape ONE_SHAPE = net.minecraft.world.level.block.Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);
    protected static final net.minecraft.world.phys.shapes.VoxelShape TWO_SHAPE = net.minecraft.world.level.block.Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);

    public GrilledShulkerBlock(Properties properties, Supplier<net.minecraft.world.item.Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    public net.minecraft.world.phys.shapes.VoxelShape getShape(net.minecraft.world.level.block.state.BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch(state.getValue(SERVINGS)) {
            case 4:
            case 3:
            case 2:
            case 1:
            default:
                return ONE_SHAPE;
            case 0:
                return TWO_SHAPE;
        }
    }

}
