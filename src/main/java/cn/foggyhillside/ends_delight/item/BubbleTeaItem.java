package cn.foggyhillside.ends_delight.item;


import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BubbleTeaItem extends DrinkableChorusItem {

    public BubbleTeaItem(Item.Properties properties) {
        super(properties);
    }

    public BubbleTeaItem(Item.Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasPotionEffectTooltip, hasCustomTooltip);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (consumer.isShiftKeyDown()) {
            super.affectConsumer(stack, level, consumer);
        }
    }

}
