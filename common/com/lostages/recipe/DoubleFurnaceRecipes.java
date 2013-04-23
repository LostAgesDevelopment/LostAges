package com.lostages.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DoubleFurnaceRecipes {
	private static final DoubleFurnaceRecipes smeltBase = new DoubleFurnaceRecipes();
	
	private Map doubleSmeltingList1 = new HashMap();
	private Map doubleSmeltingList2 = new HashMap();
	
	public static final DoubleFurnaceRecipes smelting() {
		return smeltBase;
	}
	
	private DoubleFurnaceRecipes() {
		addSmelting(Block.oreIron.blockID, Block.oreGold.blockID, new ItemStack(Item.diamond), 0F);
	}
	
	public void addSmelting(int input1, int input2, ItemStack output, float exp) {
		doubleSmeltingList1.put(Integer.valueOf(input1), output);
		doubleSmeltingList2.put(Integer.valueOf(input2), output);
	}

	public ItemStack getSmeltingResult(ItemStack item1, ItemStack item2) {
		if (item1 == null) {
			return null;
		}
		
		if (item2 == null) {
			return null;
		}
		
		ItemStack outputItem1 = (ItemStack) doubleSmeltingList1.get(Integer.valueOf(item1.itemID));
		ItemStack outputItem2 = (ItemStack) doubleSmeltingList2.get(Integer.valueOf(item2.itemID));
		System.out.println(outputItem1);
		System.out.println(outputItem2);
		
		if (outputItem1 == outputItem2) {
			return outputItem1;
		} else {
			return null;
		}
		
	}
	
}
