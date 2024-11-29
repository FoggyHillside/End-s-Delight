package cn.foggyhillside.ends_delight.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;

public class ChorusFlowerTeaItem extends BubbleTeaItem {

    public ChorusFlowerTeaItem(net.minecraft.world.item.Item.Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasPotionEffectTooltip, hasCustomTooltip);
    }

    @Override
    public void affectConsumer(net.minecraft.world.item.ItemStack stack, Level level, net.minecraft.world.entity.LivingEntity consumer) {
        consumer.removeEffect(MobEffects.LEVITATION);
        super.affectConsumer(stack, level, consumer);
    }

}
