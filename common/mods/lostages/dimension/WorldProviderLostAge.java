package mods.lostages.dimension;

import net.minecraft.world.WorldProvider;

public class WorldProviderLostAge extends WorldProvider {
	
	@Override
	public String getDimensionName() {
		return "Lost Age";
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public String getWelcomeMessage() {
		return "Entering Lost Age";
	}

	@Override
	public String getDepartMessage() {
		return "Leaving Lost Age";
	}
	
}
