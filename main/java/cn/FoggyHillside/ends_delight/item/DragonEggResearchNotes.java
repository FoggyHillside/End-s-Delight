package cn.FoggyHillside.ends_delight.item;

import cn.FoggyHillside.ends_delight.EndsDelightGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class DragonEggResearchNotes extends Item {

    public DragonEggResearchNotes() {
            super(new Item.Properties().group(EndsDelightGroup.ends_delightGroup).maxStackSize(64).rarity(Rarity.EPIC));
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
