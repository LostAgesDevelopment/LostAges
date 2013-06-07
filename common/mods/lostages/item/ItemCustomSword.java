package mods.lostages.item;

import mods.lostages.LostAges;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemCustomSword extends ItemSword {

	public ItemCustomSword(int id, EnumToolMaterial material) {
		super(id, material);
		this.setCreativeTab(LostAges.tabLATools);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) { 
		itemIcon = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	
}
