package cn.foggyhillside.endsdelight;

import cn.foggyhillside.endsdelight.registry.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.Nullable;

    @Mod.EventBusSubscriber
    public class GetDragonEggResearchNotes {
        @SubscribeEvent
        public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
            if (event.getHand() != event.getEntity().getUsedItemHand())
                return;
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
        }
        public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
            execute(null, world, x, y, z, entity);
        }

        private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
            if (entity == null)
                return;
            if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DRAGON_EGG
                    && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WRITABLE_BOOK
                    && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
                    && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.NETHER_STAR)) : false)
                    && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.END_CRYSTAL)) : false)
                    && ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).getCount() >= 4) {
                ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).shrink(4);
                ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
                if (entity instanceof Player player) {
                    ItemStack itemStack = new ItemStack(Items.NETHER_STAR);
                    player.getInventory().clearOrCountMatchingItems(p -> itemStack.getItem() == p.getItem(), 1,
                            player.inventoryMenu.getCraftSlots());
                }
                if (entity instanceof Player player) {
                    ItemStack itemStack = new ItemStack(Items.END_CRYSTAL);
                    player.getInventory().clearOrCountMatchingItems(p -> itemStack.getItem() == p.getItem(), 1,
                            player.inventoryMenu.getCraftSlots());
                }
                if (entity instanceof Player _player) {
                    ItemStack itemStack = new ItemStack(ItemRegistry.DragonEggResearchNotes.get());
                    itemStack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, itemStack);
                }
            }
        }
    }

