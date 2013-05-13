package com.lostages.block;

import com.lostages.lib.BlockStrings;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockLostAgesOre extends ItemBlock {

	public ItemBlockLostAgesOre(int par1) {
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
			default: return BlockStrings.ORE_BASE_NAME;
			case 0: return BlockStrings.ORE_COPPER_NAME;
			case 1: return BlockStrings.ORE_TIN_NAME;
			case 2: return BlockStrings.ORE_ADAMANT_NAME;
		}
	}

}
