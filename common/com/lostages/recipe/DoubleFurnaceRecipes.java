package com.lostages.recipe;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DoubleFurnaceRecipes {
	private static final DoubleFurnaceRecipes smeltBase = new DoubleFurnaceRecipes();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingOutputList1 = new HashMap();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingOutputList2 = new HashMap();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingExpList = new HashMap();
	
	public static final DoubleFurnaceRecipes smelting() {
		return smeltBase;
	}
	
	private DoubleFurnaceRecipes() {
		this.addDoubleSmelting(Block.oreIron.blockID, Block.oreIron.blockID, new ItemStack(Item.ingotIron, 3), 0F);
	}
	
	@SuppressWarnings("unchecked")
	public void addDoubleSmelting(int input1, int input2, ItemStack output, float exp) {
		this.doubleSmeltingOutputList1.put(Integer.valueOf(input1), output);
		this.doubleSmeltingOutputList2.put(Integer.valueOf(input2), output);
		this.doubleSmeltingExpList.put(Integer.valueOf(output.itemID), Float.valueOf(exp));
	}
	
	public ItemStack getDoubleSmeltingResult(ItemStack item1, ItemStack item2) {
		if (item1 == null) {
			return null;
		}
		
		if (item2 == null) {
			return null;
		}
		
		ItemStack outputItem1 = (ItemStack) doubleSmeltingOutputList2.get(Integer.valueOf(item1.itemID));
		ItemStack outputItem2 = (ItemStack) doubleSmeltingOutputList2.get(Integer.valueOf(item2.itemID));
		
		if (outputItem1 == outputItem2) {
			return outputItem1;
		} else {
			return outputItem2;
		}
	}
	
}