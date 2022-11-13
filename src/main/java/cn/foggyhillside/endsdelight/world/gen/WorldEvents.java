package cn.foggyhillside.endsdelight.world.gen;

import cn.foggyhillside.endsdelight.Utils;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID)
public class WorldEvents {

    @SubscribeEvent
    public static void biomesLoadingEvent(final BiomeLoadingEvent event) {
        ModFeatures.generationChorusSucculent(event);
    }
}
