package com.lostages.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.lostages.LostAges;
import com.lostages.lib.BlockIDs;
import com.lostages.lib.BlockStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class LostAgesBlocks {
	public static Block oreBase;
	public static ItemStack oreCopper;
	public static ItemStack oreTin;
	public static ItemStack oreAdamant;
	
	public static Block furnaceIdleDouble;
	public static Block furnaceActiveDouble;

	@SuppressWarnings("deprecation")
	public static void initBlocks() {
		oreBase = new BlockBaseOre();
		oreCopper = new ItemStack(oreBase, 1, 0);
		oreTin = new ItemStack(oreBase, 1, 1);
		oreAdamant = new ItemStack(oreBase, 1 ,2);
		
		furnaceIdleDouble = new BlockDoubleFurnace(BlockIDs.DOUBLE_FURNACE_IDLE, false).setUnlocalizedName(BlockStrings.DOUBLE_FURNACE_NAME).setCreativeTab(LostAges.tabLostAgesBlocks);
		furnaceActiveDouble = new BlockDoubleFurnace(BlockIDs.DOUBLE_FURNACE_ACTIVE, true).setUnlocalizedName(BlockStrings.DOUBLE_FURNACE_NAME).setLightValue(0.875F);
		
		GameRegistry.registerBlock(furnaceIdleDouble);
		GameRegistry.registerBlock(furnaceActiveDouble);

		GameRegistry.registerBlock(oreBase, ItemBlockBaseOre.class, BlockStrings.ORE_BASE_NAME);

		LanguageRegistry.addName(new ItemStack(oreBase, 1, 0), BlockStrings.ORE_COPPER_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(oreBase, 1, 1), BlockStrings.ORE_TIN_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(oreBase, 1, 2), BlockStrings.ORE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(furnaceIdleDouble, BlockStrings.DOUBLE_FURNACE_TRANSNAME);
	}
	
	public static void initBlockRecipes() {
		GameRegistry.addRecipe(new ItemStack(furnaceIdleDouble), new Object[]{"III", "FBF", "III", 'I', Item.ingotIron, 'F', Block.furnaceIdle, 'B', Item.bucketEmpty});
		
		OreDictionary.registerOre(BlockStrings.ORE_COPPER_NAME, new ItemStack(oreBase, 1, 0));
		OreDictionary.registerOre(BlockStrings.ORE_TIN_NAME, new ItemStack(oreBase, 1, 1));
	}
}
