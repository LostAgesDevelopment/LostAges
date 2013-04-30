package com.lostages.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.lostages.LostAges;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLostAgesCoal extends Item {
	//Generic materials used in crafting and don't have any other uses
	
	public ItemLostAgesCoal(int par1) {
		super(par1);
		setCreativeTab(LostAges.tabLostAgesMisc);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("coal");
	}

}
