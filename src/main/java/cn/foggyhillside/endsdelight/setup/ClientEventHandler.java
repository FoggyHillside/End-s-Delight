package cn.foggyhillside.endsdelight.setup;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.registry.ModTileEntityTypes;
import cn.foggyhillside.endsdelight.renderer.EndStoveTileEntityRenderer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EndsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClientEventHandler {
    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntityRenderer((TileEntityType) ModTileEntityTypes.END_STOVE.get(), EndStoveTileEntityRenderer::new);
    }
}
