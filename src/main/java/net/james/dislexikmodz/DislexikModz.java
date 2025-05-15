package net.james.dislexikmodz;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.james.dislexikmodz.block.ModBlocks;
import net.james.dislexikmodz.item.ModItemGroups;
import net.james.dislexikmodz.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DislexikModz implements ModInitializer {
	public static final String MOD_ID = "dislexikmodz";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.SAPPHITE_POWDER, 240 * 20);
		});
	}
}