package net.lighter3000.vinebound;

import net.fabricmc.api.ModInitializer;

import net.lighter3000.vinebound.block.ModBlocks;
import net.lighter3000.vinebound.item.ModItemGroups;
import net.lighter3000.vinebound.item.ModItems;
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
	}
}