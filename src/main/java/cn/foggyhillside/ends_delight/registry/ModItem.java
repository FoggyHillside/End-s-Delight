package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.item.*;
import com.nhoryzon.mc.farmersdelight.item.ConsumableItem;
import com.nhoryzon.mc.farmersdelight.item.DrinkableItem;
import com.nhoryzon.mc.farmersdelight.item.KnifeItem;
import com.nhoryzon.mc.farmersdelight.item.enumeration.Foods;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Supplier;

public enum ModItem {
    //BlockItem
    ChorusFruitCrate ("chorus_fruit_crate",
            ()-> new BlockItem(ModBlock.ChorusFruitCrate, new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    EndStove ("end_stove",
            ()-> new BlockItem(ModBlock.EndStove, new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    //knife
    DragonEggShellKnife ("dragon_egg_shell_knife",
            ()-> new KnifeItem(ModMaterials.DRAGON_EGG_SHELL, new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    PurpurKnife ("purpur_knife",
            ()-> new KnifeItem(ModMaterials.PURPUR, new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    EndStoneKnife ("end_stone_knife",
            ()-> new KnifeItem(ModMaterials.END_STONE, new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    DragonToothKnife ("dragon_tooth_knife",
            ()-> new KnifeItem(ModMaterials.DRAGON_TOOTH, new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),

    EnderPearlGrain ("ender_pearl_grain",
            ()-> new Item(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    ChorusFruitGrain ("chorus_fruit_grain",
            ()-> new Item(new FabricItemSettings().food(FoodList.ChorusFruitGrain).group(ModItemGroup.ITEM_GROUP))),
    ChorusSucculent ("chorus_succulent",
            ()-> new BlockItem(ModBlock.ChorusSucculent, new FabricItemSettings().food(FoodList.ChorusSucculent).group(ModItemGroup.ITEM_GROUP))),
    DriedChorusFlower ("dried_chorus_flower",
            ()-> new Item(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    DragonTooth ("dragon_tooth",
            ()-> new Item(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    DragonEggShell ("dragon_egg_shell",
            ()-> new Item(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    NonHatchableDragonEgg ("non_hatchable_dragon_egg",
            ()-> new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroup.ITEM_GROUP))),
    HalfDragonEggShell ("half_dragon_egg_shell",
            ()-> new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.ITEM_GROUP))),
    LiquidDragonEgg ("liquid_dragon_egg",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.LiquidDragonEgg).group(ModItemGroup.ITEM_GROUP), true)),
    FriedDragonEgg ("fried_dragon_egg",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.FriedDragonEgg).group(ModItemGroup.ITEM_GROUP), true)),
    ShulkerMeat ("shulker_meat",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.ShulkerMeat).group(ModItemGroup.ITEM_GROUP), true)),
    ShulkerMeatSlice ("shulker_meat_slice",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.ShulkerMeatSlice).group(ModItemGroup.ITEM_GROUP), true)),
    RoastedShulkerMeat ("roasted_shulker_meat",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.RoastedShulkerMeat).group(ModItemGroup.ITEM_GROUP), true)),
    RoastedShulkerMeatSlice ("roasted_shulker_meat_slice",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.RoastedShulkerMeatSlice).group(ModItemGroup.ITEM_GROUP), true)),
    DragonLeg ("dragon_leg",
            ()-> new Item(new FabricItemSettings().food(FoodList.DragonLeg).group(ModItemGroup.ITEM_GROUP))),
    SmokedDragonLeg ("smoked_dragon_leg",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.SmokedDragonLeg).group(ModItemGroup.ITEM_GROUP), true)),
    RawDragonMeat ("raw_dragon_meat",
            ()-> new Item(new FabricItemSettings().food(FoodList.RawDragonMeat).group(ModItemGroup.ITEM_GROUP))),
    RoastedDragonMeat ("roasted_dragon_meat",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.RoastedDragonMeat).group(ModItemGroup.ITEM_GROUP), true)),
    RawDragonMeatCuts ("raw_dragon_meat_cuts",
            ()-> new Item(new FabricItemSettings().food(FoodList.RawDragonMeatCuts).group(ModItemGroup.ITEM_GROUP))),
    RoastedDragonMeatCuts ("roasted_dragon_meat_cuts",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.RoastedDragonMeatCuts).group(ModItemGroup.ITEM_GROUP), true)),
    RawEnderMiteMeat ("raw_ender_mite_meat",
            ()-> new Item(new FabricItemSettings().food(FoodList.RawEnderMiteMeat).group(ModItemGroup.ITEM_GROUP))),
    DriedEnderMiteMeat ("dried_endermite_meat",
            ()-> new Item(new FabricItemSettings().food(FoodList.DriedEnderMiteMeat).group(ModItemGroup.ITEM_GROUP))),
    EnderSauce ("ender_sauce",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.EnderSauce).recipeRemainder(Items.BOWL).maxCount(16).group(ModItemGroup.ITEM_GROUP))),
    StuffedRiceCake ("stuffed_rice_cake",
            ()-> new ChorusFruitPieSliceItem(new FabricItemSettings().food(FoodList.StuffedRiceCake).group(ModItemGroup.ITEM_GROUP))),
    ChorusFlowerPie ("chorus_flower_pie",
            ()-> new ChorusFruitPieSliceItem(new FabricItemSettings().food(FoodList.ChorusFlowerPie).group(ModItemGroup.ITEM_GROUP),true)),
    //Drink
    ChorusFruitWine ("chorus_fruit_wine",
            ()-> new ChorusFruitWineItem(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16).group(ModItemGroup.ITEM_GROUP))),
    ChorusFruitMilkTea ("chorus_fruit_milk_tea",
            ()-> new BubbleTeaItem(new FabricItemSettings().food(FoodList.ChorusFruitMilkTea).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).group(ModItemGroup.ITEM_GROUP))),
    BubbleTea ("bubble_tea",
            ()-> new BubbleTeaItem(new FabricItemSettings().food(FoodList.BubbleTea).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).group(ModItemGroup.ITEM_GROUP))),
    DragonBreathSoda ("dragon_breath_soda",
            ()-> new DrinkableItem(new FabricItemSettings().food(FoodList.DragonBreathSoda).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).group(ModItemGroup.ITEM_GROUP), true)),
    ChorusFlowerTea ("chorus_flower_tea",
            ()-> new ChorusFlowerTeaItem(new FabricItemSettings().food(FoodList.ChorusFlowerTea).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).group(ModItemGroup.ITEM_GROUP), true, true)),
    //Cookie
    ChorusCookie ("chorus_cookie",
            ()-> new ChorusFruitPieSliceItem(new FabricItemSettings().food(FoodList.ChorusCookie).group(ModItemGroup.ITEM_GROUP))),
    //Popsicle
    ChorusFruitPopsicle ("chorus_fruit_popsicle",
            ()-> new ChorusFruitPopsicleItem(new FabricItemSettings().food(FoodList.ChorusFruitPopsicle).maxCount(16).group(ModItemGroup.ITEM_GROUP))),
    //Pie
    ChorusFruitPie ("chorus_fruit_pie",
            () -> new BlockItem(ModBlock.ChorusFruitPie, new FabricItemSettings().group(ModItemGroup.ITEM_GROUP))),
    ChorusFruitPieSlice ("chorus_fruit_pie_slice",
            ()-> new ChorusFruitPieSliceItem(new FabricItemSettings().food(Foods.PIE_SLICE.get()).group(ModItemGroup.ITEM_GROUP), true)),
    //Congee
    EnderCongee ("ender_congee",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.EnderCongee).recipeRemainder(Items.BOWL).maxCount(16).group(ModItemGroup.ITEM_GROUP), true)),
    //Soup
    DragonBreathAndChorusSoup ("dragon_breath_and_chorus_soup",
            ()-> new DragonBreathAndChorusSoupItem(new FabricItemSettings().food(FoodList.DragonBreathAndChorusSoup).recipeRemainder(Items.BOWL).maxCount(16).group(ModItemGroup.ITEM_GROUP), true, true)),
    //ConsumableItem
    StirFriedShulkerMeat ("stir_fried_shulker_meat",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.StirFriedShulkerMeat).maxCount(16).recipeRemainder(Items.BOWL).group(ModItemGroup.ITEM_GROUP), true)),
    RoastedDragonSteak ("roasted_dragon_steak",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.RoastedDragonSteak).maxCount(16).recipeRemainder(Items.BOWL).group(ModItemGroup.ITEM_GROUP), true)),
    EndMixedSalad ("end_mixed_salad",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.EndMixedSalad).recipeRemainder(Items.BOWL).maxCount(16).group(ModItemGroup.ITEM_GROUP), true)),
    AssortedSalad ("assorted_salad",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.AssortedSalad).recipeRemainder(ModItem.DragonEggShell.get()).maxCount(16).group(ModItemGroup.ITEM_GROUP), true)),
    //BarbecueStick
    EndBarbecueStick ("end_barbecue_stick",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.EndBarbecueStick).group(ModItemGroup.ITEM_GROUP), true)),
    //Feast
    DragonLegBlock ("dragon_leg_with_sauce_block",
            ()-> new BlockItem(ModBlock.DragonLegBlock, new FabricItemSettings().maxCount(1).group(ModItemGroup.ITEM_GROUP))),
    DragonLegWithSauce ("dragon_leg_with_sauce",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.DragonLegWithSauce).maxCount(16).recipeRemainder(Items.BOWL).group(ModItemGroup.ITEM_GROUP),true)),
    SteamedDragonEggBlock ("steamed_dragon_egg_block",
            ()-> new BlockItem(ModBlock.SteamedDragonEggBlock, new FabricItemSettings().maxCount(1).group(ModItemGroup.ITEM_GROUP))),
    SteamedDragonEgg ("steamed_dragon_egg",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.SteamedDragonEgg).recipeRemainder(Items.BOWL).maxCount(16).group(ModItemGroup.ITEM_GROUP), true)),
    DragonMeatStewBlock ("dragon_meat_stew_block",
            ()-> new BlockItem(ModBlock.DragonMeatStewBlock, new FabricItemSettings().maxCount(1).group(ModItemGroup.ITEM_GROUP))),
    DragonMeatStew ("dragon_meat_stew",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.DragonMeatStew).recipeRemainder(Items.BOWL).maxCount(16).group(ModItemGroup.ITEM_GROUP), true)),
    GrilledShulkerBlock ("grilled_shulker_block",
            ()-> new BlockItem(ModBlock.GrilledShulkerBlock, new FabricItemSettings().maxCount(1).group(ModItemGroup.ITEM_GROUP))),
    GrilledShulker ("grilled_shulker",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.GrilledShulker).recipeRemainder(Items.BOWL).maxCount(16).group(ModItemGroup.ITEM_GROUP), true));

    private final String pathName;
    private final Supplier<Item> itemSupplier;
    private final Integer burnTime;
    private Item item;

    private ModItem(String pathName, Supplier itemSupplier) {
        this(pathName, itemSupplier, (Integer)null);
    }

    private ModItem(String pathName, Supplier itemSupplier, Integer burnTime) {
        this.pathName = pathName;
        this.itemSupplier = itemSupplier;
        this.burnTime = burnTime;
    }

    public static void registerModItems() {
        ModItem[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            ModItem value = var0[var2];
            Registry.register(Registry.ITEM, new Identifier(EndsDelight.MOD_ID, value.pathName), value.get());
            if (value.burnTime != null && value.burnTime > 0) {
                FuelRegistry.INSTANCE.add(value.get(), value.burnTime);
            }
        }
    }

    public Item get() {
        if (this.item == null) {
            this.item = (Item)this.itemSupplier.get();
        }

        return this.item;
    }

    public String getId() {
        return Registry.ITEM.getId(this.get()).toString();
    }
}
