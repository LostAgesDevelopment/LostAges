package com.lostages.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.lostages.LostAges;
import com.lostages.lib.ItemReference;
import com.lostages.lib.Reference;

public class ItemCustomIngot extends Item {

	private Icon[] icons;
	private String[] names = { ItemReference.INGOT_BONE_NAME, ItemReference.INGOT_COPPER_NAME, ItemReference.INGOT_TIN_NAME, ItemReference.INGOT_BRONZE_NAME, ItemReference.INGOT_ADAMANT_NAME, ItemReference.INGOT_STEEL_NAME, ItemReference.INGOT_STRONGGOLD_NAME };
	
	public ItemCustomIngot() {
		super(ItemReference.INGOT_BASE_ID);
		this.setUnlocalizedName(ItemReference.INGOT_BASE_NAME);
		this.setCreativeTab(LostAges.tabLostAgesMisc);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		switch (itemStack.getItemDamage()) {
			default: return ItemReference.INGOT_BASE_NAME;
			case 0: return ItemReference.INGOT_BONE_NAME;
			case 1: return ItemReference.INGOT_COPPER_NAME;
			case 2: return ItemReference.INGOT_TIN_NAME;
			case 3: return ItemReference.INGOT_BRONZE_NAME;
			case 4: return ItemReference.INGOT_ADAMANT_NAME;
			case 5: return ItemReference.INGOT_STEEL_NAME;
			case 6: return ItemReference.INGOT_STRONGGOLD_NAME;
		}
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[names.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + names[i]);
		}
	}
	
	@Override
	public Icon getIconFromDamage(int meta) {
		return icons[meta];
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < names.length; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}
}
