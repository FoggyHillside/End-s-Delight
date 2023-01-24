package cn.foggyhillside.endsdelight.world;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.world.gen.ChorusSucculentGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndsDelight.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ChorusSucculentGeneration.generationChorusSucculent(event);
    }
}
