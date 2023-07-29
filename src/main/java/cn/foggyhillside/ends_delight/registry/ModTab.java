package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModTab {
    public static final ItemGroup EndsDelightTab = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EndsDelight.MOD_ID, "ends_delight_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.ends_delight"))
                    .icon(()-> new ItemStack(ModItem.BubbleTea.get()))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItem.ChorusFruitCrate.get());
                        entries.add(ModItem.EndStove.get());
                        entries.add(ModItem.DragonEggShellKnife.get());
                        entries.add(ModItem.PurpurKnife.get());
                        entries.add(ModItem.EndStoneKnife.get());
                        entries.add(ModItem.DragonToothKnife.get());
                        entries.add(ModItem.EnderPearlGrain.get());
                        entries.add(ModItem.ChorusFruitGrain.get());
                        entries.add(ModItem.ChorusSucculent.get());
                        entries.add(ModItem.DriedChorusFlower.get());
                        entries.add(ModItem.DragonTooth.get());
                        entries.add(ModItem.DragonEggShell.get());
                        entries.add(ModItem.NonHatchableDragonEgg.get());
                        entries.add(ModItem.HalfDragonEggShell.get());
                        entries.add(ModItem.LiquidDragonEgg.get());
                        entries.add(ModItem.FriedDragonEgg.get());
                        entries.add(ModItem.ShulkerMeat.get());
                        entries.add(ModItem.ShulkerMeatSlice.get());
                        entries.add(ModItem.RoastedShulkerMeat.get());
                        entries.add(ModItem.RoastedShulkerMeatSlice.get());
                        entries.add(ModItem.DragonLeg.get());
                        entries.add(ModItem.SmokedDragonLeg.get());
                        entries.add(ModItem.RawDragonMeat.get());
                        entries.add(ModItem.RoastedDragonMeat.get());
                        entries.add(ModItem.RawDragonMeatCuts.get());
                        entries.add(ModItem.RoastedDragonMeatCuts.get());
                        entries.add(ModItem.RawEnderMiteMeat.get());
                        entries.add(ModItem.DriedEnderMiteMeat.get());
                        entries.add(ModItem.EnderSauce.get());
                        entries.add(ModItem.StuffedRiceCake.get());
                        entries.add(ModItem.ChorusFlowerPie.get());
                        entries.add(ModItem.ChorusFruitWine.get());
                        entries.add(ModItem.ChorusFruitMilkTea.get());
                        entries.add(ModItem.BubbleTea.get());
                        entries.add(ModItem.DragonBreathSoda.get());
                        entries.add(ModItem.ChorusFlowerTea.get());
                        entries.add(ModItem.ChorusCookie.get());
                        entries.add(ModItem.ChorusFruitPopsicle.get());
                        entries.add(ModItem.ChorusFruitPie.get());
                        entries.add(ModItem.ChorusFruitPieSlice.get());
                        entries.add(ModItem.EnderCongee.get());
                        entries.add(ModItem.DragonBreathAndChorusSoup.get());
                        entries.add(ModItem.StirFriedShulkerMeat.get());
                        entries.add(ModItem.RoastedDragonSteak.get());
                        entries.add(ModItem.EndMixedSalad.get());
                        entries.add(ModItem.AssortedSalad.get());
                        entries.add(ModItem.EndBarbecueStick.get());
                        entries.add(ModItem.DragonLegBlock.get());
                        entries.add(ModItem.DragonLegWithSauce.get());
                        entries.add(ModItem.SteamedDragonEggBlock.get());
                        entries.add(ModItem.SteamedDragonEgg.get());
                        entries.add(ModItem.DragonMeatStewBlock.get());
                        entries.add(ModItem.DragonMeatStew.get());
                        entries.add(ModItem.GrilledShulkerBlock.get());
                        entries.add(ModItem.GrilledShulker.get());
                    }).build());

    public static void registerItemGroup(){
        EndsDelight.LOGGER.info("Registering Item Group for " + EndsDelight.MOD_ID);
    }
}
