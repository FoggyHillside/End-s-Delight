package cn.foggyhillside.ends_delight.world.gen;

import cn.foggyhillside.ends_delight.registry.ModConfiguredFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ChorusSucculentGeneration {
    public static void generateChorusSucculent(){
        BiomeModifications.addFeature((context) -> {
            return context.getBiomeKey().equals(BiomeKeys.END_HIGHLANDS);
        }, GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.CHORUS_SUCCULENT_KEY.key());
    }
}
