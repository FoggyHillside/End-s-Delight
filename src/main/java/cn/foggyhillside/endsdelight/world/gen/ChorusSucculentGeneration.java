package cn.foggyhillside.endsdelight.world.gen;

import cn.foggyhillside.endsdelight.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;

public class ChorusSucculentGeneration {
    public static void generationChorusSucculent(final BiomeLoadingEvent event) {
    ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
    Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

    boolean biomeCriteria = false;
    if (new ResourceLocation("end_highlands").equals(event.getName()))
        biomeCriteria = true;
    if (new ResourceLocation("end_midlands").equals(event.getName()))
        biomeCriteria = true;
    if (!biomeCriteria)
        return;
    {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

        base.add(ModPlacedFeatures.CHORUS_SUCCULENT);
    }
}

}
