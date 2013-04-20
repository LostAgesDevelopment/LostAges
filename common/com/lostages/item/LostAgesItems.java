package com.lostages.item;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.lostages.lib.ItemIDs;
import com.lostages.lib.ItemStrings;
import com.lostages.lib.LostAgesMaterials;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LostAgesItems {
	
	public static Item ingotBone;
	public static Item ingotAdamant;
	
	public static Item swordBone;
	public static Item pickaxeBone;
	public static Item shovelBone;
	public static Item axeBone;
	
	public static Item swordAdamant;
	public static Item pickaxeAdamant;
	public static Item shovelAdamant;
	public static Item axeAdamant;
	
	public static void init()
	{
		//Item Junk
		ingotBone = new ItemLostAgesItems(ItemIDs.BONE_INGOT).setUnlocalizedName(ItemStrings.BONE_INGOT_NAME);
		ingotAdamant = new ItemLostAgesItems(ItemIDs.ADAMANT_INGOT).setUnlocalizedName(ItemStrings.ADAMANT_INGOT_NAME);
		
		swordBone = new ItemLostAgesSword(ItemIDs.SWORD_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.SWORD_BONE_NAME);
		pickaxeBone = new ItemLostAgesPickaxe(ItemIDs.PICKAXE_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.PICKAXE_BONE_NAME);
		shovelBone = new ItemLostAgesShovel(ItemIDs.SHOVEL_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.SHOVEL_BONE_NAME);
		axeBone = new ItemLostAgesAxe(ItemIDs.AXE_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.AXE_BONE_NAME);
	
		//TODO add new enum for these tools.
		swordAdamant = new ItemLostAgesSword(ItemIDs.SWORD_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.SWORD_ADAMANT_NAME);
		pickaxeAdamant = new ItemLostAgesPickaxe(ItemIDs.PICKAXE_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.PICKAXE_ADAMANT_NAME);
		shovelAdamant = new ItemLostAgesShovel(ItemIDs.SHOVEL_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.SHOVEL_ADAMANT_NAME);
		axeAdamant = new ItemLostAgesAxe(ItemIDs.AXE_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.AXE_ADAMANT_NAME);

		//Item Names
		LanguageRegistry.addName(ingotBone, ItemStrings.BONE_INGOT_TRANSNAME);
		LanguageRegistry.addName(ingotAdamant, ItemStrings.ADAMANT_INGOT_TRANSNAME);
		
		LanguageRegistry.addName(swordBone, ItemStrings.SWORD_BONE_TRANSNAME);
		LanguageRegistry.addName(pickaxeBone, ItemStrings.PICKAXE_BONE_TRANSNAME);
		LanguageRegistry.addName(shovelBone, ItemStrings.SHOVEL_BONE_TRANSNAME);
		LanguageRegistry.addName(axeBone, ItemStrings.AXE_BONE_TRANSNAME);
		
		LanguageRegistry.addName(swordAdamant, ItemStrings.SWORD_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(pickaxeAdamant, ItemStrings.PICKAXE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(shovelAdamant, ItemStrings.SHOVEL_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(axeAdamant, ItemStrings.AXE_ADAMANT_TRANSNAME);
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(ingotBone), new Object[]{"BBB", "BBB", 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(swordBone), new Object[]{"I", "I", "B", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(pickaxeBone), new Object[]{"III", " B ", " B ", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(shovelBone), new Object[]{"I", "B", "B", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(axeBone), new Object[]{"II", "IB", " B", 'I', ingotBone, 'B', Item.bone});
		
		GameRegistry.addRecipe(new ItemStack(pickaxeAdamant), new Object[]{"XXX", " * ", " * ", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelAdamant), new Object[]{"X", "*", "*", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeAdamant), new Object[]{"XX", "X*", " *", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(swordAdamant), new Object[]{"X", "X", "*", 'X', ingotAdamant, '*', Item.stick});
	}
	
}
