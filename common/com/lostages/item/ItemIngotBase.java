package com.lostages.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.lostages.LostAges;
import com.lostages.lib.ItemIDs;
import com.lostages.lib.ItemStrings;
import com.lostages.lib.Reference;

public class ItemIngotBase extends Item {

	private Icon[] icons;
	private String[] names = { ItemStrings.INGOT_BONE_NAME, ItemStrings.INGOT_COPPER_NAME, ItemStrings.INGOT_TIN_NAME, ItemStrings.INGOT_BRONZE_NAME, ItemStrings.INGOT_ADAMANT_NAME, ItemStrings.INGOT_STEEL_NAME, ItemStrings.INGOT_STRONGGOLD_NAME };
	
	public ItemIngotBase() {
		super(ItemIDs.INGOT_BASE);
		this.setUnlocalizedName(ItemStrings.INGOT_BASE_NAME);
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
			default: return ItemStrings.INGOT_BASE_NAME;
			case 0: return ItemStrings.INGOT_BONE_NAME;
			case 1: return ItemStrings.INGOT_COPPER_NAME;
			case 2: return ItemStrings.INGOT_TIN_NAME;
			case 3: return ItemStrings.INGOT_BRONZE_NAME;
			case 4: return ItemStrings.INGOT_ADAMANT_NAME;
			case 5: return ItemStrings.INGOT_STEEL_NAME;
			case 6: return ItemStrings.INGOT_STRONGGOLD_NAME;
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
