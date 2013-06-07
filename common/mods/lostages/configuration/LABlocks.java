package mods.lostages.configuration;

import mods.lostages.api.Blocks;
import mods.lostages.block.BlockCustomOre;
import mods.lostages.block.BlockDoubleFurnace;
import mods.lostages.block.ItemBlockCustomOre;
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
		Blocks.furnaceDouble = Optional.of(new BlockDoubleFurnace());
	}
	
	private static void registerBlocks() {
		GameRegistry.registerBlock(Blocks.oreBase.get(), ItemBlockCustomOre.class, "oreBase");
		GameRegistry.registerBlock(Blocks.furnaceDouble.get(), "furnaceDouble");
	}
	
	private static void registerNames() {
		LanguageRegistry.addName(new ItemStack(Blocks.oreBase.get(), 1, 0), "Copper Ore");
		LanguageRegistry.addName(new ItemStack(Blocks.oreBase.get(), 1, 1), "Tin Ore");
		LanguageRegistry.addName(new ItemStack(Blocks.oreBase.get(), 1, 2), "Adamant Ore");
		
		LanguageRegistry.addName(new ItemStack(Blocks.furnaceDouble.get()), "Double Furnace");
	}
}
