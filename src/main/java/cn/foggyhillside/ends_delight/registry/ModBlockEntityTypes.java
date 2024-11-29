package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.block.entity.EndStoveBlockEntity;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, EndsDelight.MOD_ID);

    public static final Supplier<BlockEntityType<EndStoveBlockEntity>> END_STOVE = TILES.register("end_stove",
            () -> BlockEntityType.Builder.of(EndStoveBlockEntity::new, ModBlocks.END_STOVE.get()).build());

}
