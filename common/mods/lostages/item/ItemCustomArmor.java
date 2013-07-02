package mods.lostages.item;

import mods.lostages.LostAges;
import mods.lostages.util.Items;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCustomArmor extends ItemArmor {

	public ItemCustomArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(LostAges.tabLATools);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, int layer) {
		if (itemStack.itemID == Items.helmetAdamant.itemID || itemStack.itemID == Items.plateAdamant.itemID || itemStack.itemID == Items.bootsAdamant.itemID) {
			return "/assets/lostages/textures/armors/adamant_1.png";
		}
		if (itemStack.itemID == Items.legsAdamant.itemID) {
			return "/assets/lostages/textures/armors/adamant_2.png";
		}
		
		return null;
	}
}
