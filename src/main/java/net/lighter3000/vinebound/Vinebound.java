package net.lighter3000.vinebound;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.lighter3000.vinebound.block.ModBlocks;
import net.lighter3000.vinebound.entity.ModEntities;
import net.lighter3000.vinebound.entity.custom.MossGolemEntity;
import net.lighter3000.vinebound.item.ModItemGroups;
import net.lighter3000.vinebound.item.ModItems;
import net.lighter3000.vinebound.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vinebound implements ModInitializer {
	public static final String MOD_ID = "vinebound";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();

        ModEntities.registerModEntities();

        ModWorldGeneration.generateModWorldGen();

        FabricDefaultAttributeRegistry.register(ModEntities.MOSS_GOLEM, MossGolemEntity.createAttributes());


	}
}