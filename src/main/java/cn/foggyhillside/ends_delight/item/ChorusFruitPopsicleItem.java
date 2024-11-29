package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.utility.Utils;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.PopsicleItem;

public class ChorusFruitPopsicleItem extends PopsicleItem {

    public ChorusFruitPopsicleItem(net.minecraft.world.item.Item.Properties properties) {
        super(properties);
    }

    @Override
    public void affectConsumer(net.minecraft.world.item.ItemStack stack, Level level, net.minecraft.world.entity.LivingEntity consumer) {
        Utils.itemChorusFruitTeleport(stack, level, consumer);
        super.affectConsumer(stack, level, consumer);
    }

}
