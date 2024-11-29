package cn.foggyhillside.ends_delight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.shapes.CollisionContext;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.function.Supplier;

public class DragonEggFeastBlock extends FeastBlock {

    protected static final net.minecraft.world.phys.shapes.VoxelShape SHAPE = net.minecraft.world.level.block.Block.box(1.0D, 0.0D, 1.0D, 15.0D, 11.0D, 15.0D);

    public DragonEggFeastBlock(Properties properties, Supplier<net.minecraft.world.item.Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    public net.minecraft.world.phys.shapes.VoxelShape getShape(net.minecraft.world.level.block.state.BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

}
