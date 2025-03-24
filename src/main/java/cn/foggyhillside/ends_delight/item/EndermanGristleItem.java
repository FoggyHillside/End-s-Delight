package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.EDCommonConfigs;
import cn.foggyhillside.ends_delight.utility.Utils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class EndermanGristleItem extends ConsumableItem {

    private final Float damage;

    private final Boolean shift;

    public EndermanGristleItem(Properties properties, float damage, boolean shift) {
        super(properties);
        this.damage = damage;
        this.shift = shift;
    }

    public EndermanGristleItem(Properties properties, float damage, boolean shift, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
        this.damage = damage;
        this.shift = shift;
    }

    public EndermanGristleItem(Properties properties, float damage, boolean shift, boolean hasPotionEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasPotionEffectTooltip, hasCustomTooltip);
        this.damage = damage;
        this.shift = shift;
    }

    public net.minecraft.world.item.ItemStack finishUsingItem(net.minecraft.world.item.ItemStack pStack, Level pLevel, net.minecraft.world.entity.LivingEntity pEntityLiving) {
        net.minecraft.world.item.ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        if (EDCommonConfigs.GRISTLE_TELEPORT.get() && (!shift || pEntityLiving.isShiftKeyDown())) {
            if (!pLevel.isClientSide) {
                for (int i = 0; i < 16; ++i) {
                    double d = pEntityLiving.getX() + (pEntityLiving.getRandom().nextDouble() - (double) 0.5F) * (double) 16.0F;
                    double e = Mth.clamp(pEntityLiving.getY() + (double) (pEntityLiving.getRandom().nextInt(16) - 8), pLevel.getMinBuildHeight(), (pLevel.getMinBuildHeight() + ((ServerLevel) pLevel).getLogicalHeight() - 1));
                    double f = pEntityLiving.getZ() + (pEntityLiving.getRandom().nextDouble() - (double) 0.5F) * (double) 16.0F;
                    if (pEntityLiving.isPassenger()) {
                        pEntityLiving.stopRiding();
                    }

                    Vec3 vec3 = pEntityLiving.position();
                    if (Utils.gristleTeleport(pEntityLiving, d, e, f, true, damage)) {
                        pLevel.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(pEntityLiving));
                        SoundSource soundSource;
                        SoundEvent soundEvent;
                        if (pEntityLiving instanceof Fox) {
                            soundEvent = SoundEvents.FOX_TELEPORT;
                            soundSource = SoundSource.NEUTRAL;
                        } else {
                            soundEvent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                            soundSource = SoundSource.PLAYERS;
                        }

                        pLevel.playSound(null, pEntityLiving.getX(), pEntityLiving.getY(), pEntityLiving.getZ(), soundEvent, soundSource);
                        pEntityLiving.resetFallDistance();
                        break;
                    }
                }

                if (pEntityLiving instanceof Player player) {
                    player.resetCurrentImpulseContext();
                    player.getCooldowns().addCooldown(pStack.getItem(), 20);

                }
            }
        }
        return itemstack;
    }
}
