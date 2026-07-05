package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.EndermanGristleTransport;
import cn.foggyhillside.ends_delight.config.EDCommonConfigs;
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
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class EndermanGristleStewItem extends ConsumableItem {

    private final Float damage;

    private final Boolean shift;

    public EndermanGristleStewItem(Properties properties, float damage, boolean shift, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
        this.damage = damage;
        this.shift = shift;
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        ItemStack itemstack = super.finishUsingItem(itemStack, level, livingEntity);
        if (EDCommonConfigs.GRISTLE_TELEPORT.get() && (!shift || livingEntity.isShiftKeyDown())) {
            if (!level.isClientSide) {
                double d0 = livingEntity.getX();
                double d1 = livingEntity.getY();
                double d2 = livingEntity.getZ();

                for (int i = 0; i < 16; ++i) {
                    double d3 = livingEntity.getX() + (livingEntity.getRandom().nextDouble() - 0.5D) * 8.0D;
                    double d4 = Mth.clamp(livingEntity.getY() + (double) (livingEntity.getRandom().nextInt(EDCommonConfigs.TELEPORT_RANGE_SIZE.get()) + EDCommonConfigs.TELEPORT_MAX_HEIGHT.get() + 1 - EDCommonConfigs.TELEPORT_RANGE_SIZE.get()), level.getMinBuildHeight(), level.getMinBuildHeight() + ((ServerLevel) level).getLogicalHeight() - 1);
                    double d5 = livingEntity.getZ() + (livingEntity.getRandom().nextDouble() - 0.5D) * 8.0D;
                    if (livingEntity.isPassenger()) {
                        livingEntity.stopRiding();
                    }

                    net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(livingEntity, d3, d4, d5);
                    if (event.isCanceled()) return itemstack;
                    if (EndermanGristleTransport.randomTeleport(livingEntity, d3, d4, d5, true, damage)) {
                        SoundEvent soundevent = livingEntity instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                        level.playSound(null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                        livingEntity.playSound(soundevent, 1.0F, 1.0F);
                        break;
                    }
                }

                if (livingEntity instanceof Player) {
                    ((Player) livingEntity).getCooldowns().addCooldown(this, 20);
                }
            }

            return itemstack;
        }
        return itemstack;
    }
}
