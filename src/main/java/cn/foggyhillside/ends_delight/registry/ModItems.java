package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.FoodList;
import cn.foggyhillside.ends_delight.item.*;
import cn.foggyhillside.ends_delight.utility.Utils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;

import java.util.function.Supplier;

public class ModItems {
    public static <B extends Item> Supplier<B> regItem(String name, Supplier<B> supplier) {
        return Utils.register(name, supplier, BuiltInRegistries.ITEM);
    }

    //BlockItem
    public static final Supplier<Item> CHORUS_FRUIT_CRATE = regItem("chorus_fruit_crate",
            () -> new BlockItem(ModBlocks.CHORUS_FRUIT_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> END_STOVE = regItem("end_stove",
            () -> new BlockItem(ModBlocks.END_STOVE.get(), new Item.Properties()));
    //knife
    public static final Supplier<Item> DRAGON_EGG_SHELL_KNIFE = regItem("dragon_egg_shell_knife",
            () -> new KnifeItem(ModMaterials.DRAGON_EGG_SHELL, new Item.Properties().attributes(KnifeItem.createAttributes(
                    ModMaterials.DRAGON_EGG_SHELL, 0.5F, -2.0F))));
    public static final Supplier<Item> PURPUR_KNIFE = regItem("purpur_knife",
            () -> new KnifeItem(ModMaterials.PURPUR, new Item.Properties().attributes(KnifeItem.createAttributes(
                    ModMaterials.PURPUR, 0.5F, -2.0F))));
    public static final Supplier<Item> END_STONE_KNIFE = regItem("end_stone_knife",
            () -> new KnifeItem(ModMaterials.END_STONE, new Item.Properties().attributes(KnifeItem.createAttributes(
                    ModMaterials.END_STONE, 0.5F, -2.0F))));
    public static final Supplier<Item> DRAGON_TOOTH_KNIFE = regItem("dragon_tooth_knife",
            () -> new KnifeItem(ModMaterials.DRAGON_TOOTH, new Item.Properties().attributes(KnifeItem.createAttributes(
                    ModMaterials.DRAGON_TOOTH, 0.5F, -2.0F))));
    //Ingredients And Other Foods
    public static final Supplier<Item> ENDER_PEARL_GRAIN = regItem("ender_pearl_grain",
            () -> new Item(new Item.Properties()));
    public static final Supplier<Item> CHORUS_FRUIT_GRAIN = regItem("chorus_fruit_grain",
            () -> new Item(new Item.Properties().food(FoodList.CHORUS_FRUIT_GRAIN)));
    public static final Supplier<Item> CHORUS_SUCCULENT = regItem("chorus_succulent",
            () -> new BlockItem(ModBlocks.CHORUS_SUCCULENT.get(), new Item.Properties().food(FoodList.CHORUS_SUCCULENT)));
    public static final Supplier<Item> DRIED_CHORUS_FLOWER = regItem("dried_chorus_flower",
            () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DRAGON_TOOTH = regItem("dragon_tooth",
            () -> new Item(new Item.Properties()));
    public static final Supplier<Item> NON_HATCHABLE_DRAGON_EGG = regItem("non_hatchable_dragon_egg",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final Supplier<Item> HALF_DRAGON_EGG_SHELL = regItem("half_dragon_egg_shell",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final Supplier<Item> LIQUID_DRAGON_EGG = regItem("liquid_dragon_egg",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.LIQUID_DRAGON_EGG), true));
    public static final Supplier<Item> FRIED_DRAGON_EGG = regItem("fried_dragon_egg",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.FRIED_DRAGON_EGG), true));
    public static final Supplier<Item> SHULKER_MEAT = regItem("shulker_meat",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_MEAT), true));
    public static final Supplier<Item> SHULKER_MEAT_SLICE = regItem("shulker_meat_slice",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_MEAT_SLICE), true));
    public static final Supplier<Item> ROASTED_SHULKER_MEAT = regItem("roasted_shulker_meat",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_SHULKER_MEAT), true));
    public static final Supplier<Item> ROASTED_SHULKER_MEAT_SLICE = regItem("roasted_shulker_meat_slice",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_SHULKER_MEAT_SLICE), true));
    public static final Supplier<Item> DRAGON_LEG = regItem("dragon_leg",
            () -> new Item(new Item.Properties().food(FoodList.DRAGON_LEG)));
    public static final Supplier<Item> SMOKED_DRAGON_LEG = regItem("smoked_dragon_leg",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SMOKED_DRAGON_LEG), true));
    public static final Supplier<Item> RAW_DRAGON_MEAT = regItem("raw_dragon_meat",
            () -> new Item(new Item.Properties().food(FoodList.RAW_DRAGON_MEAT)));
    public static final Supplier<Item> ROASTED_DRAGON_MEAT = regItem("roasted_dragon_meat",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_DRAGON_MEAT), true));
    public static final Supplier<Item> RAW_DRAGON_MEAT_CUTS = regItem("raw_dragon_meat_cuts",
            () -> new Item(new Item.Properties().food(FoodList.RAW_DRAGON_MEAT_CUTS)));
    public static final Supplier<Item> ROASTED_DRAGON_MEAT_CUTS = regItem("roasted_dragon_meat_cuts",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_DRAGON_MEAT_CUTS), true));
    public static final Supplier<Item> RAW_ENDERMITE_MEAT = regItem("raw_ender_mite_meat",
            () -> new Item(new Item.Properties().food(FoodList.RAW_ENDERMITE_MEAT)));
    public static final Supplier<Item> DRIED_ENDERMITE_MEAT = regItem("dried_endermite_meat",
            () -> new Item(new Item.Properties().food(FoodList.DRIED_ENDERMITE_MEAT)));
    public static final Supplier<Item> ENDERMAN_GRISTLE = regItem("enderman_gristle",
            () -> new EndermanGristleItem(new Item.Properties().food(FoodList.ENDERMAN_GRISTLE), 0.3F, false));
    public static final Supplier<Item> CHORUS_SAUCE = regItem("chorus_sauce",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.CHORUS_SAUCE).craftRemainder(Items.BOWL).stacksTo(64)));
    public static final Supplier<Item> SHULKER_OMELETTE_MIXTURE = regItem("shulker_omelette_mixture",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_OMELETTE_MIXTURE), true));
    public static final Supplier<Item> SHULKER_OMELETTE = regItem("shulker_omelette",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_OMELETTE), true));
    public static final Supplier<Item> RAW_ENDER_SAUSAGE = regItem("raw_ender_sausage",
            () -> new EndermanGristleItem(new Item.Properties().food(FoodList.RAW_ENDER_SAUSAGE), 0.3F, false));
    public static final Supplier<Item> ENDER_SAUSAGE = regItem("ender_sausage",
            () -> new EndermanGristleItem(new Item.Properties().food(FoodList.ENDER_SAUSAGE), 0.2F, true, true));
    public static final Supplier<Item> ENDER_BAMBOO_RICE = regItem("ender_bamboo_rice",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ENDER_BAMBOO_RICE), true));
    public static final Supplier<Item> STUFFED_RICE_CAKE = regItem("stuffed_rice_cake",
            () -> new ConsumableChorusItem(new Item.Properties().food(FoodList.STUFFED_RICE_CAKE), true));
    public static final Supplier<Item> CHORUS_FLOWER_PIE = regItem("chorus_flower_pie",
            () -> new ConsumableChorusItem(new Item.Properties().food(FoodList.CHORUS_FLOWER_PIE), true, true));
    public static final Supplier<Item> CHORUS_COOKIE = regItem("chorus_cookie",
            () -> new ConsumableChorusItem(new Item.Properties().food(FoodList.CHORUS_COOKIE), true));
    public static final Supplier<Item> CHORUS_FRUIT_POPSICLE = regItem("chorus_fruit_popsicle",
            () -> new ChorusFruitPopsicleItem(new Item.Properties().food(FoodList.CHORUS_FRUIT_POPSICLE).stacksTo(16)));
    //Drink
    public static final Supplier<Item> CHORUS_FRUIT_WINE = regItem("chorus_fruit_wine",
            () -> new ChorusFruitWineItem(new Item.Properties().food(FoodList.CHORUS_FRUIT_WINE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final Supplier<Item> CHORUS_FRUIT_MILK_TEA = regItem("chorus_fruit_milk_tea",
            () -> new BubbleTeaItem(new Item.Properties().food(FoodList.CHORUS_FRUIT_MILK_TEA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    public static final Supplier<Item> BUBBLE_TEA = regItem("bubble_tea",
            () -> new BubbleTeaItem(new Item.Properties().food(FoodList.BUBBLE_TEA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    public static final Supplier<Item> DRAGON_BREATH_SODA = regItem("dragon_breath_soda",
            () -> new DrinkableItem(new Item.Properties().food(FoodList.DRAGON_BREATH_SODA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true));
    public static final Supplier<Item> CHORUS_FLOWER_TEA = regItem("chorus_flower_tea",
            () -> new ChorusFlowerTeaItem(new Item.Properties().food(FoodList.CHORUS_FLOWER_TEA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, true));
    //Pie
    public static final Supplier<Item> CHORUS_FRUIT_PIE = regItem("chorus_fruit_pie",
            () -> new BlockItem(ModBlocks.CHORUS_FRUIT_PIE.get(), new Item.Properties()));
    public static final Supplier<Item> CHORUS_FRUIT_PIE_SLICE = regItem("chorus_fruit_pie_slice",
            () -> new ConsumableChorusItem(new Item.Properties().food(FoodValues.PIE_SLICE), true, true));
    //Congee
    public static final Supplier<Item> ENDER_CONGEE = regItem("ender_congee",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ENDER_CONGEE).craftRemainder(Items.BOWL).stacksTo(16), true));
    //Soup
    public static final Supplier<Item> DRAGON_BREATH_AND_CHORUS_SOUP = regItem("dragon_breath_and_chorus_soup",
            () -> new DrinkableChorusItem(new Item.Properties().food(FoodList.DRAGON_BREATH_AND_CHORUS_SOUP).craftRemainder(Items.BOWL).stacksTo(16), true, true));
    public static final Supplier<Item> SHULKER_SOUP = regItem("shulker_soup",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_SOUP).craftRemainder(Items.BOWL).stacksTo(16), true));
    //ConsumableItem
    public static final Supplier<Item> ENDER_NOODLE = regItem("ender_noodle",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ENDER_NOODLE).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final Supplier<Item> ENDERMAN_GRISTLE_STEW = regItem("enderman_gristle_stew",
            () -> new EndermanGristleItem(new Item.Properties().food(FoodList.ENDERMAN_GRISTLE_STEW).craftRemainder(Items.BOWL).stacksTo(16), 0.2F, true, true));
    public static final Supplier<Item> STIR_FRIED_SHULKER_MEAT = regItem("stir_fried_shulker_meat",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.STIR_FRIED_SHULKER_MEAT).stacksTo(16).craftRemainder(Items.BOWL), true));
    public static final Supplier<Item> ROASTED_DRAGON_STEAK = regItem("roasted_dragon_steak",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_DRAGON_STEAK).stacksTo(16).craftRemainder(Items.BOWL), true));
    public static final Supplier<Item> END_MIXED_SALAD = regItem("end_mixed_salad",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.END_MIXED_SALAD).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final Supplier<Item> ASSORTED_SALAD = regItem("assorted_salad",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ASSORTED_SALAD).craftRemainder(Items.SHULKER_SHELL).stacksTo(16), true));
    //BarbecueStick
    public static final Supplier<Item> END_BARBECUE_STICK = regItem("end_barbecue_stick",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.END_BARBECUE_STICK), true));
    //Feast
    public static final Supplier<Item> DRAGON_LEG_BLOCK = regItem("dragon_leg_with_sauce_block",
            () -> new BlockItem(ModBlocks.DRAGON_LEG_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> DRAGON_LEG_WITH_SAUCE = regItem("dragon_leg_with_sauce",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.DRAGON_LEG_WITH_SAUCE).stacksTo(16).craftRemainder(Items.BOWL), true));
    public static final Supplier<Item> STEAMED_DRAGON_EGG_BLOCK = regItem("steamed_dragon_egg_block",
            () -> new BlockItem(ModBlocks.STEAMED_DRAGON_EGG_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> STEAMED_DRAGON_EGG = regItem("steamed_dragon_egg",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.STEAMED_DRAGON_EGG).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final Supplier<Item> DRAGON_MEAT_STEW_BLOCK = regItem("dragon_meat_stew_block",
            () -> new BlockItem(ModBlocks.DRAGON_MEAT_STEW_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> DRAGON_MEAT_STEW = regItem("dragon_meat_stew",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.DRAGON_MEAT_STEW).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final Supplier<Item> GRILLED_SHULKER_BLOCK = regItem("grilled_shulker_block",
            () -> new BlockItem(ModBlocks.GRILLED_SHULKER_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> GRILLED_SHULKER = regItem("grilled_shulker",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.GRILLED_SHULKER).craftRemainder(Items.BOWL).stacksTo(16), true));

    public static void touch() {

    }

}
