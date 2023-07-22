package cn.foggyhillside.ends_delight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DragonBreathAndChorusSoupItem extends ConsumableItem {

    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;

    public DragonBreathAndChorusSoupItem(Item.Properties properties) {
        super(properties);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }

    public DragonBreathAndChorusSoupItem(Item.Properties properties, boolean hasFoodEffectTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public DragonBreathAndChorusSoupItem(Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            if (this.hasCustomTooltip) {
                MutableComponent textEmpty = TextUtils.getTranslation("tooltip." + this, new Object[0]);
                tooltip.add(textEmpty.withStyle(ChatFormatting.BLUE));
            }

            if (this.hasFoodEffectTooltip) {
                TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
            }
        }

    }

    public ItemStack finishUsingItem(ItemStack p_40712_, Level p_40713_, LivingEntity p_40714_) {
        ItemStack itemstack = super.finishUsingItem(p_40712_, p_40713_, p_40714_);
        if (!p_40713_.isClientSide) {
            double d0 = p_40714_.getX();
            double d1 = p_40714_.getY();
            double d2 = p_40714_.getZ();

            for(int i = 0; i < 16; ++i) {
                double d3 = p_40714_.getX() + (p_40714_.getRandom().nextDouble() - 0.5D) * 16.0D;
                double d4 = Mth.clamp(p_40714_.getY() + (double)(p_40714_.getRandom().nextInt(16) - 8), (double)p_40713_.getMinBuildHeight(), (double)(p_40713_.getMinBuildHeight() + ((ServerLevel)p_40713_).getLogicalHeight() - 1));
                double d5 = p_40714_.getZ() + (p_40714_.getRandom().nextDouble() - 0.5D) * 16.0D;
                if (p_40714_.isPassenger()) {
                    p_40714_.stopRiding();
                }

                net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(p_40714_, d3, d4, d5);
                if (event.isCanceled()) return itemstack;
                if (p_40714_.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    SoundEvent soundevent = p_40714_ instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                    p_40713_.playSound((Player)null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    p_40714_.playSound(soundevent, 1.0F, 1.0F);
                    break;
                }
            }

            if (p_40714_ instanceof Player) {
                ((Player)p_40714_).getCooldowns().addCooldown(this, 20);
            }
        }
            Iterator<MobEffectInstance> itr = p_40714_.getActiveEffects().iterator();
            ArrayList<MobEffect> compatibleEffects = new ArrayList();

            MobEffectInstance selectedEffect;
            while(itr.hasNext()) {
                selectedEffect = (MobEffectInstance)itr.next();
                if (selectedEffect.getEffect().getCategory().equals(MobEffectCategory.HARMFUL) && selectedEffect.isCurativeItem(new ItemStack(Items.MILK_BUCKET))) {
                    compatibleEffects.add(selectedEffect.getEffect());
                }
            }

            if (compatibleEffects.size() > 0) {
                selectedEffect = p_40714_.getEffect((MobEffect)compatibleEffects.get(p_40713_.random.nextInt(compatibleEffects.size())));
                if (selectedEffect != null && !MinecraftForge.EVENT_BUS.post(new MobEffectEvent.Remove(p_40714_, selectedEffect))) {
                    p_40714_.removeEffect(selectedEffect.getEffect());
                }
            }
        return itemstack;
    }
}
