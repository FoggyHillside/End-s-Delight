package cn.foggyhillside.ends_delight.block;

import com.nhoryzon.mc.farmersdelight.block.FeastBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class GrilledShullkerBlock extends FeastBlock {

    protected static final VoxelShape ONE_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);
    protected static final VoxelShape TWO_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);

    public GrilledShullkerBlock(Settings settings, Item servingItem, boolean hasLeftovers) {
        super(settings, servingItem, hasLeftovers);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(SERVINGS)) {
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