package cn.foggyhillside.endsdelight.world.gen;

import cn.foggyhillside.endsdelight.Utils;
import cn.foggyhillside.endsdelight.world.gen.Features.ChorusSucculentFeature;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ChorusPlantFeature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
            Utils.MOD_ID);

    public static final RegistryObject<ChorusSucculentFeature> CHORUS_SUCCULENT_FEATURE = FEATURES
            .register("chorus_succulent_feature", () -> new ChorusSucculentFeature(NoFeatureConfig.CODEC));

    public static void generationChorusSucculent(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        boolean biomeCriteria = false;
        if (new ResourceLocation("end_highlands").equals(event.getName()))
            biomeCriteria = true;
        if (new ResourceLocation("end_midlands").equals(event.getName()))
            biomeCriteria = true;
        if (!biomeCriteria)
            return;
        {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ConfiguredFeatures.CHORUS_SUCCULENT_FEATURE);
        }
    }
}
