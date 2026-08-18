package cn.foggyhillside.ends_delight;

import cn.foggyhillside.ends_delight.client.renderer.EndStoveRenderer;
import cn.foggyhillside.ends_delight.registry.*;
import cn.foggyhillside.ends_delight.world.feature.ModFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EndsDelight.MODID)
public class EndsDelight {
    public static final String MODID = "ends_delight";

    public EndsDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);

        ModLoadingContext.get().registerConfig(Type.COMMON, EDCommonConfigs.SPEC);
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);
        ModBlockEntityTypes.TILES.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    @Mod.EventBusSubscriber(modid = EndsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSetupEvents {
        @SubscribeEvent
        public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntityTypes.END_STOVE.get(), EndStoveRenderer::new);
        }
    }
}
