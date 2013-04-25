package com.lostages.recipe;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DoubleFurnaceRecipes {
	private static final DoubleFurnaceRecipes smeltBase = new DoubleFurnaceRecipes();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingList1 = new HashMap();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingList2 = new HashMap();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingExpList = new HashMap();
	
	public static final DoubleFurnaceRecipes smelting() {
		return smeltBase;
	}
	
	private DoubleFurnaceRecipes() {
		this.addDoubleSmelting(Block.oreIron.blockID, Block.oreGold.blockID, new ItemStack(Item.diamond), 0F);
	}
	
	@SuppressWarnings("unchecked")
	public void addDoubleSmelting(int input1, int input2, ItemStack output, float exp) {
		this.doubleSmeltingList1.put(Integer.valueOf(input1), output);
		this.doubleSmeltingList2.put(Integer.valueOf(input2), output);
		this.doubleSmeltingExpList.put(Integer.valueOf(output.itemID), exp);
	}
	
	public ItemStack getDoubleSmeltingResult(ItemStack item1, ItemStack item2) {
		if (item1 == null) {
			return null;
		}
		
		if (item2 == null) {
			return null;
		}
		
		ItemStack outputItem1 = (ItemStack) doubleSmeltingList1.get(Integer.valueOf(item1.itemID));
		ItemStack outputItem2 = (ItemStack) doubleSmeltingList2.get(Integer.valueOf(item2.itemID));
		
		if (outputItem1 == outputItem2) {
			return outputItem1;
		} else {
			return outputItem2;
		}
		
	}
	
}
