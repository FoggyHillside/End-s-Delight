package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.events.loot.*;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, EndsDelight.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> DRAGON_LEG_MODIFIER_SERIALIZERS = LOOT_MODIFIERS.register("dragon_leg", DragonLegAdditionModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> DRAGON_MEAT_MODIFIER_SERIALIZERS = LOOT_MODIFIERS.register("dragon_meat", DragonMeatAdditionModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> SHULKER_MEAT_MODIFIER_SERIALIZERS = LOOT_MODIFIERS.register("shulker_meat", ShulkerMeatAdditionModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> DRAGON_TOOTH_MODIFIER_SERIALIZERS = LOOT_MODIFIERS.register("dragon_tooth", DragonToothAdditionModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ENDERMITE_MEAT_MODIFIER_SERIALIZERS = LOOT_MODIFIERS.register("endermite_meat", EndermiteMeatAdditionModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ENDERMAN_GRISTLE_MODIFIER_SERIALIZERS = LOOT_MODIFIERS.register("enderman_gristle", EndermanGristleAdditionModifier.CODEC);

}
