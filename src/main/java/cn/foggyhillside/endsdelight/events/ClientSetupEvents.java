package cn.foggyhillside.endsdelight.events;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.registry.ModBlockEntityTypes;
import cn.foggyhillside.endsdelight.client.renderer.EndStoveRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvents {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntityTypes.END_STOVE.get(), EndStoveRenderer::new);
    }
}
