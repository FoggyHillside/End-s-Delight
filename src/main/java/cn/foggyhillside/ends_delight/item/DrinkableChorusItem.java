package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.utility.Utils;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class DrinkableChorusItem extends DrinkableItem {

    public DrinkableChorusItem(net.minecraft.world.item.Item.Properties properties) {
        super(properties);
    }

    public DrinkableChorusItem(net.minecraft.world.item.Item.Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
    }

    public DrinkableChorusItem(net.minecraft.world.item.Item.Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasPotionEffectTooltip, hasCustomTooltip);
    }

    @Override
    public void affectConsumer(net.minecraft.world.item.ItemStack stack, Level level, net.minecraft.world.entity.LivingEntity consumer) {
        Utils.itemChorusFruitTeleport(stack, level, consumer);
    }

}
