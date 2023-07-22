package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.block.*;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.ToIntFunction;

public class BlockRegistry {

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EndsDelight.MODID);

    public static final RegistryObject<Block> ChorusFruitPie = BLOCKS.register("chorus_fruit_pie",
            () -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ItemRegistry.ChorusFruitPieSlice));
    public static final RegistryObject<Block> ChorusSucculent = BLOCKS.register("chorus_succulent",
            () -> new ChorusSucculentBlock(BlockBehaviour.Properties.of().strength(0.0F, 0.0F).mapColor(MapColor.COLOR_PURPLE).lightLevel((state) -> {
                return 1 + 2 * state.getValue(ChorusSucculentBlock.Succulent);
            }).sound(SoundType.FUNGUS).noOcclusion()));
    public static final RegistryObject<Block> SteamedDragonEggBlock = BLOCKS.register("steamed_dragon_egg_block",
            ()-> new SteamedDragonEggBlock(Block.Properties.copy(Blocks.DRAGON_EGG),ItemRegistry.SteamedDragonEgg,true));
    public static final RegistryObject<Block> DragonMeatStewBlock = BLOCKS.register("dragon_meat_stew_block",
            ()-> new SteamedDragonEggBlock(Block.Properties.copy(Blocks.DRAGON_EGG),ItemRegistry.DragonMeatStew,true));
    public static final RegistryObject<Block> GrilledShulkerBlock = BLOCKS.register("grilled_shulker_block",
            ()-> new GrilledShullkerBlock(Block.Properties.copy(Blocks.SHULKER_BOX),ItemRegistry.GrilledShulker,true));
    public static final RegistryObject<Block> EndStove = BLOCKS.register("end_stove",
            () -> new EndStoveBlock(Block.Properties.copy(Blocks.END_STONE_BRICKS).lightLevel(litBlockEmission(13))));
    public static final RegistryObject<Block> DragonLegBlock = BLOCKS.register("dragon_leg_with_sauce_block",
            ()-> new DragonLegBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> ChorusFruitCrate = BLOCKS.register("chorus_fruit_crate",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
}

