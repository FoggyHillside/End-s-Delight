package cn.foggyhillside.endsdelight;

import cn.foggyhillside.endsdelight.registry.*;
import cn.foggyhillside.endsdelight.world.feature.ModConfiguredFeatures;
import cn.foggyhillside.endsdelight.world.feature.ModFeatures;
import cn.foggyhillside.endsdelight.world.feature.ModPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import javax.annotation.Nonnull;


@Mod("ends_delight")
public class EndsDelight {

    public static final CreativeModeTab EndsDelightTab = new CreativeModeTab(EndsDelight.MOD_ID)
    {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.BubbleTea.get());
        }
    };

    public static final String MOD_ID = "ends_delight";

    private static final Logger LOGGER = LogUtils.getLogger();

    public EndsDelight() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.ITEMS.register(eventBus);
        BlockRegistry.BLOCKS.register(eventBus);
        ModFeatures.FEATURES.register(eventBus);
        ModBlockEntityTypes.TILES.register(eventBus);
        ModLootModifiers.LOOT_MODIFIERS.register(eventBus);
        ModConfiguredFeatures.CONFIGURED_FEATURE.register(eventBus);
        ModPlacedFeatures.PLACED_FEATURE.register(eventBus);

        eventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getName());
    }
}
