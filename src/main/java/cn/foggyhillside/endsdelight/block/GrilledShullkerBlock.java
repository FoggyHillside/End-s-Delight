package cn.foggyhillside.endsdelight.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import vectorwing.farmersdelight.blocks.FeastBlock;

import java.util.function.Supplier;

public class GrilledShullkerBlock extends FeastBlock{
    protected static final VoxelShape ONE_SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);
    protected static final VoxelShape TWO_SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);

    public GrilledShullkerBlock(AbstractBlock.Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(SERVINGS)) {
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
