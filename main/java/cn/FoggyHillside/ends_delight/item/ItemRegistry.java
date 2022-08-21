package cn.FoggyHillside.ends_delight.item;

import cn.FoggyHillside.ends_delight.EndsDelightGroup;
import cn.FoggyHillside.ends_delight.Utils;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.items.ConsumableItem;
import vectorwing.farmersdelight.items.drinks.DrinkItem;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> DragonEggResearchNotes = ITEMS.register("dragon_egg_research_notes",
            ()-> new DragonEggResearchNotes());
    public static final RegistryObject<Item> NonHatchableDragonEgg = ITEMS.register("non_hatchable_dragon_egg",
            ()-> new Item(new Item.Properties().rarity(Rarity.RARE).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> HalfDragonEggShell = ITEMS.register("half_dragon_egg_shell",
            ()-> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> DragonEggShell = ITEMS.register("dragon_egg_shell",
            ()-> new Item(new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> EnderPearlGrain = ITEMS.register("ender_pearl_grain",
            ()-> new Item(new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ChorusFruitGrain = ITEMS.register("chorus_fruit_grain",
            ()-> new Item(new Item.Properties().food(FoodList.ChorusFruitGrain).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> BakedRiceCakeWithChorusFruitFilling = ITEMS.register("baked_rice_cake_with_chorus_fruit_filling",
            ()-> new BubbleTeaItem(new Item.Properties().food(FoodList.BakedRiceCakeWithChorusFruitFilling).group(EndsDelightGroup.ends_delightGroup)));
    //Drink
    public static final RegistryObject<Item> ChorusFruitWine = ITEMS.register("chorus_fruit_wine",
            ()-> new ChorusFruitWineItem(new Item.Properties().food(FoodList.ChorusFruitWine).containerItem(Items.GLASS_BOTTLE).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ChorusFruitMilkTea = ITEMS.register("chorus_fruit_milk_tea",
            ()-> new BubbleTeaItem(new Item.Properties().food(FoodList.ChorusFruitMilkTea).maxStackSize(16).containerItem(Items.GLASS_BOTTLE).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> BubbleTea = ITEMS.register("bubble_tea",
            ()-> new BubbleTeaItem(new Item.Properties().food(FoodList.BubbleTea).maxStackSize(16).containerItem(Items.GLASS_BOTTLE).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> DragonBreathSoda = ITEMS.register("dragon_breath_soda",
            ()-> new DrinkItem(new Item.Properties().food(FoodList.DragonBreathSoda).maxStackSize(16).containerItem(Items.GLASS_BOTTLE).group(EndsDelightGroup.ends_delightGroup)));
    //Popsicle
    public static final RegistryObject<Item> ChorusFruitPopsicle = ITEMS.register("chorus_fruit_popsicle",
            ()-> new ChorusFruitPopsicleItem(new Item.Properties().food(FoodList.ChorusFruitPopsicle).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    //Soup
    public static final RegistryObject<Item> DragonBreathAndChorusSoup = ITEMS.register("dragon_breath_and_chorus_soup",
            ()-> new DragonBreathAndChorusSoupItem(new Item.Properties().food(FoodList.DragonBreathAndChorusSoup).containerItem(Items.BOWL).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    //ConsumableItem
    public static final RegistryObject<Item> StirFriedShulkerMeat = ITEMS.register("stir_fried_shulker_meat",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.StirFriedShulkerMeat).containerItem(Items.BOWL).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> LiquidDragonEgg = ITEMS.register("liquid_dragon_egg",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.LiquidDragonEgg).containerItem(Items.BOWL).group(EndsDelightGroup.ends_delightGroup)));

    public static final RegistryObject<Item> ShulkerMeat = ITEMS.register("shulker_meat",
            ()-> new Item(new Item.Properties().food(FoodList.ShulkerMeat).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ShulkerMeatSlice = ITEMS.register("shulker_meat_slice",
            ()-> new Item(new Item.Properties().food(FoodList.ShulkerMeatSlice).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> FriedDragonEgg = ITEMS.register("fried_dragon_egg",
            ()-> new Item(new Item.Properties().food(FoodList.FriedDragonEgg).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> DragonLeg = ITEMS.register("dragon_leg",
            ()-> new Item(new Item.Properties().food(FoodList.DragonLeg).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> SmokedDragonLeg = ITEMS.register("smoked_dragon_leg",
            ()-> new Item(new Item.Properties().food(FoodList.SmokedDragonLeg).group(EndsDelightGroup.ends_delightGroup)));
}
