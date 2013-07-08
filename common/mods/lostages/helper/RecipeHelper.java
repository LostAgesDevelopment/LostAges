package mods.lostages.helper;

import mods.lostages.configuration.LAConfiguration;
import mods.lostages.util.Blocks;
import mods.lostages.util.Items;
import mods.lostages.util.Recipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class RecipeHelper {
	
	public static void init() {
		registerBlockRecipes();
		registerItemRecipes();
		registerDoubleFurnaceRecipes();
	}
	
	private static void registerItemRecipes() {
		//Bone Tools
		Recipes.addToolRecipe("sword", new ItemStack(Items.swordBone), new ItemStack(Items.ingotBase, 1, 0));
		Recipes.addToolRecipe("pickaxe", new ItemStack(Items.pickaxeBone), new ItemStack(Items.ingotBase, 1, 0));
		Recipes.addToolRecipe("shovel", new ItemStack(Items.shovelBone), new ItemStack(Items.ingotBase, 1, 0));
		Recipes.addToolRecipe("axe", new ItemStack(Items.axeBone), new ItemStack(Items.ingotBase, 1, 0));
		
		//Bronze Tools
		if (LAConfiguration.registerBronzeTools) {
			Recipes.addToolOreRecipe("sword", new ItemStack(Items.swordBronze), "ingotBronze");
			Recipes.addToolOreRecipe("pickaxe", new ItemStack(Items.pickaxeBronze), "ingotBronze");
			Recipes.addToolOreRecipe("shovel", new ItemStack(Items.shovelBronze), "ingotBronze");
			Recipes.addToolOreRecipe("axe", new ItemStack(Items.axeBronze), "ingotBronze");
		}
		
		//Steel Tools
		if (LAConfiguration.registerSteelTools) {
			Recipes.addToolOreRecipe("sword", new ItemStack(Items.swordSteel), "ingotSteel");
			Recipes.addToolOreRecipe("pickaxe", new ItemStack(Items.pickaxeSteel), "ingotSteel");
			Recipes.addToolOreRecipe("shovel", new ItemStack(Items.shovelSteel), "ingotSteel");
			Recipes.addToolOreRecipe("axe", new ItemStack(Items.axeSteel), "ingotSteel");
		}
		
		//Adamant Tools
		Recipes.addToolRecipe("sword", new ItemStack(Items.swordAdamant), new ItemStack(Items.ingotBase, 1, 5));
		Recipes.addToolRecipe("pickaxe", new ItemStack(Items.pickaxeAdamant), new ItemStack(Items.ingotBase, 1, 5));
		Recipes.addToolRecipe("shovel", new ItemStack(Items.shovelAdamant), new ItemStack(Items.ingotBase, 1, 5));
		Recipes.addToolRecipe("axe", new ItemStack(Items.axeAdamant), new ItemStack(Items.ingotBase, 1, 5));
		
		//Hammers
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerWood), new ItemStack(Block.planks));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerStone), new ItemStack(Block.cobblestone));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerIron), new ItemStack(Item.ingotIron));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerGold), new ItemStack(Item.ingotGold));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerDiamond), new ItemStack(Item.diamond));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerBone), new ItemStack(Items.ingotBase, 1, 0));
		Recipes.addToolOreRecipe("hammer", new ItemStack(Items.hammerBronze), "ingotBronze");
		Recipes.addToolOreRecipe("hammer", new ItemStack(Items.hammerSteel), "ingotSteel");
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerAdamant), new ItemStack(Items.ingotBase, 1, 5));
	}
	
	private static void registerBlockRecipes() {
		Recipes.addStorageRecipe(Blocks.blockStorage, 0, Items.ingotBase, 1);
		Recipes.addStorageRecipe(Blocks.blockStorage, 1, Items.ingotBase, 2);
		Recipes.addStorageRecipe(Blocks.blockStorage, 2, Items.ingotBase, 3);
		Recipes.addStorageRecipe(Blocks.blockStorage, 3, Items.ingotBase, 4);
		Recipes.addStorageRecipe(Blocks.blockStorage, 4, Items.ingotBase, 5);
		Recipes.addStorageRecipe(Blocks.blockStorage, 5, Items.ingotBase, 6);
	}
	
	private static void registerDoubleFurnaceRecipes() {
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Items.ingotBase, 3, 1), new ItemStack(Items.ingotBase, 1, 2), new ItemStack(Items.ingotBase, 2, 3));
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Item.coal, 2), new ItemStack(Item.ingotIron), new ItemStack(Items.ingotBase, 2, 5));
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Item.ingotIron), new ItemStack(Item.coal, 2), new ItemStack(Items.ingotBase, 2, 5));
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Block.oreIron), new ItemStack(Block.oreIron), new ItemStack(Item.ingotIron, 3));
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Block.oreGold), new ItemStack(Block.oreGold), new ItemStack(Item.ingotGold, 3));
	}
	
}
