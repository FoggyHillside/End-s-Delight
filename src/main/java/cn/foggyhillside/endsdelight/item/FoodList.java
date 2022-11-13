package cn.foggyhillside.endsdelight.item;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import org.lwjgl.system.CallbackI;
import vectorwing.farmersdelight.registry.ModEffects;

public class FoodList {
    public static final Food ChorusFruitGrain = new Food.Builder().hunger(1).saturation(0.6F).fastToEat().build();
    public static final Food ChorusFruitMilkTea = new Food.Builder().hunger(6).saturation(0.5F).setAlwaysEdible().build();
    public static final Food BubbleTea = new Food.Builder().hunger(8).saturation(0.5F).setAlwaysEdible().build();
    public static final Food DragonBreathSoda = new Food.Builder().effect(() -> new EffectInstance(Effects.STRENGTH,60*20,1),1).effect(() -> new EffectInstance(Effects.RESISTANCE,60*20,0),1).setAlwaysEdible().build();
    public static final Food ShulkerMeat = new Food.Builder().hunger(4).saturation(0.5F).effect(() -> new EffectInstance(Effects.LEVITATION,4*20,1),1).setAlwaysEdible().build();
    public static final Food ShulkerMeatSlice = new Food.Builder().hunger(2).saturation(0.6F).effect(() -> new EffectInstance(Effects.LEVITATION,2*20,1),1).setAlwaysEdible().build();
    public static final Food StirFriedShulkerMeat = new Food.Builder().hunger(10).saturation(0.8F).effect(() -> new EffectInstance(Effects.LEVITATION,5*20,1),1).setAlwaysEdible().build();
    public static final Food FriedDragonEgg = new Food.Builder().hunger(20).saturation(0.5F).effect(() -> new EffectInstance(Effects.REGENERATION,300*20,1),1).effect(() -> new EffectInstance(Effects.STRENGTH,300*20,1),1).effect(() -> new EffectInstance(Effects.RESISTANCE,300*20,1),1).setAlwaysEdible().build();
    public static final Food DragonLeg = new Food.Builder().hunger(8).saturation(0.5F).build();
    public static final Food SmokedDragonLeg = new Food.Builder().hunger(14).saturation(0.5F).effect(() -> new EffectInstance(Effects.REGENERATION,10*20,1),1).setAlwaysEdible().build();
    public static final Food ChorusFruitPopsicle = new Food.Builder().hunger(3).saturation(0.2F).setAlwaysEdible().build();
    public static final Food ChorusFruitWine = new Food.Builder().hunger(0).saturation(0.0F).setAlwaysEdible().build();
    public static final Food DragonBreathAndChorusSoup = new Food.Builder().hunger(16).saturation(0.6F).setAlwaysEdible().effect(() -> new EffectInstance(Effects.REGENERATION,20*20,1),1).effect(() -> new EffectInstance(Effects.STRENGTH,60*20,1),1).effect(() -> new EffectInstance(Effects.RESISTANCE,60*20,0),1).effect(() -> new EffectInstance(ModEffects.COMFORT.get(), 180*20, 0), 1.0F).build();
    public static final Food LiquidDragonEgg = new Food.Builder().hunger(14).saturation(0.5F).effect(() -> new EffectInstance(Effects.REGENERATION,60*20,0),1).effect(() -> new EffectInstance(Effects.STRENGTH,60*20,0),1).effect(() -> new EffectInstance(Effects.RESISTANCE,60*20,0),1).effect(() -> new EffectInstance(Effects.BLINDNESS,20*20,1),1).setAlwaysEdible().build();
    public static final Food BakedRiceCakeWithChorusFruitFilling = new Food.Builder().hunger(6).saturation(0.7F).setAlwaysEdible().build();
    public static final Food RawEnderMiteMeat = new Food.Builder().hunger(3).saturation(0.6F).build();
    public static final Food RoastedEnderMiteMeat = new Food.Builder().hunger(5).saturation(0.6F).build();
    public static final Food RawDragonMeat = new Food.Builder().hunger(8).saturation(0.6F).build();
    public static final Food EndBarbecueStick = new Food.Builder().hunger(10).saturation(0.7F).effect(() -> new EffectInstance(Effects.REGENERATION,5*20,1),1).setAlwaysEdible().build();
    public static final Food RoastedDragonMeat = new Food.Builder().hunger(15).saturation(0.6F).effect(() -> new EffectInstance(Effects.REGENERATION,15*20,1),1).setAlwaysEdible().build();
    public static final Food ChorusFlowerTea = new Food.Builder().hunger(0).saturation(0.0F).setAlwaysEdible().build();
    public static final Food RoastedShulkerMeat = new Food.Builder().hunger(6).saturation(0.5F).effect(() -> new EffectInstance(Effects.LEVITATION,4*20,1),1).setAlwaysEdible().build();
    public static final Food RoastedShulkerMeatSlice = new Food.Builder().hunger(3).saturation(0.8F).effect(() -> new EffectInstance(Effects.LEVITATION,2*20,1),1).setAlwaysEdible().build();
    public static final Food LiquidDragonEggInBowl = new Food.Builder().hunger(14).saturation(0.5F).effect(() -> new EffectInstance(Effects.REGENERATION,60*20,0),1).effect(() -> new EffectInstance(Effects.STRENGTH,60*20,0),1).effect(() -> new EffectInstance(Effects.RESISTANCE,60*20,0),1).effect(() -> new EffectInstance(Effects.BLINDNESS,20*20,1),1).setAlwaysEdible().build();
    public static final Food RawDragonMeatCuts = new Food.Builder().hunger(3).saturation(0.6F).build();
    public static final Food RoastedDragonMeatCuts = new Food.Builder().hunger(6).saturation(0.6F).effect(() -> new EffectInstance(Effects.REGENERATION,5*20,1),1).setAlwaysEdible().build();
    public static final Food DragonMeatStew = new Food.Builder().hunger(10).saturation(0.6F).effect(() -> new EffectInstance(Effects.REGENERATION,15*20,1),1).effect(() -> new EffectInstance(Effects.STRENGTH,30*20,1),1).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(),300*20,0),1).build();
    public static final Food ChorusSucculent = new Food.Builder().hunger(2).saturation(0.8F).fastToEat().build();
    public static final Food EndMixedSalad = new Food.Builder().hunger(12).saturation(0.6F).effect(() -> new EffectInstance(Effects.REGENERATION,6*20,0), 1).effect(() -> new EffectInstance(Effects.SPEED,10*20,0), 1).build();
    public static final Food AssortedSalad = new Food.Builder().hunger(18).saturation(0.5F).effect(() -> new EffectInstance(Effects.REGENERATION,10*20,0), 1).effect(() -> new EffectInstance(Effects.SPEED,25*20,0), 1).effect(() -> new EffectInstance(Effects.STRENGTH,25*20,0), 1).build();
    public static final Food ChorusFlowerPie = new Food.Builder().hunger(4).saturation(0.6F).effect(() -> new EffectInstance(Effects.REGENERATION,5*20,0),1).build();
    public static final Food SteamedDragonEgg = new Food.Builder().hunger(12).saturation(0.6F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(),300*20,0),1).build();
    public static final Food GrilledShulker = new Food.Builder().hunger(8).saturation(0.6F).effect(() -> new EffectInstance(Effects.REGENERATION,5*20,0),1).effect(() -> new EffectInstance(Effects.LEVITATION,2*20,1),1).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(),300*20,0),1).build();
}
