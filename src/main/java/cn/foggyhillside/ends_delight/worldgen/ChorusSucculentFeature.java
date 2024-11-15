package cn.foggyhillside.ends_delight.worldgen;

import cn.foggyhillside.ends_delight.block.ChorusSucculentBlock;
import cn.foggyhillside.ends_delight.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;

public class ChorusSucculentFeature extends Feature<CountConfiguration> {

    public ChorusSucculentFeature(Codec<CountConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CountConfiguration> pContext) {
        int i = 0;
        RandomSource randomsource = pContext.random();
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        int j = pContext.config().count().sample(randomsource);

        for (int k = 0; k < j; ++k) {
            int l = randomsource.nextInt(8) - randomsource.nextInt(8);
            int i1 = randomsource.nextInt(8) - randomsource.nextInt(8);
            int j1 = worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, blockpos.getX() + l, blockpos.getZ() + i1);
            BlockPos blockpos1 = new BlockPos(blockpos.getX() + l, j1, blockpos.getZ() + i1);
            BlockState blockstate = ModBlocks.CHORUS_SUCCULENT.get().defaultBlockState().setValue(ChorusSucculentBlock.SUCCULENT, Integer.valueOf(randomsource.nextInt(3) + 1));
            if (blockstate.canSurvive(worldgenlevel, blockpos1)) {
                worldgenlevel.setBlock(blockpos1, blockstate, 2);
                ++i;
            }
        }

        return i > 0;

    }

}
