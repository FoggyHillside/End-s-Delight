package cn.foggyhillside.ends_delight.utility;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.registry.EDModDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
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

import java.util.function.Supplier;

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
                level.broadcastEntityEvent(entity, (byte) 46);
            }

            if (entity instanceof PathfinderMob pathfindermob) {
                pathfindermob.getNavigation().stop();
            }

            return true;
        }
    }

    public static void itemChorusFruitTeleport(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            for (int i = 0; i < 16; ++i) {
                double d = pEntityLiving.getX() + (pEntityLiving.getRandom().nextDouble() - (double) 0.5F) * (double) 16.0F;
                double e = Mth.clamp(pEntityLiving.getY() + (double) (pEntityLiving.getRandom().nextInt(16) - 8), pLevel.getMinBuildHeight(), (pLevel.getMinBuildHeight() + ((ServerLevel) pLevel).getLogicalHeight() - 1));
                double f = pEntityLiving.getZ() + (pEntityLiving.getRandom().nextDouble() - (double) 0.5F) * (double) 16.0F;
                if (pEntityLiving.isPassenger()) {
                    pEntityLiving.stopRiding();
                }

                Vec3 vec3 = pEntityLiving.position();
                if (pEntityLiving.randomTeleport(d, e, f, true)) {
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

    public static void blockChorusFruitTeleport(Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            for (int i = 0; i < 16; ++i) {
                double d = pEntityLiving.getX() + (pEntityLiving.getRandom().nextDouble() - (double) 0.5F) * (double) 16.0F;
                double e = Mth.clamp(pEntityLiving.getY() + (double) (pEntityLiving.getRandom().nextInt(16) - 8), pLevel.getMinBuildHeight(), (pLevel.getMinBuildHeight() + ((ServerLevel) pLevel).getLogicalHeight() - 1));
                double f = pEntityLiving.getZ() + (pEntityLiving.getRandom().nextDouble() - (double) 0.5F) * (double) 16.0F;
                if (pEntityLiving.isPassenger()) {
                    pEntityLiving.stopRiding();
                }

                Vec3 vec3 = pEntityLiving.position();
                if (pEntityLiving.randomTeleport(d, e, f, true)) {
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
        }
    }

    public static <R, T extends R> Supplier<T> register(String name, Supplier<T> supplier, Registry<R> reg) {
        T object = supplier.get();
        Registry.register(reg, ResourceLocation.fromNamespaceAndPath(EndsDelight.MOD_ID, name), object);
        return () -> object;
    }

}
