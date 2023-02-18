package cn.foggyhillside.endsdelight.world.feature;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.world.feature.ChorusSucculentFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public abstract class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
            EndsDelight.MOD_ID);
    public static final RegistryObject<ChorusSucculentFeature> CHORUS_SUCCULENT = FEATURES.register("chorus_succulent",
            () -> new ChorusSucculentFeature(CountConfiguration.CODEC));
}
