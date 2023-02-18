package cn.foggyhillside.endsdelight.world.feature;

import cn.foggyhillside.endsdelight.EndsDelight;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;


public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, EndsDelight.MOD_ID);

    public static final RegistryObject<PlacedFeature> CHORUS_SUCCULENT = PLACED_FEATURE.register("chorus_succulent",
            ()-> new PlacedFeature(ModConfiguredFeatures.CHORUS_SUCCULENT.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(8),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static void register(IEventBus eventBus) {
        PLACED_FEATURE.register(eventBus);
    }
}
