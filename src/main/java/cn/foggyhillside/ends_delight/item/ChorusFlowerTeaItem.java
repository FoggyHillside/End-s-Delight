package cn.foggyhillside.ends_delight.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ChorusFlowerTeaItem extends BubbleTeaItem{


    public ChorusFlowerTeaItem(Settings settings) {
        super(settings);
    }

    public ChorusFlowerTeaItem(Settings settings, boolean hasFoodEffectTooltip) {
        super(settings, hasFoodEffectTooltip);
    }

    public ChorusFlowerTeaItem(Settings settings, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(settings, hasFoodEffectTooltip, hasCustomTooltip);
    }

    @Override
    public void affectConsumer(ItemStack stack, World world, LivingEntity user) {
        user.removeStatusEffect(StatusEffects.LEVITATION);
    }
}
