package mods.lostages.item;

import mods.lostages.LostAges;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemCustomSword extends ItemSword {

	public ItemCustomSword(int id, EnumToolMaterial material) {
		super(id, material);
		this.setCreativeTab(LostAges.tabLAItems);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) { 
		itemIcon = iconRegister.registerIcon("LostAges:" + this.getUnlocalizedName().substring(5));
	}
	
}
