package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.worldgen.ChorusSucculentFeature;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;

import java.util.function.Supplier;

public class ModBiomeFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE,
            EndsDelight.MOD_ID);
    public static final Supplier<Feature<CountConfiguration>> CHORUS_SUCCULENT = FEATURES.register("chorus_succulent",
            () -> new ChorusSucculentFeature(CountConfiguration.CODEC));

}
