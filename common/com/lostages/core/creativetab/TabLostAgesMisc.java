package com.lostages.core.creativetab;

import net.minecraft.creativetab.CreativeTabs;

import com.lostages.item.LostAgesItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabLostAgesMisc extends CreativeTabs 
{

	public TabLostAgesMisc(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() 
	{
		return LostAgesItems.ingotBone.itemID;
	}
	
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel() {
		return "Lost Ages: Misc";
	}

}
