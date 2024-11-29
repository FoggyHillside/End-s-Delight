package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.block.*;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EndsDelight.MOD_ID);

    public static final Supplier<Block> CHORUS_FRUIT_PIE = BLOCKS.register("chorus_fruit_pie",
            () -> new ChorusFruitPieBlock(Properties.ofFullCopy(Blocks.CAKE), ModItems.CHORUS_FRUIT_PIE_SLICE));
    public static final Supplier<Block> CHORUS_SUCCULENT = BLOCKS.register("chorus_succulent",
            () -> new ChorusSucculentBlock(Properties.of().strength(0.0F, 0.0F).mapColor(MapColor.COLOR_PURPLE).lightLevel((state) -> {
                return 1 + 2 * state.getValue(ChorusSucculentBlock.SUCCULENT);
            }).sound(SoundType.FUNGUS).noOcclusion()));
    public static final Supplier<Block> STEAMED_DRAGON_EGG_BLOCK = BLOCKS.register("steamed_dragon_egg_block",
            ()-> new DragonEggFeastBlock(Properties.ofFullCopy(Blocks.DRAGON_EGG),ModItems.STEAMED_DRAGON_EGG,true));
    public static final Supplier<Block> DRAGON_MEAT_STEW_BLOCK = BLOCKS.register("dragon_meat_stew_block",
            ()-> new DragonEggFeastBlock(Properties.ofFullCopy(Blocks.DRAGON_EGG),ModItems.DRAGON_MEAT_STEW,true));
    public static final Supplier<Block> GRILLED_SHULKER_BLOCK = BLOCKS.register("grilled_shulker_block",
            ()-> new GrilledShulkerBlock(Properties.ofFullCopy(Blocks.SHULKER_BOX),ModItems.GRILLED_SHULKER,true));
    public static final Supplier<Block> END_STOVE = BLOCKS.register("end_stove",
            () -> new EndStoveBlock(Properties.ofFullCopy(Blocks.BRICKS).lightLevel(litBlockEmission(13))));
    public static final Supplier<Block> DRAGON_LEG_BLOCK = BLOCKS.register("dragon_leg_with_sauce_block",
            ()-> new DragonLegBlock(Properties.ofFullCopy(Blocks.CAKE).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> CHORUS_FRUIT_CRATE = BLOCKS.register("chorus_fruit_crate",
            ()-> new Block(Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }
}
