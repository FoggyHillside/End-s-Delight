package cn.foggyhillside.ends_delight;

import cn.foggyhillside.ends_delight.loot.EDLootModificationEvents;
import cn.foggyhillside.ends_delight.registry.*;
import net.fabricmc.api.ModInitializer;

public class EndsDelight implements ModInitializer {

    public static final String MOD_ID = "ends_delight";

    @Override
    public void onInitialize() {
        EDCommonConfigs.touch();
        ModItems.touch();
        ModBlocks.touch();
        ModBlockEntityTypes.touch();
        ModBiomeFeatures.touch();
        ModCreativeTab.touch();
        ModBiomeModifiers.init();
        EDLootModificationEvents.init();
    }
}