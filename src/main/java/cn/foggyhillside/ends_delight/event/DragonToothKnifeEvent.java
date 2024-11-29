package cn.foggyhillside.ends_delight.event;

import cn.foggyhillside.ends_delight.EDCommonConfigs;
import cn.foggyhillside.ends_delight.registry.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class DragonToothKnifeEvent {

    public static class KnifeEvents {
        public KnifeEvents() {
        }

        public static float onAttackEndMobs(LivingEntity livingEntity, DamageSource source, float amount) {
            String[] endMobs = EDCommonConfigs.END_MOBS.get().toArray(new String[0]);
            for (String endMob : endMobs) {
                ResourceLocation id = BuiltInRegistries.ENTITY_TYPE.getKey(livingEntity.getType());
                if (id.equals(ResourceLocation.tryParse(endMob)) && source.getEntity() instanceof LivingEntity attacker) {
                    ItemStack toolStack = attacker.getItemInHand(InteractionHand.MAIN_HAND);
                    if (toolStack.is(ModItems.DRAGON_TOOTH_KNIFE.get())) {
                        amount *= 3.5F;
                        break;
                    }
                }
            }
            return amount;
        }
    }
}