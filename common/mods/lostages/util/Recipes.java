package mods.lostages.util;

import java.util.logging.Level;

import mods.lostages.recipe.DoubleFurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void addToolRecipe(String toolType, ItemStack output, ItemStack toolMaterial) {
		if (toolType.equals("sword")) {
			GameRegistry.addShapedRecipe(output, new Object[]{"X", "X", "S", 'X', toolMaterial, 'S', Item.stick});
		} else if (toolType.equals("pickaxe")) {
			GameRegistry.addShapedRecipe(output, new Object[]{"XXX", " S ", " S ", 'X', toolMaterial, 'S', Item.stick});
		} else if (toolType.equals("shovel")) {
			GameRegistry.addShapedRecipe(output, new Object[]{"X", "S", "S", 'X', toolMaterial, 'S', Item.stick});
		} else if (toolType.equals("axe")) {
			GameRegistry.addShapedRecipe(output, new Object[]{"XX", "XS", " S", 'X', toolMaterial, 'S', Item.stick}); 
		} else if (toolType.equals("hammer")) {
			GameRegistry.addShapedRecipe(output, new Object[]{"XXX", "XXX", " S ", 'X', toolMaterial, 'S', Item.stick});
		} else {
			FMLLog.log("Lost Ages", Level.INFO, "The tool type, " + toolType + " is invalid.  The recipe for " + output.getDisplayName() + " will not work!");
		}
	}
	
	public static void addToolOreRecipe(String toolType, ItemStack output, String toolMaterial) {
		if (toolType.equals("sword")) {
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"X", "X", "S", 'X', toolMaterial, 'S', Item.stick}));
		} else if (toolType.equals("pickaxe")) {
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"XXX", " S ", " S ", 'X', toolMaterial, 'S', Item.stick}));
		} else if (toolType.equals("shovel")) {
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"X", "S", "S", 'X', toolMaterial, 'S', Item.stick}));
		} else if (toolType.equals("axe")) {
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"XX", "XS", " S", 'X', toolMaterial, 'S', Item.stick}));
		} else if (toolType.equals("hammer")) {
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"XXX", "XXX", " S ", 'X', toolMaterial, 'S', Item.stick}));
		} else {
			FMLLog.log("Lost Ages", Level.INFO, "The tool type, " + toolType + " is invalid.  The recipe for " + output.getDisplayName() + " will not work!");
		}
	}
	
	public static void addDoubleFurnaceRecipe(ItemStack input1, ItemStack input2, ItemStack output) {
		DoubleFurnaceRecipes.smelting().addDoubleSmelting(input1, input2, output);
	}
	
	public static void addStorageRecipe(Block output, int outputMetadata, Item input, int inputMetadata) {
		GameRegistry.addShapedRecipe(new ItemStack(output, 1, outputMetadata), new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(input, 1, inputMetadata)});
		GameRegistry.addShapelessRecipe(new ItemStack(input, 9, inputMetadata), new Object[]{new ItemStack(output, 1, outputMetadata)});
	}

}
