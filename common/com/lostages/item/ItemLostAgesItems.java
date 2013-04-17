package com.lostages.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.lostages.LostAges;
import com.lostages.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLostAgesItems extends Item {
	//Generic materials used in crafting and don't have any other uses
	
	public ItemLostAgesItems(int par1) 
	{
		super(par1);
		setCreativeTab(LostAges.tabLostAgesMisc);
	}
	
	//Texture name = Unlocalized name
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}
