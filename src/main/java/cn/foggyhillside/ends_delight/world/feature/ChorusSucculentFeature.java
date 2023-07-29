package cn.foggyhillside.ends_delight.world.feature;

import cn.foggyhillside.ends_delight.block.ChorusSucculentBlock;
import cn.foggyhillside.ends_delight.registry.ModBlock;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class ChorusSucculentFeature extends Feature<CountConfig> {

    public ChorusSucculentFeature(Codec<CountConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<CountConfig> context) {
        int i = 0;
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockpos = context.getOrigin();
        int j = ((CountConfig)context.getConfig()).getCount().get(random);

        for(int k = 0; k < j; ++k) {
            int l = random.nextInt(8) - random.nextInt(8);
            int i1 = random.nextInt(8) - random.nextInt(8);
            int j1 = structureWorldAccess.getTopY(Heightmap.Type.WORLD_SURFACE, blockpos.getX() + l, blockpos.getZ() + i1);
            BlockPos blockpos1 = new BlockPos(blockpos.getX() + l, j1, blockpos.getZ() + i1);
            BlockState blockstate = ModBlock.ChorusSucculent.getDefaultState().with(ChorusSucculentBlock.Succulent, Integer.valueOf(random.nextInt(3) + 1));
            if (blockstate.canPlaceAt(structureWorldAccess, blockpos1)) {
                structureWorldAccess.setBlockState(blockpos1, blockstate, 2);
                ++i;
            }
        }

        return i > 0;
    }
}
