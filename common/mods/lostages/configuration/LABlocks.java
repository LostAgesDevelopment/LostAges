package mods.lostages.configuration;

import mods.lostages.block.BlockCustomOre;
import mods.lostages.block.BlockCustomStorage;
import mods.lostages.block.BlockDoubleFurnace;
import mods.lostages.item.ItemCustomOre;
import mods.lostages.item.ItemCustomStorage;
import mods.lostages.util.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LABlocks extends Blocks {
	public static void init() {
		initializeBlocks();
		registerBlocks();
		
		MinecraftForge.setBlockHarvestLevel(Blocks.oreBase, 2, "pickaxe", 2);
		
		registerNames();
	}
	
	private static void initializeBlocks() {
		Blocks.oreBase = new BlockCustomOre(LAConfiguration.oreBaseID, Material.rock);
		Blocks.blockStorage = new BlockCustomStorage(LAConfiguration.blockStorageID, Material.iron);
		Blocks.furnaceDouble = new BlockDoubleFurnace(LAConfiguration.furnaceDoubleID, Material.rock);
	}
	
	private static void registerBlocks() {
		GameRegistry.registerBlock(Blocks.oreBase, ItemCustomOre.class, "oreBase");
		GameRegistry.registerBlock(Blocks.blockStorage, ItemCustomStorage.class, "blockStorage");
		GameRegistry.registerBlock(Blocks.furnaceDouble, "furnaceDouble");
	}
	
	private static void registerNames() {
		LanguageRegistry.addName(new ItemStack(Blocks.oreBase, 1, 0), "Copper Ore");
		LanguageRegistry.addName(new ItemStack(Blocks.oreBase, 1, 1), "Tin Ore");
		LanguageRegistry.addName(new ItemStack(Blocks.oreBase, 1, 2), "Adamant Ore");
		
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage, 1 ,0), "Copper Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage, 1, 1), "Tin Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage, 1, 2), "Bronze Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage, 1, 3), "Steel Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage, 1, 4), "Strong Gold Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage, 1, 5), "Adamant Block");
		
		LanguageRegistry.addName(new ItemStack(Blocks.furnaceDouble), "Double Furnace");
	}
}
