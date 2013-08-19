package mods.lostages.item;

import java.util.List;

import mods.lostages.LostAges;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemCustomIngot extends Item {

	private Icon[] icons;
	private String[] names = { "ingotBone", "ingotCopper", "ingotTin", "ingotBronze", "ingotSteel", "ingotStrongGold", "ingotAdamant" };
	
	public ItemCustomIngot(int par1) {
		super(par1);
		
		setMaxDamage(0);
		setHasSubtypes(true);
		setUnlocalizedName("ingotBase");
		setCreativeTab(LostAges.tabLAItems);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return "item." + names[itemStack.getItemDamage()];
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[names.length];
		for (int i = 0; i < icons.length; i++)
			icons[i] = iconRegister.registerIcon("lostages:" + names[i]);
	}
	
	@Override
	public Icon getIconFromDamage(int meta) {
		return icons[meta];
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < icons.length; i++)
			list.add(new ItemStack(id, 1, i));
	}
	
}
