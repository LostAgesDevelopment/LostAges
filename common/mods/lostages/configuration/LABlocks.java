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

import com.google.common.base.Optional;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LABlocks {
	public static void init() {
		initializeBlocks();
		registerBlocks();
		registerNames();
	}
	
	public static void initMiningLevel() {
		MinecraftForge.setBlockHarvestLevel(Blocks.oreBase.get(), 2, "pickaxe", 2);
	}
	
	private static void initializeBlocks() {
		Blocks.oreBase = Optional.of(new BlockCustomOre(LAConfiguration.oreBaseID, Material.rock));
		Blocks.blockStorage = Optional.of(new BlockCustomStorage(LAConfiguration.blockStorageID, Material.iron));
		Blocks.furnaceDouble = Optional.of(new BlockDoubleFurnace(LAConfiguration.furnaceDoubleID, Material.rock));
	}
	
	private static void registerBlocks() {
		GameRegistry.registerBlock(Blocks.oreBase.get(), ItemCustomOre.class, "oreBase");
		GameRegistry.registerBlock(Blocks.blockStorage.get(), ItemCustomStorage.class, "blockStorage");
		GameRegistry.registerBlock(Blocks.furnaceDouble.get(), "furnaceDouble");
	}
	
	private static void registerNames() {
		LanguageRegistry.addName(new ItemStack(Blocks.oreBase.get(), 1, 0), "Copper Ore");
		LanguageRegistry.addName(new ItemStack(Blocks.oreBase.get(), 1, 1), "Tin Ore");
		LanguageRegistry.addName(new ItemStack(Blocks.oreBase.get(), 1, 2), "Adamant Ore");
		
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage.get(), 1 ,0), "Copper Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage.get(), 1, 1), "Tin Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage.get(), 1, 2), "Bronze Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage.get(), 1, 3), "Steel Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage.get(), 1, 4), "Strong Gold Block");
		LanguageRegistry.addName(new ItemStack(Blocks.blockStorage.get(), 1, 5), "Adamant Block");
		
		LanguageRegistry.addName(new ItemStack(Blocks.furnaceDouble.get()), "Double Furnace");
	}
}
