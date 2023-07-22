package cn.foggyhillside.ends_delight.world.feature;

import cn.foggyhillside.ends_delight.registry.BlockRegistry;
import cn.foggyhillside.ends_delight.block.ChorusSucculentBlock;
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

    public ChorusSucculentFeature(Codec<CountConfiguration> p_66754_) {
        super(p_66754_);
    }

    public boolean place(FeaturePlaceContext<CountConfiguration> p_160316_) {
        int i = 0;
        RandomSource randomsource = p_160316_.random();
        WorldGenLevel worldgenlevel = p_160316_.level();
        BlockPos blockpos = p_160316_.origin();
        int j = p_160316_.config().count().sample(randomsource);

        for(int k = 0; k < j; ++k) {
            int l = randomsource.nextInt(8) - randomsource.nextInt(8);
            int i1 = randomsource.nextInt(8) - randomsource.nextInt(8);
            int j1 = worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, blockpos.getX() + l, blockpos.getZ() + i1);
            BlockPos blockpos1 = new BlockPos(blockpos.getX() + l, j1, blockpos.getZ() + i1);
            BlockState blockstate = BlockRegistry.ChorusSucculent.get().defaultBlockState().setValue(ChorusSucculentBlock.Succulent, Integer.valueOf(randomsource.nextInt(3) + 1));
            if (blockstate.canSurvive(worldgenlevel, blockpos1)) {
                worldgenlevel.setBlock(blockpos1, blockstate, 2);
                ++i;
            }
        }

        return i > 0;
    }
}


