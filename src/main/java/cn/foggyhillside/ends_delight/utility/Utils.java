package cn.foggyhillside.ends_delight.utility;

import cn.foggyhillside.ends_delight.registry.EDModDamageTypes;
import io.github.fabricators_of_create.porting_lib.entity.events.EntityTeleportEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import vectorwing.farmersdelight.common.registry.ModDamageTypes;

import static io.github.fabricators_of_create.porting_lib.entity.EntityHooks.onChorusFruitTeleport;

public class Utils {

    public static boolean gristleTeleport(LivingEntity entity, double pX, double pY, double pZ, boolean pBroadcastTeleport, float damage) {
        double d0 = entity.getX();
        double d1 = entity.getY();
        double d2 = entity.getZ();
        double d3 = pY;
        boolean flag = false;
        BlockPos blockpos = BlockPos.containing(pX, pY, pZ);
        Level level = entity.level();
        if (level.hasChunkAt(blockpos)) {
            boolean flag1 = false;

            while (!flag1 && blockpos.getY() > (d1 < level.getMinBuildHeight() ? level.getMinBuildHeight() : d1)) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMotion() && d3 < (double) (level.getMinBuildHeight() + ((ServerLevel) level).getLogicalHeight() - 2)) {
                    flag1 = true;
                } else {
                    d3--;
                    blockpos = blockpos1;
                }
            }

            if (flag1) {
                entity.teleportTo(pX, d3, pZ);
                if (level.noCollision(entity) && !level.containsAnyLiquid(entity.getBoundingBox())) {
                    flag = true;
                }
                if (flag) {
                    if (entity instanceof Player && !((Player) entity).isCreative()) {
                        if (entity.getHealth() < (entity.getMaxHealth() * 0.3F)) {
                            entity.hurt(ModDamageTypes.getSimpleDamageSource(level, EDModDamageTypes.ENDERMAN_GRISTLE_TELEPORT), entity.getHealth() * 1.5F);
                        } else {
                            entity.hurt(ModDamageTypes.getSimpleDamageSource(level, EDModDamageTypes.ENDERMAN_GRISTLE_TELEPORT), entity.getHealth() * damage);
                        }
                    }
                }
            }
        }

        if (!flag) {
            entity.teleportTo(d0, d1, d2);
            return false;
        } else {
            if (pBroadcastTeleport) {
                level.broadcastEntityEvent(entity, (byte)46);
            }

            if (entity instanceof PathfinderMob pathfindermob) {
                pathfindermob.getNavigation().stop();
            }

            return true;
        }
    }

    public static void itemChorusFruitTeleport(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            for (int i = 0; i < 16; i++) {
                double d0 = pEntityLiving.getX() + (pEntityLiving.getRandom().nextDouble() - 0.5) * 16.0;
                double d1 = Mth.clamp(
                        pEntityLiving.getY() + (double) (pEntityLiving.getRandom().nextInt(16) - 8),
                        (double) pLevel.getMinBuildHeight(),
                        (double) (pLevel.getMinBuildHeight() + ((ServerLevel) pLevel).getLogicalHeight() - 1)
                );
                double d2 = pEntityLiving.getZ() + (pEntityLiving.getRandom().nextDouble() - 0.5) * 16.0;
                if (pEntityLiving.isPassenger()) {
                    pEntityLiving.stopRiding();
                }

                Vec3 vec3 = pEntityLiving.position();
                EntityTeleportEvent.ChorusFruit event = onChorusFruitTeleport(pEntityLiving, d0, d1, d2);
                if (event.isCanceled()) return;
                if (pEntityLiving.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
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
                player.getCooldowns().addCooldown(pStack.getItem(), 20);
            }
        }
    }

    public static void blockChorusFruitTeleport(Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            for (int i = 0; i < 16; i++) {
                double d0 = pEntityLiving.getX() + (pEntityLiving.getRandom().nextDouble() - 0.5) * 16.0;
                double d1 = Mth.clamp(
                        pEntityLiving.getY() + (double) (pEntityLiving.getRandom().nextInt(16) - 8),
                        (double) pLevel.getMinBuildHeight(),
                        (double) (pLevel.getMinBuildHeight() + ((ServerLevel) pLevel).getLogicalHeight() - 1)
                );
                double d2 = pEntityLiving.getZ() + (pEntityLiving.getRandom().nextDouble() - 0.5) * 16.0;
                if (pEntityLiving.isPassenger()) {
                    pEntityLiving.stopRiding();
                }

                Vec3 vec3 = pEntityLiving.position();
                EntityTeleportEvent.ChorusFruit event = onChorusFruitTeleport(pEntityLiving, d0, d1, d2);
                if (event.isCanceled()) return;
                if (pEntityLiving.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
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
        }
    }

}
