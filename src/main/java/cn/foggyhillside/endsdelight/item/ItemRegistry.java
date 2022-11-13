package cn.foggyhillside.endsdelight.item;

import cn.foggyhillside.endsdelight.EndsDelightGroup;
import cn.foggyhillside.endsdelight.MaterialRegistry;
import cn.foggyhillside.endsdelight.Utils;
import cn.foggyhillside.endsdelight.block.BlockRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.network.play.client.CChatMessagePacket;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.system.CallbackI;
import org.omg.CORBA.PUBLIC_MEMBER;
import vectorwing.farmersdelight.items.ConsumableItem;
import vectorwing.farmersdelight.items.Foods;
import vectorwing.farmersdelight.items.KnifeItem;
import vectorwing.farmersdelight.items.drinks.DrinkItem;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    //knife
    public static final RegistryObject<Item> DragonEggShellKnife = ITEMS.register("dragon_egg_shell_knife",
             ()->new KnifeItem(MaterialRegistry.DRAGON_EGG_SHELL, 0.5F, -2.0F, new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> PurpurKnife = ITEMS.register("purpur_knife",
            ()->new KnifeItem(MaterialRegistry.PURPUR, 0.5F, -2.0F, new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> EndStoneKnife = ITEMS.register("end_stone_knife",
            ()->new KnifeItem(MaterialRegistry.END_STONE, 0.5F, -2.0F, new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> DragonEggResearchNotes = ITEMS.register("dragon_egg_research_notes",
            ()-> new DragonEggResearchNotes());

    public static final RegistryObject<Item> EnderPearlGrain = ITEMS.register("ender_pearl_grain",
            ()-> new Item(new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ChorusFruitGrain = ITEMS.register("chorus_fruit_grain",
            ()-> new Item(new Item.Properties().food(FoodList.ChorusFruitGrain).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ChorusSucculent = ITEMS.register("chorus_succulent",
            ()-> new BlockItem(BlockRegistry.ChorusSucculent.get(), new Item.Properties().food(FoodList.ChorusSucculent).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> DriedChorusFlower = ITEMS.register("dried_chorus_flower",
            ()-> new Item(new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> DragonEggShell = ITEMS.register("dragon_egg_shell",
           ()-> new Item(new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> LargerDragonEggShell = ITEMS.register("larger_dragon_egg_shell",
            ()-> new Item(new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> EnderManLimb = ITEMS.register("ender_man_limb",
            ()-> new Item(new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> NonHatchableDragonEgg = ITEMS.register("non_hatchable_dragon_egg",
            ()-> new Item(new Item.Properties().rarity(Rarity.RARE).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> HalfDragonEggShell = ITEMS.register("half_dragon_egg_shell",
            ()-> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ShulkerMeat = ITEMS.register("shulker_meat",
            ()-> new Item(new Item.Properties().food(FoodList.ShulkerMeat).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ShulkerMeatSlice = ITEMS.register("shulker_meat_slice",
            ()-> new Item(new Item.Properties().food(FoodList.ShulkerMeatSlice).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> RoastedShulkerMeat = ITEMS.register("roasted_shulker_meat",
            ()-> new Item(new Item.Properties().food(FoodList.RoastedShulkerMeat).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> RoastedShulkerMeatSlice = ITEMS.register("roasted_shulker_meat_slice",
            ()-> new Item(new Item.Properties().food(FoodList.RoastedShulkerMeatSlice).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> DragonLeg = ITEMS.register("dragon_leg",
            ()-> new Item(new Item.Properties().food(FoodList.DragonLeg).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> SmokedDragonLeg = ITEMS.register("smoked_dragon_leg",
            ()-> new Item(new Item.Properties().food(FoodList.SmokedDragonLeg).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> RawDragonMeat = ITEMS.register("raw_dragon_meat",
            ()-> new Item(new Item.Properties().food(FoodList.RawDragonMeat).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> RoastedDragonMeat = ITEMS.register("roasted_dragon_meat",
            ()-> new Item(new Item.Properties().food(FoodList.RoastedDragonMeat).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> RawDragonMeatCuts = ITEMS.register("raw_dragon_meat_cuts",
            ()-> new Item(new Item.Properties().food(FoodList.RawDragonMeatCuts).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> RoastedDragonMeatCuts = ITEMS.register("roasted_dragon_meat_cuts",
            ()-> new Item(new Item.Properties().food(FoodList.RoastedDragonMeatCuts).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> RawEnderMiteMeat = ITEMS.register("raw_ender_mite_meat",
            ()-> new Item(new Item.Properties().food(FoodList.RawEnderMiteMeat).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> RoastedEnderMiteMeat = ITEMS.register("roasted_ender_mite_meat",
            ()-> new Item(new Item.Properties().food(FoodList.RoastedEnderMiteMeat).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> BakedRiceCakeWithChorusFruitFilling = ITEMS.register("baked_rice_cake_with_chorus_fruit_filling",
            ()-> new ChorusFruitPieSliceItem(new Item.Properties().food(FoodList.BakedRiceCakeWithChorusFruitFilling).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ChorusFlowerPie = ITEMS.register("chorus_flower_pie",
            ()-> new ChorusFruitPieSliceItem(new Item.Properties().food(FoodList.ChorusFlowerPie).group(EndsDelightGroup.ends_delightGroup)));
    //Drink
    public static final RegistryObject<Item> ChorusFruitWine = ITEMS.register("chorus_fruit_wine",
            ()-> new ChorusFruitWineItem(new Item.Properties().food(FoodList.ChorusFruitWine).containerItem(Items.GLASS_BOTTLE).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ChorusFruitMilkTea = ITEMS.register("chorus_fruit_milk_tea",
            ()-> new BubbleTeaItem(new Item.Properties().food(FoodList.ChorusFruitMilkTea).maxStackSize(16).containerItem(Items.GLASS_BOTTLE).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> BubbleTea = ITEMS.register("bubble_tea",
            ()-> new BubbleTeaItem(new Item.Properties().food(FoodList.BubbleTea).maxStackSize(16).containerItem(Items.GLASS_BOTTLE).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> DragonBreathSoda = ITEMS.register("dragon_breath_soda",
            ()-> new DrinkItem(new Item.Properties().food(FoodList.DragonBreathSoda).maxStackSize(16).containerItem(Items.GLASS_BOTTLE).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ChorusFlowerTea = ITEMS.register("chorus_flower_tea",
            ()-> new ChorusFlowerTeaItem(new Item.Properties().food(FoodList.ChorusFlowerTea).maxStackSize(16).containerItem(Items.GLASS_BOTTLE).group(EndsDelightGroup.ends_delightGroup)));
    //Popsicle
    public static final RegistryObject<Item> ChorusFruitPopsicle = ITEMS.register("chorus_fruit_popsicle",
            ()-> new ChorusFruitPopsicleItem(new Item.Properties().food(FoodList.ChorusFruitPopsicle).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    //Pie
    public static final RegistryObject<Item> ChorusFruitPie = ITEMS.register("chorus_fruit_pie",
            () -> new BlockItem(BlockRegistry.ChorusFruitPie.get(), new Item.Properties().group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> ChorusFruitPieSlice = ITEMS.register("chorus_fruit_pie_slice",
            ()-> new ChorusFruitPieSliceItem(new Item.Properties().food(Foods.PIE_SLICE).group(EndsDelightGroup.ends_delightGroup)));
    //Feast
    public static final RegistryObject<Item> SteamedDragonEggBlock = ITEMS.register("steamed_dragon_egg_block",
            ()-> new BlockItem(BlockRegistry.SteamedDragonEggBlock.get(), new Item.Properties().maxStackSize(1).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> SteamedDragonEgg = ITEMS.register("steamed_dragon_egg",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.SteamedDragonEgg).containerItem(Items.BOWL).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup), true));
    public static final RegistryObject<Item> DragonMeatStewBlock = ITEMS.register("dragon_meat_stew_block",
            ()-> new BlockItem(BlockRegistry.DragonMeatStewBlock.get(), new Item.Properties().maxStackSize(1).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> DragonMeatStew = ITEMS.register("dragon_meat_stew",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.DragonMeatStew).containerItem(Items.BOWL).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> GrilledShulkerBlock = ITEMS.register("grilled_shulker_block",
            ()-> new BlockItem(BlockRegistry.GrilledShulkerBlock.get(), new Item.Properties().maxStackSize(1).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> GrilledShulker = ITEMS.register("grilled_shulker",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.GrilledShulker).containerItem(Items.BOWL).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    //Soup
    public static final RegistryObject<Item> DragonBreathAndChorusSoup = ITEMS.register("dragon_breath_and_chorus_soup",
            ()-> new DragonBreathAndChorusSoupItem(new Item.Properties().food(FoodList.DragonBreathAndChorusSoup).containerItem(Items.BOWL).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    //ConsumableItem
    public static final RegistryObject<Item> StirFriedShulkerMeat = ITEMS.register("stir_fried_shulker_meat",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.StirFriedShulkerMeat).containerItem(Items.BOWL).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> EndMixedSalad = ITEMS.register("end_mixed_salad",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.EndMixedSalad).containerItem(Items.BOWL).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> AssortedSalad = ITEMS.register("assorted_salad",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.AssortedSalad).containerItem(ItemRegistry.LargerDragonEggShell.get()).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> LiquidDragonEgg = ITEMS.register("liquid_dragon_egg",
            ()-> new LiquidDragonEgg(new Item.Properties().food(FoodList.LiquidDragonEgg).containerItem(ItemRegistry.LargerDragonEggShell.get()).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> FriedDragonEgg = ITEMS.register("fried_dragon_egg",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.FriedDragonEgg).containerItem(Items.BOWL).group(EndsDelightGroup.ends_delightGroup)));
    public static final RegistryObject<Item> LiquidDragonEggInBowl = ITEMS.register("liquid_dragon_egg_in_bowl",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.LiquidDragonEggInBowl).containerItem(Items.BOWL).maxStackSize(16).group(EndsDelightGroup.ends_delightGroup)));
    //BarbecueStick
    public static final RegistryObject<Item> EndBarbecueStick = ITEMS.register("end_barbecue_stick",
            ()-> new Item(new Item.Properties().food(FoodList.EndBarbecueStick).group(EndsDelightGroup.ends_delightGroup)));
}
