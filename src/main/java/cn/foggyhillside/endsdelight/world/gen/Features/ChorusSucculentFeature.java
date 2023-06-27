package cn.foggyhillside.endsdelight.world.gen.Features;

import cn.foggyhillside.endsdelight.registry.BlockRegistry;
import cn.foggyhillside.endsdelight.block.ChorusSucculentBlock;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;

import java.util.Random;

public class ChorusSucculentFeature extends Feature<FeatureSpreadConfig> {
    public ChorusSucculentFeature(Codec<FeatureSpreadConfig> codec) {
        super(codec);
    }

    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, FeatureSpreadConfig config) {
        int i = 0;
        int j = config.getSpread().getSpread(rand);

        for(int k = 0; k < j; ++k) {
            int l = rand.nextInt(8) - rand.nextInt(8);
            int i1 = rand.nextInt(8) - rand.nextInt(8);
            int j1 = reader.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX() + l, pos.getZ() + i1);
            BlockPos blockpos = new BlockPos(pos.getX() + l, j1, pos.getZ() + i1);
            BlockState blockstate = BlockRegistry.ChorusSucculent.get().getDefaultState().with(ChorusSucculentBlock.Succulent, Integer.valueOf(rand.nextInt(3) + 1));
            if (blockstate.isValidPosition(reader, blockpos)) {
                reader.setBlockState(blockpos, blockstate, 2);
                ++i;
            }
        }

        return i > 0;
    }
}
