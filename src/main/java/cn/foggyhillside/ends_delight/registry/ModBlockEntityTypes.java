package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.blockentitiy.EndStoveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EndsDelight.MODID);

    public static final RegistryObject<BlockEntityType<EndStoveBlockEntity>> END_STOVE = TILES.register("end_stove",
            () -> BlockEntityType.Builder.of(EndStoveBlockEntity::new, BlockRegistry.EndStove.get()).build(null));
}
