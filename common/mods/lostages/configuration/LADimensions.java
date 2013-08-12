package mods.lostages.configuration;

import mods.lostages.dimension.WorldProviderLostAge;
import net.minecraftforge.common.DimensionManager;

public class LADimensions {

	public static void init() {
		DimensionManager.registerProviderType(LAConfiguration.dimensionLostAgeID, WorldProviderLostAge.class, false);
		
		DimensionManager.registerDimension(LAConfiguration.dimensionLostAgeID, LAConfiguration.dimensionLostAgeID);
	}
	
}
