package mods.lostages.item;

import mods.lostages.block.BlockCustomOre;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCustomOre extends ItemBlock {
	
	public ItemCustomOre(int par1) {
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
		return "block." +  BlockCustomOre.EnumCustomOre.VALID_ORES[meta].unlocalName;
	}
	
}
