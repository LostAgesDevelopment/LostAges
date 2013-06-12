package mods.lostages.helper;

import mods.lostages.util.Blocks;
import mods.lostages.util.Items;
import net.minecraft.creativetab.CreativeTabs;

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
			return Blocks.oreBase.get().blockID;
		} else if (tabName.equals("LAToolTab")) {
			return Items.swordBone.get().itemID;
		} else {
			return Items.ingotBase.get().itemID;
		}
	}
}
