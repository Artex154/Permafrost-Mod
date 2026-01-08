package be.artex.permafrost;

import be.artex.permafrost.entity.ModEntityTypes;
import be.artex.permafrost.item.ModItems;
import be.artex.permafrost.particle.ModParticles;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Permafrost implements ModInitializer {
	public static final String MOD_ID = "permafrost";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModParticles.registerModParticles();
		ModEntityTypes.registerModEntityTypes();
	}
}