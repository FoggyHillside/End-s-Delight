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
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Supplier;

public enum ModItem {
    //BlockItem
    ChorusFruitCrate ("chorus_fruit_crate",
            ()-> new BlockItem(ModBlock.ChorusFruitCrate, new FabricItemSettings())),
    EndStove ("end_stove",
            ()-> new BlockItem(ModBlock.EndStove, new FabricItemSettings())),
    //knife
    DragonEggShellKnife ("dragon_egg_shell_knife",
            ()-> new KnifeItem(ModMaterials.DRAGON_EGG_SHELL, new FabricItemSettings())),
    PurpurKnife ("purpur_knife",
            ()-> new KnifeItem(ModMaterials.PURPUR, new FabricItemSettings())),
    EndStoneKnife ("end_stone_knife",
            ()-> new KnifeItem(ModMaterials.END_STONE, new FabricItemSettings())),
    DragonToothKnife ("dragon_tooth_knife",
            ()-> new KnifeItem(ModMaterials.DRAGON_TOOTH, new FabricItemSettings())),

    EnderPearlGrain ("ender_pearl_grain",
            ()-> new Item(new FabricItemSettings())),
    ChorusFruitGrain ("chorus_fruit_grain",
            ()-> new Item(new FabricItemSettings().food(FoodList.ChorusFruitGrain))),
    ChorusSucculent ("chorus_succulent",
            ()-> new BlockItem(ModBlock.ChorusSucculent, new FabricItemSettings().food(FoodList.ChorusSucculent))),
    DriedChorusFlower ("dried_chorus_flower",
            ()-> new Item(new FabricItemSettings())),
    DragonTooth ("dragon_tooth",
            ()-> new Item(new FabricItemSettings())),
    DragonEggShell ("dragon_egg_shell",
            ()-> new Item(new FabricItemSettings())),
    NonHatchableDragonEgg ("non_hatchable_dragon_egg",
            ()-> new Item(new FabricItemSettings().rarity(Rarity.RARE))),
    HalfDragonEggShell ("half_dragon_egg_shell",
            ()-> new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON))),
    LiquidDragonEgg ("liquid_dragon_egg",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.LiquidDragonEgg), true)),
    FriedDragonEgg ("fried_dragon_egg",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.FriedDragonEgg), true)),
    ShulkerMeat ("shulker_meat",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.ShulkerMeat), true)),
    ShulkerMeatSlice ("shulker_meat_slice",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.ShulkerMeatSlice), true)),
    RoastedShulkerMeat ("roasted_shulker_meat",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.RoastedShulkerMeat), true)),
    RoastedShulkerMeatSlice ("roasted_shulker_meat_slice",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.RoastedShulkerMeatSlice), true)),
    DragonLeg ("dragon_leg",
            ()-> new Item(new FabricItemSettings().food(FoodList.DragonLeg))),
    SmokedDragonLeg ("smoked_dragon_leg",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.SmokedDragonLeg), true)),
    RawDragonMeat ("raw_dragon_meat",
            ()-> new Item(new FabricItemSettings().food(FoodList.RawDragonMeat))),
    RoastedDragonMeat ("roasted_dragon_meat",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.RoastedDragonMeat), true)),
    RawDragonMeatCuts ("raw_dragon_meat_cuts",
            ()-> new Item(new FabricItemSettings().food(FoodList.RawDragonMeatCuts))),
    RoastedDragonMeatCuts ("roasted_dragon_meat_cuts",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.RoastedDragonMeatCuts), true)),
    RawEnderMiteMeat ("raw_ender_mite_meat",
            ()-> new Item(new FabricItemSettings().food(FoodList.RawEnderMiteMeat))),
    DriedEnderMiteMeat ("dried_endermite_meat",
            ()-> new Item(new FabricItemSettings().food(FoodList.DriedEnderMiteMeat))),
    EnderSauce ("ender_sauce",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.EnderSauce).recipeRemainder(Items.BOWL).maxCount(16))),
    StuffedRiceCake ("stuffed_rice_cake",
            ()-> new ChorusFruitPieSliceItem(new FabricItemSettings().food(FoodList.StuffedRiceCake))),
    ChorusFlowerPie ("chorus_flower_pie",
            ()-> new ChorusFruitPieSliceItem(new FabricItemSettings().food(FoodList.ChorusFlowerPie),true)),
    //Drink
    ChorusFruitWine ("chorus_fruit_wine",
            ChorusFruitWineItem::new),
    ChorusFruitMilkTea ("chorus_fruit_milk_tea",
            ()-> new BubbleTeaItem(new FabricItemSettings().food(FoodList.ChorusFruitMilkTea).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE))),
    BubbleTea ("bubble_tea",
            ()-> new BubbleTeaItem(new FabricItemSettings().food(FoodList.BubbleTea).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE))),
    DragonBreathSoda ("dragon_breath_soda",
            ()-> new DrinkableItem(new FabricItemSettings().food(FoodList.DragonBreathSoda).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE), true)),
    ChorusFlowerTea ("chorus_flower_tea",
            ()-> new ChorusFlowerTeaItem(new FabricItemSettings().food(FoodList.ChorusFlowerTea).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE), true, true)),
    //Cookie
    ChorusCookie ("chorus_cookie",
            ()-> new ChorusFruitPieSliceItem(new FabricItemSettings().food(FoodList.ChorusCookie))),
    //Popsicle
    ChorusFruitPopsicle ("chorus_fruit_popsicle",
            ()-> new ChorusFruitPopsicleItem(new FabricItemSettings().food(FoodList.ChorusFruitPopsicle).maxCount(16))),
    //Pie
    ChorusFruitPie ("chorus_fruit_pie",
            () -> new BlockItem(ModBlock.ChorusFruitPie, new FabricItemSettings())),
    ChorusFruitPieSlice ("chorus_fruit_pie_slice",
            ()-> new ChorusFruitPieSliceItem(new FabricItemSettings().food(Foods.PIE_SLICE.get()), true)),
    //Congee
    EnderCongee ("ender_congee",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.EnderCongee).recipeRemainder(Items.BOWL).maxCount(16), true)),
    //Soup
    DragonBreathAndChorusSoup ("dragon_breath_and_chorus_soup",
            ()-> new DragonBreathAndChorusSoupItem(new FabricItemSettings().food(FoodList.DragonBreathAndChorusSoup).recipeRemainder(Items.BOWL).maxCount(16), true, true)),
    //ConsumableItem
    StirFriedShulkerMeat ("stir_fried_shulker_meat",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.StirFriedShulkerMeat).maxCount(16).recipeRemainder(Items.BOWL), true)),
    RoastedDragonSteak ("roasted_dragon_steak",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.RoastedDragonSteak).maxCount(16).recipeRemainder(Items.BOWL), true)),
    EndMixedSalad ("end_mixed_salad",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.EndMixedSalad).recipeRemainder(Items.BOWL).maxCount(16), true)),
    AssortedSalad ("assorted_salad",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.AssortedSalad).recipeRemainder(ModItem.DragonEggShell.get()).maxCount(16), true)),
    //BarbecueStick
    EndBarbecueStick ("end_barbecue_stick",
            ()-> new TooltipItem(new FabricItemSettings().food(FoodList.EndBarbecueStick), true)),
    //Feast
    DragonLegBlock ("dragon_leg_with_sauce_block",
            ()-> new BlockItem(ModBlock.DragonLegBlock, new FabricItemSettings().maxCount(1))),
    DragonLegWithSauce ("dragon_leg_with_sauce",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.DragonLegWithSauce).maxCount(16).recipeRemainder(Items.BOWL),true)),
    SteamedDragonEggBlock ("steamed_dragon_egg_block",
            ()-> new BlockItem(ModBlock.SteamedDragonEggBlock, new FabricItemSettings().maxCount(1))),
    SteamedDragonEgg ("steamed_dragon_egg",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.SteamedDragonEgg).recipeRemainder(Items.BOWL).maxCount(16), true)),
    DragonMeatStewBlock ("dragon_meat_stew_block",
            ()-> new BlockItem(ModBlock.DragonMeatStewBlock, new FabricItemSettings().maxCount(1))),
    DragonMeatStew ("dragon_meat_stew",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.DragonMeatStew).recipeRemainder(Items.BOWL).maxCount(16), true)),
    GrilledShulkerBlock ("grilled_shulker_block",
            ()-> new BlockItem(ModBlock.GrilledShulkerBlock, new FabricItemSettings().maxCount(1))),
    GrilledShulker ("grilled_shulker",
            ()-> new ConsumableItem(new FabricItemSettings().food(FoodList.GrilledShulker).recipeRemainder(Items.BOWL).maxCount(16), true));

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
            Registry.register(Registries.ITEM, new Identifier(EndsDelight.MOD_ID, value.pathName), value.get());
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
        return Registries.ITEM.getId(this.get()).toString();
    }
}
