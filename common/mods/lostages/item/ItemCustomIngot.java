package mods.lostages.item;

import java.util.List;

import mods.lostages.LostAges;
import mods.lostages.util.LAItems;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemCustomIngot extends Item {
	
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
		int meta = itemStack.getItemDamage();
		return "item." + EnumCustomIngot.VALID_INGOTS[meta].unlocalName;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		for (EnumCustomIngot ingot : EnumCustomIngot.VALID_INGOTS)
			ingot.loadTextures(iconRegister);
	}
	
	@Override
	public Icon getIconFromDamage(int meta) {
		return EnumCustomIngot.VALID_INGOTS[meta].texture;
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (EnumCustomIngot ingot : EnumCustomIngot.VALID_INGOTS)
			list.add(ingot.getItemStack());
	}
	
	public enum EnumCustomIngot {
		
		INGOTBONE("ingotBone"),
		INGOTCOPPER("ingotCopper"),
		INGOTTIN("ingotTin"),
		INGOTBRONZE("ingotBronze"),
		INGOTSTEEL("ingotSteel"),
		INGOTSTRONGGOLD("ingotStrongGold"),
		INGOTADAMANT("ingotAdamant");
		
		public final String unlocalName;
		public final int meta = ordinal();
		public Icon texture;
		
		public static final EnumCustomIngot[] VALID_INGOTS = values();
		
		private EnumCustomIngot(String unlocalName) {
			this.unlocalName = unlocalName;
		}
		
		public void loadTextures(IconRegister iconRegister) {
			texture = iconRegister.registerIcon("LostAges:" + unlocalName);
		}
		
		public ItemStack getItemStack() {
			return new ItemStack(LAItems.ingotBase.itemID, 1, meta);
		}
		
	}
	
}
