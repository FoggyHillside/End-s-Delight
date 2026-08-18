package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.utility.Utils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.PopsicleItem;

public class ChorusFruitPopsicleItem extends PopsicleItem {
    public ChorusFruitPopsicleItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        Utils.ItemChorusFruitTeleport(stack, level, consumer);
        super.affectConsumer(stack, level, consumer);
    }
}
