package cn.foggyhillside.ends_delight.utility;

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

public class Utils {
    public static void ItemChorusFruitTeleport(ItemStack itemstack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide) {
            double d0 = livingEntity.getX();
            double d1 = livingEntity.getY();
            double d2 = livingEntity.getZ();

            for (int i = 0; i < 16; ++i) {
                double d3 = livingEntity.getX() + (livingEntity.getRandom().nextDouble() - 0.5D) * 16.0D;
                double d4 = Mth.clamp(livingEntity.getY() + (double) (livingEntity.getRandom().nextInt(16) - 8), level.getMinBuildHeight(), level.getMinBuildHeight() + ((ServerLevel) level).getLogicalHeight() - 1);
                double d5 = livingEntity.getZ() + (livingEntity.getRandom().nextDouble() - 0.5D) * 16.0D;
                if (livingEntity.isPassenger()) {
                    livingEntity.stopRiding();
                }

                net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(livingEntity, d3, d4, d5);
                if (event.isCanceled()) return;
                if (livingEntity.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    SoundEvent soundevent = livingEntity instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                    level.playSound(null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    livingEntity.playSound(soundevent, 1.0F, 1.0F);
                    break;
                }
            }

            if (livingEntity instanceof Player) {
                ((Player) livingEntity).getCooldowns().addCooldown(itemstack.getItem(), 20);
            }
        }
    }

    public static void BlockChorusFruitTeleport(Level level, LivingEntity livingEntity) {
        if (!level.isClientSide) {
            double d0 = livingEntity.getX();
            double d1 = livingEntity.getY();
            double d2 = livingEntity.getZ();

            for (int i = 0; i < 16; ++i) {
                double d3 = livingEntity.getX() + (livingEntity.getRandom().nextDouble() - 0.5D) * 16.0D;
                double d4 = Mth.clamp(livingEntity.getY() + (double) (livingEntity.getRandom().nextInt(16) - 8), level.getMinBuildHeight(), level.getMinBuildHeight() + ((ServerLevel) level).getLogicalHeight() - 1);
                double d5 = livingEntity.getZ() + (livingEntity.getRandom().nextDouble() - 0.5D) * 16.0D;
                if (livingEntity.isPassenger()) {
                    livingEntity.stopRiding();
                }

                net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(livingEntity, d3, d4, d5);
                if (event.isCanceled()) return;
                if (livingEntity.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    SoundEvent soundevent = livingEntity instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                    level.playSound(null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    livingEntity.playSound(soundevent, 1.0F, 1.0F);
                    break;
                }
            }
        }
    }
}
