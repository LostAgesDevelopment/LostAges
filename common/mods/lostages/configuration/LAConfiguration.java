package mods.lostages.configuration;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;


public class LAConfiguration {
	
	//Blocks
	public static int oreBaseID;
	public static int blockStorageID;
	public static int furnaceDoubleIdleID;
	public static int furnaceDoubleActiveID;
	
	public static int portalLostAgeID;
	
	//Dimension IDs
	public static int dimensionLostAgeID;
	
	//Items
	public static int ingotBaseID;
	
	//Bows
	public static int bowJungleID;
	
	//Bone Tools
	public static int swordBoneID;
	public static int pickaxeBoneID;
	public static int shovelBoneID;
	public static int axeBoneID;
	
	//Bronze Tools
	public static int swordBronzeID;
	public static int pickaxeBronzeID;
	public static int shovelBronzeID;
	public static int axeBronzeID;
	
	//Steel Tools
	public static int swordSteelID;
	public static int pickaxeSteelID;
	public static int shovelSteelID;
	public static int axeSteelID;
	
	//Adamant Tools
	public static int swordAdamantID;
	public static int pickaxeAdamantID;
	public static int shovelAdamantID;
	public static int axeAdamantID;
	
	//Hammers
	public static int hammerWoodID;
	public static int hammerStoneID;
	public static int hammerIronID;
	public static int hammerGoldID;
	public static int hammerDiamondID;
	public static int hammerBoneID;
	public static int hammerBronzeID;
	public static int hammerSteelID;
	public static int hammerAdamantID;
	public static int hammerMagicID;
	
	//Copper Armor
	public static int helmetCopperID;
	public static int plateCopperID;
	public static int legsCopperID;
	public static int bootsCopperID;
	
	//Bronze Armor
	public static int helmetBronzeID;
	public static int plateBronzeID;
	public static int legsBronzeID;
	public static int bootsBronzeID;
	
	//Steel Armor
	public static int helmetSteelID;
	public static int plateSteelID;
	public static int legsSteelID;
	public static int bootsSteelID;
	
	//Adamant Armor
	public static int helmetAdamantID;
	public static int plateAdamantID;
	public static int legsAdamantID;
	public static int bootsAdamantID;
	
	//World Generation
	public static boolean generateCopperOre;
	public static int copperVeinAmount;
	public static boolean generateTinOre;
	public static int tinVeinAmount;
	public static int adamantVeinAmount;
	
	//Item Registration
	public static boolean registerCopperTools;
	public static boolean registerBronzeTools;
	public static boolean registerSteelTools;
	
	public static void initConfigFile(File configFile) {
		Configuration config = new Configuration(configFile);
		try {
			config.load();
			//Blocks
			oreBaseID = config.getBlock("Base Ore ID", 1000).getInt();
			blockStorageID = config.getBlock("Base Storage Block ID", 1001).getInt();
			furnaceDoubleIdleID = config.getBlock("furnaceDoubleIdle", 2000).getInt();
			furnaceDoubleActiveID = config.getBlock("furnaceDoubleActive", 2001).getInt();
			portalLostAgeID = config.getBlock("portalLostAgeID", 2002).getInt();
			
			//Dimension IDs
			dimensionLostAgeID = config.get("Dimension IDs", "LostAge", 20).getInt();
			
			//Items
			ingotBaseID = config.getItem("Base Ingot ID", 4000).getInt();
			
			//Bows
			bowJungleID = config.get("Bows", "bowJungle", 5000).getInt();
			
			//Bone Tools
			swordBoneID = config.get("Bone Tools", "swordBone", 6000).getInt();
			pickaxeBoneID = config.get("Bone Tools", "pickaxeBone", 6001).getInt();
			shovelBoneID = config.get("Bone Tools", "shovelBone", 6002).getInt();
			axeBoneID = config.get("Bone Tools", "axeBone", 6003).getInt();
			
			//Bronze Tools
			swordBronzeID = config.get("Bronze Tools", "swordBronze", 6004).getInt();
			pickaxeBronzeID = config.get("Bronze Tools", "pickaxeBronze", 6005).getInt();
			shovelBronzeID = config.get("Bronze Tools", "shovelBronze", 6006).getInt();
			axeBronzeID = config.get("Bronze Tools", "axeBronze", 6007).getInt();
			
			//Steel Tools
			swordSteelID = config.get("Steel Tools", "swordSteel", 6008).getInt();
			pickaxeSteelID = config.get("Steel Tools", "pickaxeSteel", 6009).getInt();
			shovelSteelID = config.get("Steel Tools", "shovelSteel", 6010).getInt();
			axeSteelID = config.get("Steel Tools", "axeSteel", 6011).getInt();
			
			//Adamant Tools
			swordAdamantID = config.get("Adamant Tools", "swordAdamant", 6012).getInt();
			pickaxeAdamantID = config.get("Adamant Tools", "pickaxeAdamant", 6013).getInt();
			shovelAdamantID = config.get("Adamant Tools", "shovelAdamant", 6014).getInt();
			axeAdamantID = config.get("Adamant Tools", "axeAdamant", 6015).getInt();
			
			//Hammers
			hammerWoodID = config.get("Hammers", "hammerWood", 8000).getInt();
			hammerStoneID = config.get("Hammers", "hammerStone", 8001).getInt();
			hammerIronID = config.get("Hammers", "hammerIron", 8002).getInt();
			hammerGoldID = config.get("Hammers", "hammerGold", 8003).getInt();
			hammerDiamondID = config.get("Hammers", "hammerDiamond", 8004).getInt();
			hammerBoneID = config.get("Hammers", "hammerBone", 8005).getInt();
			hammerBronzeID = config.get("Hammers", "hammerBronze", 8006).getInt();
			hammerSteelID = config.get("Hammers", "hammerSteel", 8007).getInt();
			hammerAdamantID = config.get("Hammers", "hammerAdamant", 8008).getInt();
			hammerMagicID = config.get("Hammers", "hammerMagic", 8009).getInt();
			
			//Copper Armor
			helmetCopperID = config.get("Copper Armor", "helmetCopper", 10004).getInt();
			plateCopperID = config.get("Copper Armor", "plateCopper", 10005).getInt();
			legsCopperID = config.get("Copper Armor", "legsCopper", 10006).getInt();
			bootsCopperID = config.get("Copper Armor", "bootsCopper", 10007).getInt();
			
			//Bronze Armor
			helmetBronzeID = config.get("Bronze Armor", "helmetBronze", 10008).getInt();
			plateBronzeID = config.get("Bronze Armor", "plateBronze", 10009).getInt();
			legsBronzeID = config.get("Bronze Armor", "legsBronze", 10010).getInt();
			bootsBronzeID = config.get("Bronze Armor", "bootsBronze", 10011).getInt();
			
			//Steel Armor
			helmetSteelID = config.get("Steel Armor", "helmetSteel", 10012).getInt();
			plateSteelID = config.get("Steel Armor", "plateSteel", 10013).getInt();
			legsSteelID = config.get("Steel Armor", "legsSteel", 10014).getInt();
			bootsSteelID = config.get("Steel Armor", "bootsSteel", 10015).getInt();
			
			//Adamant Armor
			helmetAdamantID = config.get("Adamant Armor", "helmentAdamant", 10000).getInt();
			plateAdamantID = config.get("Adamant Armor", "plateAdamant", 10001).getInt();
			legsAdamantID = config.get("Adamant Armor", "legsAdamant", 10002).getInt();
			bootsAdamantID = config.get("Adamant Armor", "bootsAdamant", 10003).getInt();
			
			//World Generation
			generateCopperOre = config.get("World Generation", "generateCopperOre", true).getBoolean(true);
			copperVeinAmount = config.get("World Generation", "copperVeinAmount", 5).getInt();
			generateTinOre = config.get("World Generation", "generateTinOre", true).getBoolean(true);
			tinVeinAmount = config.get("World Generation", "tinVeinAmount", 5).getInt();
			adamantVeinAmount = config.get("World Generation", "adamantVeinAmount", 10).getInt();
			
			//Item Registration
			registerCopperTools = config.get("Item Registration", "Register Copper Tools & Armors", true).getBoolean(true);
			registerBronzeTools = config.get("Item Registration", "Register Bronze Tools & Armors", true).getBoolean(true);
			registerSteelTools = config.get("Item Registration", "Register Steel Tools & Armors", true).getBoolean(true);
		} catch (Exception e) {
			e.printStackTrace();
			FMLLog.log("Lost Ages", Level.CONFIG, "Lost Ages has encountered an error loading it's config!");
		} finally {
			config.save();
		}
	}
	
}
