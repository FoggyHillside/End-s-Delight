package cn.foggyhillside.ends_delight.item;

import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodList {
    public static final FoodComponent ChorusFruitGrain = new FoodComponent.Builder().hunger(1).saturationModifier(0.6F).snack().build();
    public static final FoodComponent ChorusFruitMilkTea = new FoodComponent.Builder().hunger(6).saturationModifier(0.5F).alwaysEdible().build();
    public static final FoodComponent BubbleTea = new FoodComponent.Builder().hunger(8).saturationModifier(0.5F).alwaysEdible().build();
    public static final FoodComponent DragonBreathSoda = new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,60*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,60*20,0),1).alwaysEdible().build();
    public static final FoodComponent ShulkerMeat = new FoodComponent.Builder().hunger(4).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,4*20,1),1).alwaysEdible().build();
    public static final FoodComponent ShulkerMeatSlice = new FoodComponent.Builder().hunger(2).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,2*20,1),1).snack().alwaysEdible().build();
    public static final FoodComponent StirFriedShulkerMeat = new FoodComponent.Builder().hunger(10).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,5*20,1),1).alwaysEdible().build();
    public static final FoodComponent FriedDragonEgg = new FoodComponent.Builder().hunger(20).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,300*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,300*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,300*20,1),1).alwaysEdible().build();
    public static final FoodComponent DragonLeg = new FoodComponent.Builder().hunger(8).saturationModifier(0.5F).build();
    public static final FoodComponent SmokedDragonLeg = new FoodComponent.Builder().hunger(14).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10*20, 1), 1).build();
    public static final FoodComponent ChorusFruitPopsicle = new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).alwaysEdible().build();
    public static final FoodComponent ChorusFruitWine = new FoodComponent.Builder().hunger(0).saturationModifier(0.0F).alwaysEdible().build();
    public static final FoodComponent DragonBreathAndChorusSoup = new FoodComponent.Builder().hunger(16).saturationModifier(0.6F).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,60*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,60*20,0),1).statusEffect(new StatusEffectInstance(EffectsRegistry.COMFORT.get(), 180*20, 0), 1.0F).build();
    public static final FoodComponent LiquidDragonEgg = new FoodComponent.Builder().hunger(14).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,60*20,0),1).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,60*20,0),1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,60*20,0),1).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,20*20,0),1).alwaysEdible().build();
    public static final FoodComponent StuffedRiceCake = new FoodComponent.Builder().hunger(6).saturationModifier(0.7F).alwaysEdible().build();
    public static final FoodComponent RawEnderMiteMeat = new FoodComponent.Builder().hunger(3).saturationModifier(0.6F).build();
    public static final FoodComponent DriedEnderMiteMeat = new FoodComponent.Builder().hunger(5).saturationModifier(0.6F).build();
    public static final FoodComponent RawDragonMeat = new FoodComponent.Builder().hunger(8).saturationModifier(0.6F).build();
    public static final FoodComponent EndBarbecueStick = new FoodComponent.Builder().hunger(10).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,5*20,1),1).alwaysEdible().build();
    public static final FoodComponent RoastedDragonMeat = new FoodComponent.Builder().hunger(15).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,15*20,1),1).alwaysEdible().build();
    public static final FoodComponent ChorusFlowerTea = new FoodComponent.Builder().hunger(0).saturationModifier(0.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5*20, 1),1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*20, 0),1).alwaysEdible().build();
    public static final FoodComponent RoastedShulkerMeat = new FoodComponent.Builder().hunger(6).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,4*20,1),1).alwaysEdible().build();
    public static final FoodComponent RoastedShulkerMeatSlice = new FoodComponent.Builder().hunger(3).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,2*20,1),1).snack().alwaysEdible().build();
    public static final FoodComponent RawDragonMeatCuts = new FoodComponent.Builder().hunger(3).saturationModifier(0.6F).snack().build();
    public static final FoodComponent RoastedDragonMeatCuts = new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,5*20,1),1).snack().alwaysEdible().build();
    public static final FoodComponent DragonMeatStew = new FoodComponent.Builder().hunger(10).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,75*20,2),1).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,15*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,30*20,1),1).statusEffect(new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(),300*20,0),1).build();
    public static final FoodComponent ChorusSucculent = new FoodComponent.Builder().hunger(2).saturationModifier(0.8F).snack().build();
    public static final FoodComponent EndMixedSalad = new FoodComponent.Builder().hunger(12).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,6*20,0), 1).statusEffect(new StatusEffectInstance(StatusEffects.SPEED,10*20,0), 1).build();
    public static final FoodComponent AssortedSalad = new FoodComponent.Builder().hunger(18).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,10*20,0), 1).statusEffect(new StatusEffectInstance(StatusEffects.SPEED,25*20,0), 1).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,25*20,0), 1).build();
    public static final FoodComponent ChorusFlowerPie = new FoodComponent.Builder().hunger(4).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,5*20,0),1).build();
    public static final FoodComponent SteamedDragonEgg = new FoodComponent.Builder().hunger(12).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,75*20,2),1).statusEffect(new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(),300*20,0),1).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,75*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,75*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,75*20,1),1).build();
    public static final FoodComponent GrilledShulker = new FoodComponent.Builder().hunger(8).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,5*20,0),1).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,2*20,1),1).statusEffect(new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(),300*20,0),1).build();
    public static final FoodComponent RoastedDragonSteak = new FoodComponent.Builder().hunger(18).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,25*20,1),1).statusEffect(new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(),300*20,0),1).alwaysEdible().build();
    public static final FoodComponent EnderSauce = new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build();
    public static final FoodComponent ChorusCookie = new FoodComponent.Builder().hunger(2).saturationModifier(0.6F).build();
    public static final FoodComponent EnderCongee = new FoodComponent.Builder().hunger(10).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,15*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,45*20,1),1).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,45*20,2),1).alwaysEdible().build();
    public static final FoodComponent DragonLegWithSauce = new FoodComponent.Builder().hunger(10).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,75*20,2),1).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,15*20,1),1).statusEffect(new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(),300*20,0),1).build();
}
