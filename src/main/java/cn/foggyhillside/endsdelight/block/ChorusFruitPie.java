package cn.foggyhillside.endsdelight.block;

import cn.foggyhillside.endsdelight.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

public class ChorusFruitPie {
        @Mod.EventBusSubscriber
        private static class GlobalTrigger {
            @SubscribeEvent
            public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
                PlayerEntity entity = event.getPlayer();
                if (event.getHand() != entity.getActiveHand()) {
                    return;
                }
                double i = event.getPos().getX();
                double j = event.getPos().getY();
                double k = event.getPos().getZ();
                IWorld world = event.getWorld();
                BlockState state = world.getBlockState(event.getPos());
                Map<String, Object> dependencies = new HashMap<>();
                dependencies.put("x", i);
                dependencies.put("y", j);
                dependencies.put("z", k);
                dependencies.put("world", world);
                dependencies.put("entity", entity);
                dependencies.put("direction", event.getFace());
                dependencies.put("blockstate", state);
                dependencies.put("event", event);
                executeProcedure(dependencies);
            }
        }

        public static void executeProcedure(Map<String, Object> dependencies) {

            IWorld world = (IWorld) dependencies.get("world");
            double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
            double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
            double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
            Entity entity = (Entity) dependencies.get("entity");
            if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == BlockRegistry.ChorusFruitPie.get()
                    && ((PlayerEntity) entity).canEat(false) ){
                if (((PlayerEntity) entity).isSneaking() == true
                        && ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                        && ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
                    double d0 = ((PlayerEntity) entity).getPosX();
                    double d1 = ((PlayerEntity) entity).getPosY();
                    double d2 = ((PlayerEntity) entity).getPosZ();

                    for(int i = 0; i < 16; ++i) {
                        double d3 = ((PlayerEntity) entity).getPosX() + (((PlayerEntity) entity).getRNG().nextDouble() - 0.5D) * 16.0D;
                        double d4 = MathHelper.clamp(((PlayerEntity) entity).getPosY() + (double)(((PlayerEntity) entity).getRNG().nextInt(16) - 8), 0.0D, (double)(world.func_234938_ad_() - 1));
                        double d5 = ((PlayerEntity) entity).getPosZ() + (((PlayerEntity) entity).getRNG().nextDouble() - 0.5D) * 16.0D;
                        if (((PlayerEntity) entity).isPassenger()) {
                            ((PlayerEntity) entity).stopRiding();
                        }

                        net.minecraftforge.event.entity.living.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(((PlayerEntity) entity), d3, d4, d5);
                        if (((PlayerEntity) entity).attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                            SoundEvent soundevent = entity instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                            ((PlayerEntity) entity).playSound(soundevent, 1.0F, 1.0F);
                            break;
                        }
                    }
                }
            }
        }
}



