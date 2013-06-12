package mods.lostages.block;

import java.util.List;

import mods.lostages.LostAges;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockCustomStorage extends Block {

	private String[] names = {"blockCopper", "blockTin", "blockBronze", "blockSteel", "blockStrongGold", "blockAdamant"};
	private Icon[] icons;
	
	public BlockCustomStorage(int id, Material material) {
		super(id, material);
		this.setUnlocalizedName("blockStorage");
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setCreativeTab(LostAges.tabLABlocks);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[names.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon("lostages:" + names[i]);
		}
	}
	
	@Override
	public Icon getIcon(int side, int metadata) {
		return icons[metadata];
	}

	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < icons.length; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}
	
}
