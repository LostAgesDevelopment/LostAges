package com.lostages.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.lostages.lib.ItemIDs;
import com.lostages.lib.ItemStrings;
import com.lostages.lib.LostAgesMaterials;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LostAgesItems {
	
	public static Item ingotBone;
	
	public static Item swordBone;
	public static Item pickaxeBone;
	public static Item shovelBone;
	public static Item axeBone;
	public static Item hoeBone;
	
	public static void init()
	{
		//Item Junk
		ingotBone = new ItemLostAgesItems(ItemIDs.BONE_INGOT).setUnlocalizedName(ItemStrings.BONE_INGOT_NAME);
		swordBone = new ItemLostAgesSword(ItemIDs.SWORD_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.SWORD_BONE_NAME);
		pickaxeBone = new ItemLostAgesPickaxe(ItemIDs.PICKAXE_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.PICKAXE_BONE_NAME);
		shovelBone = new ItemLostAgesShovel(ItemIDs.SHOVEL_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.SHOVEL_BONE_NAME);
		axeBone = new ItemLostAgesAxe(ItemIDs.AXE_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.AXE_BONE_NAME);
		hoeBone = new ItemLostAgesHoe(ItemIDs.HOE_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.HOE_BONE_NAME);
		
		//Item Names
		LanguageRegistry.addName(ingotBone, ItemStrings.BONE_INGOT_TRANSNAME);
		LanguageRegistry.addName(swordBone, ItemStrings.SWORD_BONE_TRANSNAME);
		LanguageRegistry.addName(pickaxeBone, ItemStrings.PICKAXE_BONE_TRANSNAME);
		LanguageRegistry.addName(shovelBone, ItemStrings.SHOVEL_BONE_TRANSNAME);
		LanguageRegistry.addName(axeBone, ItemStrings.AXE_BONE_TRANSNAME);
		LanguageRegistry.addName(hoeBone, ItemStrings.HOE_BONE_TRANSNAME);
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(ingotBone), new Object[]{"BBB", "BBB", 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(swordBone), new Object[]{"I", "I", "B", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(pickaxeBone), new Object[]{"III", " B ", " B ", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(shovelBone), new Object[]{"I", "B", "B", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(axeBone), new Object[]{"II", "IB", " B", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(hoeBone), new Object[]{"II", " B", " B", 'I', ingotBone, 'B', Item.bone});
	}
	
}
