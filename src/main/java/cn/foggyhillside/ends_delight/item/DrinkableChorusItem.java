package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.utility.Utils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class DrinkableChorusItem extends DrinkableItem {

    public DrinkableChorusItem(Item.Properties properties) {
        super(properties);
    }

    public DrinkableChorusItem(Item.Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
    }

    public DrinkableChorusItem(Item.Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasPotionEffectTooltip, hasCustomTooltip);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        Utils.ItemChorusFruitTeleport(stack, level, consumer);
    }

}