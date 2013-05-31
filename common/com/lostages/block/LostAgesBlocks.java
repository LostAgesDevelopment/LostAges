package com.lostages.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.lostages.lib.BlockReference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class LostAgesBlocks {
	public static Block oreBase;
	public static ItemStack oreCopper;
	public static ItemStack oreTin;
	public static ItemStack oreAdamant;
	
	public static Block furnaceDouble;

	@SuppressWarnings("deprecation")
	public static void initBlocks() {
		oreBase = new BlockCustomOre();
		oreCopper = new ItemStack(oreBase, 1, 0);
		oreTin = new ItemStack(oreBase, 1, 1);
		oreAdamant = new ItemStack(oreBase, 1 ,2);
		
		furnaceDouble = new BlockDoubleFurnace();
		
		GameRegistry.registerBlock(furnaceDouble);
		
		GameRegistry.registerBlock(oreBase, ItemBlockCustomOre.class, BlockReference.ORE_BASE_NAME);

		LanguageRegistry.addName(new ItemStack(oreBase, 1, 0), BlockReference.ORE_COPPER_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(oreBase, 1, 1), BlockReference.ORE_TIN_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(oreBase, 1, 2), BlockReference.ORE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(furnaceDouble, BlockReference.DOUBLE_FURNACE_TRANSNAME);
	}
	
	public static void initBlockRecipes() {
		GameRegistry.addRecipe(new ItemStack(furnaceDouble), new Object[]{"III", "FBF", "III", 'I', Item.ingotIron, 'F', Block.furnaceIdle, 'B', Item.bucketEmpty});
		
		OreDictionary.registerOre(BlockReference.ORE_COPPER_NAME, new ItemStack(oreBase, 1, 0));
		OreDictionary.registerOre(BlockReference.ORE_TIN_NAME, new ItemStack(oreBase, 1, 1));
	}
}
