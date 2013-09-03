package mods.lostages.config;

import mods.lostages.util.LABlocks;
import mods.lostages.util.LAItems;
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
		if (tabName.equals("LABlockTab"))
			return "Lost Ages Blocks";
		else if (tabName.equals("LAItemTab"))
			return "Lost Ages Items";
		else
			return null;
	}
	
	@Override
	public int getTabIconItemIndex() {
		if (tabName.equals("LABlockTab"))
			return new ItemStack(LABlocks.blockStorage, 1, 1).itemID;
		else if (tabName.equals("LAItemTab"))
			return LAItems.hammerMagic.itemID;
		else
			return 0;
	}
	
}
