package cn.foggyhillside.endsdelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DragonEggResearchNotesItem extends Item {

    public DragonEggResearchNotesItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return itemStack.copy();}

}
