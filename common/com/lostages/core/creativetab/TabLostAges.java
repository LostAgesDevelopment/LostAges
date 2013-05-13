package com.lostages.core.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.lostages.block.LostAgesBlocks;
import com.lostages.item.LostAgesItems;
import com.lostages.lib.Reference;

public class TabLostAges extends CreativeTabs 
{

	private String tabName;
	
	public TabLostAges(int par1, String par2Str) {
		super(par1, par2Str);
		tabName = par2Str;
	}
	
	@Override
	public String getTranslatedTabLabel() {
		if (tabName.equals(Reference.TAB_BLOCK)) {
			return Reference.MOD_NAME + " Blocks";
		} else if (tabName.equals(Reference.TAB_TOOL)) {
			return Reference.MOD_NAME + " Tools";
		} else if (tabName.equals(Reference.TAB_MISC)) {
			return Reference.MOD_ID + " Items";
		} else {
			return Reference.MOD_NAME;
		}
	}
	
	@Override
	public int getTabIconItemIndex() {
		if (tabName.equals(Reference.TAB_BLOCK)) {
			return LostAgesBlocks.oreAdamant.itemID;
		} else if (tabName.equals(Reference.TAB_MISC)) {
			return LostAgesItems.ingotSteel.itemID;
		} else if (tabName.equals(Reference.TAB_TOOL)) {
			return LostAgesItems.swordBone.itemID;
		} else {
			return Item.diamond.itemID;
		}
	}
	
}
