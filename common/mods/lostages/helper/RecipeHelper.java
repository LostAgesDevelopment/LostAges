package mods.lostages.helper;

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
		Recipes.addToolRecipe("sword", new ItemStack(Items.swordBone.get()), new ItemStack(Items.ingotBase.get(), 1, 0));
		Recipes.addToolRecipe("pickaxe", new ItemStack(Items.pickaxeBone.get()), new ItemStack(Items.ingotBase.get(), 1, 0));
		Recipes.addToolRecipe("shovel", new ItemStack(Items.shovelBone.get()), new ItemStack(Items.ingotBase.get(), 1, 0));
		Recipes.addToolRecipe("axe", new ItemStack(Items.axeBone.get()), new ItemStack(Items.ingotBase.get(), 1, 0));
		
		//Bronze Tools
		Recipes.addToolOreRecipe("sword", new ItemStack(Items.swordBronze.get()), "ingotBronze");
		Recipes.addToolOreRecipe("pickaxe", new ItemStack(Items.pickaxeBronze.get()), "ingotBronze");
		Recipes.addToolOreRecipe("shovel", new ItemStack(Items.shovelBronze.get()), "ingotBronze");
		Recipes.addToolOreRecipe("axe", new ItemStack(Items.axeBronze.get()), "ingotBronze");
		
		//Steel Tools
		Recipes.addToolOreRecipe("sword", new ItemStack(Items.swordSteel.get()), "ingotSteel");
		Recipes.addToolOreRecipe("pickaxe", new ItemStack(Items.pickaxeSteel.get()), "ingotSteel");
		Recipes.addToolOreRecipe("shovel", new ItemStack(Items.shovelSteel.get()), "ingotSteel");
		Recipes.addToolOreRecipe("axe", new ItemStack(Items.axeSteel.get()), "ingotSteel");
		
		//Adamant Tools
		Recipes.addToolRecipe("sword", new ItemStack(Items.swordAdamant.get()), new ItemStack(Items.ingotBase.get(), 1, 5));
		Recipes.addToolRecipe("pickaxe", new ItemStack(Items.pickaxeAdamant.get()), new ItemStack(Items.ingotBase.get(), 1, 5));
		Recipes.addToolRecipe("shovel", new ItemStack(Items.shovelAdamant.get()), new ItemStack(Items.ingotBase.get(), 1, 5));
		Recipes.addToolRecipe("axe", new ItemStack(Items.axeAdamant.get()), new ItemStack(Items.ingotBase.get(), 1, 5));
		
		//Hammers
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerWood.get()), new ItemStack(Block.planks));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerStone.get()), new ItemStack(Block.cobblestone));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerIron.get()), new ItemStack(Item.ingotIron));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerGold.get()), new ItemStack(Item.ingotGold));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerDiamond.get()), new ItemStack(Item.diamond));
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerBone.get()), new ItemStack(Items.ingotBase.get(), 1, 0));
		Recipes.addToolOreRecipe("hammer", new ItemStack(Items.hammerBronze.get()), "ingotBronze");
		Recipes.addToolOreRecipe("hammer", new ItemStack(Items.hammerSteel.get()), "ingotSteel");
		Recipes.addToolRecipe("hammer", new ItemStack(Items.hammerAdamant.get()), new ItemStack(Items.ingotBase.get(), 1, 5));
	}
	
	private static void registerBlockRecipes() {
		Recipes.addStorageRecipe(Blocks.blockStorage.get(), 0, Items.ingotBase.get(), 1);
		Recipes.addStorageRecipe(Blocks.blockStorage.get(), 1, Items.ingotBase.get(), 2);
		Recipes.addStorageRecipe(Blocks.blockStorage.get(), 2, Items.ingotBase.get(), 3);
		Recipes.addStorageRecipe(Blocks.blockStorage.get(), 3, Items.ingotBase.get(), 4);
		Recipes.addStorageRecipe(Blocks.blockStorage.get(), 4, Items.ingotBase.get(), 5);
		Recipes.addStorageRecipe(Blocks.blockStorage.get(), 5, Items.ingotBase.get(), 6);
	}
	
	private static void registerDoubleFurnaceRecipes() {
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Items.ingotBase.get(), 3, 1), new ItemStack(Items.ingotBase.get(), 1, 2), new ItemStack(Items.ingotBase.get(), 2, 3));
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Item.coal, 2), new ItemStack(Item.ingotIron), new ItemStack(Items.ingotBase.get(), 2, 5));
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Item.ingotIron), new ItemStack(Item.coal, 2), new ItemStack(Items.ingotBase.get(), 2, 5));
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Block.oreIron), new ItemStack(Block.oreIron), new ItemStack(Item.ingotIron, 3));
		Recipes.addDoubleFurnaceRecipe(new ItemStack(Block.oreGold), new ItemStack(Block.oreGold), new ItemStack(Item.ingotGold, 3));
	}
	
}
