package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.block.entity.EndStoveBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, EndsDelight.MODID);

    public static final Supplier<BlockEntityType<EndStoveBlockEntity>> END_STOVE = TILES.register("end_stove",
            () -> BlockEntityType.Builder.of(EndStoveBlockEntity::new, ModBlocks.END_STOVE.get()).build(null));

}
