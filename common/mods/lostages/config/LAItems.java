package mods.lostages.config;

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
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;


public class LAItems {
	
	public static EnumToolMaterial ToolMaterialBone = EnumHelper.addToolMaterial("BONE", 1, 200, 5.0F, 1, 20);
	public static EnumToolMaterial ToolMaterialBronze = EnumHelper.addToolMaterial("BRONZE", 2, 225, 6.0F, 2, 10);
	public static EnumToolMaterial ToolMaterialSteel = EnumHelper.addToolMaterial("STEEL", 2, 500, 7.0F, 3, 16);
	public static EnumToolMaterial ToolMaterialAdamant = EnumHelper.addToolMaterial("ADAMANT", 3, 1561, 8.0F, 3, 10);
	
	public static EnumArmorMaterial ArmorMaterialCopper = EnumHelper.addArmorMaterial("COPPER", 15, new int[]{2, 4, 3, 2}, 12);
	public static EnumArmorMaterial ArmorMaterialBronze = EnumHelper.addArmorMaterial("BRONZE", 20, new int[]{2, 4, 4, 2}, 15);
	public static EnumArmorMaterial ArmorMaterialSteel = EnumHelper.addArmorMaterial("STEEL", 25, new int[]{3, 5, 4, 2}, 20);
	public static EnumArmorMaterial ArmorMaterialAdamant = EnumHelper.addArmorMaterial("ADAMANT", 35, new int[]{2, 6, 5, 2}, 25);
	
	public static void init() {
		initializeItems();
		registerItems();
	}
	
	private static void initializeItems() {
		//Items
		Items.ingotBase =new ItemCustomIngot(LAConfig.ingotBaseID);
		
		//Bows
		Items.bowJungle = new ItemCustomBow(LAConfig.bowJungleID).setUnlocalizedName("bowJungle");
		
		//Bone Tools
		Items.swordBone = new ItemCustomSword(LAConfig.swordBoneID, ToolMaterialBone).setUnlocalizedName("swordBone");
		Items.pickaxeBone = new ItemCustomPickaxe(LAConfig.pickaxeBoneID, ToolMaterialBone).setUnlocalizedName("pickaxeBone");
		Items.shovelBone = new ItemCustomShovel(LAConfig.shovelBoneID, ToolMaterialBone).setUnlocalizedName("shovelBone");
		Items.axeBone = new ItemCustomAxe(LAConfig.axeBoneID, ToolMaterialBone).setUnlocalizedName("axeBone");
		
		//Copper Armors
		if (LAConfig.registerCopperTools) {
			Items.helmetCopper = new ItemCustomArmor(LAConfig.helmetCopperID, ArmorMaterialCopper, 3, 0).setUnlocalizedName("helmetCopper");
			Items.plateCopper = new ItemCustomArmor(LAConfig.plateCopperID, ArmorMaterialCopper, 3, 1).setUnlocalizedName("plateCopper");
			Items.legsCopper = new ItemCustomArmor(LAConfig.legsCopperID, ArmorMaterialCopper, 3, 2).setUnlocalizedName("legsCopper");
			Items.bootsCopper = new ItemCustomArmor(LAConfig.bootsCopperID, ArmorMaterialCopper, 3, 3).setUnlocalizedName("bootsCopper");
		}
		
		//Bronze Tools & Armors
		if (LAConfig.registerBronzeTools) {
			Items.swordBronze = new ItemCustomSword(LAConfig.swordBronzeID, ToolMaterialBronze).setUnlocalizedName("swordBronze");
			Items.pickaxeBronze = new ItemCustomPickaxe(LAConfig.pickaxeBronzeID, ToolMaterialBronze).setUnlocalizedName("pickaxeBronze");
			Items.shovelBronze = new ItemCustomShovel(LAConfig.shovelBronzeID, ToolMaterialBronze).setUnlocalizedName("shovelBronze");
			Items.axeBronze = new ItemCustomAxe(LAConfig.axeBronzeID, ToolMaterialBronze).setUnlocalizedName("axeBronze");
			Items.helmetBronze = new ItemCustomArmor(LAConfig.helmetBronzeID, ArmorMaterialBronze, 3, 0).setUnlocalizedName("helmetBronze");
			Items.plateBronze = new ItemCustomArmor(LAConfig.plateBronzeID, ArmorMaterialBronze, 3, 1).setUnlocalizedName("plateBronze");
			Items.legsBronze = new ItemCustomArmor(LAConfig.legsBronzeID, ArmorMaterialBronze, 3, 2).setUnlocalizedName("legsBronze");
			Items.bootsBronze = new ItemCustomArmor(LAConfig.bootsBronzeID, ArmorMaterialBronze, 3, 3).setUnlocalizedName("bootsBronze");
		}
		
		//Steel Tools & Armors
		if (LAConfig.registerSteelTools) {
			Items.swordSteel = new ItemCustomSword(LAConfig.swordSteelID, ToolMaterialSteel).setUnlocalizedName("swordSteel");
			Items.pickaxeSteel = new ItemCustomPickaxe(LAConfig.pickaxeSteelID, ToolMaterialSteel).setUnlocalizedName("pickaxeSteel");
			Items.shovelSteel = new ItemCustomShovel(LAConfig.shovelSteelID, ToolMaterialSteel).setUnlocalizedName("shovelSteel");
			Items.axeSteel = new ItemCustomAxe(LAConfig.axeSteelID, ToolMaterialSteel).setUnlocalizedName("axeSteel");
			Items.helmetSteel = new ItemCustomArmor(LAConfig.helmetSteelID, ArmorMaterialSteel, 2, 0).setUnlocalizedName("helmetSteel");
			Items.plateSteel = new ItemCustomArmor(LAConfig.plateSteelID, ArmorMaterialSteel, 2, 1).setUnlocalizedName("plateSteel");
			Items.legsSteel = new ItemCustomArmor(LAConfig.legsSteelID, ArmorMaterialSteel, 2, 2).setUnlocalizedName("legsSteel");
			Items.bootsSteel = new ItemCustomArmor(LAConfig.bootsSteelID, ArmorMaterialSteel, 2, 3).setUnlocalizedName("bootsSteel");
		}
		
		//Adamant Tools & Armors
		Items.swordAdamant = new ItemCustomSword(LAConfig.swordAdamantID, ToolMaterialAdamant).setUnlocalizedName("swordAdamant");
		Items.pickaxeAdamant = new ItemCustomPickaxe(LAConfig.pickaxeAdamantID, ToolMaterialAdamant).setUnlocalizedName("pickaxeAdamant");
		Items.shovelAdamant = new ItemCustomShovel(LAConfig.shovelAdamantID, ToolMaterialAdamant).setUnlocalizedName("shovelAdamant");
		Items.axeAdamant = new ItemCustomAxe(LAConfig.axeAdamantID, ToolMaterialAdamant).setUnlocalizedName("axeAdamant");
		Items.helmetAdamant = new ItemCustomArmor(LAConfig.helmetAdamantID, ArmorMaterialAdamant, 3, 0).setUnlocalizedName("helmetAdamant");
		Items.plateAdamant =  new ItemCustomArmor(LAConfig.plateAdamantID, ArmorMaterialAdamant, 3, 1).setUnlocalizedName("plateAdamant");
		Items.legsAdamant = new ItemCustomArmor(LAConfig.legsAdamantID, ArmorMaterialAdamant, 3, 2).setUnlocalizedName("legsAdamant");
		Items.bootsAdamant = new ItemCustomArmor(LAConfig.bootsAdamantID, ArmorMaterialAdamant, 3, 3).setUnlocalizedName("bootsAdamant");
		
		//Hammers
		Items.hammerWood = new ItemHammer(LAConfig.hammerWoodID, EnumToolMaterial.WOOD).setUnlocalizedName("hammerWood");
		Items.hammerStone = new ItemHammer(LAConfig.hammerStoneID, EnumToolMaterial.STONE).setUnlocalizedName("hammerStone");
		Items.hammerIron = new ItemHammer(LAConfig.hammerIronID, EnumToolMaterial.IRON).setUnlocalizedName("hammerIron");
		Items.hammerGold = new ItemHammer(LAConfig.hammerGoldID, EnumToolMaterial.GOLD).setUnlocalizedName("hammerGold");
		Items.hammerDiamond = new ItemHammer(LAConfig.hammerDiamondID, EnumToolMaterial.EMERALD).setUnlocalizedName("hammerDiamond");
		Items.hammerBone = new ItemHammer(LAConfig.hammerBoneID, ToolMaterialBone).setUnlocalizedName("hammerBone");
		Items.hammerBronze = new ItemHammer(LAConfig.hammerBronzeID, ToolMaterialBronze).setUnlocalizedName("hammerBronze");
		Items.hammerSteel = new ItemHammer(LAConfig.hammerSteelID, ToolMaterialSteel).setUnlocalizedName("hammerSteel");
		Items.hammerAdamant = new ItemHammer(LAConfig.hammerAdamantID, ToolMaterialAdamant).setUnlocalizedName("hammerAdamant");
		Items.hammerMagic = new ItemHammer(LAConfig.hammerMagicID, EnumToolMaterial.EMERALD, Block.stoneBrick).setUnlocalizedName("hammerMagic");
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
		
		//Copper Armors
		if (LAConfig.registerCopperTools) {
			GameRegistry.registerItem(Items.helmetCopper, "helmetCopper");
			GameRegistry.registerItem(Items.plateCopper, "plateCopper");
			GameRegistry.registerItem(Items.legsCopper, "legsCopper");
			GameRegistry.registerItem(Items.bootsCopper, "bootsCopper");
		}
		
		//Bronze Tools & Armors
		if (LAConfig.registerBronzeTools) {
			GameRegistry.registerItem(Items.swordBronze, "swordBronze");
			GameRegistry.registerItem(Items.pickaxeBronze, "pickaxeBronze");
			GameRegistry.registerItem(Items.shovelBronze, "shovelBronze");
			GameRegistry.registerItem(Items.axeBronze, "axeBronze");
			GameRegistry.registerItem(Items.helmetBronze, "helmetBronze");
			GameRegistry.registerItem(Items.plateBronze, "plateBronze");
			GameRegistry.registerItem(Items.legsBronze, "legsBronze");
			GameRegistry.registerItem(Items.bootsBronze, "bootsBronze");
		}
		
		//Steel Tools & Armors
		if (LAConfig.registerSteelTools) {
			GameRegistry.registerItem(Items.swordSteel, "swordSteel");
			GameRegistry.registerItem(Items.pickaxeSteel, "pickaxeSteel");
			GameRegistry.registerItem(Items.shovelSteel, "shovelSteel");
			GameRegistry.registerItem(Items.axeSteel, "axeSteel");
			GameRegistry.registerItem(Items.helmetSteel, "helmetSteel");
			GameRegistry.registerItem(Items.plateSteel, "plateSteel");
			GameRegistry.registerItem(Items.legsSteel, "legsSteel");
			GameRegistry.registerItem(Items.bootsSteel, "bootsSteel");
		}
		
		//Adamant Tools & Armors
		GameRegistry.registerItem(Items.swordAdamant, "swordAdamant");
		GameRegistry.registerItem(Items.pickaxeAdamant, "pickaxeAdamant");
		GameRegistry.registerItem(Items.shovelAdamant, "shovelAdamant");
		GameRegistry.registerItem(Items.axeAdamant, "axeAdamant");
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
	
}
