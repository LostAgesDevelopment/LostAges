package com.lostages.item;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.lostages.lib.CustomArmorMaterials;
import com.lostages.lib.CustomToolMaterials;
import com.lostages.lib.ItemIDs;
import com.lostages.lib.ItemStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LostAgesItems {
	
	//Ingots
	public static Item ingotBase;
	public static ItemStack ingotBone;
	public static ItemStack ingotCopper;
	public static ItemStack ingotTin;
	public static ItemStack ingotAdamant;
	public static ItemStack ingotBronze;
	public static ItemStack ingotSteel;
	public static ItemStack ingotStrongGold;

	//Bows
	public static Item bowJungle;
	
	//Bone Tools
	public static Item swordBone;
	public static Item pickaxeBone;
	public static Item shovelBone;
	public static Item axeBone;
	public static Item hammerBone;

	//Strong Gold Tools
	public static Item swordStrongGold;
	public static Item pickaxeStrongGold;
	public static Item shovelStrongGold;
	public static Item axeStrongGold;
	public static Item hammerStrongGold;
	
	//Bronze Tools
	public static Item swordBronze;
	public static Item pickaxeBronze;
	public static Item shovelBronze;
	public static Item axeBronze;
	public static Item hammerBronze;
	
	//Steel Tools
	public static Item swordSteel;
	public static Item pickaxeSteel;
	public static Item shovelSteel;
	public static Item axeSteel;
	public static Item hammerSteel;
	
	
	//Orc Tools
	public static Item swordOrc;
	public static Item pickaxeOrc;
	public static Item shovelOrc;
	public static Item axeOrc;
	public static Item hammerOrc;
	
	//Adamant Tools
	public static Item swordAdamant;
	public static Item pickaxeAdamant;
	public static Item shovelAdamant;
	public static Item axeAdamant;
	public static Item hammerAdamant;

	//Hammers
	public static Item hammerWood;
	public static Item hammerStone;
	public static Item hammerIron;
	public static Item hammerGold;
	public static Item hammerDiamond;
	public static Item hammerMagic;	
	
	//Armor
	public static Item helmAdamant;
	public static Item chestAdamant;
	public static Item legsAdamant;
	public static Item bootsAdamant;
	
	
	public static void initItems() {
		//Ingots
		ingotBase = new ItemBaseIngot();
		ingotBone = new ItemStack(ingotBase, 1, 0);
		ingotCopper = new ItemStack(ingotBase, 1, 1);
		ingotTin = new ItemStack(ingotBase, 1, 2);
		ingotBronze = new ItemStack(ingotBase, 1, 3);
		ingotAdamant = new ItemStack(ingotBase, 1, 4);
		ingotSteel = new ItemStack(ingotBase, 1, 5);
		ingotStrongGold = new ItemStack(ingotBase, 1, 6);
	    
		//Bows
	    bowJungle = new ItemBow(ItemIDs.BOW_JUNGLE).setUnlocalizedName(ItemStrings.BOW_JUNGLE_NAME);
		
		//Hammers
		hammerWood = new ItemHammer(ItemIDs.HAMMER_WOOD, EnumToolMaterial.WOOD, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_WOOD_NAME);
		hammerStone = new ItemHammer(ItemIDs.HAMMER_STONE, EnumToolMaterial.STONE, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_STONE_NAME);
		hammerIron = new ItemHammer(ItemIDs.HAMMER_IRON, EnumToolMaterial.IRON, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_IRON_NAME);
		hammerGold = new ItemHammer(ItemIDs.HAMMER_GOLD, EnumToolMaterial.GOLD, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_GOLD_NAME);
		hammerDiamond = new ItemHammer(ItemIDs.HAMMER_DIAMOND, EnumToolMaterial.EMERALD, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_DIAMOND_NAME);
		hammerMagic = new ItemHammer(ItemIDs.HAMMER_MAGIC, EnumToolMaterial.EMERALD, new ItemStack(Block.stoneBrick)).setUnlocalizedName(ItemStrings.HAMMER_MAGIC_NAME);
		
		//Bone Tools
		swordBone = new ItemCustomSword(ItemIDs.SWORD_BONE, CustomToolMaterials.BONE).setUnlocalizedName(ItemStrings.SWORD_BONE_NAME);
		pickaxeBone = new ItemCustomPickaxe(ItemIDs.PICKAXE_BONE, CustomToolMaterials.BONE).setUnlocalizedName(ItemStrings.PICKAXE_BONE_NAME);
		shovelBone = new ItemCustomShovel(ItemIDs.SHOVEL_BONE, CustomToolMaterials.BONE).setUnlocalizedName(ItemStrings.SHOVEL_BONE_NAME);
		axeBone = new ItemCustomAxe(ItemIDs.AXE_BONE, CustomToolMaterials.BONE).setUnlocalizedName(ItemStrings.AXE_BONE_NAME);
		hammerBone = new ItemHammer(ItemIDs.HAMMER_BONE, CustomToolMaterials.BONE, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_BONE_NAME);
		
		//Strong Gold Tools
		swordStrongGold = new ItemCustomSword(ItemIDs.SWORD_STRONGGOLD, CustomToolMaterials.STRONGGOLD).setUnlocalizedName(ItemStrings.SWORD_STRONGGOLD_NAME);
		pickaxeStrongGold = new ItemCustomPickaxe(ItemIDs.PICKAXE_STRONGGOLD, CustomToolMaterials.STRONGGOLD).setUnlocalizedName(ItemStrings.PICKAXE_STRONGGOLD_NAME);
		shovelStrongGold = new ItemCustomShovel(ItemIDs.SHOVEL_STRONGGOLD, CustomToolMaterials.STRONGGOLD).setUnlocalizedName(ItemStrings.SHOVEL_STRONGGOLD_NAME);
		axeStrongGold = new ItemCustomAxe(ItemIDs.AXE_STRONGGOLD, CustomToolMaterials.STRONGGOLD).setUnlocalizedName(ItemStrings.AXE_STRONGGOLD_NAME);
		hammerStrongGold = new ItemHammer(ItemIDs.HAMMER_STRONGGOLD, CustomToolMaterials.STRONGGOLD, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_STRONGGOLD_NAME);
		
		//Bronze Tools
		swordBronze = new ItemCustomSword(ItemIDs.SWORD_BRONZE, CustomToolMaterials.BRONZE).setUnlocalizedName(ItemStrings.SWORD_BRONZE_NAME);
		pickaxeBronze = new ItemCustomPickaxe(ItemIDs.PICKAXE_BRONZE, CustomToolMaterials.BRONZE).setUnlocalizedName(ItemStrings.PICKAXE_BRONZE_NAME);
		shovelBronze = new ItemCustomShovel(ItemIDs.SHOVEL_BRONZE, CustomToolMaterials.BRONZE).setUnlocalizedName(ItemStrings.SHOVEL_BRONZE_NAME);
		axeBronze = new ItemCustomAxe(ItemIDs.AXE_BRONZE, CustomToolMaterials.BRONZE).setUnlocalizedName(ItemStrings.AXE_BRONZE_NAME);
		hammerBronze = new ItemHammer(ItemIDs.HAMMER_BRONZE, CustomToolMaterials.BRONZE, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_BRONZE_NAME);
		
		//Steel Tools
		swordSteel = new ItemCustomSword(ItemIDs.SWORD_STEEL, CustomToolMaterials.STEEL).setUnlocalizedName(ItemStrings.SWORD_STEEL_NAME);
		pickaxeSteel = new ItemCustomPickaxe(ItemIDs.PICKAXE_STEEL, CustomToolMaterials.STEEL).setUnlocalizedName(ItemStrings.PICKAXE_STEEL_NAME);
		shovelSteel = new ItemCustomShovel(ItemIDs.SHOVEL_STEEL, CustomToolMaterials.STEEL).setUnlocalizedName(ItemStrings.SHOVEL_STEEL_NAME);
		axeSteel = new ItemCustomAxe(ItemIDs.AXE_STEEL, CustomToolMaterials.STEEL).setUnlocalizedName(ItemStrings.AXE_STEEL_NAME);
		hammerSteel = new ItemHammer(ItemIDs.HAMMER_STEEL, CustomToolMaterials.STEEL, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_STEEL_NAME);
		
		//Adamant Tools
		swordAdamant = new ItemCustomSword(ItemIDs.SWORD_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.SWORD_ADAMANT_NAME);
		pickaxeAdamant = new ItemCustomPickaxe(ItemIDs.PICKAXE_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.PICKAXE_ADAMANT_NAME);
		shovelAdamant = new ItemCustomShovel(ItemIDs.SHOVEL_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.SHOVEL_ADAMANT_NAME);
		axeAdamant = new ItemCustomAxe(ItemIDs.AXE_ADAMANT, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemStrings.AXE_ADAMANT_NAME);
		hammerAdamant = new ItemHammer(ItemIDs.HAMMER_ADAMANT, EnumToolMaterial.EMERALD, new ItemStack(Block.cobblestone)).setUnlocalizedName(ItemStrings.HAMMER_ADAMANT_NAME);
		
		//Armor
		//Adamant Armor
		helmAdamant = new ItemCustomArmor(ItemIDs.HELM_ADAMANT, CustomArmorMaterials.ADAMANT, 1, 0).setUnlocalizedName(ItemStrings.HELMET_ADAMANT_NAME);
		chestAdamant = new ItemCustomArmor(ItemIDs.CHEST_ADAMANT, CustomArmorMaterials.ADAMANT, 1, 1).setUnlocalizedName(ItemStrings.CHESTPLATE_ADAMANT_NAME);
		legsAdamant = new ItemCustomArmor(ItemIDs.LEGS_ADAMANT, CustomArmorMaterials.ADAMANT, 1, 2).setUnlocalizedName(ItemStrings.LEGGINGS_ADAMANT_NAME);
		bootsAdamant = new ItemCustomArmor(ItemIDs.BOOTS_ADAMANT, CustomArmorMaterials.ADAMANT, 1, 3).setUnlocalizedName(ItemStrings.BOOTS_ADAMANT_NAME);

		//Item Names
		//Ingots
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 0), ItemStrings.INGOT_BONE_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 1), ItemStrings.INGOT_COPPER_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 2), ItemStrings.INGOT_TIN_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 3), ItemStrings.INGOT_BRONZE_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 4), ItemStrings.INGOT_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 5), ItemStrings.INGOT_STEEL_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 6), ItemStrings.INGOT_STRONGGOLD_TRANSNAME);
		
		//Bows
		
		//Bone tools
		LanguageRegistry.addName(swordBone, ItemStrings.SWORD_BONE_TRANSNAME);
		LanguageRegistry.addName(pickaxeBone, ItemStrings.PICKAXE_BONE_TRANSNAME);
		LanguageRegistry.addName(shovelBone, ItemStrings.SHOVEL_BONE_TRANSNAME);
		LanguageRegistry.addName(axeBone, ItemStrings.AXE_BONE_TRANSNAME);
		LanguageRegistry.addName(hammerBone, ItemStrings.HAMMER_BONE_TRANSNAME);
		
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
		LanguageRegistry.addName(hammerMagic, ItemStrings.HAMMER_MAGIC_TRANSNAME);

		
		//Armor
		//Adamant Armor
		LanguageRegistry.addName(helmAdamant, ItemStrings.HELMET_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(chestAdamant, ItemStrings.CHESTPLATE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(legsAdamant, ItemStrings.LEGGINGS_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(bootsAdamant, ItemStrings.BOOTS_ADAMANT_TRANSNAME);
	}
	
	public static void initItemRecipes() {
		//Smelting Recipes
		
        //Bone tools
		GameRegistry.addRecipe(new ItemStack(swordBone), new Object[]{"I", "I", "B", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(pickaxeBone), new Object[]{"III", " B ", " B ", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(shovelBone), new Object[]{"I", "B", "B", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(axeBone), new Object[]{"II", "IB", " B", 'I', ingotBone, 'B', Item.bone});
		GameRegistry.addRecipe(new ItemStack(hammerBone), new Object[]{"XXX", " * ", 'X', ingotBone , '*', Item.bone});
		
        //Strong Gold tools
		GameRegistry.addRecipe(new ItemStack(swordStrongGold), new Object[]{"I", "I", "B", 'I', ingotStrongGold, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(pickaxeStrongGold), new Object[]{"III", " B ", " B ", 'I', ingotStrongGold, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelStrongGold), new Object[]{"I", "B", "B", 'I', ingotStrongGold, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeStrongGold), new Object[]{"II", "IB", " B", 'I', ingotStrongGold, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerStrongGold), new Object[]{"XXX", " * ", 'X', ingotStrongGold , '*', Item.stick});

        //Bronze tools
		GameRegistry.addRecipe(new ItemStack(swordBronze), new Object[]{"I", "I", "B", 'I', ingotBronze, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(pickaxeBronze), new Object[]{"III", " B ", " B ", 'I', ingotBronze, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelBronze), new Object[]{"I", "B", "B", 'I', ingotBronze, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeBronze), new Object[]{"II", "IB", " B", 'I', ingotBronze, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerBronze), new Object[]{"XXX", " * ", 'X', ingotBronze , '*', Item.stick});

        //Steel tools
		GameRegistry.addRecipe(new ItemStack(swordSteel), new Object[]{"I", "I", "B", 'I', ingotSteel, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(pickaxeSteel), new Object[]{"III", " B ", " B ", 'I', ingotSteel, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelSteel), new Object[]{"I", "B", "B", 'I', ingotSteel, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeSteel), new Object[]{"II", "IB", " B", 'I', ingotSteel, 'B', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerSteel), new Object[]{"XXX", " * ", 'X', ingotSteel , '*', Item.stick});
		
		//Adamant tools
		GameRegistry.addRecipe(new ItemStack(pickaxeAdamant), new Object[]{"XXX", " * ", " * ", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(shovelAdamant), new Object[]{"X", "*", "*", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(axeAdamant), new Object[]{"XX", "X*", " *", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(swordAdamant), new Object[]{"X", "X", "*", 'X', ingotAdamant, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerAdamant), new Object[]{"XXX", " * ", 'X', ingotAdamant , '*', Item.stick});
		
		//Hammers
		GameRegistry.addRecipe(new ItemStack(hammerWood), new Object[]{"XXX", " * ", 'X', Block.planks, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerStone), new Object[]{"XXX", " * ", 'X', Block.cobblestone , '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerIron), new Object[]{"XXX", " * ", 'X', Item.ingotIron , '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerGold), new Object[]{"XXX", " * ", 'X', Item.ingotGold , '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(hammerDiamond), new Object[]{"XXX", " * ", 'X', Item.diamond , '*', Item.stick});
		//TODO Add magic hammer recipe
		
		//Ore Dictionary
		OreDictionary.registerOre(ItemStrings.INGOT_COPPER_NAME, new ItemStack(ingotBase, 1, 1));
		OreDictionary.registerOre(ItemStrings.INGOT_TIN_NAME, new ItemStack(ingotBase, 1, 2));
		OreDictionary.registerOre(ItemStrings.INGOT_BRONZE_NAME, new ItemStack(ingotBase, 1, 3));
	}
}
