package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.EndsDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModTags {

    public static final TagKey<Biome> CHORUS_SUCCULENT = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(EndsDelight.MOD_ID, "chorus_succulent"));

}
