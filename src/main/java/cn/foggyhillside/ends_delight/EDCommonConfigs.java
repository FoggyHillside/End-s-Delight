package cn.foggyhillside.ends_delight;

import com.google.common.collect.ImmutableList;
import io.github.fabricators_of_create.porting_lib.config.ModConfigSpec;

import java.util.List;

public class EDCommonConfigs {

    public static ModConfigSpec SPEC;

    public static ModConfigSpec.ConfigValue<List<? extends String>> END_MOBS;

    public static ModConfigSpec.BooleanValue GRISTLE_TELEPORT;

    public static ModConfigSpec.IntValue TELEPORT_RANGE_SIZE;

    public static ModConfigSpec.IntValue TELEPORT_MAX_HEIGHT;

    static {
        ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

        BUILDER.push("Configs for End's Delight");

        END_MOBS = BUILDER.comment("Dragon Tooth Knife can cause more damage when attacking following mobs \n(Default: [\"minecraft:enderman\", \"minecraft:endermite\", \"minecraft:ender_dragon\", \"minecraft:shulker\"])")
                .defineList("allowedMobs", ImmutableList.of("minecraft:enderman", "minecraft:endermite", "minecraft:ender_dragon", "minecraft:shulker"), obj -> true);
        GRISTLE_TELEPORT = BUILDER.comment("Whether teleport after consuming an Enderman Gristle Item or an Enderman Gristle Stew Item \nDefault: true").define("enableGristleTeleport", true);
        TELEPORT_RANGE_SIZE = BUILDER.comment("The range size of gristle teleport (Default: 24 (1 ~ 32))").defineInRange("teleportRangeSize", 24, 1, 32);
        TELEPORT_MAX_HEIGHT = BUILDER.comment("The max height of gristle teleport (Default: 32 (1 ~ 64))").defineInRange("teleportMaxHeight", 32, 1, 64);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
