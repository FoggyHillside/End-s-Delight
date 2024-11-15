package cn.foggyhillside.ends_delight;

import cn.foggyhillside.ends_delight.registry.EDModDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.registry.ModDamageTypes;

public class EndermanGristleTransport {

    public static boolean randomTeleport(LivingEntity entity, double pX, double pY, double pZ, boolean pBroadcastTeleport, float damage) {
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

}
