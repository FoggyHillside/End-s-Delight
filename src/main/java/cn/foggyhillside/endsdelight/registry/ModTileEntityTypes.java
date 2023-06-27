package cn.foggyhillside.endsdelight.registry;

import cn.foggyhillside.endsdelight.EndsDelight;
import cn.foggyhillside.endsdelight.tile.EndStoveTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, EndsDelight.MOD_ID);

    public static final RegistryObject<TileEntityType<EndStoveTileEntity>> END_STOVE = TILES.register("end_stove",
            () -> TileEntityType.Builder.create(EndStoveTileEntity::new, BlockRegistry.EndStove.get()).build(null));
}
