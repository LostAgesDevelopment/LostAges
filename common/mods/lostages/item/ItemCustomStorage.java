package mods.lostages.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCustomStorage extends ItemBlock {

	private String[] names = { "blockCopper", "blockTin", "blockBronze", "blockSteel", "blockStrongGold", "blockAdamant" };
	
	public ItemCustomStorage(int par1) {
		super(par1);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return "block." + names[itemStack.getItemDamage()];
	}

}
