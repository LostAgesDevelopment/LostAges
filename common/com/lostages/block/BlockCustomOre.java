package com.lostages.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.lostages.LostAges;
import com.lostages.lib.BlockReference;
import com.lostages.lib.Reference;

public class BlockCustomOre extends Block {

	private Icon[] icons;
	private String[] names = { BlockReference.ORE_COPPER_NAME, BlockReference.ORE_TIN_NAME, BlockReference.ORE_ADAMANT_NAME };
	
	public BlockCustomOre() {
		super(BlockReference.ORE_BASE, Material.rock);
		this.setUnlocalizedName(BlockReference.ORE_BASE_NAME);
		this.setCreativeTab(LostAges.tabLostAgesBlocks);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[names.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + names[i]);
		}
	}
	
	@Override
	public Icon getIcon(int id, int meta) {
		return icons[meta];
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < icons.length; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}
}
