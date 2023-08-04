package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModBlock {

    public static final Block ChorusFruitCrate = registerBlock("chorus_fruit_crate", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.0F).resistance(3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block EndStove = registerBlock("end_stove", new EndStoveBlock());
    public static final Block DragonLegBlock = registerBlock("dragon_leg_with_sauce_block", new DragonLegBlock(FabricBlockSettings.copy(Blocks.CAKE)));
    public static final Block ChorusSucculent = registerBlock("chorus_succulent",
            new ChorusSucculentBlock(FabricBlockSettings.of(Material.PLANT).strength(0.0F, 0.0F).mapColor(MapColor.PURPLE).lightLevel((state) -> {
                return 1 + 2 * state.get(ChorusSucculentBlock.Succulent);
            }).sounds(BlockSoundGroup.FUNGUS).nonOpaque()));
    public static final Block ChorusFruitPie = registerBlock("chorus_fruit_pie", new ChorusFruitPieBlock(ModItem.ChorusFruitPieSlice.get()));

    public static final Block SteamedDragonEggBlock = registerBlock("steamed_dragon_egg_block", new SteamedDragonEggBlock(FabricBlockSettings.copy(Blocks.DRAGON_EGG), ModItem.SteamedDragonEgg.get(), true));
    public static final Block DragonMeatStewBlock = registerBlock("dragon_meat_stew_block", new SteamedDragonEggBlock(FabricBlockSettings.copy(Blocks.DRAGON_EGG), ModItem.DragonMeatStew.get(), true));

    public static final Block GrilledShulkerBlock = registerBlock("grilled_shulker_block", new GrilledShullkerBlock(FabricBlockSettings.copy(Blocks.SHULKER_BOX), ModItem.GrilledShulker.get(), true));

    private static Block registerBlock(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(EndsDelight.MOD_ID, name), block);
    }

    public static void registerModBlocks(){
        EndsDelight.LOGGER.info("Registering Mod Blocks for " + EndsDelight.MOD_ID);
    }

    private Block block;
    private final Supplier<Block> blockSupplier;

    private ModBlock(String pathName, Supplier blockSupplier, boolean isCutout, FlammableBlockRegistry.Entry flammableRate) {
        this.blockSupplier = blockSupplier;

    }

}
