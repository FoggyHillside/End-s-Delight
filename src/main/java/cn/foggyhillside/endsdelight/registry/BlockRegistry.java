package cn.foggyhillside.endsdelight.registry;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.blocks.PieBlock;

import java.util.function.ToIntFunction;

public class BlockRegistry {

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return (Boolean)state.get(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EndsDelight.MOD_ID);

    public static final RegistryObject<Block> ChorusFruitPie = BLOCKS.register("chorus_fruit_pie",
            () -> new PieBlock(Block.Properties.from(Blocks.CAKE), ItemRegistry.ChorusFruitPieSlice));
    public static final RegistryObject<Block> ChorusSucculent = BLOCKS.register("chorus_succulent",
            () -> new ChorusSucculentBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.PURPLE).setLightLevel((state) -> {
                return 1 + 2 * state.get(ChorusSucculentBlock.Succulent);
            }).sound(SoundType.FUNGUS).notSolid()));
    public static final RegistryObject<Block> SteamedDragonEggBlock = BLOCKS.register("steamed_dragon_egg_block",
            ()-> new SteamedDragonEggBlock(Block.Properties.from(Blocks.DRAGON_EGG),ItemRegistry.SteamedDragonEgg,true));
    public static final RegistryObject<Block> DragonMeatStewBlock = BLOCKS.register("dragon_meat_stew_block",
            ()-> new SteamedDragonEggBlock(Block.Properties.from(Blocks.DRAGON_EGG),ItemRegistry.DragonMeatStew,true));
    public static final RegistryObject<Block> GrilledShulkerBlock = BLOCKS.register("grilled_shulker_block",
            ()-> new GrilledShullkerBlock(Block.Properties.from(Blocks.SHULKER_BOX),ItemRegistry.GrilledShulker,true));
    public static final RegistryObject<Block> EndStove = BLOCKS.register("end_stove",
            () -> new EndStoveBlock(Block.Properties.from(Blocks.END_STONE_BRICKS).setLightLevel(getLightValueLit(13))));
    public static final RegistryObject<Block> ChorusFruitCrate = BLOCKS.register("chorus_fruit_crate",
            ()-> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));

}

