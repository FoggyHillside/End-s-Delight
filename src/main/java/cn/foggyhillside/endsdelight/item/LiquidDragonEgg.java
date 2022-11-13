package cn.foggyhillside.endsdelight.item;

import net.minecraft.item.ItemStack;
import vectorwing.farmersdelight.items.ConsumableItem;

public class LiquidDragonEgg extends ConsumableItem {

    public LiquidDragonEgg(Properties builder) {
        super(builder);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return new ItemStack(ItemRegistry.LargerDragonEggShell.get());
    }

}
