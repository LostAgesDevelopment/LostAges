package com.lostages.recipe;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.lostages.item.LostAgesItems;

public class DoubleFurnaceRecipes {
	private static final DoubleFurnaceRecipes smeltBase = new DoubleFurnaceRecipes();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingOutputList1 = new HashMap();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingOutputList2 = new HashMap();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingCheckList1 = new HashMap();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingCheckList2 = new HashMap();
	
	@SuppressWarnings("rawtypes")
	private Map doubleSmeltingExpList = new HashMap();
	
	public static final DoubleFurnaceRecipes smelting() {
		return smeltBase;
	}
	
	private DoubleFurnaceRecipes() {
		this.addDoubleSmelting(new ItemStack(Block.oreIron), new ItemStack(Block.oreIron), new ItemStack(Item.ingotIron, 3), 0F);
		this.addDoubleSmelting(new ItemStack(Item.ingotIron), new ItemStack(Item.coal, 2), new ItemStack(LostAgesItems.ingotSteel), 0F);
	}
	
	@SuppressWarnings("unchecked")
	public void addDoubleSmelting(ItemStack input1, ItemStack input2, ItemStack output, float exp) {
		this.doubleSmeltingOutputList1.put(Integer.valueOf(input1.itemID), output);
		this.doubleSmeltingOutputList2.put(Integer.valueOf(input2.itemID), output);
		this.doubleSmeltingCheckList1.put(Integer.valueOf(input1.itemID), input1);
		this.doubleSmeltingCheckList2.put(Integer.valueOf(input2.itemID), input2);
		this.doubleSmeltingExpList.put(Integer.valueOf(output.itemID), Float.valueOf(exp));
	}
	
	public ItemStack getDoubleSmeltingResult(ItemStack item1, ItemStack item2) {
		if (item1 == null) {
			return null;
		}
		
		if (item2 == null) {
			return null;
		}
		
		ItemStack outputItem1 = (ItemStack) doubleSmeltingOutputList1.get(Integer.valueOf(item1.itemID));
		ItemStack outputItem2 = (ItemStack) doubleSmeltingOutputList2.get(Integer.valueOf(item2.itemID));
		
		if (outputItem1 == outputItem2) {
			return outputItem1;
		} else {
			return null;
		}
	}
	
	public ItemStack getSlot1ReduceAmount(ItemStack input) {
		return (ItemStack) this.doubleSmeltingCheckList1.get(Integer.valueOf(input.itemID));
	}
	
	public ItemStack getSlot2ReduceAmount(ItemStack input) {
		return (ItemStack) this.doubleSmeltingCheckList2.get(Integer.valueOf(input.itemID));
	}
	
}
