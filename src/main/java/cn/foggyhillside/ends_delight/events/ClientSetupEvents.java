package cn.foggyhillside.ends_delight.events;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.client.renderer.EndStoveRenderer;
import cn.foggyhillside.ends_delight.registry.ModBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.client.renderer.StoveRenderer;

@Mod.EventBusSubscriber(modid = EndsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvents {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer((BlockEntityType) ModBlockEntityTypes.END_STOVE.get(), EndStoveRenderer::new);
    }
}
