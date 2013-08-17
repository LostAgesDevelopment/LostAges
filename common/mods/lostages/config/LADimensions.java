package mods.lostages.config;

import mods.lostages.dimension.WorldProviderLostAge;
import net.minecraftforge.common.DimensionManager;

public class LADimensions {

	public static void init() {
		DimensionManager.registerProviderType(LAConfig.dimensionLostAgeID, WorldProviderLostAge.class, false);
		
		DimensionManager.registerDimension(LAConfig.dimensionLostAgeID, LAConfig.dimensionLostAgeID);
	}
	
}
