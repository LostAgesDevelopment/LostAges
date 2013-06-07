package mods.lostages.helper;

import mods.lostages.api.Blocks;
import mods.lostages.api.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHelper {
	public static void init() {
		//Blocks
		OreDictionary.registerOre("oreCopper", new ItemStack(Blocks.oreBase.get(), 1, 0));
		OreDictionary.registerOre("oreTin", new ItemStack(Blocks.oreBase.get(), 1, 1));
		
		//Items
		OreDictionary.registerOre("ingotCopper", new ItemStack(Items.ingotBase.get(), 1, 1));
		OreDictionary.registerOre("ingotTin", new ItemStack(Items.ingotBase.get(), 1, 2));
	}
}
