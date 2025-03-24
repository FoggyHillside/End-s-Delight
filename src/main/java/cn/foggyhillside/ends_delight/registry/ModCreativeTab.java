package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.utility.Utils;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

public class ModCreativeTab {

    public static <B extends CreativeModeTab> Supplier<B> regTab(String name, Supplier<B> supplier) {
        return Utils.register(name, supplier, BuiltInRegistries.CREATIVE_MODE_TAB);
    }

    public static final Supplier<CreativeModeTab> ENDS_DELIGHT_TAB = regTab("ends_delight_tab", () -> FabricItemGroup.builder()
            .title(Component.translatable("itemGroup.ends_delight"))
            .icon(() -> ModItems.BUBBLE_TEA.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.END_STOVE.get());
                output.accept(ModItems.CHORUS_FRUIT_CRATE.get());
                output.accept(ModItems.END_STONE_KNIFE.get());
                output.accept(ModItems.PURPUR_KNIFE.get());
                output.accept(ModItems.DRAGON_EGG_SHELL_KNIFE.get());
                output.accept(ModItems.DRAGON_TOOTH_KNIFE.get());
                output.accept(ModItems.ENDER_PEARL_GRAIN.get());
                output.accept(ModItems.CHORUS_FRUIT_GRAIN.get());
                output.accept(ModItems.CHORUS_SUCCULENT.get());
                output.accept(ModItems.DRIED_CHORUS_FLOWER.get());
                output.accept(ModItems.DRAGON_TOOTH.get());
                output.accept(ModItems.NON_HATCHABLE_DRAGON_EGG.get());
                output.accept(ModItems.HALF_DRAGON_EGG_SHELL.get());
                output.accept(ModItems.LIQUID_DRAGON_EGG.get());
                output.accept(ModItems.FRIED_DRAGON_EGG.get());
                output.accept(ModItems.SHULKER_MEAT.get());
                output.accept(ModItems.SHULKER_MEAT_SLICE.get());
                output.accept(ModItems.ROASTED_SHULKER_MEAT.get());
                output.accept(ModItems.ROASTED_SHULKER_MEAT_SLICE.get());
                output.accept(ModItems.DRAGON_LEG.get());
                output.accept(ModItems.SMOKED_DRAGON_LEG.get());
                output.accept(ModItems.RAW_DRAGON_MEAT.get());
                output.accept(ModItems.ROASTED_DRAGON_MEAT.get());
                output.accept(ModItems.RAW_DRAGON_MEAT_CUTS.get());
                output.accept(ModItems.ROASTED_DRAGON_MEAT_CUTS.get());
                output.accept(ModItems.RAW_ENDERMITE_MEAT.get());
                output.accept(ModItems.DRIED_ENDERMITE_MEAT.get());
                output.accept(ModItems.ENDERMAN_GRISTLE.get());
                output.accept(ModItems.CHORUS_SAUCE.get());
                output.accept(ModItems.SHULKER_OMELETTE_MIXTURE.get());
                output.accept(ModItems.SHULKER_OMELETTE.get());
                output.accept(ModItems.RAW_ENDER_SAUSAGE.get());
                output.accept(ModItems.ENDER_SAUSAGE.get());
                output.accept(ModItems.ENDER_BAMBOO_RICE.get());
                output.accept(ModItems.STUFFED_RICE_CAKE.get());
                output.accept(ModItems.CHORUS_FLOWER_PIE.get());
                output.accept(ModItems.CHORUS_COOKIE.get());
                output.accept(ModItems.CHORUS_FRUIT_POPSICLE.get());
                output.accept(ModItems.CHORUS_FRUIT_MILK_TEA.get());
                output.accept(ModItems.BUBBLE_TEA.get());
                output.accept(ModItems.CHORUS_FRUIT_WINE.get());
                output.accept(ModItems.DRAGON_BREATH_SODA.get());
                output.accept(ModItems.CHORUS_FLOWER_TEA.get());
                output.accept(ModItems.CHORUS_FRUIT_PIE.get());
                output.accept(ModItems.CHORUS_FRUIT_PIE_SLICE.get());
                output.accept(ModItems.ENDER_CONGEE.get());
                output.accept(ModItems.DRAGON_BREATH_AND_CHORUS_SOUP.get());
                output.accept(ModItems.SHULKER_SOUP.get());
                output.accept(ModItems.ENDER_NOODLE.get());
                output.accept(ModItems.ENDERMAN_GRISTLE_STEW.get());
                output.accept(ModItems.STIR_FRIED_SHULKER_MEAT.get());
                output.accept(ModItems.ROASTED_DRAGON_STEAK.get());
                output.accept(ModItems.END_MIXED_SALAD.get());
                output.accept(ModItems.ASSORTED_SALAD.get());
                output.accept(ModItems.END_BARBECUE_STICK.get());
                output.accept(ModItems.DRAGON_LEG_BLOCK.get());
                output.accept(ModItems.DRAGON_LEG_WITH_SAUCE.get());
                output.accept(ModItems.STEAMED_DRAGON_EGG_BLOCK.get());
                output.accept(ModItems.STEAMED_DRAGON_EGG.get());
                output.accept(ModItems.DRAGON_MEAT_STEW_BLOCK.get());
                output.accept(ModItems.DRAGON_MEAT_STEW.get());
                output.accept(ModItems.GRILLED_SHULKER_BLOCK.get());
                output.accept(ModItems.GRILLED_SHULKER.get());
            }).build());

    public static void touch() {

    }
}
