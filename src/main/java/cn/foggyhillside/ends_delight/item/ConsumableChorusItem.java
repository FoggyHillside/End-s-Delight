package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.utility.Utils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ConsumableChorusItem extends ConsumableItem {

    private final Boolean shift;

    public ConsumableChorusItem(Properties properties, boolean shift) {
        super(properties);
        this.shift = shift;
    }

    public ConsumableChorusItem(Properties properties, boolean hasFoodEffectTooltip, boolean shift) {
        super(properties, hasFoodEffectTooltip);
        this.shift = shift;
    }

    public ConsumableChorusItem(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, boolean shift) {
        super(properties, hasPotionEffectTooltip, hasCustomTooltip);
        this.shift = shift;
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (!shift || consumer.isShiftKeyDown()) {
            Utils.ItemChorusFruitTeleport(stack, level, consumer);
        }
    }

}
