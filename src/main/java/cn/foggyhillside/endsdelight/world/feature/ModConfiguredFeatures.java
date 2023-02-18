package cn.foggyhillside.endsdelight.world.feature;

import cn.foggyhillside.endsdelight.EndsDelight;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, EndsDelight.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> CHORUS_SUCCULENT = CONFIGURED_FEATURE.register("chorus_succulent",
            ()-> new ConfiguredFeature<>(ModFeatures.CHORUS_SUCCULENT.get(),
                    new CountConfiguration(20)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURE.register(eventBus);
    }
}