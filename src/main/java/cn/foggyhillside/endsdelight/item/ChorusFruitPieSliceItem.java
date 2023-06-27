package cn.foggyhillside.endsdelight.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
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

public class ChorusFruitPieSliceItem extends Item {

    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;

    public ChorusFruitPieSliceItem(Item.Properties properties) {
        super(properties);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }

    public ChorusFruitPieSliceItem(Item.Properties properties, boolean hasFoodEffectTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public ChorusFruitPieSliceItem(Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
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
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (!worldIn.isRemote && entityLiving.isSneaking() == true) {
            double d0 = entityLiving.getPosX();
            double d1 = entityLiving.getPosY();
            double d2 = entityLiving.getPosZ();

            for(int i = 0; i < 16; ++i) {
                double d3 = entityLiving.getPosX() + (entityLiving.getRNG().nextDouble() - 0.5D) * 16.0D;
                double d4 = MathHelper.clamp(entityLiving.getPosY() + (double)(entityLiving.getRNG().nextInt(16) - 8), 0.0D, (double)(worldIn.func_234938_ad_() - 1));
                double d5 = entityLiving.getPosZ() + (entityLiving.getRNG().nextDouble() - 0.5D) * 16.0D;
                if (entityLiving.isPassenger()) {
                    entityLiving.stopRiding();
                }

                net.minecraftforge.event.entity.living.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(entityLiving, d3, d4, d5);
                if (event.isCanceled()) return itemstack;
                if (entityLiving.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    SoundEvent soundevent = entityLiving instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                    worldIn.playSound((PlayerEntity)null, d0, d1, d2, soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    entityLiving.playSound(soundevent, 1.0F, 1.0F);
                    break;
                }
            }

            if (entityLiving instanceof PlayerEntity) {
                ((PlayerEntity)entityLiving).getCooldownTracker().setCooldown(this, 20);
            }
        }

        return itemstack;
    }

}
