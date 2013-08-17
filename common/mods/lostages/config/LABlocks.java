package mods.lostages.config;

import mods.lostages.block.BlockCustomOre;
import mods.lostages.block.BlockCustomPortal;
import mods.lostages.block.BlockCustomStorage;
import mods.lostages.block.BlockDoubleFurnace;
import mods.lostages.item.ItemCustomOre;
import mods.lostages.item.ItemCustomStorage;
import mods.lostages.util.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class LABlocks extends Blocks {
	
	public static void init() {
		initializeBlocks();
		registerBlocks();
		
		MinecraftForge.setBlockHarvestLevel(Blocks.oreBase, 2, "pickaxe", 2);
	}
	
	private static void initializeBlocks() {
		Blocks.oreBase = new BlockCustomOre(LAConfig.oreBaseID, Material.rock);
		Blocks.oreCopper = new ItemStack(Blocks.oreBase, 1, 0);
		Blocks.oreTin = new ItemStack(Blocks.oreBase, 1, 1);
		Blocks.oreAdamant = new ItemStack(Blocks.oreBase, 1, 2);
		
		Blocks.blockStorage = new BlockCustomStorage(LAConfig.blockStorageID, Material.iron);
		Blocks.furnaceDoubleIdle = new BlockDoubleFurnace(LAConfig.furnaceDoubleIdleID, false);
		Blocks.furnaceDoubleActive = new BlockDoubleFurnace(LAConfig.furnaceDoubleActiveID, true);
		
		Blocks.portalLostAge = new BlockCustomPortal(LAConfig.portalLostAgeID);
	}
	
	private static void registerBlocks() {
		GameRegistry.registerBlock(Blocks.oreBase, ItemCustomOre.class, "oreBase");
		GameRegistry.registerBlock(Blocks.blockStorage, ItemCustomStorage.class, "blockStorage");
		GameRegistry.registerBlock(Blocks.furnaceDoubleIdle, "furnaceDoubleIdle");
		GameRegistry.registerBlock(Blocks.furnaceDoubleActive, "furnaceDoubleActive");
		GameRegistry.registerBlock(Blocks.portalLostAge, "portalLostAge");
	}
	
}
