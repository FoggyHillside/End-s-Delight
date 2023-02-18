package cn.foggyhillside.endsdelight.block;

import cn.foggyhillside.endsdelight.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber
public class ChorusFruitPie {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Player player) {
        execute(null, world, x, y, z, entity, player);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Player player) {
        if (entity == null)
            return;
        if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == BlockRegistry.ChorusFruitPie.get()
                && player.getOffhandItem().getItem() == (ItemStack.EMPTY).getItem()
                && player.getOffhandItem().getItem() == (ItemStack.EMPTY).getItem()
                && player.isShiftKeyDown() == true
                && player.canEat(false)) {
            if (!world.isClientSide()) {
                double d0 = player.getX();
                double d1 = player.getY();
                double d2 = player.getZ();

                for (int i = 0; i < 16; ++i) {
                    double d3 = player.getX() + (player.getRandom().nextDouble() - 0.5D) * 16.0D;
                    double d4 = Mth.clamp(player.getY() + (double) (player.getRandom().nextInt(16) - 8), (double) world.getMinBuildHeight(), (double) (world.getMinBuildHeight() + ((ServerLevel) world).getLogicalHeight() - 1));
                    double d5 = player.getZ() + (player.getRandom().nextDouble() - 0.5D) * 16.0D;
                    if (player.isPassenger()) {
                        player.stopRiding();
                    }

                    EntityTeleportEvent.ChorusFruit event2 = ForgeEventFactory.onChorusFruitTeleport(player, d3, d4, d5);
                    if (player.randomTeleport(event2.getTargetX(), event2.getTargetY(), event2.getTargetZ(), true)) {
                        SoundEvent soundevent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                        player.playSound(soundevent, 1.0F, 1.0F);
                        break;
                    }
                }
            }
        }
    }
}





