package com.lostages.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.lostages.lib.BlockReference;

public class ItemBlockCustomOre extends ItemBlock {

	public ItemBlockCustomOre(int par1) {
		super(par1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		switch (itemStack.getItemDamage()) {
			default: return BlockReference.ORE_BASE_NAME;
			case 0: return BlockReference.ORE_COPPER_NAME;
			case 1: return BlockReference.ORE_TIN_NAME;
			case 2: return BlockReference.ORE_ADAMANT_NAME;
		}
	}
}
