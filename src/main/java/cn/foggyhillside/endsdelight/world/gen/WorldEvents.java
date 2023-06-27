package cn.foggyhillside.endsdelight.world.gen;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.registry.ModFeatures;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndsDelight.MOD_ID)
public class WorldEvents {

    @SubscribeEvent
    public static void biomesLoadingEvent(final BiomeLoadingEvent event) {
        ModFeatures.generationChorusSucculent(event);
    }
}
