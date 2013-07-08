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
		Blocks.oreCopper = new ItemStack(Blocks.oreBase, 1, 0);
		Blocks.oreTin = new ItemStack(Blocks.oreBase, 1, 1);
		Blocks.oreAdamant = new ItemStack(Blocks.oreBase, 1, 2);
		
		Blocks.blockStorage = new BlockCustomStorage(LAConfiguration.blockStorageID, Material.iron);
		Blocks.furnaceDoubleIdle = new BlockDoubleFurnace(LAConfiguration.furnaceDoubleIdleID, false);
		Blocks.furnaceDoubleActive = new BlockDoubleFurnace(LAConfiguration.furnaceDoubleActiveID, true);
		
		//	Blocks.portalLA = new BlocLAPortal(LAConfiguration.portalLAID);
	}
	
	private static void registerBlocks() {
		GameRegistry.registerBlock(Blocks.oreBase, ItemCustomOre.class, "oreBase");
		GameRegistry.registerBlock(Blocks.blockStorage, ItemCustomStorage.class, "blockStorage");
		GameRegistry.registerBlock(Blocks.furnaceDoubleIdle, "furnaceDoubleIdle");
		GameRegistry.registerBlock(Blocks.furnaceDoubleActive, "furnaceDoubleActive");
		//	GameRegistry.registerBlock(Blocks.portalLA, "portalLA");
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
		
		LanguageRegistry.addName(new ItemStack(Blocks.furnaceDoubleIdle), "Double Furnace");
		LanguageRegistry.addName(new ItemStack(Blocks.furnaceDoubleActive), "Double Furnace");
		
		//	LanguageRegistry.addName(Blocks.portalLA, "Lost Ages Portal");
	}
}
