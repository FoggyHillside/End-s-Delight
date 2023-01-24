package cn.foggyhillside.endsdelight.item;

import cn.foggyhillside.endsdelight.EndsDelight;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class DragonEggResearchNotes extends Item {

    public DragonEggResearchNotes() {
            super(new Item.Properties().tab(EndsDelight.EndsDelightTab).stacksTo(64).rarity(Rarity.EPIC));
        }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return stack.copy();
    }

}
