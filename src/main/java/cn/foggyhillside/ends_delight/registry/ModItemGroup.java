package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(EndsDelight.MOD_ID, "main"),
            () -> new ItemStack(ModItem.BubbleTea.get()));
}
