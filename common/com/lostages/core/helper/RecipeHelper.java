package com.lostages.core.helper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.lostages.recipe.DoubleFurnaceRecipes;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHelper {
	
	public static void addMetaShapedCrafting(Block block, int outputMetadata, int outputAmount, Object recipe) {
		GameRegistry.addShapedRecipe(new ItemStack(block, outputAmount, outputMetadata), recipe);
	}
	
	public static void addMetaShapedCrafting(Item item, int outputMetadata, int outputAmount, Object recipe) {
		GameRegistry.addShapedRecipe(new ItemStack(item, outputAmount, outputMetadata), recipe);
	}
	
	public static void addMetaSmelting(int input, int metadata, ItemStack output, float xp) {
		FurnaceRecipes.smelting().addSmelting(input, metadata, output, xp);
	}
	
	public static void addDoubleFurnaceRecipe(ItemStack input1, ItemStack input2, ItemStack output) {
		DoubleFurnaceRecipes.smelting().addDoubleSmelting(input1, input2, output);
	}
	
}
