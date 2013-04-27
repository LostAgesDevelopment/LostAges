package com.lostages.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import blfngl.fallout.common.FalloutMain;

public class AdamantArmor extends ItemArmor implements IArmorTextureProvider
{

  public AdamantArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public String getArmorTextureFile(ItemStack par1)
	{
    //TODO add texture paths
		if ( par1.itemID==LostAges.helmAdamant.itemID||par1.itemID==LostAges.chestAdamant.itemID||par1.itemID==LostAges.greavesAdamant.itemID)
		{
			return "/LostAges/armor.png";
		}
		if(par1.itemID==LostAges.legsAdamant.itemID)
		{
			return "/LostAges/armor.png";
		}
		return "/LostAges/armor.png";
	}      
}
