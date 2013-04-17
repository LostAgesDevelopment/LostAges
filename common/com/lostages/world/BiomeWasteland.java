package com.lostages.world;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeWasteland extends BiomeGenBase
{

	public BiomeWasteland(int id) 
	{
		super(id);
		topBlock = (byte) Block.grass.blockID;
		fillerBlock = (byte) Block.dirt.blockID;
	}

}
