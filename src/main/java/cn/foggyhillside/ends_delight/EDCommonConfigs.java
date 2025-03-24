package cn.foggyhillside.ends_delight;

import com.google.common.collect.ImmutableList;
import vectorwing.farmersdelight.refabricated.mlconfigs.ConfigBuilder;
import vectorwing.farmersdelight.refabricated.mlconfigs.ConfigType;
import vectorwing.farmersdelight.refabricated.mlconfigs.ModConfigHolder;

import java.util.List;
import java.util.function.Supplier;

public class EDCommonConfigs {

    public static ModConfigHolder CONFIG;

    public static Supplier<List<String>> END_MOBS;

    public static Supplier<Boolean> GRISTLE_TELEPORT;

    public static Supplier<Integer> TELEPORT_RANGE_SIZE;

    public static Supplier<Integer> TELEPORT_MAX_HEIGHT;

    static {
        ConfigBuilder builder = ConfigBuilder.create(EndsDelight.MOD_ID, ConfigType.COMMON);

        builder.push("Configs for End's Delight");

        END_MOBS = builder.comment("Dragon Tooth Knife can cause more damage when attacking following mobs \n(Default: [\"minecraft:enderman\", \"minecraft:endermite\", \"minecraft:ender_dragon\", \"minecraft:shulker\"])")
                .define("allowedMobs", ImmutableList.of("minecraft:enderman", "minecraft:endermite", "minecraft:ender_dragon", "minecraft:shulker"), obj -> true);
        GRISTLE_TELEPORT = builder.comment("Whether teleport after consuming an Enderman Gristle Item or an Enderman Gristle Stew Item \nDefault: true").define("enableGristleTeleport", true);
        TELEPORT_RANGE_SIZE = builder.comment("The range size of gristle teleport (Default: 24 (1 ~ 32))").define("teleportRangeSize", 24, 1, 32);
        TELEPORT_MAX_HEIGHT = builder.comment("The max height of gristle teleport (Default: 32 (1 ~ 64))").define("teleportMaxHeight", 32, 1, 64);

        builder.pop();
        CONFIG = builder.build();
        CONFIG.forceLoad();
    }

    public static void touch() {

    }

}
