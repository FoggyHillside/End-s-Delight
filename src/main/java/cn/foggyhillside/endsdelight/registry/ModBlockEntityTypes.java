package cn.foggyhillside.endsdelight.registry;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.blockentitiy.EndStoveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, EndsDelight.MOD_ID);

    public static final RegistryObject<BlockEntityType<EndStoveBlockEntity>> END_STOVE = TILES.register("end_stove",
            () -> BlockEntityType.Builder.of(EndStoveBlockEntity::new, BlockRegistry.EndStove.get()).build(null));
}
