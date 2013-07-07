package mods.lostages.configuration;

import mods.lostages.dimension.WorldProviderLostAge;
import net.minecraftforge.common.DimensionManager;

public class LADimensions {

	public static void init() {
		DimensionManager.registerProviderType(LAConfiguration.dimensionLA, WorldProviderLostAge.class, false);
		
		DimensionManager.registerDimension(LAConfiguration.dimensionLA, LAConfiguration.dimensionLA);
	}
	
}
