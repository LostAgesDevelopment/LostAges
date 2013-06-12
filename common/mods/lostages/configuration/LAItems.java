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

import com.google.common.base.Optional;

import cpw.mods.fml.common.registry.LanguageRegistry;


public class LAItems {
	
	public static EnumToolMaterial ToolMaterialBone;
	public static EnumToolMaterial ToolMaterialBronze;
	public static EnumToolMaterial ToolMaterialSteel;
	public static EnumToolMaterial ToolMaterialAdamant;
	
	public static EnumArmorMaterial ArmorMaterialAdamant;
	
	public static void init() {
		//Initialize Tool Material
		ToolMaterialBone = EnumHelper.addToolMaterial("BONE", 1, 200, 5.0F, 1, 20);
		ToolMaterialBronze = EnumHelper.addToolMaterial("BRONZE", 2, 225, 6.0F, 2, 10);
		ToolMaterialSteel = EnumHelper.addToolMaterial("STEEL", 2, 500, 7.0F, 3, 16);
		ToolMaterialAdamant = EnumHelper.addToolMaterial("ADAMANT", 3, 1561, 8.0F, 3, 10);
		
		//Initialize Armor Material
		ArmorMaterialAdamant = EnumHelper.addArmorMaterial("ADAMANT", 35, new int[]{2, 6, 5, 2}, 25);
		
		initializeItems();
		
		registerNames();
	}
	
	private static void initializeItems() {
		//Items
		Items.ingotBase = Optional.of(new ItemCustomIngot(LAConfiguration.ingotBaseID));
		
		//Bows
		Items.bowJungle = Optional.of(new ItemCustomBow(LAConfiguration.bowJungleID).setUnlocalizedName("bowJungle"));
		
		//Bone Tools
		Items.swordBone = Optional.of(new ItemCustomSword(LAConfiguration.swordBoneID, ToolMaterialBone).setUnlocalizedName("swordBone"));
		Items.pickaxeBone = Optional.of(new ItemCustomPickaxe(LAConfiguration.pickaxeBoneID, ToolMaterialBone).setUnlocalizedName("pickaxeBone"));
		Items.shovelBone = Optional.of(new ItemCustomShovel(LAConfiguration.shovelBoneID, ToolMaterialBone).setUnlocalizedName("shovelBone"));
		Items.axeBone = Optional.of(new ItemCustomAxe(LAConfiguration.axeBoneID, ToolMaterialBone).setUnlocalizedName("axeBone"));
		
		//Bronze Tools
		Items.swordBronze = Optional.of(new ItemCustomSword(LAConfiguration.swordBronzeID, ToolMaterialBronze).setUnlocalizedName("swordBronze"));
		Items.pickaxeBronze = Optional.of(new ItemCustomPickaxe(LAConfiguration.pickaxeBronzeID, ToolMaterialBronze).setUnlocalizedName("pickaxeBronze"));
		Items.shovelBronze = Optional.of(new ItemCustomShovel(LAConfiguration.shovelBronzeID, ToolMaterialBronze).setUnlocalizedName("shovelBronze"));
		Items.axeBronze = Optional.of(new ItemCustomAxe(LAConfiguration.axeBronzeID, ToolMaterialBronze).setUnlocalizedName("axeBronze"));
		
		//Steel Tools
		Items.swordSteel = Optional.of(new ItemCustomSword(LAConfiguration.swordSteelID, ToolMaterialSteel).setUnlocalizedName("swordSteel"));
		Items.pickaxeSteel = Optional.of(new ItemCustomPickaxe(LAConfiguration.pickaxeSteelID, ToolMaterialSteel).setUnlocalizedName("pickaxeSteel"));
		Items.shovelSteel = Optional.of(new ItemCustomShovel(LAConfiguration.shovelSteelID, ToolMaterialSteel).setUnlocalizedName("shovelSteel"));
		Items.axeSteel = Optional.of(new ItemCustomAxe(LAConfiguration.axeSteelID, ToolMaterialSteel).setUnlocalizedName("axeSteel"));
		
		//Adamant Tools
		Items.swordAdamant = Optional.of(new ItemCustomSword(LAConfiguration.swordAdamantID, ToolMaterialAdamant).setUnlocalizedName("swordAdamant"));
		Items.pickaxeAdamant = Optional.of(new ItemCustomPickaxe(LAConfiguration.pickaxeAdamantID, ToolMaterialAdamant).setUnlocalizedName("pickaxeAdamant"));
		Items.shovelAdamant = Optional.of(new ItemCustomShovel(LAConfiguration.shovelAdamantID, ToolMaterialAdamant).setUnlocalizedName("shovelAdamant"));
		Items.axeAdamant = Optional.of(new ItemCustomAxe(LAConfiguration.axeAdamantID, ToolMaterialAdamant).setUnlocalizedName("axeAdamant"));
		
		//Adamant Armor
		Items.helmetAdamant = Optional.of(new ItemCustomArmor(LAConfiguration.helmetAdamantID, ArmorMaterialAdamant, 1, 0).setUnlocalizedName("helmetAdamant"));
		Items.plateAdamant =  Optional.of(new ItemCustomArmor(LAConfiguration.plateAdamantID, ArmorMaterialAdamant, 1, 1).setUnlocalizedName("plateAdamant"));
		Items.legsAdamant = Optional.of(new ItemCustomArmor(LAConfiguration.legsAdamantID, ArmorMaterialAdamant, 1, 2).setUnlocalizedName("legsAdamant"));
		Items.bootsAdamant = Optional.of(new ItemCustomArmor(LAConfiguration.bootsAdamantID, ArmorMaterialAdamant, 1, 3).setUnlocalizedName("bootsAdamant"));
		
		//Hammers
		Items.hammerWood = Optional.of(new ItemHammer(LAConfiguration.hammerWoodID, EnumToolMaterial.WOOD).setUnlocalizedName("hammerWood"));
		Items.hammerStone = Optional.of(new ItemHammer(LAConfiguration.hammerStoneID, EnumToolMaterial.STONE).setUnlocalizedName("hammerStone"));
		Items.hammerIron = Optional.of(new ItemHammer(LAConfiguration.hammerIronID, EnumToolMaterial.IRON).setUnlocalizedName("hammerIron"));
		Items.hammerGold = Optional.of(new ItemHammer(LAConfiguration.hammerGoldID, EnumToolMaterial.GOLD).setUnlocalizedName("hammerGold"));
		Items.hammerDiamond = Optional.of(new ItemHammer(LAConfiguration.hammerDiamondID, EnumToolMaterial.EMERALD).setUnlocalizedName("hammerDiamond"));
		Items.hammerBone = Optional.of(new ItemHammer(LAConfiguration.hammerBoneID, ToolMaterialBone).setUnlocalizedName("hammerBone"));
		Items.hammerBronze = Optional.of(new ItemHammer(LAConfiguration.hammerBronzeID, ToolMaterialBronze).setUnlocalizedName("hammerBronze"));
		Items.hammerSteel = Optional.of(new ItemHammer(LAConfiguration.hammerSteelID, ToolMaterialSteel).setUnlocalizedName("hammerSteel"));
		Items.hammerAdamant = Optional.of(new ItemHammer(LAConfiguration.hammerAdamantID, ToolMaterialAdamant).setUnlocalizedName("hammerAdamant"));
		Items.hammerMagic = Optional.of(new ItemHammer(LAConfiguration.hammerMagicID, EnumToolMaterial.EMERALD, Block.stoneBrick).setUnlocalizedName("hammerMagic"));
	}
	
	private static void registerNames() {
		//Items
		LanguageRegistry.addName(new ItemStack(Items.ingotBase.get(), 1, 0), "Smelted Bone");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase.get(), 1, 1), "Copper Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase.get(), 1, 2), "Tin Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase.get(), 1, 3), "Bronze Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase.get(), 1, 4), "Steel Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase.get(), 1, 5), "Strong Gold Ingot");
		LanguageRegistry.addName(new ItemStack(Items.ingotBase.get(), 1, 6), "Adamant Ingot");
		
		//Bows
		LanguageRegistry.addName(Items.bowJungle.get(), "Jungle Bow");
		
		//Bone Tools
		LanguageRegistry.addName(Items.swordBone.get(), "Bone Sword");
		LanguageRegistry.addName(Items.pickaxeBone.get(), "Bone Pickaxe");
		LanguageRegistry.addName(Items.shovelBone.get(), "Bone Shovel");
		LanguageRegistry.addName(Items.axeBone.get(), "Bone Axe");
		
		//Bronze Tools
		LanguageRegistry.addName(Items.swordBronze.get(), "Bronze Sword");
		LanguageRegistry.addName(Items.pickaxeBronze.get(), "Bronze Pickaxe");
		LanguageRegistry.addName(Items.shovelBronze.get(), "Bronze Shovel");
		LanguageRegistry.addName(Items.axeBronze.get(), "Bronze Axe");
		
		//Steel Tools
		LanguageRegistry.addName(Items.swordSteel.get(), "Steel Sword");
		LanguageRegistry.addName(Items.pickaxeSteel.get(), "Steel Pickaxe");
		LanguageRegistry.addName(Items.shovelSteel.get(), "Steel Shovel");
		LanguageRegistry.addName(Items.axeSteel.get(), "Steel Axe");
		
		//Adamant Tools
		LanguageRegistry.addName(Items.swordAdamant.get(), "Adamant Sword");
		LanguageRegistry.addName(Items.pickaxeAdamant.get(), "Adamant Pickaxe");
		LanguageRegistry.addName(Items.shovelAdamant.get(), "Adamant Shovel");
		LanguageRegistry.addName(Items.axeAdamant.get(), "Adamant Axe");
		
		//Adamant Armor
		LanguageRegistry.addName(Items.helmetAdamant.get(), "Adamant Helemt");
		LanguageRegistry.addName(Items.plateAdamant.get(), "Adamant Chestplate");
		LanguageRegistry.addName(Items.legsAdamant.get(), "Adamant Leggings");
		LanguageRegistry.addName(Items.bootsAdamant.get(), "Adamant Boots");
		
		//Hammers
		LanguageRegistry.addName(Items.hammerWood.get(), "Wooden Hammer");
		LanguageRegistry.addName(Items.hammerStone.get(), "Stone Hammer");
		LanguageRegistry.addName(Items.hammerIron.get(), "Iron Hammer");
		LanguageRegistry.addName(Items.hammerGold.get(), "Gold Hammer");
		LanguageRegistry.addName(Items.hammerDiamond.get(), "Diamond Hammer");
		LanguageRegistry.addName(Items.hammerBone.get(), "Bone Hammer");
		LanguageRegistry.addName(Items.hammerBronze.get(), "Bronze Hammer");
		LanguageRegistry.addName(Items.hammerSteel.get(), "Steel Hammer");
		LanguageRegistry.addName(Items.hammerAdamant.get(), "Adamant Hammer");
		LanguageRegistry.addName(Items.hammerMagic.get(), "Magic Hammer");
	}
}
