package cn.foggyhillside.endsdelight;

import cn.foggyhillside.endsdelight.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EndsDelightGroup extends ItemGroup {
    public static final EndsDelightGroup ends_delightGroup = new EndsDelightGroup();

    public EndsDelightGroup() {
        super("ends_delight");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.BubbleTea.get());
    }

}
