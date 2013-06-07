package mods.lostages.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import mods.lostages.api.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DoubleFurnaceRecipes {
	private static final DoubleFurnaceRecipes smeltBase = new DoubleFurnaceRecipes();
	
    private HashMap<List<Integer>, ItemStack> metaSmeltingList1 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList2 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList1 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList2 = new HashMap<List<Integer>, ItemStack>();
	
	public static final DoubleFurnaceRecipes smelting() {
		return smeltBase;
	}
	
	private DoubleFurnaceRecipes() {
		this.addDoubleSmelting(new ItemStack(Items.ingotBase.get(), 3, 1), new ItemStack(Items.ingotBase.get(), 1, 2), new ItemStack(Items.ingotBase.get(), 2, 3));
		this.addDoubleSmelting(new ItemStack(Item.coal, 2), new ItemStack(Item.ingotIron), new ItemStack(Items.ingotBase.get(), 2, 5));
		this.addDoubleSmelting(new ItemStack(Item.ingotIron), new ItemStack(Item.coal, 2), new ItemStack(Items.ingotBase.get(), 2, 5));
		this.addDoubleSmelting(new ItemStack(Block.oreIron), new ItemStack(Block.oreIron), new ItemStack(Item.ingotIron, 3));
		this.addDoubleSmelting(new ItemStack(Block.oreGold), new ItemStack(Block.oreGold), new ItemStack(Item.ingotGold, 3));
	}
	
	public void addDoubleSmelting(ItemStack input1, ItemStack input2, ItemStack output) {
		this.metaSmeltingList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), output);
		this.metaSmeltingList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), output);
		this.metaSmeltingCheckList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), input1);
		this.metaSmeltingCheckList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), input2);
	}
	
	public ItemStack getDoubleSmeltingResult(ItemStack item1, ItemStack item2) {
		if (item1 == null)
			return null;
		
		if (item2 == null)
			return null;
		
		ItemStack outputItem1 = this.metaSmeltingList1.get(Arrays.asList(item1.itemID, item1.getItemDamage()));
		ItemStack outputItem2 = this.metaSmeltingList2.get(Arrays.asList(item2.itemID, item2.getItemDamage()));
		
		if (outputItem1 == null)
			return null;
		
		if (outputItem2 == null)
			return null;
		
		if (outputItem1 == outputItem2) {
			return outputItem1;
		} else {
			return outputItem2;
		}
	}
	
	public ItemStack getSlot1ReduceAmount(ItemStack input) {
		return (ItemStack) this.metaSmeltingCheckList1.get(Arrays.asList(input.itemID, input.getItemDamage()));
	}
	
	public ItemStack getSlot2ReduceAmount(ItemStack input) {
		return (ItemStack) this.metaSmeltingCheckList2.get(Arrays.asList(input.itemID, input.getItemDamage()));
	}
	
}
