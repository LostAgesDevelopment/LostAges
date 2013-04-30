package com.lostages.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

import com.lostages.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
public class AdamantArmor extends ItemArmor implements IArmorTextureProvider
{

	public AdamantArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)  {
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}


	public String getArmorTextureFile(ItemStack par1) {
    //TODO add texture paths
		if ( par1.itemID==LostAgesItems.helmAdamant.itemID||par1.itemID==LostAgesItems.chestAdamant.itemID||par1.itemID==LostAgesItems.bootsAdamant.itemID) {
			return "/LostAges/armor.png";
		}
		if(par1.itemID==LostAgesItems.legsAdamant.itemID) {
			return "/LostAges/armor.png";
		}
		return "/LostAges/armor.png";
	}      
}
