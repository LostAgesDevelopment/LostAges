package mods.lostages.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCustomOre extends ItemBlock {

	private String[] names = { "oreCopper", "oreTin", "oreAdamant" };
	
	public ItemCustomOre(int par1) {
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
		return "block." +  names[itemStack.getItemDamage()];
	}
	
}
