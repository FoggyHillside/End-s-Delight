package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.utility.Utils;
import cn.foggyhillside.ends_delight.worldgen.ChorusSucculentFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;

import java.util.function.Supplier;

public class ModBiomeFeatures {

    public static <B extends Feature<?>> Supplier<B> regFeature(String name, Supplier<B> supplier) {
        return Utils.register(name, supplier, BuiltInRegistries.FEATURE);
    }

    public static final Supplier<Feature<CountConfiguration>> CHORUS_SUCCULENT = regFeature("chorus_succulent",
            () -> new ChorusSucculentFeature(CountConfiguration.CODEC));

    public static void touch() {

    }
}
