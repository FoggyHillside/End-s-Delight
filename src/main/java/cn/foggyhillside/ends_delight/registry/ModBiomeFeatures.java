package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.worldgen.ChorusSucculentFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBiomeFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE,
            EndsDelight.MODID);
    public static final Supplier<Feature<CountConfiguration>> CHORUS_SUCCULENT = FEATURES.register("chorus_succulent",
            () -> new ChorusSucculentFeature(CountConfiguration.CODEC));

}
