package com.lostages.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

import com.lostages.lib.BlockIDs;
import com.lostages.lib.BlockStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LostAgesBlocks 
{

	public static Block oreAdamant;
	
	@SuppressWarnings("deprecation")
	public static void init()
	{
		oreAdamant = new BlockLostAgesOre(BlockIDs.ORE_ADAMANT, Material.rock).setUnlocalizedName(BlockStrings.ORE_ADAMANT_NAME).setHardness(3.0F).setResistance(5.0F);
		
		GameRegistry.registerBlock(oreAdamant);
		
		LanguageRegistry.addName(oreAdamant, BlockStrings.ORE_ADAMANT_TRANSNAME);
		
		MinecraftForge.setBlockHarvestLevel(oreAdamant, "pickaxe", 3);
	}
	
}
