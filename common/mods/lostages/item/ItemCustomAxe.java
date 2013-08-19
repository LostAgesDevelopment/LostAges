package mods.lostages.item;

import mods.lostages.LostAges;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class ItemCustomAxe extends ItemAxe {
	
	public ItemCustomAxe(int id, EnumToolMaterial material) {
		super(id, material);
		setCreativeTab(LostAges.tabLAItems);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(5) + 1);
	}
	
}
