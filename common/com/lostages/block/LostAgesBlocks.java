package com.lostages.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.lostages.LostAges;
import com.lostages.lib.BlockIDs;
import com.lostages.lib.BlockStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class LostAgesBlocks 
{

	public static Block oreAdamant;
	public static Block oreCopper;
	public static Block oreTin;
	
	public static Block furnaceIdleDouble;
	public static Block furnaceActiveDouble;

	@SuppressWarnings("deprecation")
	public static void init()
	{
		oreAdamant = new BlockLostAgesOre(BlockIDs.ORE_ADAMANT, Material.rock).setUnlocalizedName(BlockStrings.ORE_ADAMANT_NAME).setHardness(3.0F).setResistance(5.0F);
		oreCopper = new BlockLostAgesOre(BlockIDs.ORE_COPPER, Material.rock).setUnlocalizedName(BlockStrings.ORE_COPPER_NAME).setHardness(2.0F).setResistance(5.0F);
		oreTin = new BlockLostAgesOre(BlockIDs.ORE_TIN, Material.rock).setUnlocalizedName(BlockStrings.ORE_TIN_NAME).setHardness(1.5F).setResistance(5.0F);
		
		furnaceIdleDouble = new BlockDoubleFurnace(BlockIDs.DOUBLE_FURNACE_IDLE, false).setUnlocalizedName(BlockStrings.DOUBLE_FURNACE_NAME).setCreativeTab(LostAges.tabLostAgesBlocks);
		furnaceActiveDouble = new BlockDoubleFurnace(BlockIDs.DOUBLE_FURNACE_ACTIVE, true).setUnlocalizedName(BlockStrings.DOUBLE_FURNACE_NAME).setLightValue(0.875F);
		
		GameRegistry.registerBlock(furnaceIdleDouble);
		GameRegistry.registerBlock(furnaceActiveDouble);

		GameRegistry.registerBlock(oreAdamant);
		GameRegistry.registerBlock(oreCopper);
		GameRegistry.registerBlock(oreTin);
		
		OreDictionary.registerOre("oreCopper", oreCopper);
		OreDictionary.registerOre("oreTine", oreTin);

		LanguageRegistry.addName(oreAdamant, BlockStrings.ORE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(oreCopper, BlockStrings.ORE_COPPER_TRANSNAME);
		LanguageRegistry.addName(oreTin, BlockStrings.ORE_TIN_TRANSNAME);
		LanguageRegistry.addName(furnaceIdleDouble, BlockStrings.DOUBLE_FURNACE_TRANSNAME);

		GameRegistry.addRecipe(new ItemStack(furnaceIdleDouble), new Object[]{"III", "FBF", "III", 'I', Item.ingotIron, 'F', Block.furnaceIdle, 'B', Item.bucketEmpty});

		MinecraftForge.setBlockHarvestLevel(oreAdamant, "pickaxe", 3);
	}
}
