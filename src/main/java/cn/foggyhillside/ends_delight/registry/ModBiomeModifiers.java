package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModBiomeModifiers {

    private static final ResourceKey<PlacedFeature> CHORUS_SUCCULENT = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(EndsDelight.MOD_ID, "chorus_succulent"));

    public static void init() {
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.CHORUS_SUCCULENT), GenerationStep.Decoration.VEGETAL_DECORATION, CHORUS_SUCCULENT);
    }

}
