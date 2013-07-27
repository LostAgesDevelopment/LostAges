package mods.lostages.worldgen;

import mods.lostages.util.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ChestGenLA {
	
	public static void init() {
		//Dungeon Chests
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.hammerMagic), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.ingotBase, 1, 5), 1, 3, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.ingotBase, 1, 6), 1, 3, 10));
		
		//Bonus Chest
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.hammerBone), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.hammerMagic), 1, 1, 1));
		
		//Mineshafts
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Items.hammerMagic), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Items.ingotBase, 1, 5), 1, 3, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Items.ingotBase, 1, 6), 1, 3, 10));
		
		//Village Black Smith
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(Items.hammerMagic), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(Items.ingotBase, 1, 5), 1, 3, 10));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(Items.helmetAdamant), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(Items.bootsAdamant), 1, 1, 5));
	}
	
}
