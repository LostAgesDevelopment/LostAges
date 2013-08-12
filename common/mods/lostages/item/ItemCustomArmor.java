package mods.lostages.item;

import mods.lostages.LostAges;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCustomArmor extends ItemArmor {
	
	public String armorMaterialName;
	
	public ItemCustomArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		armorMaterialName = par2EnumArmorMaterial.name().toLowerCase();
		this.setCreativeTab(LostAges.tabLAItems);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, int layer) {
		if (slot == 0 || slot == 1 || slot == 3)
			return "lostages:textures/armor/" + armorMaterialName + "_1.png";
		
		if (slot == 2)
			return "lostages:textures/armor/" + armorMaterialName + "_2.png";
		
		return null;
	}
	
}
