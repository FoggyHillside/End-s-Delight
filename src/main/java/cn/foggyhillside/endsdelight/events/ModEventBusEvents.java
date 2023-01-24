package cn.foggyhillside.endsdelight.events;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.events.loot.DragonLegAdditionModifier;
import cn.foggyhillside.endsdelight.events.loot.DragonMeatAdditionModifier;
import cn.foggyhillside.endsdelight.events.loot.EndermanLimbAdditionModifier;
import cn.foggyhillside.endsdelight.events.loot.ShulkerMeatAdditionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;


@Mod.EventBusSubscriber(modid = EndsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

        @SubscribeEvent
        public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                               event) {
            event.getRegistry().registerAll(
                    new DragonMeatAdditionModifier.Serializer().setRegistryName
                            (new ResourceLocation(EndsDelight.MOD_ID,"add_dragon_meat")),
                    new DragonLegAdditionModifier.Serializer().setRegistryName
                            (new ResourceLocation(EndsDelight.MOD_ID,"add_dragon_leg")),
                    new EndermanLimbAdditionModifier.Serializer().setRegistryName
                            (new ResourceLocation(EndsDelight.MOD_ID,"add_enderman_limb")),
                    new ShulkerMeatAdditionModifier.Serializer().setRegistryName
                            (new ResourceLocation(EndsDelight.MOD_ID,"add_endermite_meat")),
                    new ShulkerMeatAdditionModifier.Serializer().setRegistryName
                            (new ResourceLocation(EndsDelight.MOD_ID,"add_shulker_meat"))
            );
        }
}
