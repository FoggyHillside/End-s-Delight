package cn.foggyhillside.endsdelight.world.gen.Features;

import cn.foggyhillside.endsdelight.block.BlockRegistry;
import cn.foggyhillside.endsdelight.block.ChorusSucculentBlock;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class ChorusSucculentFeature extends Feature<NoFeatureConfig> {

    public ChorusSucculentFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    public boolean isAirOrLeaves(IWorldGenerationBaseReader reader, BlockPos pos) {
        if (!(reader instanceof IWorldReader)) {
            return reader.hasBlockState(pos, (state) -> state.isAir() || state.isIn(BlockTags.LEAVES));
        }
        else {
            return reader.hasBlockState(pos, state -> state.canBeReplacedByLeaves((IWorldReader)  reader, pos));
        }
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos,
                            NoFeatureConfig config) {
        while (pos.getY() > 1 && isAirOrLeaves(reader, pos)) {
            pos = pos.down();
        }
        pos = pos.up();

            BlockState ChorusSucculent = BlockRegistry.ChorusSucculent.get().getDefaultState()
                    .with(ChorusSucculentBlock.Succulent, rand.nextInt(3) + 1);;
            setBlockState(reader, pos.up(0), ChorusSucculent);
        return false;
    }
}
