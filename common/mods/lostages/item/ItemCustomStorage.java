package mods.lostages.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCustomStorage extends ItemBlock {

	public ItemCustomStorage(int par1) {
		super(par1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		switch (itemStack.getItemDamage()) {
			default: return "blockStorage";
			case 0: return "blockCopper";
			case 1: return "blockTin";
			case 2: return "blockBronze";
			case 3: return "blockSteel";
			case 4: return "blockStrongGold";
			case 5: return "blockAdamant";
		}
	}

}
