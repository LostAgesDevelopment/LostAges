package mods.lostages.item;

import mods.lostages.block.BlockCustomStorage;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCustomStorage extends ItemBlock {
	
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
		int meta = itemStack.getItemDamage();
		return "block." + BlockCustomStorage.EnumCustomStorage.VALID_BLOCKS[meta].unlocalName;
	}

}
