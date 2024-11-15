package cn.foggyhillside.ends_delight.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChorusFlowerTeaItem extends BubbleTeaItem {

    public ChorusFlowerTeaItem(Item.Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasPotionEffectTooltip, hasCustomTooltip);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        consumer.removeEffect(MobEffects.LEVITATION);
        super.affectConsumer(stack, level, consumer);
    }

}
