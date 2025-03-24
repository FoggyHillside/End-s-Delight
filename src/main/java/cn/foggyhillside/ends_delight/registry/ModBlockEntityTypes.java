package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.block.entity.EndStoveBlockEntity;
import cn.foggyhillside.ends_delight.utility.Utils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntityTypes {

    public static <B extends BlockEntityType<?>> Supplier<B> regBlockEntity(String name, Supplier<B> supplier) {
        return Utils.register(name, supplier, BuiltInRegistries.BLOCK_ENTITY_TYPE);
    }

    public static final Supplier<BlockEntityType<EndStoveBlockEntity>> END_STOVE = regBlockEntity("end_stove",
            () -> BlockEntityType.Builder.of(EndStoveBlockEntity::new, ModBlocks.END_STOVE.get()).build());

    public static void touch() {

    }
}
