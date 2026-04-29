package cn.foggyhillside.ends_delight;

import cn.foggyhillside.ends_delight.client.renderer.EndStoveRenderer;
import cn.foggyhillside.ends_delight.registry.ModBlockEntityTypes;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.slf4j.Logger;

import static cn.foggyhillside.ends_delight.registry.ModBiomeFeatures.FEATURES;
import static cn.foggyhillside.ends_delight.registry.ModBlockEntityTypes.TILES;
import static cn.foggyhillside.ends_delight.registry.ModBlocks.BLOCKS;
import static cn.foggyhillside.ends_delight.registry.ModCreativeTab.CREATIVE_MODE_TABS;
import static cn.foggyhillside.ends_delight.registry.ModItems.ITEMS;
import static cn.foggyhillside.ends_delight.registry.ModLootModifiers.LOOT_MODIFIERS;

@Mod(EndsDelight.MODID)
public class EndsDelight {
    public static final String MODID = "ends_delight";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EndsDelight(IEventBus modEventBus, ModContainer modContainer) {

        TILES.register(modEventBus);
        BLOCKS.register(modEventBus);
        FEATURES.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        LOOT_MODIFIERS.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, EDCommonConfigs.SPEC);
        if (Dist.CLIENT.equals(net.neoforged.fml.loading.FMLEnvironment.dist)) {
            modEventBus.register(ClientSetupEvents.class);
        }
    }

    public static class ClientSetupEvents
    {
        @SubscribeEvent
        public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntityTypes.END_STOVE.get(), EndStoveRenderer::new);
        }
    }
}
