package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.blockentity.EndStoveBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntity {
    public static BlockEntityType<EndStoveBlockEntity> EndStove;

    public static void registerBlockEntities() {
        EndStove = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(EndsDelight.MOD_ID, "gem_infusing_station"),
                FabricBlockEntityTypeBuilder.create(EndStoveBlockEntity::new,
                        ModBlock.EndStove).build(null));
    }
}
