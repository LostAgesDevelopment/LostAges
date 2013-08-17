package mods.lostages.util;

import java.util.logging.Level;

import mods.lostages.config.LALogger;
import mods.lostages.recipe.DoubleFurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void addToolRecipe(String toolType, ItemStack output, ItemStack toolMaterial) {
		if (toolType.equals("sword"))
			GameRegistry.addShapedRecipe(output, new Object[]{"X", "X", "S", 'X', toolMaterial, 'S', Item.stick});
		else if (toolType.equals("pickaxe"))
			GameRegistry.addShapedRecipe(output, new Object[]{"XXX", " S ", " S ", 'X', toolMaterial, 'S', Item.stick});
		else if (toolType.equals("shovel"))
			GameRegistry.addShapedRecipe(output, new Object[]{"X", "S", "S", 'X', toolMaterial, 'S', Item.stick});
		else if (toolType.equals("axe"))
			GameRegistry.addShapedRecipe(output, new Object[]{"XX", "XS", " S", 'X', toolMaterial, 'S', Item.stick}); 
		else if (toolType.equals("hammer"))
			GameRegistry.addShapedRecipe(output, new Object[]{"XXX", "XXX", " S ", 'X', toolMaterial, 'S', Item.stick});
		else
			LALogger.log(Level.INFO, "The tool type, " + toolType + " is invalid.  The recipe for " + output.getDisplayName() + " will not work!");
	}
	
	public static void addToolOreRecipe(String toolType, ItemStack output, String toolMaterial) {
		if (toolType.equals("sword"))
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"X", "X", "S", 'X', toolMaterial, 'S', Item.stick}));
		else if (toolType.equals("pickaxe"))
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"XXX", " S ", " S ", 'X', toolMaterial, 'S', Item.stick}));
		else if (toolType.equals("shovel"))
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"X", "S", "S", 'X', toolMaterial, 'S', Item.stick}));
		else if (toolType.equals("axe"))
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"XX", "XS", " S", 'X', toolMaterial, 'S', Item.stick}));
		else if (toolType.equals("hammer"))
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"XXX", "XXX", " S ", 'X', toolMaterial, 'S', Item.stick}));
		else
			LALogger.log(Level.INFO, "The tool type, " + toolType + " is invalid.  The recipe for " + output.getDisplayName() + " will not work!");
	}
	
	public static void addArmorRecipe(String armorType, ItemStack output, ItemStack toolMaterial) {
		if (armorType.equals("helmet"))
			GameRegistry.addShapedRecipe(output, new Object[]{"XXX", "X X", 'X', toolMaterial});
		else if (armorType.equals("plate"))
			GameRegistry.addShapedRecipe(output, new Object[]{"X X", "XXX", "XXX", 'X', toolMaterial});
		else if (armorType.equals("legs"))
			GameRegistry.addShapedRecipe(output, new Object[]{"XXX", "X X", "X X", 'X', toolMaterial});
		else if (armorType.equals("boots"))
			GameRegistry.addShapedRecipe(output, new Object[]{"X X", "X X", 'X', toolMaterial});
		else
			LALogger.log(Level.INFO, "The armor type, " + armorType + " is invalid.  The recipe for " + output.getDisplayName() + " will not work!");
	}
	
	public static void addArmorOreRecipe(String armorType, ItemStack output, String toolMaterial) {
		if (armorType.equals("helmet"))
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"XXX", "X X", 'X', toolMaterial}));
		else if (armorType.equals("plate"))
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"X X", "XXX", "XXX", 'X', toolMaterial}));
		else if (armorType.equals("legs"))
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"XXX", "X X", "X X", 'X', toolMaterial}));
		else if (armorType.equals("boots"))
			GameRegistry.addRecipe(new ShapedOreRecipe(output, new Object[]{"X X", "X X", 'X', toolMaterial}));
		else
			LALogger.log(Level.INFO, "The armor type, " + armorType + " is invalid.  The recipe for " + output.getDisplayName() + " will not work!");
	}
	
	public static void addDoubleFurnaceRecipe(ItemStack input1, ItemStack input2, ItemStack output) {
		DoubleFurnaceRecipes.smelting().addDoubleSmelting(input1, input2, output);
	}
	
	public static void addStorageRecipe(Block output, int outputMetadata, Item input, int inputMetadata) {
		GameRegistry.addShapedRecipe(new ItemStack(output, 1, outputMetadata), new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(input, 1, inputMetadata)});
		GameRegistry.addShapelessRecipe(new ItemStack(input, 9, inputMetadata), new Object[]{new ItemStack(output, 1, outputMetadata)});
	}

}
