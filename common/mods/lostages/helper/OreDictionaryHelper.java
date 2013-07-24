package mods.lostages.helper;

import mods.lostages.util.Blocks;
import mods.lostages.util.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHelper {
	
	public static void init() {
		//Blocks
		OreDictionary.registerOre("oreCopper", new ItemStack(Blocks.oreBase, 1, 0));
		OreDictionary.registerOre("oreTin", new ItemStack(Blocks.oreBase, 1, 1));
		
		//Items
		OreDictionary.registerOre("ingotCopper", new ItemStack(Items.ingotBase, 1, 1));
		OreDictionary.registerOre("ingotTin", new ItemStack(Items.ingotBase, 1, 2));
		OreDictionary.registerOre("ingotBronze", new ItemStack(Items.ingotBase, 1, 3));
		OreDictionary.registerOre("ingotSteel", new ItemStack(Items.ingotBase, 1, 4));
	}
	
}
