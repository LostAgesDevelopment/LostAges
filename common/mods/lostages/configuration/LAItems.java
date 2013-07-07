package mods.lostages.configuration;

import mods.lostages.item.ItemCustomArmor;
import mods.lostages.item.ItemCustomAxe;
import mods.lostages.item.ItemCustomBow;
import mods.lostages.item.ItemCustomIngot;
import mods.lostages.item.ItemCustomPickaxe;
import mods.lostages.item.ItemCustomShovel;
import mods.lostages.item.ItemCustomSword;
import mods.lostages.item.ItemHammer;
import mods.lostages.util.Items;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class LAItems {
	
	public static EnumToolMaterial ToolMaterialBone = EnumHelper.addToolMaterial("BONE", 1, 200, 5.0F, 1, 20);
	public static EnumToolMaterial ToolMaterialBronze = EnumHelper.addToolMaterial("BRONZE", 2, 225, 6.0F, 2, 10);
	public static EnumToolMaterial ToolMaterialSteel = EnumHelper.addToolMaterial("STEEL", 2, 500, 7.0F, 3, 16);
	public static EnumToolMaterial ToolMaterialAdamant = EnumHelper.addToolMaterial("ADAMANT", 3, 1561, 8.0F, 3, 10);
	
	public static EnumArmorMaterial ArmorMaterialAdamant = EnumHelper.addArmorMaterial("ADAMANT", 35, new int[]{2, 6, 5, 2}, 25);
	
	public static void init() {
		initializeItems();
		registerItems();
		
		registerNames();
	}
	
	private static void initializeItems() {
		//Items
		Items.ingotBase =new ItemCustomIngot(LAConfiguration.ingotBaseID);
		
		//Bows
		Items.bowJungle = new ItemCustomBow(LAConfiguration.bowJungleID).setUnlocalizedName("bowJungle");
		
		//Bone Tools
		Items.swordBone = new ItemCustomSword(LAConfiguration.swordBoneID, ToolMaterialBone).setUnlocalizedName("swordBone");
		Items.pickaxeBone = new ItemCustomPickaxe(LAConfiguration.pickaxeBoneID, ToolMaterialBone).setUnlocalizedName("pickaxeBone");
		Items.shovelBone = new ItemCustomShovel(LAConfiguration.shovelBoneID, ToolMaterialBone).setUnlocalizedName("shovelBone");
		Items.axeBone = new ItemCustomAxe(LAConfiguration.axeBoneID, ToolMaterialBone).setUnlocalizedName("axeBone");
		
		//Bronze Tools
		Items.swordBronze = new ItemCustomSword(LAConfiguration.swordBronzeID, ToolMaterialBronze).setUnlocalizedName("swordBronze");
		Items.pickaxeBronze = new ItemCustomPickaxe(LAConfiguration.pickaxeBronzeID, ToolMaterialBronze).setUnlocalizedName("pickaxeBronze");
		Items.shovelBronze = new ItemCustomShovel(LAConfiguration.shovelBronzeID, ToolMaterialBronze).setUnlocalizedName("shovelBronze");
		Items.axeBronze = new ItemCustomAxe(LAConfiguration.axeBronzeID, ToolMaterialBronze).setUnlocalizedName("axeBronze");
		
		//Steel Tools
		Items.swordSteel = new ItemCustomSword(LAConfiguration.swordSteelID, ToolMaterialSteel).setUnlocalizedName("swordSteel");
		Items.pickaxeSteel = new ItemCustomPickaxe(LAConfiguration.pickaxeSteelID, ToolMaterialSteel).setUnlocalizedName("pickaxeSteel");
		Items.shovelSteel = new ItemCustomShovel(LAConfiguration.shovelSteelID, ToolMaterialSteel).setUnlocalizedName("shovelSteel");
		Items.axeSteel = new ItemCustomAxe(LAConfiguration.axeSteelID, ToolMaterialSteel).setUnlocalizedName("axeSteel");
		
		//Adamant Tools
		Items.swordAdamant = new ItemCustomSword(LAConfiguration.swordAdamantID, ToolMaterialAdamant).setUnlocalizedName("swordAdamant");
		Items.pickaxeAdamant = new ItemCustomPickaxe(LAConfiguration.pickaxeAdamantID, ToolMaterialAdamant).setUnlocalizedName("pickaxeAdamant");
		Items.shovelAdamant = new ItemCustomShovel(LAConfiguration.shovelAdamantID, ToolMaterialAdamant).setUnlocalizedName("shovelAdamant");
		Items.axeAdamant = new ItemCustomAxe(LAConfiguration.axeAdamantID, ToolMaterialAdamant).setUnlocalizedName("axeAdamant");
		
		//Adamant Armor
		Items.helmetAdamant = new ItemCustomArmor(LAConfiguration.helmetAdamantID, ArmorMaterialAdamant, 3, 0).setUnlocalizedName("helmetAdamant");
		Items.plateAdamant =  new ItemCustomArmor(LAConfiguration.plateAdamantID, ArmorMaterialAdamant, 3, 1).setUnlocalizedName("plateAdamant");
		Items.legsAdamant = new ItemCustomArmor(LAConfiguration.legsAdamantID, ArmorMaterialAdamant, 3, 2).setUnlocalizedName("legsAdamant");
		Items.bootsAdamant = new ItemCustomArmor(LAConfiguration.bootsAdamantID, ArmorMaterialAdamant, 3, 3).setUnlocalizedName("bootsAdamant");
		
		//Hammers
		Items.hammerWood = new ItemHammer(LAConfiguration.hammerWoodID, EnumToolMaterial.WOOD).setUnlocalizedName("hammerWood");
		Items.hammerStone = new ItemHammer(LAConfiguration.hammerStoneID, EnumToolMaterial.STONE).setUnlocalizedName("hammerStone");
		Items.hammerIron = new ItemHammer(LAConfiguration.hammerIronID, EnumToolMaterial.IRON).setUnlocalizedName("hammerIron");
		Items.hammerGold = new ItemHammer(LAConfiguration.hammerGoldID, EnumToolMaterial.GOLD).setUnlocalizedName("hammerGold");
		Items.hammerDiamond = new ItemHammer(LAConfiguration.hammerDiamondID, EnumToolMaterial.EMERALD).setUnlocalizedName("hammerDiamond");
		Items.hammerBone = new ItemHammer(LAConfiguration.hammerBoneID, ToolMaterialBone).setUnlocalizedName("hammerBone");
		Items.hammerBronze = new ItemHammer(LAConfiguration.hammerBronzeID, ToolMaterialBronze).setUnlocalizedName("hammerBronze");
		Items.hammerSteel = new ItemHammer(LAConfiguration.hammerSteelID, ToolMaterialSteel).setUnlocalizedName("hammerSteel");
		Items.hammerAdamant = new ItemHammer(LAConfiguration.hammerAdamantID, ToolMaterialAdamant).setUnlocalizedName("hammerAdamant");
		Items.hammerMagic = new ItemHammer(LAConfiguration.hammerMagicID, EnumToolMaterial.EMERALD, Block.stoneBrick).setUnlocalizedName("hammerMagic");
	}

	private static void registerItems() {
		//Items
		GameRegistry.registerItem(Items.ingotBase, "ingotBase");
		
		//Bows
		GameRegistry.registerItem(Items.bowJungle, "bowJungle");
		
		//Bone Tools
		GameRegistry.registerItem(Items.swordBone, "swordBone");
		GameRegistry.registerItem(Items.pickaxeBone, "pickaxeBone");
		GameRegistry.registerItem(Items.shovelBone, "shovelBone");
		GameRegistry.registerItem(Items.axeBone, "axeBone");
		
		//Bronze Tools
		GameRegistry.registerItem(Items.swordBronze, "swordBronze");
		GameRegistry.registerItem(Items.pickaxeBronze, "pickaxeBronze");
		GameRegistry.registerItem(Items.shovelBronze, "shovelBronze");
		GameRegistry.registerItem(Items.axeBronze, "axeBronze");
		
		//Steel Tools
		GameRegistry.registerItem(Items.swordSteel, "swordSteel");
		GameRegistry.registerItem(Items.pickaxeSteel, "pickaxeSteel");
		GameRegistry.registerItem(Items.shovelSteel, "shovelSteel");
		GameRegistry.registerItem(Items.axeSteel, "axeSteel");
		
		//Adamant Tools
		GameRegistry.registerItem(Items.swordAdamant, "swordAdamant");
		GameRegistry.registerItem(Items.pickaxeAdamant, "pickaxeAdamant");
		GameRegistry.registerItem(Items.shovelAdamant, "shovelAdamant");
		GameRegistry.registerItem(Items.axeAdamant, "axeAdamant");
		
		//Adamant Armor
		GameRegistry.registerItem(Items.helmetAdamant, "helmetAdamant");
		GameRegistry.registerItem(Items.plateAdamant, "plateAdamant");
		GameRegistry.registerItem(Items.legsAdamant, "legsAdamant");
		GameRegistry.registerItem(Items.bootsAdamant, "bootsAdamant");
		
		//Hammers
		GameRegistry.registerItem(Items.hammerWood, "hammerWood");
		GameRegistry.registerItem(Items.hammerStone, "hammerStone");
		GameRegistry.registerItem(Items.hammerIron, "hammerIron");
		GameRegistry.registerItem(Items.hammerGold, "hammerGold");
		GameRegistry.registerItem(Items.hammerDiamond, "hammerDiamond");
		GameRegistry.registerItem(Items.hammerBone, "hammerBone");
		GameRegistry.registerItem(Items.hammerBronze, "hammerBronze");
		GameRegistry.registerItem(Items.hammerSteel, "hammerSteel");
		GameRegistry.registerItem(Items.hammerAdamant, "hammerAdamant");
		GameRegistry.registerItem(Items.hammerMagic, "hammerMagic");
	}
	
	private static void registerNames() {
		//Items
		LanguageRegistry.addName(new ItemStack(Items.ingotBase, 1, 0), "Smelted Bone");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase, 1, 1), "Copper Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase, 1, 2), "Tin Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase, 1, 3), "Bronze Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase, 1, 4), "Steel Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase, 1, 5), "Strong Gold Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase, 1, 6), "Adamant Ingot");
		
		//Bows
		LanguageRegistry.addName(Items.bowJungle, "Jungle Bow");
		
		//Bone Tools
		LanguageRegistry.addName(Items.swordBone, "Bone Sword");
		LanguageRegistry.addName(Items.pickaxeBone, "Bone Pickaxe");
		LanguageRegistry.addName(Items.shovelBone, "Bone Shovel");
		LanguageRegistry.addName(Items.axeBone, "Bone Axe");
		
		//Bronze Tools
		LanguageRegistry.addName(Items.swordBronze, "Bronze Sword");
		LanguageRegistry.addName(Items.pickaxeBronze, "Bronze Pickaxe");
		LanguageRegistry.addName(Items.shovelBronze, "Bronze Shovel");
		LanguageRegistry.addName(Items.axeBronze, "Bronze Axe");
		
		//Steel Tools
		LanguageRegistry.addName(Items.swordSteel, "Steel Sword");
		LanguageRegistry.addName(Items.pickaxeSteel, "Steel Pickaxe");
		LanguageRegistry.addName(Items.shovelSteel, "Steel Shovel");
		LanguageRegistry.addName(Items.axeSteel, "Steel Axe");
		
		//Adamant Tools
		LanguageRegistry.addName(Items.swordAdamant, "Adamant Sword");
		LanguageRegistry.addName(Items.pickaxeAdamant, "Adamant Pickaxe");
		LanguageRegistry.addName(Items.shovelAdamant, "Adamant Shovel");
		LanguageRegistry.addName(Items.axeAdamant, "Adamant Axe");
		
		//Adamant Armor
		LanguageRegistry.addName(Items.helmetAdamant, "Adamant Helemt");
		LanguageRegistry.addName(Items.plateAdamant, "Adamant Chestplate");
		LanguageRegistry.addName(Items.legsAdamant, "Adamant Leggings");
		LanguageRegistry.addName(Items.bootsAdamant, "Adamant Boots");
		
		//Hammers
		LanguageRegistry.addName(Items.hammerWood, "Wooden Hammer");
		LanguageRegistry.addName(Items.hammerStone, "Stone Hammer");
		LanguageRegistry.addName(Items.hammerIron, "Iron Hammer");
		LanguageRegistry.addName(Items.hammerGold, "Gold Hammer");
		LanguageRegistry.addName(Items.hammerDiamond, "Diamond Hammer");
		LanguageRegistry.addName(Items.hammerBone, "Bone Hammer");
		LanguageRegistry.addName(Items.hammerBronze, "Bronze Hammer");
		LanguageRegistry.addName(Items.hammerSteel, "Steel Hammer");
		LanguageRegistry.addName(Items.hammerAdamant, "Adamant Hammer");
		LanguageRegistry.addName(Items.hammerMagic, "Magic Hammer");
	}
}
