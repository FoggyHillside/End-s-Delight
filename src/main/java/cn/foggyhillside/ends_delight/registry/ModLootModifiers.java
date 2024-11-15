package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.event.loot.*;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, EndsDelight.MODID);

    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> DragonLegModifierSerializers = LOOT_MODIFIERS.register("dragon_leg", DragonLegAdditionModifier.CODEC);
    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> DragonMeatModifierSerializers = LOOT_MODIFIERS.register("dragon_meat", DragonMeatAdditionModifier.CODEC);
    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> ShulkerMeatModifierSerializers = LOOT_MODIFIERS.register("shulker_meat", ShulkerMeatAdditionModifier.CODEC);
    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> DragonToothModifierSerializers = LOOT_MODIFIERS.register("dragon_tooth", DragonToothAdditionModifier.CODEC);
    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> EndermiteMeatModifierSerializers = LOOT_MODIFIERS.register("endermite_meat", EndermiteMeatAdditionModifier.CODEC);
    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> EndermanGristleModifierSerializers = LOOT_MODIFIERS.register("enderman_gristle", EndermanGristleAdditionModifier.CODEC);

}
