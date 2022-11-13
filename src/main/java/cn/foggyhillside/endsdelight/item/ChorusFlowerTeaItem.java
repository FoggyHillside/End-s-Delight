package cn.foggyhillside.endsdelight.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ChorusFlowerTeaItem extends BubbleTeaItem {

    public ChorusFlowerTeaItem(Properties builder) {
        super(builder);
    }

    @Override
    public void affectConsumer(ItemStack stack, World worldIn, LivingEntity consumer) {
                consumer.removePotionEffect(Effects.LEVITATION);
        }
}
