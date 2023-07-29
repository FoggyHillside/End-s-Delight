package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.world.feature.ChorusSucculentFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {

    public static Feature CHORUS_SUCCULENT = registerFeature("chorus_succulent", new ChorusSucculentFeature(CountConfig.CODEC));

    private static Feature registerFeature(String name, Feature feature){
        return Registry.register(Registries.FEATURE, new Identifier(EndsDelight.MOD_ID, name), feature);
    }

    public static void registerModFeatures(){
        EndsDelight.LOGGER.info("Registering Mod Features for " + EndsDelight.MOD_ID);
    }

}
