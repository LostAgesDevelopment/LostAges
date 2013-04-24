package com.lostages.item;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

import com.lostages.lib.ItemIDs;
import com.lostages.lib.ItemStrings;
import com.lostages.lib.LostAgesMaterials;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LostAgesItems {
	
	public static Item smeltedbone;
	public static Item ingotAdamant;
	public static Item ingotBronze;
	public static Item ingotSteel;
	public static Item ingotStrongGold;
	
	public static Item bowJungle;
	
	public static Item swordBone;
	public static Item pickaxeBone;
	public static Item shovelBone;
	public static Item axeBone;
	public static Item hammerBone;

	public static Item pickaxeFlint;
	public static Item shovelFlint;
	public static Item axeFlint;
	
	public static Item swordStrongGold;
	public static Item pickaxeStrongGold;
	public static Item shovelStrongGold;
	public static Item axeStrongGold;
	public static Item hammerStrongGold;
	
	public static Item swordBronze;
	public static Item pickaxeBronze;
	public static Item shovelBronze;
	public static Item axeBronze;
	public static Item hammerBronze;
	
	public static Item swordSteel;
	public static Item pickaxeSteel;
	public static Item shovelSteel;
	public static Item axeSteel;
	public static Item hammerSteel;
	
	public static Item swordAdamant;
	public static Item pickaxeAdamant;
	public static Item shovelAdamant;
	public static Item axeAdamant;
	public static Item hammerAdamant;

	public static Item hammerWood;
	public static Item hammerStone;
	public static Item hammerIron;
	public static Item hammerGold;
	public static Item hammerDiamond;
	

	
	public static void init()
	{
		//Ingots
		smeltedbone = new ItemLostAgesItems(ItemIDs.SMELTEDBONE).setUnlocalizedName(ItemStrings.SMELTEDBONE_NAME);
		ingotAdamant = new ItemLostAgesItems(ItemIDs.ADAMANT_INGOT).setUnlocalizedName(ItemStrings.ADAMANT_INGOT_NAME);
		ingotBronze = new ItemLostAgesItems(ItemIDs.BRONZE_INGOT).setUnlocalizedName(ItemStrings.BRONZE_INGOT_NAME);
		ingotSteel = new ItemLostAgesItems(ItemIDs.STEEL_INGOT).setUnlocalizedName(ItemStrings.STEEL_INGOT_NAME);
		ingotStrongGold = new ItemLostAgesItems(ItemIDs.STRONGGOLD_INGOT).setUnlocalizedName(ItemStrings.STRONGGOLD_INGOT_NAME);

		//Other Items
	    bowJungle = new ItemBow(ItemIDs.BOW_JUNGLE).setUnlocalizedName(ItemStrings.BOW_JUNGLE_NAME);
		
		//Hammers
		hammerWood = new ItemLostAgesHammer(ItemIDs.HAMMER_WOOD, EnumToolMaterial.WOOD).setUnlocalizedName(ItemStrings.HAMMER_WOOD_NAME);
		hammerStone = new ItemLostAgesHammer(ItemIDs.HAMMER_STONE, EnumToolMaterial.STONE).setUnlocalizedName(ItemStrings.HAMMER_STONE_NAME);
		hammerIron = new ItemLostAgesHammer(ItemIDs.HAMMER_IRON, EnumToolMaterial.IRON).setUnlocalizedName(ItemStrings.HAMMER_IRON_NAME);
		hammerGold = new ItemLostAgesHammer(ItemIDs.HAMMER_GOLD, EnumToolMaterial.GOLD).setUnlocalizedName(ItemStrings.HAMMER_GOLD_NAME);
		hammerDiamond = new ItemLostAgesHammer(ItemIDs.HAMMER_DIAMOND, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.HAMMER_DIAMOND_NAME);
		
		//Bone Tools
		swordBone = new ItemLostAgesSword(ItemIDs.SWORD_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.SWORD_BONE_NAME);
		pickaxeBone = new ItemLostAgesPickaxe(ItemIDs.PICKAXE_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.PICKAXE_BONE_NAME);
		shovelBone = new ItemLostAgesShovel(ItemIDs.SHOVEL_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.SHOVEL_BONE_NAME);
		axeBone = new ItemLostAgesAxe(ItemIDs.AXE_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.AXE_BONE_NAME);
		hammerBone = new ItemLostAgesHammer(ItemIDs.HAMMER_BONE, LostAgesMaterials.BONE).setUnlocalizedName(ItemStrings.HAMMER_BONE_NAME);

		//Flint Tools
		pickaxeFlint = new ItemLostAgesPickaxe(ItemIDs.PICKAXE_FLINT, LostAgesMaterials.FLINT).setUnlocalizedName(ItemStrings.PICKAXE_FLINT_NAME);
		shovelFlint = new ItemLostAgesShovel(ItemIDs.SHOVEL_FLINT, LostAgesMaterials.FLINT).setUnlocalizedName(ItemStrings.SHOVEL_FLINT_NAME);
		axeFlint = new ItemLostAgesAxe(ItemIDs.AXE_FLINT, LostAgesMaterials.FLINT).setUnlocalizedName(ItemStrings.AXE_FLINT_NAME);
		
		//Strong Gold Tools
		swordStrongGold = new ItemLostAgesSword(ItemIDs.SWORD_STRONGGOLD, LostAgesMaterials.STRONGGOLD).setUnlocalizedName(ItemStrings.SWORD_STRONGGOLD_NAME);
		pickaxeStrongGold = new ItemLostAgesPickaxe(ItemIDs.PICKAXE_STRONGGOLD, LostAgesMaterials.STRONGGOLD).setUnlocalizedName(ItemStrings.PICKAXE_STRONGGOLD_NAME);
		shovelStrongGold = new ItemLostAgesShovel(ItemIDs.SHOVEL_STRONGGOLD, LostAgesMaterials.STRONGGOLD).setUnlocalizedName(ItemStrings.SHOVEL_STRONGGOLD_NAME);
		axeStrongGold = new ItemLostAgesAxe(ItemIDs.AXE_STRONGGOLD, LostAgesMaterials.STRONGGOLD).setUnlocalizedName(ItemStrings.AXE_STRONGGOLD_NAME);
		hammerStrongGold = new ItemLostAgesHammer(ItemIDs.HAMMER_STRONGGOLD, LostAgesMaterials.STRONGGOLD).setUnlocalizedName(ItemStrings.HAMMER_STRONGGOLD_NAME);
		
		//Bronze Tools
		swordBronze = new ItemLostAgesSword(ItemIDs.SWORD_BRONZE, LostAgesMaterials.BRONZE).setUnlocalizedName(ItemStrings.SWORD_BRONZE_NAME);
		pickaxeBronze = new ItemLostAgesPickaxe(ItemIDs.PICKAXE_BRONZE, LostAgesMaterials.BRONZE).setUnlocalizedName(ItemStrings.PICKAXE_BRONZE_NAME);
		shovelBronze = new ItemLostAgesShovel(ItemIDs.SHOVEL_BRONZE, LostAgesMaterials.BRONZE).setUnlocalizedName(ItemStrings.SHOVEL_BRONZE_NAME);
		axeBronze = new ItemLostAgesAxe(ItemIDs.AXE_BRONZE, LostAgesMaterials.BRONZE).setUnlocalizedName(ItemStrings.AXE_BRONZE_NAME);
		hammerBronze = new ItemLostAgesHammer(ItemIDs.HAMMER_BRONZE, LostAgesMaterials.BRONZE).setUnlocalizedName(ItemStrings.HAMMER_BRONZE_NAME);
		
		//Steel Tools
		swordSteel = new ItemLostAgesSword(ItemIDs.SWORD_STEEL, LostAgesMaterials.STEEL).setUnlocalizedName(ItemStrings.SWORD_STEEL_NAME);
		pickaxeSteel = new ItemLostAgesPickaxe(ItemIDs.PICKAXE_STEEL, LostAgesMaterials.STEEL).setUnlocalizedName(ItemStrings.PICKAXE_STEEL_NAME);
		shovelSteel = new ItemLostAgesShovel(ItemIDs.SHOVEL_STEEL, LostAgesMaterials.STEEL).setUnlocalizedName(ItemStrings.SHOVEL_STEEL_NAME);
		axeSteel = new ItemLostAgesAxe(ItemIDs.AXE_STEEL, LostAgesMaterials.STEEL).setUnlocalizedName(ItemStrings.AXE_STEEL_NAME);
		hammerSteel = new ItemLostAgesHammer(ItemIDs.HAMMER_STEEL, LostAgesMaterials.STEEL).setUnlocalizedName(ItemStrings.HAMMER_STEEL_NAME);
		
		//Adamant Tools
		swordAdamant = new ItemLostAgesSword(ItemIDs.SWORD_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.SWORD_ADAMANT_NAME);
		pickaxeAdamant = new ItemLostAgesPickaxe(ItemIDs.PICKAXE_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.PICKAXE_ADAMANT_NAME);
		shovelAdamant = new ItemLostAgesShovel(ItemIDs.SHOVEL_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.SHOVEL_ADAMANT_NAME);
		axeAdamant = new ItemLostAgesAxe(ItemIDs.AXE_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.AXE_ADAMANT_NAME);
		hammerAdamant = new ItemLostAgesHammer(ItemIDs.HAMMER_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.HAMMER_ADAMANT_NAME);

		//Item Names
		//Ingots
		LanguageRegistry.addName(smeltedbone, ItemStrings.SMELTEDBONE_TRANSNAME);
		LanguageRegistry.addName(ingotAdamant, ItemStrings.ADAMANT_INGOT_TRANSNAME);
		LanguageRegistry.addName(ingotBronze, ItemStrings.BRONZE_INGOT_TRANSNAME);
		LanguageRegistry.addName(ingotSteel, ItemStrings.STEEL_INGOT_TRANSNAME);
		
		//Bone tools
		LanguageRegistry.addName(swordBone, ItemStrings.SWORD_BONE_TRANSNAME);
		LanguageRegistry.addName(pickaxeBone, ItemStrings.PICKAXE_BONE_TRANSNAME);
		LanguageRegistry.addName(shovelBone, ItemStrings.SHOVEL_BONE_TRANSNAME);
		LanguageRegistry.addName(axeBone, ItemStrings.AXE_BONE_TRANSNAME);
		LanguageRegistry.addName(hammerBone, ItemStrings.HAMMER_BONE_TRANSNAME);
		
		//Flint tools
		LanguageRegistry.addName(pickaxeFlint, ItemStrings.PICKAXE_FLINT_TRANSNAME);
		LanguageRegistry.addName(shovelFlint, ItemStrings.SHOVEL_FLINT_TRANSNAME);
		LanguageRegistry.addName(axeFlint, ItemStrings.AXE_FLINT_TRANSNAME);
		
		//Strong Gold tools
		LanguageRegistry.addName(swordStrongGold, ItemStrings.SWORD_STRONGGOLD_TRANSNAME);
		LanguageRegistry.addName(pickaxeStrongGold, ItemStrings.PICKAXE_STRONGGOLD_TRANSNAME);
		LanguageRegistry.addName(shovelStrongGold, ItemStrings.SHOVEL_STRONGGOLD_TRANSNAME);
		LanguageRegistry.addName(axeStrongGold, ItemStrings.AXE_STRONGGOLD_TRANSNAME);
		LanguageRegistry.addName(hammerStrongGold, ItemStrings.HAMMER_STRONGGOLD_TRANSNAME);
		
		//Bronze tools
		LanguageRegistry.addName(swordBronze, ItemStrings.SWORD_BRONZE_TRANSNAME);
		LanguageRegistry.addName(pickaxeBronze, ItemStrings.PICKAXE_BRONZE_TRANSNAME);
		LanguageRegistry.addName(shovelBronze, ItemStrings.SHOVEL_BRONZE_TRANSNAME);
		LanguageRegistry.addName(axeBronze, ItemStrings.AXE_BRONZE_TRANSNAME);
		LanguageRegistry.addName(hammerBronze, ItemStrings.HAMMER_BRONZE_TRANSNAME);
		
		//Steel tools
		LanguageRegistry.addName(swordSteel, ItemStrings.SWORD_STEEL_TRANSNAME);
		LanguageRegistry.addName(pickaxeSteel, ItemStrings.PICKAXE_STEEL_TRANSNAME);
		LanguageRegistry.addName(shovelSteel, ItemStrings.SHOVEL_STEEL_TRANSNAME);
		LanguageRegistry.addName(axeSteel, ItemStrings.AXE_STEEL_TRANSNAME);
		LanguageRegistry.addName(hammerSteel, ItemStrings.HAMMER_STEEL_TRANSNAME);
		
		//Adamant tools
		LanguageRegistry.addName(swordAdamant, ItemStrings.SWORD_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(pickaxeAdamant, ItemStrings.PICKAXE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(shovelAdamant, ItemStrings.SHOVEL_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(axeAdamant, ItemStrings.AXE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(hammerAdamant, ItemStrings.HAMMER_ADAMANT_TRANSNAME);
		
		//Hammers
		LanguageRegistry.addName(hammerWood, ItemStrings.HAMMER_WOOD_TRANSNAME);
		LanguageRegistry.addName(hammerStone, ItemStrings.HAMMER_STONE_TRANSNAME);
		LanguageRegistry.addName(hammerIron, ItemStrings.HAMMER_IRON_TRANSNAME);
		LanguageRegistry.addName(hammerGold, ItemStrings.HAMMER_GOLD_TRANSNAME);
		LanguageRegistry.addName(hammerDiamond, ItemStrings.HAMMER_DIAMOND_TRANSNAME);

	
		//Smelting Recipes
        GameRegistry.addSmelting(Item.bone.itemID, new ItemStack(smeltedbone), 0.3F);
				
		//Recipes
        //Bone tools
		GameRegistry.addRecipe(new ItemStack(swordBone), new Object[]{"I", "I", "B", 'I', smeltedbone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(pickaxeBone), new Object[]{"III", " B ", " B ", 'I', smeltedbone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(shovelBone), new Object[]{"I", "B", "B", 'I', smeltedbone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(axeBone), new Object[]{"II", "IB", " B", 'I', smeltedbone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(hammerBone), new Object[]{"XXX", "*", 'X', smeltedbone , '*', Item.bone});

        //Bone tools
		GameRegistry.addRecipe(new ItemStack(pickaxeFlint), new Object[]{"III", " B ", " B ", 'I', Item.flint, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelFlint), new Object[]{"I", "B", "B", 'I', Item.flint, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeFlint), new Object[]{"II", "IB", " B", 'I', Item.flint, 'B', Item.stick});
		
        //Strong Gold tools
		GameRegistry.addRecipe(new ItemStack(swordStrongGold), new Object[]{"I", "I", "B", 'I', ingotStrongGold, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(pickaxeStrongGold), new Object[]{"III", " B ", " B ", 'I', ingotStrongGold, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelStrongGold), new Object[]{"I", "B", "B", 'I', ingotStrongGold, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeStrongGold), new Object[]{"II", "IB", " B", 'I', ingotStrongGold, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerStrongGold), new Object[]{"XXX", "*", 'X', ingotStrongGold , '*', Item.stick});

        //Bronze tools
		GameRegistry.addRecipe(new ItemStack(swordBronze), new Object[]{"I", "I", "B", 'I', ingotBronze, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(pickaxeBronze), new Object[]{"III", " B ", " B ", 'I', ingotBronze, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelBronze), new Object[]{"I", "B", "B", 'I', ingotBronze, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeBronze), new Object[]{"II", "IB", " B", 'I', ingotBronze, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerBronze), new Object[]{"XXX", "*", 'X', ingotBronze , '*', Item.stick});

        //Steel tools
		GameRegistry.addRecipe(new ItemStack(swordSteel), new Object[]{"I", "I", "B", 'I', ingotSteel, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(pickaxeSteel), new Object[]{"III", " B ", " B ", 'I', ingotSteel, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelSteel), new Object[]{"I", "B", "B", 'I', ingotSteel, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeSteel), new Object[]{"II", "IB", " B", 'I', ingotSteel, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerSteel), new Object[]{"XXX", "*", 'X', ingotSteel , '*', Item.stick});
		
		//Adamant tools
		GameRegistry.addRecipe(new ItemStack(pickaxeAdamant), new Object[]{"XXX", " * ", " * ", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelAdamant), new Object[]{"X", "*", "*", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeAdamant), new Object[]{"XX", "X*", " *", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(swordAdamant), new Object[]{"X", "X", "*", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerAdamant), new Object[]{"XXX", "*", 'X', ingotAdamant , '*', Item.stick});
		
		//Hammers
		GameRegistry.addRecipe(new ItemStack(hammerWood), new Object[]{"XXX", "*", 'X', Block.planks , '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerStone), new Object[]{"XXX", "*", 'X', Block.cobblestone , '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerIron), new Object[]{"XXX", "*", 'X', Item.ingotIron , '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerGold), new Object[]{"XXX", "*", 'X', Item.ingotGold , '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerDiamond), new Object[]{"XXX", "*", 'X', Item.diamond , '*', Item.stick});
	}
	
}
