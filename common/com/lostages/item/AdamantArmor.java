package com.lostages.item;

import com.lostages.LostAges;
import com.lostages.lib.Reference;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

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
		if ( par1.itemID==LostAgesItems.helmAdamant.itemID||par1.itemID==LostAgesItems.chestAdamant.itemID||par1.itemID==LostAgesItems.greavesAdamant.itemID)
		{
			return "/LostAges/armor.png";
		}
		if(par1.itemID==LostAgesItems.legsAdamant.itemID)
		{
			return "/LostAges/armor.png";
		}
		return "/LostAges/armor.png";
	}      
}
