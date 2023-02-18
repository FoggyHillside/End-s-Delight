package cn.foggyhillside.endsdelight.registry;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.events.loot.DragonLegAdditionModifier;
import cn.foggyhillside.endsdelight.events.loot.DragonMeatAdditionModifier;
import cn.foggyhillside.endsdelight.events.loot.EndermanLimbAdditionModifier;
import cn.foggyhillside.endsdelight.events.loot.ShulkerMeatAdditionModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, EndsDelight.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> DragonLegModifierSerializers = LOOT_MODIFIERS.register("dragon_leg", DragonLegAdditionModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> EndermanLimbModifierSerializers = LOOT_MODIFIERS.register("enderman_limb", EndermanLimbAdditionModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> DragonMeatModifierSerializers = LOOT_MODIFIERS.register("dragon_meat", DragonMeatAdditionModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ShulkerMeatModifierSerializers = LOOT_MODIFIERS.register("shulker_meat", ShulkerMeatAdditionModifier.CODEC);

    public static void register(IEventBus bus) {
        LOOT_MODIFIERS.register(bus);
    }
}
