package mods.lostages.item;

import mods.lostages.LostAges;
import mods.lostages.api.Items;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
public class ItemCustomArmor extends ItemArmor implements IArmorTextureProvider {

	public ItemCustomArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(LostAges.tabLATools);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	
	public String getArmorTextureFile(ItemStack par1) {
		if (par1.itemID == Items.helmetAdamant.get().itemID || par1.itemID == Items.plateAdamant.get().itemID || par1.itemID == Items.bootsAdamant.get().itemID) {
			return "/mods/lostages/textures/armor/adamant_1.png";
		}
		if (par1.itemID == Items.legsAdamant.get().itemID) {
			return "/mods/lostages/textures/armor/adamant_2.png";
		}
		
		return null;
	}
}
