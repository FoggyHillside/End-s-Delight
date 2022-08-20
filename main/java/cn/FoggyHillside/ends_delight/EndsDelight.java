package cn.FoggyHillside.ends_delight;

import cn.FoggyHillside.ends_delight.item.ItemRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ends_delight")
public class EndsDelight {
    public EndsDelight() {
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}