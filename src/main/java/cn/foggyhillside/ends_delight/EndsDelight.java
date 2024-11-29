package cn.foggyhillside.ends_delight;

import cn.foggyhillside.ends_delight.registry.ModBiomeModifiers;
import io.github.fabricators_of_create.porting_lib.config.ConfigRegistry;
import io.github.fabricators_of_create.porting_lib.config.ModConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cn.foggyhillside.ends_delight.registry.ModBiomeFeatures.FEATURES;
import static cn.foggyhillside.ends_delight.registry.ModBlockEntityTypes.TILES;
import static cn.foggyhillside.ends_delight.registry.ModBlocks.BLOCKS;
import static cn.foggyhillside.ends_delight.registry.ModCreativeTab.CREATIVE_MODE_TABS;
import static cn.foggyhillside.ends_delight.registry.ModItems.ITEMS;
import static cn.foggyhillside.ends_delight.registry.ModLootModifiers.LOOT_MODIFIERS;

public class EndsDelight implements ModInitializer {

    public static final String MOD_ID = "ends_delight";
    public static final Logger LOGGER = LoggerFactory.getLogger("ends_delight");

    @Override
    public void onInitialize() {
        ConfigRegistry.registerConfig(MOD_ID, ModConfig.Type.COMMON, EDCommonConfigs.SPEC);
        BLOCKS.register();
        TILES.register();
        FEATURES.register();
        ITEMS.register();
        CREATIVE_MODE_TABS.register();
        LOOT_MODIFIERS.register();
        ModBiomeModifiers.init();
    }
}