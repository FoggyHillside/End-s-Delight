package cn.foggyhillside.endsdelight.registry;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.MaterialRegistry;
import cn.foggyhillside.endsdelight.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.item.SkilletItem;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndsDelight.MOD_ID);
    //BlockItem
    public static final RegistryObject<Item> EndStove = ITEMS.register("end_stove",
            ()-> new BlockItem(BlockRegistry.EndStove.get(), new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    //knife
    public static final RegistryObject<Item> DragonEggShellKnife = ITEMS.register("dragon_egg_shell_knife",
             ()->new KnifeItem(MaterialRegistry.DRAGON_EGG_SHELL, 0.5F, -2.0F, new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> PurpurKnife = ITEMS.register("purpur_knife",
            ()->new KnifeItem(MaterialRegistry.PURPUR, 0.5F, -2.0F, new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> EndStoneKnife = ITEMS.register("end_stone_knife",
            ()->new KnifeItem(MaterialRegistry.END_STONE, 0.5F, -2.0F, new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> DragonEggResearchNotes = ITEMS.register("dragon_egg_research_notes",
            ()-> new DragonEggResearchNotes());

    public static final RegistryObject<Item> EnderPearlGrain = ITEMS.register("ender_pearl_grain",
            ()-> new Item(new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> ChorusFruitGrain = ITEMS.register("chorus_fruit_grain",
            ()-> new Item(new Item.Properties().food(FoodList.ChorusFruitGrain).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> ChorusSucculent = ITEMS.register("chorus_succulent",
            ()-> new BlockItem(BlockRegistry.ChorusSucculent.get(), new Item.Properties().food(FoodList.ChorusSucculent).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> DriedChorusFlower = ITEMS.register("dried_chorus_flower",
            ()-> new Item(new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> DragonEggShell = ITEMS.register("dragon_egg_shell",
           ()-> new Item(new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> LargerDragonEggShell = ITEMS.register("larger_dragon_egg_shell",
            ()-> new Item(new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> EnderManLimb = ITEMS.register("ender_man_limb",
            ()-> new Item(new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> NonHatchableDragonEgg = ITEMS.register("non_hatchable_dragon_egg",
            ()-> new Item(new Item.Properties().rarity(Rarity.RARE).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> HalfDragonEggShell = ITEMS.register("half_dragon_egg_shell",
            ()-> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> ShulkerMeat = ITEMS.register("shulker_meat",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.ShulkerMeat).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> ShulkerMeatSlice = ITEMS.register("shulker_meat_slice",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.ShulkerMeatSlice).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> RoastedShulkerMeat = ITEMS.register("roasted_shulker_meat",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.RoastedShulkerMeat).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> RoastedShulkerMeatSlice = ITEMS.register("roasted_shulker_meat_slice",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.RoastedShulkerMeatSlice).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> DragonLeg = ITEMS.register("dragon_leg",
            ()-> new Item(new Item.Properties().food(FoodList.DragonLeg).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> SmokedDragonLeg = ITEMS.register("smoked_dragon_leg",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.SmokedDragonLeg).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> RawDragonMeat = ITEMS.register("raw_dragon_meat",
            ()-> new Item(new Item.Properties().food(FoodList.RawDragonMeat).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> RoastedDragonMeat = ITEMS.register("roasted_dragon_meat",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.RoastedDragonMeat).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> RawDragonMeatCuts = ITEMS.register("raw_dragon_meat_cuts",
            ()-> new Item(new Item.Properties().food(FoodList.RawDragonMeatCuts).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> RoastedDragonMeatCuts = ITEMS.register("roasted_dragon_meat_cuts",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.RoastedDragonMeatCuts).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> RawEnderMiteMeat = ITEMS.register("raw_ender_mite_meat",
            ()-> new Item(new Item.Properties().food(FoodList.RawEnderMiteMeat).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> RoastedEnderMiteMeat = ITEMS.register("roasted_ender_mite_meat",
            ()-> new Item(new Item.Properties().food(FoodList.RoastedEnderMiteMeat).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> BakedRiceCakeWithChorusFruitFilling = ITEMS.register("baked_rice_cake_with_chorus_fruit_filling",
            ()-> new ChorusFruitPieSliceItem(new Item.Properties().food(FoodList.BakedRiceCakeWithChorusFruitFilling).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> ChorusFlowerPie = ITEMS.register("chorus_flower_pie",
            ()-> new ChorusFruitPieSliceItem(new Item.Properties().food(FoodList.ChorusFlowerPie).tab(EndsDelight.EndsDelightTab),true));
    //Drink
    public static final RegistryObject<Item> ChorusFruitWine = ITEMS.register("chorus_fruit_wine",
            ()-> new ChorusFruitWineItem(new Item.Properties().food(FoodList.ChorusFruitWine).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> ChorusFruitMilkTea = ITEMS.register("chorus_fruit_milk_tea",
            ()-> new BubbleTeaItem(new Item.Properties().food(FoodList.ChorusFruitMilkTea).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> BubbleTea = ITEMS.register("bubble_tea",
            ()-> new BubbleTeaItem(new Item.Properties().food(FoodList.BubbleTea).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> DragonBreathSoda = ITEMS.register("dragon_breath_soda",
            ()-> new DragonBreathSodaItem(new Item.Properties().food(FoodList.DragonBreathSoda).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> ChorusFlowerTea = ITEMS.register("chorus_flower_tea",
            ()-> new ChorusFlowerTeaItem(new Item.Properties().food(FoodList.ChorusFlowerTea).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(EndsDelight.EndsDelightTab), true));
    //Popsicle
    public static final RegistryObject<Item> ChorusFruitPopsicle = ITEMS.register("chorus_fruit_popsicle",
            ()-> new ChorusFruitPopsicleItem(new Item.Properties().food(FoodList.ChorusFruitPopsicle).stacksTo(16).tab(EndsDelight.EndsDelightTab)));
    //Pie
    public static final RegistryObject<Item> ChorusFruitPie = ITEMS.register("chorus_fruit_pie",
            () -> new BlockItem(BlockRegistry.ChorusFruitPie.get(), new Item.Properties().tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> ChorusFruitPieSlice = ITEMS.register("chorus_fruit_pie_slice",
            ()-> new ChorusFruitPieSliceItem(new Item.Properties().food(FoodValues.PIE_SLICE).tab(EndsDelight.EndsDelightTab), true));
    //Soup
    public static final RegistryObject<Item> DragonBreathAndChorusSoup = ITEMS.register("dragon_breath_and_chorus_soup",
            ()-> new DragonBreathAndChorusSoupItem(new Item.Properties().food(FoodList.DragonBreathAndChorusSoup).craftRemainder(Items.BOWL).stacksTo(16).tab(EndsDelight.EndsDelightTab), true));
    //ConsumableItem
    public static final RegistryObject<Item> StirFriedShulkerMeat = ITEMS.register("stir_fried_shulker_meat",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.StirFriedShulkerMeat).craftRemainder(Items.BOWL).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> EndMixedSalad = ITEMS.register("end_mixed_salad",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.EndMixedSalad).craftRemainder(Items.BOWL).stacksTo(16).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> AssortedSalad = ITEMS.register("assorted_salad",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.AssortedSalad).craftRemainder(ItemRegistry.LargerDragonEggShell.get()).stacksTo(16).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> LiquidDragonEgg = ITEMS.register("liquid_dragon_egg",
            ()-> new LiquidDragonEgg(new Item.Properties().food(FoodList.LiquidDragonEgg).craftRemainder(ItemRegistry.LargerDragonEggShell.get()).stacksTo(16).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> LiquidDragonEggInBowl = ITEMS.register("liquid_dragon_egg_in_bowl",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.LiquidDragonEggInBowl).craftRemainder(Items.BOWL).stacksTo(16).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> FriedDragonEgg = ITEMS.register("fried_dragon_egg",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.FriedDragonEgg).craftRemainder(Items.BOWL).tab(EndsDelight.EndsDelightTab), true));
    //BarbecueStick
    public static final RegistryObject<Item> EndBarbecueStick = ITEMS.register("end_barbecue_stick",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.EndBarbecueStick).tab(EndsDelight.EndsDelightTab), true));
    //Feast
    public static final RegistryObject<Item> SteamedDragonEggBlock = ITEMS.register("steamed_dragon_egg_block",
            ()-> new BlockItem(BlockRegistry.SteamedDragonEggBlock.get(), new Item.Properties().stacksTo(1).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> SteamedDragonEgg = ITEMS.register("steamed_dragon_egg",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.SteamedDragonEgg).craftRemainder(Items.BOWL).stacksTo(16).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> DragonMeatStewBlock = ITEMS.register("dragon_meat_stew_block",
            ()-> new BlockItem(BlockRegistry.DragonMeatStewBlock.get(), new Item.Properties().stacksTo(1).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> DragonMeatStew = ITEMS.register("dragon_meat_stew",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.DragonMeatStew).craftRemainder(Items.BOWL).stacksTo(16).tab(EndsDelight.EndsDelightTab), true));
    public static final RegistryObject<Item> GrilledShulkerBlock = ITEMS.register("grilled_shulker_block",
            ()-> new BlockItem(BlockRegistry.GrilledShulkerBlock.get(), new Item.Properties().stacksTo(1).tab(EndsDelight.EndsDelightTab)));
    public static final RegistryObject<Item> GrilledShulker = ITEMS.register("grilled_shulker",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.GrilledShulker).craftRemainder(Items.BOWL).stacksTo(16).tab(EndsDelight.EndsDelightTab), true));
}
