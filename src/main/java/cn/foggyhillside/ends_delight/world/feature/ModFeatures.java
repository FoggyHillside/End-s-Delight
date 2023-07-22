package cn.foggyhillside.ends_delight.world.feature;

import cn.foggyhillside.ends_delight.EndsDelight;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public abstract class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
            EndsDelight.MODID);
    public static final RegistryObject<ChorusSucculentFeature> CHORUS_SUCCULENT = FEATURES.register("chorus_succulent",
            () -> new ChorusSucculentFeature(CountConfiguration.CODEC));
}
