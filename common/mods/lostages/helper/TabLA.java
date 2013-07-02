package mods.lostages.helper;

import mods.lostages.util.Blocks;
import mods.lostages.util.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabLA extends CreativeTabs {

	private String tabName;
	
	public TabLA(int par1, String par2Str) {
		super(par1, par2Str);
		tabName = par2Str;
	}

	@Override
	public String getTranslatedTabLabel() {
		if (tabName.equals("LABlockTab")) {
			return "Lost Ages Blocks";
		} else if (tabName.equals("LAToolTab")) {
			return "Lost Ages Tools";
		} else {
			return "Lost Ages Items";
		}
	}
	
	@Override
	public int getTabIconItemIndex() {
		if (tabName.equals("LABlockTab")) {
			return new ItemStack(Blocks.blockStorage, 1, 1).itemID;
		} else if (tabName.equals("LAToolTab")) {
			return Items.hammerMagic.itemID;
		} else {
			return new ItemStack(Items.ingotBase, 1, 2).itemID;
		}
	}
}
