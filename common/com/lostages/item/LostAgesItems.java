package com.lostages.item;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.lostages.lib.CustomArmorMaterials;
import com.lostages.lib.CustomToolMaterials;
import com.lostages.lib.ItemReference;

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
		ingotBase = new ItemCustomIngot();
		ingotBone = new ItemStack(ingotBase, 1, 0);
		ingotCopper = new ItemStack(ingotBase, 1, 1);
		ingotTin = new ItemStack(ingotBase, 1, 2);
		ingotBronze = new ItemStack(ingotBase, 1, 3);
		ingotAdamant = new ItemStack(ingotBase, 1, 4);
		ingotSteel = new ItemStack(ingotBase, 1, 5);
		ingotStrongGold = new ItemStack(ingotBase, 1, 6);
	    
		//Bows
	    bowJungle = new ItemCustomBow(ItemReference.BOW_JUNGLE_ID).setUnlocalizedName(ItemReference.BOW_JUNGLE_NAME);
		
		//Hammers
		hammerWood = new ItemHammer(ItemReference.HAMMER_WOOD_ID, EnumToolMaterial.WOOD, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_WOOD_NAME);
		hammerStone = new ItemHammer(ItemReference.HAMMER_STONE_ID, EnumToolMaterial.STONE, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_STONE_NAME);
		hammerIron = new ItemHammer(ItemReference.HAMMER_IRON_ID, EnumToolMaterial.IRON, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_IRON_NAME);
		hammerGold = new ItemHammer(ItemReference.HAMMER_GOLD_ID, EnumToolMaterial.GOLD, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_GOLD_NAME);
		hammerDiamond = new ItemHammer(ItemReference.HAMMER_DIAMOND_ID, EnumToolMaterial.EMERALD, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_DIAMOND_NAME);
		hammerMagic = new ItemHammer(ItemReference.HAMMER_MAGIC_ID, EnumToolMaterial.EMERALD, Block.stoneBrick).setUnlocalizedName(ItemReference.HAMMER_MAGIC_NAME);
		
		//Bone Tools
		swordBone = new ItemCustomSword(ItemReference.SWORD_BONE_ID, CustomToolMaterials.BONE).setUnlocalizedName(ItemReference.SWORD_BONE_NAME);
		pickaxeBone = new ItemCustomPickaxe(ItemReference.PICKAXE_BONE_ID, CustomToolMaterials.BONE).setUnlocalizedName(ItemReference.PICKAXE_BONE_NAME);
		shovelBone = new ItemCustomShovel(ItemReference.SHOVEL_BONE_ID, CustomToolMaterials.BONE).setUnlocalizedName(ItemReference.SHOVEL_BONE_NAME);
		axeBone = new ItemCustomAxe(ItemReference.AXE_BONE_ID, CustomToolMaterials.BONE).setUnlocalizedName(ItemReference.AXE_BONE_NAME);
		hammerBone = new ItemHammer(ItemReference.HAMMER_BONE_ID, CustomToolMaterials.BONE, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_BONE_NAME);
		
		//Strong Gold Tools
		swordStrongGold = new ItemCustomSword(ItemReference.SWORD_STRONGGOLD_ID, CustomToolMaterials.STRONGGOLD).setUnlocalizedName(ItemReference.SWORD_STRONGGOLD_NAME);
		pickaxeStrongGold = new ItemCustomPickaxe(ItemReference.PICKAXE_STRONGGOLD_ID, CustomToolMaterials.STRONGGOLD).setUnlocalizedName(ItemReference.PICKAXE_STRONGGOLD_NAME);
		shovelStrongGold = new ItemCustomShovel(ItemReference.SHOVEL_STRONGGOLD_ID, CustomToolMaterials.STRONGGOLD).setUnlocalizedName(ItemReference.SHOVEL_STRONGGOLD_NAME);
		axeStrongGold = new ItemCustomAxe(ItemReference.AXE_STRONGGOLD_ID, CustomToolMaterials.STRONGGOLD).setUnlocalizedName(ItemReference.AXE_STRONGGOLD_NAME);
		hammerStrongGold = new ItemHammer(ItemReference.HAMMER_STRONGGOLD_ID, CustomToolMaterials.STRONGGOLD, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_STRONGGOLD_NAME);
		
		//Bronze Tools
		swordBronze = new ItemCustomSword(ItemReference.SWORD_BRONZE_ID, CustomToolMaterials.BRONZE).setUnlocalizedName(ItemReference.SWORD_BRONZE_NAME);
		pickaxeBronze = new ItemCustomPickaxe(ItemReference.PICKAXE_BRONZE_ID, CustomToolMaterials.BRONZE).setUnlocalizedName(ItemReference.PICKAXE_BRONZE_NAME);
		shovelBronze = new ItemCustomShovel(ItemReference.SHOVEL_BRONZE_ID, CustomToolMaterials.BRONZE).setUnlocalizedName(ItemReference.SHOVEL_BRONZE_NAME);
		axeBronze = new ItemCustomAxe(ItemReference.AXE_BRONZE_ID, CustomToolMaterials.BRONZE).setUnlocalizedName(ItemReference.AXE_BRONZE_NAME);
		hammerBronze = new ItemHammer(ItemReference.HAMMER_BRONZE_ID, CustomToolMaterials.BRONZE, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_BRONZE_NAME);
		
		//Steel Tools
		swordSteel = new ItemCustomSword(ItemReference.SWORD_STEEL_ID, CustomToolMaterials.STEEL).setUnlocalizedName(ItemReference.SWORD_STEEL_NAME);
		pickaxeSteel = new ItemCustomPickaxe(ItemReference.PICKAXE_STEEL_ID, CustomToolMaterials.STEEL).setUnlocalizedName(ItemReference.PICKAXE_STEEL_NAME);
		shovelSteel = new ItemCustomShovel(ItemReference.SHOVEL_STEEL_ID, CustomToolMaterials.STEEL).setUnlocalizedName(ItemReference.SHOVEL_STEEL_NAME);
		axeSteel = new ItemCustomAxe(ItemReference.AXE_STEEL_ID, CustomToolMaterials.STEEL).setUnlocalizedName(ItemReference.AXE_STEEL_NAME);
		hammerSteel = new ItemHammer(ItemReference.HAMMER_STEEL_ID, CustomToolMaterials.STEEL, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_STEEL_NAME);
		
		//Adamant Tools
		swordAdamant = new ItemCustomSword(ItemReference.SWORD_ADAMANT_ID, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemReference.SWORD_ADAMANT_NAME);
		pickaxeAdamant = new ItemCustomPickaxe(ItemReference.PICKAXE_ADAMANT_ID, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemReference.PICKAXE_ADAMANT_NAME);
		shovelAdamant = new ItemCustomShovel(ItemReference.SHOVEL_ADAMANT_ID, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemReference.SHOVEL_ADAMANT_NAME);
		axeAdamant = new ItemCustomAxe(ItemReference.AXE_ADAMANT_ID, EnumToolMaterial.EMERALD).setUnlocalizedName(ItemReference.AXE_ADAMANT_NAME);
		hammerAdamant = new ItemHammer(ItemReference.HAMMER_ADAMANT_ID, EnumToolMaterial.EMERALD, Block.cobblestone).setUnlocalizedName(ItemReference.HAMMER_ADAMANT_NAME);
		
		//Armor
		//Adamant Armor
		helmAdamant = new ItemCustomArmor(ItemReference.HELM_ADAMANT_ID, CustomArmorMaterials.ADAMANT, 1, 0).setUnlocalizedName(ItemReference.HELMET_ADAMANT_NAME);
		chestAdamant = new ItemCustomArmor(ItemReference.CHEST_ADAMANT_ID, CustomArmorMaterials.ADAMANT, 1, 1).setUnlocalizedName(ItemReference.CHESTPLATE_ADAMANT_NAME);
		legsAdamant = new ItemCustomArmor(ItemReference.LEGS_ADAMANT_ID, CustomArmorMaterials.ADAMANT, 1, 2).setUnlocalizedName(ItemReference.LEGGINGS_ADAMANT_NAME);
		bootsAdamant = new ItemCustomArmor(ItemReference.BOOTS_ADAMANT_ID, CustomArmorMaterials.ADAMANT, 1, 3).setUnlocalizedName(ItemReference.BOOTS_ADAMANT_NAME);

		//Item Names
		//Ingots
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 0), ItemReference.INGOT_BONE_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 1), ItemReference.INGOT_COPPER_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 2), ItemReference.INGOT_TIN_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 3), ItemReference.INGOT_BRONZE_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 4), ItemReference.INGOT_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 5), ItemReference.INGOT_STEEL_TRANSNAME);
		LanguageRegistry.addName(new ItemStack(ingotBase, 1, 6), ItemReference.INGOT_STRONGGOLD_TRANSNAME);
		
		//Bows
		
		//Bone tools
		LanguageRegistry.addName(swordBone, ItemReference.SWORD_BONE_TRANSNAME);
		LanguageRegistry.addName(pickaxeBone, ItemReference.PICKAXE_BONE_TRANSNAME);
		LanguageRegistry.addName(shovelBone, ItemReference.SHOVEL_BONE_TRANSNAME);
		LanguageRegistry.addName(axeBone, ItemReference.AXE_BONE_TRANSNAME);
		LanguageRegistry.addName(hammerBone, ItemReference.HAMMER_BONE_TRANSNAME);
		
		//Strong Gold tools
		LanguageRegistry.addName(swordStrongGold, ItemReference.SWORD_STRONGGOLD_TRANSNAME);
		LanguageRegistry.addName(pickaxeStrongGold, ItemReference.PICKAXE_STRONGGOLD_TRANSNAME);
		LanguageRegistry.addName(shovelStrongGold, ItemReference.SHOVEL_STRONGGOLD_TRANSNAME);
		LanguageRegistry.addName(axeStrongGold, ItemReference.AXE_STRONGGOLD_TRANSNAME);
		LanguageRegistry.addName(hammerStrongGold, ItemReference.HAMMER_STRONGGOLD_TRANSNAME);
		
		//Bronze tools
		LanguageRegistry.addName(swordBronze, ItemReference.SWORD_BRONZE_TRANSNAME);
		LanguageRegistry.addName(pickaxeBronze, ItemReference.PICKAXE_BRONZE_TRANSNAME);
		LanguageRegistry.addName(shovelBronze, ItemReference.SHOVEL_BRONZE_TRANSNAME);
		LanguageRegistry.addName(axeBronze, ItemReference.AXE_BRONZE_TRANSNAME);
		LanguageRegistry.addName(hammerBronze, ItemReference.HAMMER_BRONZE_TRANSNAME);
		
		//Steel tools
		LanguageRegistry.addName(swordSteel, ItemReference.SWORD_STEEL_TRANSNAME);
		LanguageRegistry.addName(pickaxeSteel, ItemReference.PICKAXE_STEEL_TRANSNAME);
		LanguageRegistry.addName(shovelSteel, ItemReference.SHOVEL_STEEL_TRANSNAME);
		LanguageRegistry.addName(axeSteel, ItemReference.AXE_STEEL_TRANSNAME);
		LanguageRegistry.addName(hammerSteel, ItemReference.HAMMER_STEEL_TRANSNAME);
		
		//Adamant tools
		LanguageRegistry.addName(swordAdamant, ItemReference.SWORD_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(pickaxeAdamant, ItemReference.PICKAXE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(shovelAdamant, ItemReference.SHOVEL_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(axeAdamant, ItemReference.AXE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(hammerAdamant, ItemReference.HAMMER_ADAMANT_TRANSNAME);
		
		//Hammers
		LanguageRegistry.addName(hammerWood, ItemReference.HAMMER_WOOD_TRANSNAME);
		LanguageRegistry.addName(hammerStone, ItemReference.HAMMER_STONE_TRANSNAME);
		LanguageRegistry.addName(hammerIron, ItemReference.HAMMER_IRON_TRANSNAME);
		LanguageRegistry.addName(hammerGold, ItemReference.HAMMER_GOLD_TRANSNAME);
		LanguageRegistry.addName(hammerDiamond, ItemReference.HAMMER_DIAMOND_TRANSNAME);
		LanguageRegistry.addName(hammerMagic, ItemReference.HAMMER_MAGIC_TRANSNAME);

		
		//Armor
		//Adamant Armor
		LanguageRegistry.addName(helmAdamant, ItemReference.HELMET_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(chestAdamant, ItemReference.CHESTPLATE_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(legsAdamant, ItemReference.LEGGINGS_ADAMANT_TRANSNAME);
		LanguageRegistry.addName(bootsAdamant, ItemReference.BOOTS_ADAMANT_TRANSNAME);
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
		OreDictionary.registerOre(ItemReference.INGOT_COPPER_NAME, new ItemStack(ingotBase, 1, 1));
		OreDictionary.registerOre(ItemReference.INGOT_TIN_NAME, new ItemStack(ingotBase, 1, 2));
		OreDictionary.registerOre(ItemReference.INGOT_BRONZE_NAME, new ItemStack(ingotBase, 1, 3));
	}
}
