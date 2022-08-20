package cn.FoggyHillside.ends_delight;

import cn.FoggyHillside.ends_delight.item.DragonEggResearchNotes;
import cn.FoggyHillside.ends_delight.item.ItemRegistry;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Map;
import java.util.HashMap;

public class GetDragonEggResearchNotes {
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
        if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DRAGON_EGG
                && ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
                .getItem() == Items.WRITABLE_BOOK
                && ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN
                .asItem()
                && (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount() >= 4
                && ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.END_CRYSTAL)) : false)
                && ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.NETHER_STAR)) : false)) {
            if (entity instanceof PlayerEntity) {
                ItemStack _stktoremove = new ItemStack(Items.END_CRYSTAL);
                ((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
                        ((PlayerEntity) entity).container.func_234641_j_());
            }
            if (entity instanceof PlayerEntity) {
                ItemStack _stktoremove = new ItemStack(Items.NETHER_STAR);
                ((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
                        ((PlayerEntity) entity).container.func_234641_j_());
            }
            (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
            (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).shrink((int) 4);
            if (entity instanceof PlayerEntity) {
                ItemStack _setstack = new ItemStack(ItemRegistry.DragonEggResearchNotes.get());
                _setstack.setCount((int) 1);
                ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
            }
        }
    }
}
