package mods.lostages.config;

import mods.lostages.item.ItemCustomArmor;
import mods.lostages.item.ItemCustomAxe;
import mods.lostages.item.ItemCustomBow;
import mods.lostages.item.ItemCustomIngot;
import mods.lostages.item.ItemCustomPickaxe;
import mods.lostages.item.ItemCustomShovel;
import mods.lostages.item.ItemCustomSword;
import mods.lostages.item.ItemHammer;
import mods.lostages.util.LAItems;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;


public class ItemRegistry {
	
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
		LAItems.ingotBase =new ItemCustomIngot(ConfigHandler.ingotBaseID);
		
		//Bows
		LAItems.bowJungle = new ItemCustomBow(ConfigHandler.bowJungleID).setUnlocalizedName("bowJungle");
		
		//Bone Tools
		LAItems.swordBone = new ItemCustomSword(ConfigHandler.swordBoneID, ToolMaterialBone).setUnlocalizedName("swordBone");
		LAItems.pickaxeBone = new ItemCustomPickaxe(ConfigHandler.pickaxeBoneID, ToolMaterialBone).setUnlocalizedName("pickaxeBone");
		LAItems.shovelBone = new ItemCustomShovel(ConfigHandler.shovelBoneID, ToolMaterialBone).setUnlocalizedName("shovelBone");
		LAItems.axeBone = new ItemCustomAxe(ConfigHandler.axeBoneID, ToolMaterialBone).setUnlocalizedName("axeBone");
		
		//Copper Armors
		if (ConfigHandler.registerCopperTools) {
			LAItems.helmetCopper = new ItemCustomArmor(ConfigHandler.helmetCopperID, ArmorMaterialCopper, 3, 0).setUnlocalizedName("helmetCopper");
			LAItems.plateCopper = new ItemCustomArmor(ConfigHandler.plateCopperID, ArmorMaterialCopper, 3, 1).setUnlocalizedName("plateCopper");
			LAItems.legsCopper = new ItemCustomArmor(ConfigHandler.legsCopperID, ArmorMaterialCopper, 3, 2).setUnlocalizedName("legsCopper");
			LAItems.bootsCopper = new ItemCustomArmor(ConfigHandler.bootsCopperID, ArmorMaterialCopper, 3, 3).setUnlocalizedName("bootsCopper");
		}
		
		//Bronze Tools & Armors
		if (ConfigHandler.registerBronzeTools) {
			LAItems.swordBronze = new ItemCustomSword(ConfigHandler.swordBronzeID, ToolMaterialBronze).setUnlocalizedName("swordBronze");
			LAItems.pickaxeBronze = new ItemCustomPickaxe(ConfigHandler.pickaxeBronzeID, ToolMaterialBronze).setUnlocalizedName("pickaxeBronze");
			LAItems.shovelBronze = new ItemCustomShovel(ConfigHandler.shovelBronzeID, ToolMaterialBronze).setUnlocalizedName("shovelBronze");
			LAItems.axeBronze = new ItemCustomAxe(ConfigHandler.axeBronzeID, ToolMaterialBronze).setUnlocalizedName("axeBronze");
			LAItems.helmetBronze = new ItemCustomArmor(ConfigHandler.helmetBronzeID, ArmorMaterialBronze, 3, 0).setUnlocalizedName("helmetBronze");
			LAItems.plateBronze = new ItemCustomArmor(ConfigHandler.plateBronzeID, ArmorMaterialBronze, 3, 1).setUnlocalizedName("plateBronze");
			LAItems.legsBronze = new ItemCustomArmor(ConfigHandler.legsBronzeID, ArmorMaterialBronze, 3, 2).setUnlocalizedName("legsBronze");
			LAItems.bootsBronze = new ItemCustomArmor(ConfigHandler.bootsBronzeID, ArmorMaterialBronze, 3, 3).setUnlocalizedName("bootsBronze");
		}
		
		//Steel Tools & Armors
		if (ConfigHandler.registerSteelTools) {
			LAItems.swordSteel = new ItemCustomSword(ConfigHandler.swordSteelID, ToolMaterialSteel).setUnlocalizedName("swordSteel");
			LAItems.pickaxeSteel = new ItemCustomPickaxe(ConfigHandler.pickaxeSteelID, ToolMaterialSteel).setUnlocalizedName("pickaxeSteel");
			LAItems.shovelSteel = new ItemCustomShovel(ConfigHandler.shovelSteelID, ToolMaterialSteel).setUnlocalizedName("shovelSteel");
			LAItems.axeSteel = new ItemCustomAxe(ConfigHandler.axeSteelID, ToolMaterialSteel).setUnlocalizedName("axeSteel");
			LAItems.helmetSteel = new ItemCustomArmor(ConfigHandler.helmetSteelID, ArmorMaterialSteel, 2, 0).setUnlocalizedName("helmetSteel");
			LAItems.plateSteel = new ItemCustomArmor(ConfigHandler.plateSteelID, ArmorMaterialSteel, 2, 1).setUnlocalizedName("plateSteel");
			LAItems.legsSteel = new ItemCustomArmor(ConfigHandler.legsSteelID, ArmorMaterialSteel, 2, 2).setUnlocalizedName("legsSteel");
			LAItems.bootsSteel = new ItemCustomArmor(ConfigHandler.bootsSteelID, ArmorMaterialSteel, 2, 3).setUnlocalizedName("bootsSteel");
		}
		
		//Adamant Tools & Armors
		LAItems.swordAdamant = new ItemCustomSword(ConfigHandler.swordAdamantID, ToolMaterialAdamant).setUnlocalizedName("swordAdamant");
		LAItems.pickaxeAdamant = new ItemCustomPickaxe(ConfigHandler.pickaxeAdamantID, ToolMaterialAdamant).setUnlocalizedName("pickaxeAdamant");
		LAItems.shovelAdamant = new ItemCustomShovel(ConfigHandler.shovelAdamantID, ToolMaterialAdamant).setUnlocalizedName("shovelAdamant");
		LAItems.axeAdamant = new ItemCustomAxe(ConfigHandler.axeAdamantID, ToolMaterialAdamant).setUnlocalizedName("axeAdamant");
		LAItems.helmetAdamant = new ItemCustomArmor(ConfigHandler.helmetAdamantID, ArmorMaterialAdamant, 3, 0).setUnlocalizedName("helmetAdamant");
		LAItems.plateAdamant =  new ItemCustomArmor(ConfigHandler.plateAdamantID, ArmorMaterialAdamant, 3, 1).setUnlocalizedName("plateAdamant");
		LAItems.legsAdamant = new ItemCustomArmor(ConfigHandler.legsAdamantID, ArmorMaterialAdamant, 3, 2).setUnlocalizedName("legsAdamant");
		LAItems.bootsAdamant = new ItemCustomArmor(ConfigHandler.bootsAdamantID, ArmorMaterialAdamant, 3, 3).setUnlocalizedName("bootsAdamant");
		
		//Hammers
		LAItems.hammerWood = new ItemHammer(ConfigHandler.hammerWoodID, EnumToolMaterial.WOOD).setUnlocalizedName("hammerWood");
		LAItems.hammerStone = new ItemHammer(ConfigHandler.hammerStoneID, EnumToolMaterial.STONE).setUnlocalizedName("hammerStone");
		LAItems.hammerIron = new ItemHammer(ConfigHandler.hammerIronID, EnumToolMaterial.IRON).setUnlocalizedName("hammerIron");
		LAItems.hammerGold = new ItemHammer(ConfigHandler.hammerGoldID, EnumToolMaterial.GOLD).setUnlocalizedName("hammerGold");
		LAItems.hammerDiamond = new ItemHammer(ConfigHandler.hammerDiamondID, EnumToolMaterial.EMERALD).setUnlocalizedName("hammerDiamond");
		LAItems.hammerBone = new ItemHammer(ConfigHandler.hammerBoneID, ToolMaterialBone).setUnlocalizedName("hammerBone");
		LAItems.hammerBronze = new ItemHammer(ConfigHandler.hammerBronzeID, ToolMaterialBronze).setUnlocalizedName("hammerBronze");
		LAItems.hammerSteel = new ItemHammer(ConfigHandler.hammerSteelID, ToolMaterialSteel).setUnlocalizedName("hammerSteel");
		LAItems.hammerAdamant = new ItemHammer(ConfigHandler.hammerAdamantID, ToolMaterialAdamant).setUnlocalizedName("hammerAdamant");
		LAItems.hammerMagic = new ItemHammer(ConfigHandler.hammerMagicID, EnumToolMaterial.EMERALD, Block.stoneBrick).setUnlocalizedName("hammerMagic");
	}

	private static void registerItems() {
		//Items
		GameRegistry.registerItem(LAItems.ingotBase, "ingotBase");
		
		//Bows
		GameRegistry.registerItem(LAItems.bowJungle, "bowJungle");
		
		//Bone Tools
		GameRegistry.registerItem(LAItems.swordBone, "swordBone");
		GameRegistry.registerItem(LAItems.pickaxeBone, "pickaxeBone");
		GameRegistry.registerItem(LAItems.shovelBone, "shovelBone");
		GameRegistry.registerItem(LAItems.axeBone, "axeBone");
		
		//Copper Armors
		if (ConfigHandler.registerCopperTools) {
			GameRegistry.registerItem(LAItems.helmetCopper, "helmetCopper");
			GameRegistry.registerItem(LAItems.plateCopper, "plateCopper");
			GameRegistry.registerItem(LAItems.legsCopper, "legsCopper");
			GameRegistry.registerItem(LAItems.bootsCopper, "bootsCopper");
		}
		
		//Bronze Tools & Armors
		if (ConfigHandler.registerBronzeTools) {
			GameRegistry.registerItem(LAItems.swordBronze, "swordBronze");
			GameRegistry.registerItem(LAItems.pickaxeBronze, "pickaxeBronze");
			GameRegistry.registerItem(LAItems.shovelBronze, "shovelBronze");
			GameRegistry.registerItem(LAItems.axeBronze, "axeBronze");
			GameRegistry.registerItem(LAItems.helmetBronze, "helmetBronze");
			GameRegistry.registerItem(LAItems.plateBronze, "plateBronze");
			GameRegistry.registerItem(LAItems.legsBronze, "legsBronze");
			GameRegistry.registerItem(LAItems.bootsBronze, "bootsBronze");
		}
		
		//Steel Tools & Armors
		if (ConfigHandler.registerSteelTools) {
			GameRegistry.registerItem(LAItems.swordSteel, "swordSteel");
			GameRegistry.registerItem(LAItems.pickaxeSteel, "pickaxeSteel");
			GameRegistry.registerItem(LAItems.shovelSteel, "shovelSteel");
			GameRegistry.registerItem(LAItems.axeSteel, "axeSteel");
			GameRegistry.registerItem(LAItems.helmetSteel, "helmetSteel");
			GameRegistry.registerItem(LAItems.plateSteel, "plateSteel");
			GameRegistry.registerItem(LAItems.legsSteel, "legsSteel");
			GameRegistry.registerItem(LAItems.bootsSteel, "bootsSteel");
		}
		
		//Adamant Tools & Armors
		GameRegistry.registerItem(LAItems.swordAdamant, "swordAdamant");
		GameRegistry.registerItem(LAItems.pickaxeAdamant, "pickaxeAdamant");
		GameRegistry.registerItem(LAItems.shovelAdamant, "shovelAdamant");
		GameRegistry.registerItem(LAItems.axeAdamant, "axeAdamant");
		GameRegistry.registerItem(LAItems.helmetAdamant, "helmetAdamant");
		GameRegistry.registerItem(LAItems.plateAdamant, "plateAdamant");
		GameRegistry.registerItem(LAItems.legsAdamant, "legsAdamant");
		GameRegistry.registerItem(LAItems.bootsAdamant, "bootsAdamant");
		
		//Hammers
		GameRegistry.registerItem(LAItems.hammerWood, "hammerWood");
		GameRegistry.registerItem(LAItems.hammerStone, "hammerStone");
		GameRegistry.registerItem(LAItems.hammerIron, "hammerIron");
		GameRegistry.registerItem(LAItems.hammerGold, "hammerGold");
		GameRegistry.registerItem(LAItems.hammerDiamond, "hammerDiamond");
		GameRegistry.registerItem(LAItems.hammerBone, "hammerBone");
		GameRegistry.registerItem(LAItems.hammerBronze, "hammerBronze");
		GameRegistry.registerItem(LAItems.hammerSteel, "hammerSteel");
		GameRegistry.registerItem(LAItems.hammerAdamant, "hammerAdamant");
		GameRegistry.registerItem(LAItems.hammerMagic, "hammerMagic");
	}
	
}
