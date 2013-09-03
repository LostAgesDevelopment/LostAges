package mods.lostages.config;

import mods.lostages.block.BlockCustomOre;
import mods.lostages.block.BlockCustomPortal;
import mods.lostages.block.BlockCustomStorage;
import mods.lostages.block.BlockDoubleFurnace;
import mods.lostages.item.ItemCustomOre;
import mods.lostages.item.ItemCustomStorage;
import mods.lostages.util.LABlocks;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry extends LABlocks {
	
	public static void init() {
		initializeBlocks();
		registerBlocks();
		
		MinecraftForge.setBlockHarvestLevel(LABlocks.oreBase, 2, "pickaxe", 2);
	}
	
	private static void initializeBlocks() {
		LABlocks.oreBase = new BlockCustomOre(ConfigHandler.oreBaseID, Material.rock);
		
		LABlocks.blockStorage = new BlockCustomStorage(ConfigHandler.blockStorageID, Material.iron);
		LABlocks.furnaceDouble = new BlockDoubleFurnace(ConfigHandler.furnaceDoubleID);
		
		LABlocks.portalLostAge = new BlockCustomPortal(ConfigHandler.portalLostAgeID);
	}
	
	private static void registerBlocks() {
		GameRegistry.registerBlock(LABlocks.oreBase, ItemCustomOre.class, "oreBase");
		GameRegistry.registerBlock(LABlocks.blockStorage, ItemCustomStorage.class, "blockStorage");
		GameRegistry.registerBlock(LABlocks.furnaceDouble, "furnaceDouble");
		GameRegistry.registerBlock(LABlocks.portalLostAge, "portalLostAge");
	}
	
}
