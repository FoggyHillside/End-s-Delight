package cn.foggyhillside.endsdelight.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.setup.Configuration;
import vectorwing.farmersdelight.utils.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class ChorusFlowerTeaItem extends BubbleTeaItem {

    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;

    public ChorusFlowerTeaItem(Item.Properties properties) {
        super(properties);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }

    public ChorusFlowerTeaItem(Item.Properties properties, boolean hasFoodEffectTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public ChorusFlowerTeaItem(Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            if (this.hasCustomTooltip) {
                IFormattableTextComponent textEmpty = TextUtils.getTranslation("tooltip." + this, new Object[0]);
                tooltip.add(textEmpty.mergeStyle(TextFormatting.BLUE));
            }

            if (this.hasFoodEffectTooltip) {
                TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
            }
        }
    }

    @Override
    public void affectConsumer(ItemStack stack, World worldIn, LivingEntity consumer) {
                consumer.removePotionEffect(Effects.LEVITATION);
        }
}
