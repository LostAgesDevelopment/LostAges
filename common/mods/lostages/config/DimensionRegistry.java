package mods.lostages.config;

import mods.lostages.dimension.WorldProviderLostAge;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry {

	public static void init() {
		DimensionManager.registerProviderType(ConfigHandler.dimensionLostAgeID, WorldProviderLostAge.class, false);
		
		DimensionManager.registerDimension(ConfigHandler.dimensionLostAgeID, ConfigHandler.dimensionLostAgeID);
	}
	
}
