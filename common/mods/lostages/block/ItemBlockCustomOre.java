package mods.lostages.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCustomOre extends ItemBlock {

	public ItemBlockCustomOre(int par1) {
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
			default: return "oreBase";
			case 0: return "oreCopper";
			case 1: return "oreTin";
			case 2: return "oreAdamant";
		}
	}
}
