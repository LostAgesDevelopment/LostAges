package com.lostages.core.creativetab;

import com.lostages.item.LostAgesItems;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TabLostAgesTools extends CreativeTabs
{
	public TabLostAgesTools(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return LostAgesItems.ingotBone.itemID;
	}
	
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "Lost Ages: Tools";
	}
}
