package cn.foggyhillside.ends_delight;

import cn.foggyhillside.ends_delight.registry.BlockRegistry;
import cn.foggyhillside.ends_delight.registry.ItemRegistry;
import cn.foggyhillside.ends_delight.registry.ModBlockEntityTypes;
import cn.foggyhillside.ends_delight.registry.ModLootModifiers;
import cn.foggyhillside.ends_delight.world.feature.ModFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(EndsDelight.MODID)
public class EndsDelight
{
    public static final String MODID = "ends_delight";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> EndsDelightTab = CREATIVE_MODE_TABS.register("ends_delight", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.ends_delight"))
            .icon(() -> ItemRegistry.BubbleTea.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemRegistry.ChorusFruitCrate.get());
                output.accept(ItemRegistry.EndStove.get());
                output.accept(ItemRegistry.DragonEggShellKnife.get());
                output.accept(ItemRegistry.PurpurKnife.get());
                output.accept(ItemRegistry.EndStoneKnife.get());
                output.accept(ItemRegistry.DragonToothKnife.get());
                output.accept(ItemRegistry.EnderPearlGrain.get());
                output.accept(ItemRegistry.ChorusFruitGrain.get());
                output.accept(ItemRegistry.ChorusSucculent.get());
                output.accept(ItemRegistry.DriedChorusFlower.get());
                output.accept(ItemRegistry.DragonTooth.get());
                output.accept(ItemRegistry.DragonEggShell.get());
                output.accept(ItemRegistry.NonHatchableDragonEgg.get());
                output.accept(ItemRegistry.HalfDragonEggShell.get());
                output.accept(ItemRegistry.LiquidDragonEgg.get());
                output.accept(ItemRegistry.FriedDragonEgg.get());
                output.accept(ItemRegistry.ShulkerMeat.get());
                output.accept(ItemRegistry.ShulkerMeatSlice.get());
                output.accept(ItemRegistry.RoastedShulkerMeat.get());
                output.accept(ItemRegistry.RoastedShulkerMeatSlice.get());
                output.accept(ItemRegistry.DragonLeg.get());
                output.accept(ItemRegistry.SmokedDragonLeg.get());
                output.accept(ItemRegistry.RawDragonMeat.get());
                output.accept(ItemRegistry.RoastedDragonMeat.get());
                output.accept(ItemRegistry.RawDragonMeatCuts.get());
                output.accept(ItemRegistry.RoastedDragonMeatCuts.get());
                output.accept(ItemRegistry.RawEnderMiteMeat.get());
                output.accept(ItemRegistry.DriedEnderMiteMeat.get());
                output.accept(ItemRegistry.EnderSauce.get());
                output.accept(ItemRegistry.StuffedRiceCake.get());
                output.accept(ItemRegistry.ChorusFlowerPie.get());
                output.accept(ItemRegistry.ChorusFruitWine.get());
                output.accept(ItemRegistry.ChorusFruitMilkTea.get());
                output.accept(ItemRegistry.BubbleTea.get());
                output.accept(ItemRegistry.DragonBreathSoda.get());
                output.accept(ItemRegistry.ChorusFlowerTea.get());
                output.accept(ItemRegistry.ChorusCookie.get());
                output.accept(ItemRegistry.ChorusFruitPopsicle.get());
                output.accept(ItemRegistry.ChorusFruitPie.get());
                output.accept(ItemRegistry.ChorusFruitPieSlice.get());
                output.accept(ItemRegistry.EnderCongee.get());
                output.accept(ItemRegistry.DragonBreathAndChorusSoup.get());
                output.accept(ItemRegistry.StirFriedShulkerMeat.get());
                output.accept(ItemRegistry.RoastedDragonSteak.get());
                output.accept(ItemRegistry.EndMixedSalad.get());
                output.accept(ItemRegistry.AssortedSalad.get());
                output.accept(ItemRegistry.EndBarbecueStick.get());
                output.accept(ItemRegistry.DragonLegBlock.get());
                output.accept(ItemRegistry.DragonLegWithSauce.get());
                output.accept(ItemRegistry.SteamedDragonEggBlock.get());
                output.accept(ItemRegistry.SteamedDragonEgg.get());
                output.accept(ItemRegistry.DragonMeatStewBlock.get());
                output.accept(ItemRegistry.DragonMeatStew.get());
                output.accept(ItemRegistry.GrilledShulkerBlock.get());
                output.accept(ItemRegistry.GrilledShulker.get());
            }).build());

    public EndsDelight()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);

        CREATIVE_MODE_TABS.register(modEventBus);

        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);
        ModBlockEntityTypes.TILES.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getName());
    }
}
