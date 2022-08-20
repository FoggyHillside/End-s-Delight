package cn.FoggyHillside.ends_delight;

import cn.FoggyHillside.ends_delight.item.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EndsDelightGroup extends ItemGroup {
    public static final EndsDelightGroup ends_delightGroup = new EndsDelightGroup();

    public EndsDelightGroup() {
        super("End's Delight Group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.BubbleTea.get());
    }

}
