package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.EDCommonConfigs;
import cn.foggyhillside.ends_delight.EndermanGristleTransport;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        if (EDCommonConfigs.GRISTLE_TELEPORT.get() && (!shift || pEntityLiving.isShiftKeyDown())) {
            if (!pLevel.isClientSide) {
                for (int i = 0; i < 16; i++) {
                    double d0 = pEntityLiving.getX() + (pEntityLiving.getRandom().nextDouble() - 0.5) * 8.0;
                    double d1 = Mth.clamp(
                            pEntityLiving.getY() + (double) (pEntityLiving.getRandom().nextInt(EDCommonConfigs.TELEPORT_RANGE_SIZE.get()) + EDCommonConfigs.TELEPORT_MAX_HEIGHT.get() + 1 - EDCommonConfigs.TELEPORT_RANGE_SIZE.get()),
                            (double) pLevel.getMinBuildHeight(),
                            (double) (pLevel.getMinBuildHeight() + ((ServerLevel) pLevel).getLogicalHeight() - 1)
                    );
                    double d2 = pEntityLiving.getZ() + (pEntityLiving.getRandom().nextDouble() - 0.5) * 8.0;
                    if (pEntityLiving.isPassenger()) {
                        pEntityLiving.stopRiding();
                    }

                    Vec3 vec3 = pEntityLiving.position();
                    net.neoforged.neoforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.neoforged.neoforge.event.EventHooks.onChorusFruitTeleport(pEntityLiving, d0, d1, d2);
                    if (event.isCanceled()) return itemstack;
                    if (EndermanGristleTransport.randomTeleport(pEntityLiving, event.getTargetX(), event.getTargetY(), event.getTargetZ(), true, damage)) {
                        pLevel.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(pEntityLiving));
                        SoundSource soundsource;
                        SoundEvent soundevent;
                        if (pEntityLiving instanceof Fox) {
                            soundevent = SoundEvents.FOX_TELEPORT;
                            soundsource = SoundSource.NEUTRAL;
                        } else {
                            soundevent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                            soundsource = SoundSource.PLAYERS;
                        }

                        pLevel.playSound(null, pEntityLiving.getX(), pEntityLiving.getY(), pEntityLiving.getZ(), soundevent, soundsource);
                        pEntityLiving.resetFallDistance();
                        break;
                    }
                }

                if (pEntityLiving instanceof Player player) {
                    player.resetCurrentImpulseContext();
                    player.getCooldowns().addCooldown(this, 20);
                }
            }
        }
        return itemstack;
    }
}
