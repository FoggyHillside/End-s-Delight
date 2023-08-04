package cn.foggyhillside.ends_delight;

import cn.foggyhillside.ends_delight.registry.*;
import cn.foggyhillside.ends_delight.world.gen.ChorusSucculentGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class EndsDelight implements ModInitializer {

	public static final String MOD_ID = "ends_delight";
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		ModItem.registerModItems();
		ModBlock.registerModBlocks();
		ModBlockEntity.registerBlockEntities();
		ModFeatures.registerModFeatures();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ChorusSucculentGeneration.generateChorusSucculent();
		this.registerLootTable();

		LOGGER.info("Hello Fabric world!");
	}

	protected void registerLootTable() {
		Set<Identifier> scavengingEntityIdList = Set.of(EntityType.ENDERMITE.getLootTableId(), EntityType.ENDER_DRAGON.getLootTableId(), EntityType.SHULKER.getLootTableId());
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			Identifier injectId = new Identifier("ends_delight", "inject/" + id.getPath());
			if (scavengingEntityIdList.contains(id)) {
				tableBuilder.pool(LootPool.builder().with(LootTableEntry.builder(injectId)));
			}

		});
	}

}