package cn.foggyhillside.endsdelight.world.feature;

import cn.foggyhillside.endsdelight.registry.ModFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<CountConfiguration, ?>> CHORUS_SUCCULENT =
            FeatureUtils.register("chorus_succulent", ModFeatures.CHORUS_SUCCULENT.get(),
                    new CountConfiguration(20));

}
