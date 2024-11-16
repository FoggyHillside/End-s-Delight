package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.FoodList;
import cn.foggyhillside.ends_delight.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EndsDelight.MODID);

    //BlockItem
    public static final DeferredItem<BlockItem> CHORUS_FRUIT_CRATE = ITEMS.register("chorus_fruit_crate",
            () -> new BlockItem(ModBlocks.CHORUS_FRUIT_CRATE.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> END_STOVE = ITEMS.register("end_stove",
            () -> new BlockItem(ModBlocks.END_STOVE.get(), new Item.Properties()));
    //knife
    public static final DeferredItem<Item> DRAGON_EGG_SHELL_KNIFE = ITEMS.register("dragon_egg_shell_knife",
            () -> new KnifeItem(ModMaterials.DRAGON_EGG_SHELL, new Item.Properties().attributes(KnifeItem.createAttributes(
                    ModMaterials.DRAGON_EGG_SHELL, 0.5F, -2.0F))));
    public static final DeferredItem<Item> PURPUR_KNIFE = ITEMS.register("purpur_knife",
            () -> new KnifeItem(ModMaterials.PURPUR, new Item.Properties().attributes(KnifeItem.createAttributes(
                    ModMaterials.PURPUR, 0.5F, -2.0F))));
    public static final DeferredItem<Item> END_STONE_KNIFE = ITEMS.register("end_stone_knife",
            () -> new KnifeItem(ModMaterials.END_STONE, new Item.Properties().attributes(KnifeItem.createAttributes(
                    ModMaterials.END_STONE, 0.5F, -2.0F))));
    public static final DeferredItem<Item> DRAGON_TOOTH_KNIFE = ITEMS.register("dragon_tooth_knife",
            () -> new KnifeItem(ModMaterials.DRAGON_TOOTH, new Item.Properties().attributes(KnifeItem.createAttributes(
                    ModMaterials.DRAGON_TOOTH, 0.5F, -2.0F))));
    //Ingredients And Other Foods
    public static final DeferredItem<Item> ENDER_PEARL_GRAIN = ITEMS.register("ender_pearl_grain",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHORUS_FRUIT_GRAIN = ITEMS.register("chorus_fruit_grain",
            () -> new Item(new Item.Properties().food(FoodList.CHORUS_FRUIT_GRAIN)));
    public static final DeferredItem<BlockItem> CHORUS_SUCCULENT = ITEMS.register("chorus_succulent",
            () -> new BlockItem(ModBlocks.CHORUS_SUCCULENT.get(), new Item.Properties().food(FoodList.CHORUS_SUCCULENT)));
    public static final DeferredItem<Item> DRIED_CHORUS_FLOWER = ITEMS.register("dried_chorus_flower",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRAGON_TOOTH = ITEMS.register("dragon_tooth",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NON_HATCHABLE_DRAGON_EGG = ITEMS.register("non_hatchable_dragon_egg",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> HALF_DRAGON_EGG_SHELL = ITEMS.register("half_dragon_egg_shell",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> LIQUID_DRAGON_EGG = ITEMS.register("liquid_dragon_egg",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.LIQUID_DRAGON_EGG), true));
    public static final DeferredItem<Item> FRIED_DRAGON_EGG = ITEMS.register("fried_dragon_egg",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.FRIED_DRAGON_EGG), true));
    public static final DeferredItem<Item> SHULKER_MEAT = ITEMS.register("shulker_meat",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_MEAT), true));
    public static final DeferredItem<Item> SHULKER_MEAT_SLICE = ITEMS.register("shulker_meat_slice",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_MEAT_SLICE), true));
    public static final DeferredItem<Item> ROASTED_SHULKER_MEAT = ITEMS.register("roasted_shulker_meat",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_SHULKER_MEAT), true));
    public static final DeferredItem<Item> ROASTED_SHULKER_MEAT_SLICE = ITEMS.register("roasted_shulker_meat_slice",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_SHULKER_MEAT_SLICE), true));
    public static final DeferredItem<Item> DRAGON_LEG = ITEMS.register("dragon_leg",
            () -> new Item(new Item.Properties().food(FoodList.DRAGON_LEG)));
    public static final DeferredItem<Item> SMOKED_DRAGON_LEG = ITEMS.register("smoked_dragon_leg",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SMOKED_DRAGON_LEG), true));
    public static final DeferredItem<Item> RAW_DRAGON_MEAT = ITEMS.register("raw_dragon_meat",
            () -> new Item(new Item.Properties().food(FoodList.RAW_DRAGON_MEAT)));
    public static final DeferredItem<Item> ROASTED_DRAGON_MEAT = ITEMS.register("roasted_dragon_meat",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_DRAGON_MEAT), true));
    public static final DeferredItem<Item> RAW_DRAGON_MEAT_CUTS = ITEMS.register("raw_dragon_meat_cuts",
            () -> new Item(new Item.Properties().food(FoodList.RAW_DRAGON_MEAT_CUTS)));
    public static final DeferredItem<Item> ROASTED_DRAGON_MEAT_CUTS = ITEMS.register("roasted_dragon_meat_cuts",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_DRAGON_MEAT_CUTS), true));
    public static final DeferredItem<Item> RAW_ENDERMITE_MEAT = ITEMS.register("raw_ender_mite_meat",
            () -> new Item(new Item.Properties().food(FoodList.RAW_ENDERMITE_MEAT)));
    public static final DeferredItem<Item> DRIED_ENDERMITE_MEAT = ITEMS.register("dried_endermite_meat",
            () -> new Item(new Item.Properties().food(FoodList.DRIED_ENDERMITE_MEAT)));
    public static final DeferredItem<Item> ENDERMAN_GRISTLE = ITEMS.register("enderman_gristle",
            () -> new EndermanGristleItem(new Item.Properties().food(FoodList.ENDERMAN_GRISTLE), 0.3F, false));
    public static final DeferredItem<Item> CHORUS_SAUCE = ITEMS.register("chorus_sauce",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.CHORUS_SAUCE).craftRemainder(Items.BOWL).stacksTo(64)));
    public static final DeferredItem<Item> SHULKER_OMELETTE_MIXTURE = ITEMS.register("shulker_omelette_mixture",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_OMELETTE_MIXTURE),true));
    public static final DeferredItem<Item> SHULKER_OMELETTE = ITEMS.register("shulker_omelette",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_OMELETTE),true));
    public static final DeferredItem<Item> RAW_ENDER_SAUSAGE = ITEMS.register("raw_ender_sausage",
            () -> new EndermanGristleItem(new Item.Properties().food(FoodList.RAW_ENDER_SAUSAGE), 0.3F, false));
    public static final DeferredItem<Item> ENDER_SAUSAGE = ITEMS.register("ender_sausage",
            () -> new EndermanGristleItem(new Item.Properties().food(FoodList.ENDER_SAUSAGE), 0.2F, true, true));
    public static final DeferredItem<Item> ENDER_BAMBOO_RICE = ITEMS.register("ender_bamboo_rice",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ENDER_BAMBOO_RICE), true));
    public static final DeferredItem<Item> STUFFED_RICE_CAKE = ITEMS.register("stuffed_rice_cake",
            () -> new ConsumableChorusItem(new Item.Properties().food(FoodList.STUFFED_RICE_CAKE), true));
    public static final DeferredItem<Item> CHORUS_FLOWER_PIE = ITEMS.register("chorus_flower_pie",
            () -> new ConsumableChorusItem(new Item.Properties().food(FoodList.CHORUS_FLOWER_PIE), true, true));
    public static final DeferredItem<Item> CHORUS_COOKIE = ITEMS.register("chorus_cookie",
            () -> new ConsumableChorusItem(new Item.Properties().food(FoodList.CHORUS_COOKIE), true));
    public static final DeferredItem<Item> CHORUS_FRUIT_POPSICLE = ITEMS.register("chorus_fruit_popsicle",
            () -> new ChorusFruitPopsicleItem(new Item.Properties().food(FoodList.CHORUS_FRUIT_POPSICLE).stacksTo(16)));
    //Drink
    public static final DeferredItem<Item> CHORUS_FRUIT_WINE = ITEMS.register("chorus_fruit_wine",
            () -> new ChorusFruitWineItem(new Item.Properties().food(FoodList.CHORUS_FRUIT_WINE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final DeferredItem<Item> CHORUS_FRUIT_MILK_TEA = ITEMS.register("chorus_fruit_milk_tea",
            () -> new BubbleTeaItem(new Item.Properties().food(FoodList.CHORUS_FRUIT_MILK_TEA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    public static final DeferredItem<Item> BUBBLE_TEA = ITEMS.register("bubble_tea",
            () -> new BubbleTeaItem(new Item.Properties().food(FoodList.BUBBLE_TEA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    public static final DeferredItem<Item> DRAGON_BREATH_SODA = ITEMS.register("dragon_breath_soda",
            () -> new DrinkableItem(new Item.Properties().food(FoodList.DRAGON_BREATH_SODA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true));
    public static final DeferredItem<Item> CHORUS_FLOWER_TEA = ITEMS.register("chorus_flower_tea",
            () -> new ChorusFlowerTeaItem(new Item.Properties().food(FoodList.CHORUS_FLOWER_TEA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, true));
    //Pie
    public static final DeferredItem<BlockItem> CHORUS_FRUIT_PIE = ITEMS.register("chorus_fruit_pie",
            () -> new BlockItem(ModBlocks.CHORUS_FRUIT_PIE.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHORUS_FRUIT_PIE_SLICE = ITEMS.register("chorus_fruit_pie_slice",
            () -> new ConsumableChorusItem(new Item.Properties().food(FoodValues.PIE_SLICE), true, true));
    //Congee
    public static final DeferredItem<Item> ENDER_CONGEE = ITEMS.register("ender_congee",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ENDER_CONGEE).craftRemainder(Items.BOWL).stacksTo(16), true));
    //Soup
    public static final DeferredItem<Item> DRAGON_BREATH_AND_CHORUS_SOUP = ITEMS.register("dragon_breath_and_chorus_soup",
            () -> new DrinkableChorusItem(new Item.Properties().food(FoodList.DRAGON_BREATH_AND_CHORUS_SOUP).craftRemainder(Items.BOWL).stacksTo(16), true, true));
    public static final DeferredItem<Item> SHULKER_SOUP = ITEMS.register("shulker_soup",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.SHULKER_SOUP).craftRemainder(Items.BOWL).stacksTo(16), true));
    //ConsumableItem
    public static final DeferredItem<Item> ENDER_NOODLE = ITEMS.register("ender_noodle",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ENDER_NOODLE).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final DeferredItem<Item> ENDERMAN_GRISTLE_STEW = ITEMS.register("enderman_gristle_stew",
            () -> new EndermanGristleItem(new Item.Properties().food(FoodList.ENDERMAN_GRISTLE_STEW).craftRemainder(Items.BOWL).stacksTo(16), 0.2F, true, true));
    public static final DeferredItem<Item> STIR_FRIED_SHULKER_MEAT = ITEMS.register("stir_fried_shulker_meat",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.STIR_FRIED_SHULKER_MEAT).stacksTo(16).craftRemainder(Items.BOWL), true));
    public static final DeferredItem<Item> ROASTED_DRAGON_STEAK = ITEMS.register("roasted_dragon_steak",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ROASTED_DRAGON_STEAK).stacksTo(16).craftRemainder(Items.BOWL), true));
    public static final DeferredItem<Item> END_MIXED_SALAD = ITEMS.register("end_mixed_salad",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.END_MIXED_SALAD).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final DeferredItem<Item> ASSORTED_SALAD = ITEMS.register("assorted_salad",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.ASSORTED_SALAD).craftRemainder(Items.SHULKER_SHELL).stacksTo(16), true));
    //BarbecueStick
    public static final DeferredItem<Item> END_BARBECUE_STICK = ITEMS.register("end_barbecue_stick",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.END_BARBECUE_STICK), true));
    //Feast
    public static final DeferredItem<BlockItem> DRAGON_LEG_BLOCK = ITEMS.register("dragon_leg_with_sauce_block",
            () -> new BlockItem(ModBlocks.DRAGON_LEG_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> DRAGON_LEG_WITH_SAUCE = ITEMS.register("dragon_leg_with_sauce",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.DRAGON_LEG_WITH_SAUCE).stacksTo(16).craftRemainder(Items.BOWL), true));
    public static final DeferredItem<BlockItem> STEAMED_DRAGON_EGG_BLOCK = ITEMS.register("steamed_dragon_egg_block",
            () -> new BlockItem(ModBlocks.STEAMED_DRAGON_EGG_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> STEAMED_DRAGON_EGG = ITEMS.register("steamed_dragon_egg",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.STEAMED_DRAGON_EGG).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final DeferredItem<BlockItem> DRAGON_MEAT_STEW_BLOCK = ITEMS.register("dragon_meat_stew_block",
            () -> new BlockItem(ModBlocks.DRAGON_MEAT_STEW_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> DRAGON_MEAT_STEW = ITEMS.register("dragon_meat_stew",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.DRAGON_MEAT_STEW).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final DeferredItem<BlockItem> GRILLED_SHULKER_BLOCK = ITEMS.register("grilled_shulker_block",
            () -> new BlockItem(ModBlocks.GRILLED_SHULKER_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GRILLED_SHULKER = ITEMS.register("grilled_shulker",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.GRILLED_SHULKER).craftRemainder(Items.BOWL).stacksTo(16), true));
}
