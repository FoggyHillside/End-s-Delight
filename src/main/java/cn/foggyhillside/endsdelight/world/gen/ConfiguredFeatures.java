package cn.foggyhillside.endsdelight.world.gen;

import cn.foggyhillside.endsdelight.registry.ModFeatures;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;

public class ConfiguredFeatures<T, T1> {
    public static final ConfiguredFeature<?, ?> CHORUS_SUCCULENT_FEATURE =
            register("chorus_succulent_feature", ModFeatures.CHORUS_SUCCULENT_FEATURE.get()
                    .withConfiguration(new FeatureSpreadConfig(20))
                    .withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).chance(8));

    private static <FC extends IFeatureConfig> ConfiguredFeature register(String key,
                                                                          ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
