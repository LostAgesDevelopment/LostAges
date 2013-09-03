package mods.lostages.config;

import mods.lostages.util.LABlocks;
import mods.lostages.util.LAItems;
import mods.lostages.util.RecipeHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeRegistry {

	public static void init() {
		registerBlockRecipes();
		registerItemRecipes();
		registerDoubleFurnaceRecipes();
	}
	
	//Item Recipes
	private static void registerItemRecipes() {
		//Bone Tools
		RecipeHelper.addToolRecipe("sword", new ItemStack(LAItems.swordBone), new ItemStack(LAItems.ingotBase, 1, 0));
		RecipeHelper.addToolRecipe("pickaxe", new ItemStack(LAItems.pickaxeBone), new ItemStack(LAItems.ingotBase, 1, 0));
		RecipeHelper.addToolRecipe("shovel", new ItemStack(LAItems.shovelBone), new ItemStack(LAItems.ingotBase, 1, 0));
		RecipeHelper.addToolRecipe("axe", new ItemStack(LAItems.axeBone), new ItemStack(LAItems.ingotBase, 1, 0));
		
		//Copper Armors
		if (ConfigHandler.registerCopperTools) {
			RecipeHelper.addArmorOreRecipe("helmet", new ItemStack(LAItems.helmetCopper), "ingotCopper");
			RecipeHelper.addArmorOreRecipe("plate", new ItemStack(LAItems.bootsCopper), "ingotCopper");
			RecipeHelper.addArmorOreRecipe("legs", new ItemStack(LAItems.legsCopper), "ingotCopper");
			RecipeHelper.addArmorOreRecipe("boots", new ItemStack(LAItems.bootsCopper), "ingotCopper");
		}
		
		//Bronze Tools & Armors
		if (ConfigHandler.registerBronzeTools) {
			RecipeHelper.addToolOreRecipe("sword", new ItemStack(LAItems.swordBronze), "ingotBronze");
			RecipeHelper.addToolOreRecipe("pickaxe", new ItemStack(LAItems.pickaxeBronze), "ingotBronze");
			RecipeHelper.addToolOreRecipe("shovel", new ItemStack(LAItems.shovelBronze), "ingotBronze");
			RecipeHelper.addToolOreRecipe("axe", new ItemStack(LAItems.axeBronze), "ingotBronze");
			RecipeHelper.addArmorOreRecipe("helmet", new ItemStack(LAItems.helmetBronze), "ingotBronze");
			RecipeHelper.addArmorOreRecipe("plate", new ItemStack(LAItems.plateBronze), "ingotBronze");
			RecipeHelper.addArmorOreRecipe("legs", new ItemStack(LAItems.legsBronze), "ingotBronze");
			RecipeHelper.addArmorOreRecipe("boots", new ItemStack(LAItems.bootsBronze), "ingotBronze");
		}
		
		//Steel Tools & Armors
		if (ConfigHandler.registerSteelTools) {
			RecipeHelper.addToolOreRecipe("sword", new ItemStack(LAItems.swordSteel), "ingotSteel");
			RecipeHelper.addToolOreRecipe("pickaxe", new ItemStack(LAItems.pickaxeSteel), "ingotSteel");
			RecipeHelper.addToolOreRecipe("shovel", new ItemStack(LAItems.shovelSteel), "ingotSteel");
			RecipeHelper.addToolOreRecipe("axe", new ItemStack(LAItems.axeSteel), "ingotSteel");
			RecipeHelper.addArmorOreRecipe("helmet", new ItemStack(LAItems.helmetSteel), "ingotSteel");
			RecipeHelper.addArmorOreRecipe("plate", new ItemStack(LAItems.plateSteel), "ingotSteel");
			RecipeHelper.addArmorOreRecipe("legs", new ItemStack(LAItems.legsSteel), "ingotSteel");
			RecipeHelper.addArmorOreRecipe("boots", new ItemStack(LAItems.bootsSteel), "ingotSteel");
		}
		
		//Adamant Tools & Armors
		RecipeHelper.addToolRecipe("sword", new ItemStack(LAItems.swordAdamant), new ItemStack(LAItems.ingotBase, 1, 6));
		RecipeHelper.addToolRecipe("pickaxe", new ItemStack(LAItems.pickaxeAdamant), new ItemStack(LAItems.ingotBase, 1, 6));
		RecipeHelper.addToolRecipe("shovel", new ItemStack(LAItems.shovelAdamant), new ItemStack(LAItems.ingotBase, 1, 6));
		RecipeHelper.addToolRecipe("axe", new ItemStack(LAItems.axeAdamant), new ItemStack(LAItems.ingotBase, 1, 6));
		RecipeHelper.addArmorRecipe("helmet", new ItemStack(LAItems.helmetAdamant), new ItemStack(LAItems.ingotBase, 1, 6));
		RecipeHelper.addArmorRecipe("plate", new ItemStack(LAItems.plateAdamant), new ItemStack(LAItems.ingotBase, 1, 6));
		RecipeHelper.addArmorRecipe("legs", new ItemStack(LAItems.legsAdamant), new ItemStack(LAItems.ingotBase, 1, 6));
		RecipeHelper.addArmorRecipe("boots", new ItemStack(LAItems.bootsAdamant), new ItemStack(LAItems.ingotBase, 1, 6));
		
		//Hammers
		RecipeHelper.addToolRecipe("hammer", new ItemStack(LAItems.hammerWood), new ItemStack(Block.planks));
		RecipeHelper.addToolRecipe("hammer", new ItemStack(LAItems.hammerStone), new ItemStack(Block.cobblestone));
		RecipeHelper.addToolRecipe("hammer", new ItemStack(LAItems.hammerIron), new ItemStack(Item.ingotIron));
		RecipeHelper.addToolRecipe("hammer", new ItemStack(LAItems.hammerGold), new ItemStack(Item.ingotGold));
		RecipeHelper.addToolRecipe("hammer", new ItemStack(LAItems.hammerDiamond), new ItemStack(Item.diamond));
		RecipeHelper.addToolRecipe("hammer", new ItemStack(LAItems.hammerBone), new ItemStack(LAItems.ingotBase, 1, 0));
		RecipeHelper.addToolRecipe("hammer", new ItemStack(LAItems.hammerAdamant), new ItemStack(LAItems.ingotBase, 1, 6));
		RecipeHelper.addToolOreRecipe("hammer", new ItemStack(LAItems.hammerBronze), "ingotBronze");
		RecipeHelper.addToolOreRecipe("hammer", new ItemStack(LAItems.hammerSteel), "ingotSteel");
	}
	
	//Block Recipes
	private static void registerBlockRecipes() {
		//Storage Block
		RecipeHelper.addStorageRecipe(LABlocks.blockStorage, 0, LAItems.ingotBase, 1);
		RecipeHelper.addStorageRecipe(LABlocks.blockStorage, 1, LAItems.ingotBase, 2);
		RecipeHelper.addStorageRecipe(LABlocks.blockStorage, 2, LAItems.ingotBase, 3);
		RecipeHelper.addStorageRecipe(LABlocks.blockStorage, 3, LAItems.ingotBase, 4);
		RecipeHelper.addStorageRecipe(LABlocks.blockStorage, 4, LAItems.ingotBase, 5);
		RecipeHelper.addStorageRecipe(LABlocks.blockStorage, 5, LAItems.ingotBase, 6);
	}
	
	//Double Furnace Recipes
	private static void registerDoubleFurnaceRecipes() {
		RecipeHelper.addDoubleFurnaceRecipe(new ItemStack(LAItems.ingotBase, 3, 1), new ItemStack(LAItems.ingotBase, 1, 2), new ItemStack(LAItems.ingotBase, 2, 3));
		RecipeHelper.addDoubleFurnaceRecipe(new ItemStack(Item.ingotIron), new ItemStack(Item.coal, 2), new ItemStack(LAItems.ingotBase, 2, 5));
		RecipeHelper.addDoubleFurnaceRecipe(new ItemStack(Block.oreIron), new ItemStack(Block.oreIron), new ItemStack(Item.ingotIron, 2));
		RecipeHelper.addDoubleFurnaceRecipe(new ItemStack(Block.oreGold), new ItemStack(Block.oreGold), new ItemStack(Item.ingotGold, 2));
		RecipeHelper.addDoubleFurnaceRecipe(new ItemStack(LABlocks.oreBase, 1, 0), new ItemStack(LABlocks.oreBase, 1, 0), new ItemStack(LAItems.ingotBase, 2, 1));
		RecipeHelper.addDoubleFurnaceRecipe(new ItemStack(LABlocks.oreBase, 1, 1), new ItemStack(LABlocks.oreBase, 1, 1), new ItemStack(LAItems.ingotBase, 2, 2));
	}
	
}
