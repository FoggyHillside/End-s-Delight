package cn.foggyhillside.endsdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FoodList {
    public static final FoodProperties ChorusFruitGrain = new FoodProperties.Builder().nutrition(1).saturationMod(0.6F).fast().build();
    public static final FoodProperties ChorusFruitMilkTea = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).alwaysEat().build();
    public static final FoodProperties BubbleTea = new FoodProperties.Builder().nutrition(8).saturationMod(0.5F).alwaysEat().build();
    public static final FoodProperties DragonBreathSoda = new FoodProperties.Builder().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,60*20,1),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,60*20,0),1).alwaysEat().build();
    public static final FoodProperties ShulkerMeat = new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.LEVITATION,4*20,1),1).alwaysEat().build();
    public static final FoodProperties ShulkerMeatSlice = new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.LEVITATION,2*20,1),1).fast().alwaysEat().build();
    public static final FoodProperties StirFriedShulkerMeat = new FoodProperties.Builder().nutrition(10).saturationMod(0.8F).effect(() -> new MobEffectInstance(MobEffects.LEVITATION,5*20,1),1).alwaysEat().build();
    public static final FoodProperties FriedDragonEgg = new FoodProperties.Builder().nutrition(20).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,300*20,1),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,300*20,1),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,300*20,1),1).alwaysEat().build();
    public static final FoodProperties DragonLeg = new FoodProperties.Builder().nutrition(8).saturationMod(0.5F).build();
    public static final FoodProperties SmokedDragonLeg = new FoodProperties.Builder().nutrition(14).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,10*20,1),1).alwaysEat().build();
    public static final FoodProperties ChorusFruitPopsicle = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).alwaysEat().build();
    public static final FoodProperties ChorusFruitWine = new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).alwaysEat().build();
    public static final FoodProperties DragonBreathAndChorusSoup = new FoodProperties.Builder().nutrition(16).saturationMod(0.6F).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION,20*20,1),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,60*20,1),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,60*20,0),1).effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 180*20, 0), 1.0F).build();
    public static final FoodProperties LiquidDragonEgg = new FoodProperties.Builder().nutrition(14).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,60*20,0),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,60*20,0),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,60*20,0),1).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS,20*20,1),1).alwaysEat().build();
    public static final FoodProperties BakedRiceCakeWithChorusFruitFilling = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).alwaysEat().build();
    public static final FoodProperties RawEnderMiteMeat = new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build();
    public static final FoodProperties RoastedEnderMiteMeat = new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties RawDragonMeat = new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).build();
    public static final FoodProperties EndBarbecueStick = new FoodProperties.Builder().nutrition(10).saturationMod(0.7F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,5*20,1),1).alwaysEat().build();
    public static final FoodProperties RoastedDragonMeat = new FoodProperties.Builder().nutrition(15).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,15*20,1),1).alwaysEat().build();
    public static final FoodProperties ChorusFlowerTea = new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 5*20, 1),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*20, 0),1).alwaysEat().build();
    public static final FoodProperties RoastedShulkerMeat = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.LEVITATION,4*20,1),1).alwaysEat().build();
    public static final FoodProperties RoastedShulkerMeatSlice = new FoodProperties.Builder().nutrition(3).saturationMod(0.8F).effect(() -> new MobEffectInstance(MobEffects.LEVITATION,2*20,1),1).fast().alwaysEat().build();
    public static final FoodProperties LiquidDragonEggInBowl = new FoodProperties.Builder().nutrition(14).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,60*20,0),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,60*20,0),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,60*20,0),1).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS,20*20,1),1).alwaysEat().build();
    public static final FoodProperties RawDragonMeatCuts = new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).fast().build();
    public static final FoodProperties RoastedDragonMeatCuts = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,5*20,1),1).fast().alwaysEat().build();
    public static final FoodProperties DragonMeatStew = new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,15*20,1),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,30*20,1),1).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(),300*20,0),1).build();
    public static final FoodProperties ChorusSucculent = new FoodProperties.Builder().nutrition(2).saturationMod(0.8F).fast().build();
    public static final FoodProperties EndMixedSalad = new FoodProperties.Builder().nutrition(12).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,6*20,0), 1).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,10*20,0), 1).build();
    public static final FoodProperties AssortedSalad = new FoodProperties.Builder().nutrition(18).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,10*20,0), 1).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,25*20,0), 1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,25*20,0), 1).build();
    public static final FoodProperties ChorusFlowerPie = new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,5*20,0),1).build();
    public static final FoodProperties SteamedDragonEgg = new FoodProperties.Builder().nutrition(12).saturationMod(0.6F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(),300*20,0),1).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,75*20,1),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,75*20,1),1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,75*20,1),1).build();
    public static final FoodProperties GrilledShulker = new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,5*20,0),1).effect(() -> new MobEffectInstance(MobEffects.LEVITATION,2*20,1),1).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(),300*20,0),1).build();
}
