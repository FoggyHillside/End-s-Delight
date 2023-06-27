package cn.foggyhillside.endsdelight;

import cn.foggyhillside.endsdelight.registry.BlockRegistry;
import cn.foggyhillside.endsdelight.registry.ItemRegistry;
import cn.foggyhillside.endsdelight.registry.ModFeatures;
import cn.foggyhillside.endsdelight.registry.ModTileEntityTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ends_delight")
public class EndsDelight {
    public EndsDelight() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModFeatures.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModTileEntityTypes.TILES.register(FMLJavaModLoadingContext.get().getModEventBus());

        eventBus.addListener(this::doClientStuff);

    }

    public static final String MOD_ID = "ends_delight";

    public void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(BlockRegistry.ChorusSucculent.get(), RenderType.getCutout());
        });
    }
}

