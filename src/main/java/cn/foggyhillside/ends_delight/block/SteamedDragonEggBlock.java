package cn.foggyhillside.ends_delight.block;

import com.nhoryzon.mc.farmersdelight.block.FeastBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class SteamedDragonEggBlock extends FeastBlock {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 11.0D, 15.0D);

    public SteamedDragonEggBlock(Settings settings, Item servingItem, boolean hasLeftovers) {
        super(settings, servingItem, hasLeftovers);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
