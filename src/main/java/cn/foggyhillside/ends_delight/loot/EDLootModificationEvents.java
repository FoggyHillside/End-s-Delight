package cn.foggyhillside.ends_delight.loot;

import cn.foggyhillside.ends_delight.EndsDelight;
import cn.foggyhillside.ends_delight.registry.ModBlocks;
import cn.foggyhillside.ends_delight.registry.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.tag.ModTags;

import static vectorwing.farmersdelight.refabricated.LootModificationEvents.pastrySlicing;

public class EDLootModificationEvents {
    private static final ResourceKey<LootTable> ENTITIES_ENDERMAN = vanillaKey("entities/enderman");
    private static final ResourceKey<LootTable> ENTITIES_ENDERMITE = vanillaKey("entities/endermite");
    private static final ResourceKey<LootTable> ENTITIES_SHULKER = vanillaKey("entities/shulker");
    private static final ResourceKey<LootTable> ENTITIES_ENDER_DRAGON = vanillaKey("entities/ender_dragon");
    private static final ResourceKey<LootTable> BLOCKS_CHORUS_FRUIT_PIE = key("blocks/chorus_fruit_pie");

    public static void init() {
        LootTableEvents.MODIFY.register(EDLootModificationEvents::modifyTable);
    }

    private static void modifyTable(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (!source.isBuiltin()) // Will return if the current loot table is modified via datapack.
            return;
        mobLoot(key, tableBuilder, source, registries);
        slicingLoot(key, tableBuilder, source, registries);
    }

    private static void mobLoot(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (key == ENTITIES_ENDERMAN) {
            tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.ENDERMAN_GRISTLE.get())
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                            EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                    )).and(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(registries, 0.4F, 0.1F)))));
        }

        if (key == ENTITIES_ENDERMITE) {
            tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.DRIED_ENDERMITE_MEAT.get())
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                                    EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                            )).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true)))
                            )).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.DRIED_ENDERMITE_MEAT.get())
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                                    EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                            )).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true)))
                            ).and(LootItemRandomChanceCondition.randomChance(0.75F)))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.DRIED_ENDERMITE_MEAT.get())
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                                    EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                            )).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true)))
                            ).and(LootItemRandomChanceCondition.randomChance(0.5F)))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.RAW_ENDERMITE_MEAT.get())
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                                    EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                            )).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(false)))
                            )).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.RAW_ENDERMITE_MEAT.get())
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                                    EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                            )).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(false)))
                            ).and(LootItemRandomChanceCondition.randomChance(0.75F)))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.RAW_ENDERMITE_MEAT.get())
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                                    EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                            )).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(false)))
                            ).and(LootItemRandomChanceCondition.randomChance(0.5F)))));
        }

        if (key == ENTITIES_SHULKER) {
            tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.SHULKER_MEAT.get())
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                            EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                    )).and(LootItemRandomChanceCondition.randomChance(0.9F)))));
        }

        if (key == ENTITIES_ENDER_DRAGON) {
            tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.DRAGON_LEG.get())
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.RAW_DRAGON_MEAT.get())
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F)))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.RAW_DRAGON_MEAT.get())
                            .when(LootItemRandomChanceCondition.randomChance(0.75F))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.RAW_DRAGON_MEAT.get())
                            .when(LootItemRandomChanceCondition.randomChance(0.5F))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.RAW_DRAGON_MEAT.get())
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                                    EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                            ))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.DRAGON_TOOTH.get())
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F)))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.DRAGON_TOOTH.get())
                            .when(LootItemRandomChanceCondition.randomChance(0.75F))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.DRAGON_TOOTH.get())
                            .when(LootItemRandomChanceCondition.randomChance(0.5F))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.DRAGON_TOOTH.get())
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                                    EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                            ))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))));
        }
    }

    private static void slicingLoot(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (key == BLOCKS_CHORUS_FRUIT_PIE)
            pastrySlicing(tableBuilder, ModBlocks.CHORUS_FRUIT_PIE.get(), ModItems.CHORUS_FRUIT_PIE_SLICE.get(), PieBlock.BITES, 4);
    }

    private static ResourceKey<LootTable> vanillaKey(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace(path));
    }

    private static ResourceKey<LootTable> key(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(EndsDelight.MOD_ID, path));
    }


}
