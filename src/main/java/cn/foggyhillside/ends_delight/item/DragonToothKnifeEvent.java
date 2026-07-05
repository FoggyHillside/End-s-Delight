package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.config.EDCommonConfigs;
import cn.foggyhillside.ends_delight.registry.ItemRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

public class DragonToothKnifeEvent {

    @Mod.EventBusSubscriber(
            modid = EndsDelight.MODID,
            bus = Mod.EventBusSubscriber.Bus.FORGE
    )
    public static class KnifeEvents {
        public KnifeEvents() {
        }

        @SubscribeEvent
        public static void onAttackEndMobs(LivingDamageEvent event) {
            LivingEntity target = event.getEntity();
            String[] endMobs = EDCommonConfigs.END_MOBS.get().toArray(new String[0]);
            for (String endMob : endMobs) {
                ResourceLocation id = ForgeRegistries.ENTITY_TYPES.getKey(target.getType());
                if (id != null && id.equals(ResourceLocation.tryParse(endMob)) && event.getSource().getEntity() instanceof LivingEntity attacker) {
                    ItemStack toolStack = attacker.getItemInHand(InteractionHand.MAIN_HAND);
                    if (toolStack.is(ItemRegistry.DragonToothKnife.get())) {
                        event.setAmount(event.getAmount() * 3.5F);
                        break;
                    }
                }

            }
        }
    }
}
