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
	public String getTranslatedTabLabel() 
	{
		switch (tabName) 
		{
			case Reference.TAB_BLOCK:
				return Reference.MOD_NAME + " Blocks";
			case Reference.TAB_MISC:
				return Reference.MOD_NAME + " Items";
			case Reference.TAB_TOOL:
				return Reference.MOD_NAME + " Tools";
			default: 
				return Reference.MOD_NAME; 
		}
	}
	
	@Override
	public int getTabIconItemIndex()
	{
		switch (tabName)
		{
			case Reference.TAB_BLOCK:
				return LostAgesBlocks.oreAdamant.blockID;
			case Reference.TAB_MISC:
				return LostAgesItems.ingotBone.itemID;
			case Reference.TAB_TOOL:
				return LostAgesItems.swordBone.itemID;
			default:
				return Item.diamond.itemID;
		}
	}
	
}
