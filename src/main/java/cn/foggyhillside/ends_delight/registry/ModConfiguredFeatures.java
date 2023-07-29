package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public enum ModConfiguredFeatures {

    CHORUS_SUCCULENT_KEY("chorus_succulent");

    private final Identifier featureIdentifier;
    private RegistryKey<ConfiguredFeature<?, ?>> configuredFeatureRegistryKey;
    private RegistryKey<PlacedFeature> featureRegistryKey;

    private ModConfiguredFeatures(String featurePathName) {
        this.featureIdentifier = new Identifier(EndsDelight.MOD_ID, featurePathName);
    }

    public static void registerConfiguredFeatures() {
        ModConfiguredFeatures[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            ModConfiguredFeatures value = var0[var2];
            value.configuredFeatureRegistryKey = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, value.featureIdentifier);
            value.featureRegistryKey = RegistryKey.of(RegistryKeys.PLACED_FEATURE, value.featureIdentifier);
        }

    }

    public RegistryKey<ConfiguredFeature<? extends FeatureConfig, ?>> configKey() {
        return this.configuredFeatureRegistryKey;
    }

    public RegistryKey<PlacedFeature> key() {
        return this.featureRegistryKey;
    }

    public Identifier identifier() {
        return this.featureIdentifier;
    }
}

