package cn.foggyhillside.ends_delight.block;

import cn.foggyhillside.ends_delight.block.entity.EndStoveBlockEntity;
import cn.foggyhillside.ends_delight.registry.ModBlockEntityTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.AbstractStoveBlock;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class EndStoveBlock extends AbstractStoveBlock {
    public static final MapCodec<EndStoveBlock> CODEC = simpleCodec(EndStoveBlock::new);

    @Override
    public MapCodec<EndStoveBlock> codec() {
        return CODEC;
    }

    public EndStoveBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        if (!state.getValue(LIT)) return;
        double x = (double) pos.getX() + 0.5D;
        double y = pos.getY();
        double z = (double) pos.getZ() + 0.5D;
        if (rand.nextInt(10) == 0) {
            level.playLocalSound(x, y, z, ModSounds.BLOCK_STOVE_CRACKLE.get(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
        }

        Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
        Direction.Axis direction$axis = direction.getAxis();
        double horizontalOffset = rand.nextDouble() * 0.6D - 0.3D;
        double xOffset = direction$axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52D : horizontalOffset;
        double yOffset = rand.nextDouble() * 6.0D / 16.0D;
        double zOffset = direction$axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52D : horizontalOffset;
        level.addParticle(ParticleTypes.SMOKE, x + xOffset, y + yOffset, z + zOffset, 0.0D, 0.0D, 0.0D);
        level.addParticle(ParticleTypes.FLAME, x + xOffset, y + yOffset, z + zOffset, 0.0D, 0.0D, 0.0D);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntityTypes.END_STOVE.get().create(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide && state.getValue(LIT))
            return createTickerHelper(blockEntityType, ModBlockEntityTypes.END_STOVE.get(), EndStoveBlockEntity::particleTick);
        return createStoveTicker(level, blockEntityType, ModBlockEntityTypes.END_STOVE.get());
    }
}
