package mods.lostages.configuration;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;


public class LAConfiguration {
	//Blocks
	public static int oreBaseID;
	public static int blockStorageID;
	public static int furnaceDoubleID;
	
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
	
	//Adamant Armor
	public static int helmetAdamantID;
	public static int plateAdamantID;
	public static int legsAdamantID;
	public static int bootsAdamantID;
	
	public static void initConfigFile(File configFile) {
		Configuration config = new Configuration(configFile);
		try {
			config.load();
			//Blocks
			oreBaseID = config.getBlock("Base Ore ID", 1000).getInt();
			blockStorageID = config.getBlock("Base Storage Block ID", 1001).getInt();
			furnaceDoubleID = config.getBlock("furnaceDouble", 2000).getInt();
			
			//Items
			ingotBaseID = config.getItem("Base Ingot ID", 7000).getInt();
			
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
			
			//Adamant Armor
			helmetAdamantID = config.get("Adamant Armor", "helmentAdamant", 10000).getInt();
			plateAdamantID = config.get("Adamant Armor", "plateAdamant", 10001).getInt();
			legsAdamantID = config.get("Adamant Armor", "legsAdamant", 10002).getInt();
			bootsAdamantID = config.get("Adamant Armor", "bootsAdamant", 10003).getInt();
			
		} catch (Exception e) {
			e.printStackTrace();
			FMLLog.log("Lost Ages", Level.CONFIG, "Lost Ages has encountered an error loading it's config!");
		} finally {
			config.save();
		}
	}
}
