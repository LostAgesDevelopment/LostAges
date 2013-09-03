package mods.lostages.config;

import mods.lostages.util.LABlocks;
import mods.lostages.util.LAItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegistry {

	public static void init() {
		//Blocks
		OreDictionary.registerOre("oreCopper", new ItemStack(LABlocks.oreBase, 1, 0));
		OreDictionary.registerOre("oreTin", new ItemStack(LABlocks.oreBase, 1, 1));
		OreDictionary.registerOre("oreAdamant", new ItemStack(LABlocks.oreBase, 1, 2));
		
		//Items
		OreDictionary.registerOre("ingotCopper", new ItemStack(LAItems.ingotBase, 1, 1));
		OreDictionary.registerOre("ingotTin", new ItemStack(LAItems.ingotBase, 1, 2));
		OreDictionary.registerOre("ingotBronze", new ItemStack(LAItems.ingotBase, 1, 3));
		OreDictionary.registerOre("ingotSteel", new ItemStack(LAItems.ingotBase, 1, 4));
		OreDictionary.registerOre("ingotStrongGold", new ItemStack(LAItems.ingotBase, 1, 5));
		OreDictionary.registerOre("ingotAdamant", new ItemStack(LAItems.ingotBase, 1, 6));
	}
	
}
