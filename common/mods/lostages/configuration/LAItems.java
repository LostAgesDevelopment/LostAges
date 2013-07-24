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
		Items.ingotBase =new ItemCustomIngot(LAConfiguration.ingotBaseID);
		
		//Bows
		Items.bowJungle = new ItemCustomBow(LAConfiguration.bowJungleID).setUnlocalizedName("bowJungle");
		
		//Bone Tools
		Items.swordBone = new ItemCustomSword(LAConfiguration.swordBoneID, ToolMaterialBone).setUnlocalizedName("swordBone");
		Items.pickaxeBone = new ItemCustomPickaxe(LAConfiguration.pickaxeBoneID, ToolMaterialBone).setUnlocalizedName("pickaxeBone");
		Items.shovelBone = new ItemCustomShovel(LAConfiguration.shovelBoneID, ToolMaterialBone).setUnlocalizedName("shovelBone");
		Items.axeBone = new ItemCustomAxe(LAConfiguration.axeBoneID, ToolMaterialBone).setUnlocalizedName("axeBone");
		
		//Copper Armors
		if (LAConfiguration.registerCopperTools) {
			Items.helmetCopper = new ItemCustomArmor(LAConfiguration.helmetCopperID, ArmorMaterialCopper, 3, 0).setUnlocalizedName("helmetCopper");
			Items.plateCopper = new ItemCustomArmor(LAConfiguration.plateCopperID, ArmorMaterialCopper, 3, 1).setUnlocalizedName("plateCopper");
			Items.legsCopper = new ItemCustomArmor(LAConfiguration.legsCopperID, ArmorMaterialCopper, 3, 2).setUnlocalizedName("legsCopper");
			Items.bootsCopper = new ItemCustomArmor(LAConfiguration.bootsCopperID, ArmorMaterialCopper, 3, 3).setUnlocalizedName("bootsCopper");
		}
		
		//Bronze Tools & Armors
		if (LAConfiguration.registerBronzeTools) {
			Items.swordBronze = new ItemCustomSword(LAConfiguration.swordBronzeID, ToolMaterialBronze).setUnlocalizedName("swordBronze");
			Items.pickaxeBronze = new ItemCustomPickaxe(LAConfiguration.pickaxeBronzeID, ToolMaterialBronze).setUnlocalizedName("pickaxeBronze");
			Items.shovelBronze = new ItemCustomShovel(LAConfiguration.shovelBronzeID, ToolMaterialBronze).setUnlocalizedName("shovelBronze");
			Items.axeBronze = new ItemCustomAxe(LAConfiguration.axeBronzeID, ToolMaterialBronze).setUnlocalizedName("axeBronze");
			Items.helmetBronze = new ItemCustomArmor(LAConfiguration.helmetBronzeID, ArmorMaterialBronze, 3, 0).setUnlocalizedName("helmetBronze");
			Items.plateBronze = new ItemCustomArmor(LAConfiguration.plateBronzeID, ArmorMaterialBronze, 3, 1).setUnlocalizedName("plateBronze");
			Items.legsBronze = new ItemCustomArmor(LAConfiguration.legsBronzeID, ArmorMaterialBronze, 3, 2).setUnlocalizedName("legsBronze");
			Items.bootsBronze = new ItemCustomArmor(LAConfiguration.bootsBronzeID, ArmorMaterialBronze, 3, 3).setUnlocalizedName("bootsBronze");
		}
		
		//Steel Tools & Armors
		if (LAConfiguration.registerSteelTools) {
			Items.swordSteel = new ItemCustomSword(LAConfiguration.swordSteelID, ToolMaterialSteel).setUnlocalizedName("swordSteel");
			Items.pickaxeSteel = new ItemCustomPickaxe(LAConfiguration.pickaxeSteelID, ToolMaterialSteel).setUnlocalizedName("pickaxeSteel");
			Items.shovelSteel = new ItemCustomShovel(LAConfiguration.shovelSteelID, ToolMaterialSteel).setUnlocalizedName("shovelSteel");
			Items.axeSteel = new ItemCustomAxe(LAConfiguration.axeSteelID, ToolMaterialSteel).setUnlocalizedName("axeSteel");
			Items.helmetSteel = new ItemCustomArmor(LAConfiguration.helmetSteelID, ArmorMaterialSteel, 2, 0).setUnlocalizedName("helmetSteel");
			Items.plateSteel = new ItemCustomArmor(LAConfiguration.plateSteelID, ArmorMaterialSteel, 2, 1).setUnlocalizedName("plateSteel");
			Items.legsSteel = new ItemCustomArmor(LAConfiguration.legsSteelID, ArmorMaterialSteel, 2, 2).setUnlocalizedName("legsSteel");
			Items.bootsSteel = new ItemCustomArmor(LAConfiguration.bootsSteelID, ArmorMaterialSteel, 2, 3).setUnlocalizedName("bootsSteel");
		}
		
		//Adamant Tools & Armors
		Items.swordAdamant = new ItemCustomSword(LAConfiguration.swordAdamantID, ToolMaterialAdamant).setUnlocalizedName("swordAdamant");
		Items.pickaxeAdamant = new ItemCustomPickaxe(LAConfiguration.pickaxeAdamantID, ToolMaterialAdamant).setUnlocalizedName("pickaxeAdamant");
		Items.shovelAdamant = new ItemCustomShovel(LAConfiguration.shovelAdamantID, ToolMaterialAdamant).setUnlocalizedName("shovelAdamant");
		Items.axeAdamant = new ItemCustomAxe(LAConfiguration.axeAdamantID, ToolMaterialAdamant).setUnlocalizedName("axeAdamant");
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
		
		//Copper Armors
		if (LAConfiguration.registerCopperTools) {
			GameRegistry.registerItem(Items.helmetCopper, "helmetCopper");
			GameRegistry.registerItem(Items.plateCopper, "plateCopper");
			GameRegistry.registerItem(Items.legsCopper, "legsCopper");
			GameRegistry.registerItem(Items.bootsCopper, "bootsCopper");
		}
		
		//Bronze Tools & Armors
		if (LAConfiguration.registerBronzeTools) {
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
		if (LAConfiguration.registerSteelTools) {
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
