package com.lostages.core.handler;

import java.io.File;
import java.util.logging.Level;

import com.lostages.lib.BlockIDs;
import com.lostages.lib.BlockStrings;
import com.lostages.lib.ItemIDs;
import com.lostages.lib.ItemStrings;
import com.lostages.lib.Reference;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler {
	
	public static void loadConfig(File file)
	{
		Configuration config = new Configuration(file);
		try {
			config.load();
			//Items
			//Ingots
			ItemIDs.SMELTEDBONE = config.getItem(ItemStrings.SMELTEDBONE_TRANSNAME, ItemIDs.SMELTEDBONE_DEFAULT).getInt();
			ItemIDs.ADAMANT_INGOT = config.getItem(ItemStrings.ADAMANT_INGOT_TRANSNAME, ItemIDs.ADAMANT_INGOT_DEFAULT).getInt();
			ItemIDs.BRONZE_INGOT = config.getItem(ItemStrings.BRONZE_INGOT_TRANSNAME, ItemIDs.BRONZE_INGOT_DEFAULT).getInt();
			ItemIDs.STEEL_INGOT = config.getItem(ItemStrings.STEEL_INGOT_TRANSNAME, ItemIDs.STEEL_INGOT_DEFAULT).getInt();
			
			//Other Items
			ItemIDs.STACKEDCOAL2 = config.getItem(ItemStrings.STACKEDCOAL2_TRANSNAME, ItemIDs.STACKEDCOAL2_DEFAULT).getInt();
			ItemIDs.STACKEDCOAL4 = config.getItem(ItemStrings.STACKEDCOAL4_TRANSNAME, ItemIDs.STACKEDCOAL4_DEFAULT).getInt();
			ItemIDs.STACKEDCOAL6 = config.getItem(ItemStrings.STACKEDCOAL6_TRANSNAME, ItemIDs.STACKEDCOAL6_DEFAULT).getInt();
			ItemIDs.STACKEDCOAL8 = config.getItem(ItemStrings.STACKEDCOAL8_TRANSNAME, ItemIDs.STACKEDCOAL8_DEFAULT).getInt();

			//Armor
			//Adamant Armor
			ItemIDs.HELM_ADAMANT = config.getItem("Adamant Helmet", ItemIDs.HELM_ADAMANT_DEFAULT).getInt();
			ItemIDs.CHEST_ADAMANT = config.getItem("Adamant Chestplate", ItemIDs.CHEST_ADAMANT_DEFAULT).getInt();
			ItemIDs.LEGS_ADAMANT = config.getItem("Adamant Leggings", ItemIDs.LEGS_ADAMANT_DEFAULT).getInt();
			ItemIDs.BOOTS_ADAMANT = config.getItem("Adamant Boots", ItemIDs.BOOTS_ADAMANT_DEFAULT).getInt();

			
			//Tools - Weapons			
			//Bows
			ItemIDs.BOW_JUNGLE = config.getItem(ItemStrings.BOW_JUNGLE_TRANSNAME, ItemIDs.BOW_JUNGLE_DEFAULT).getInt();
			
			//Bone tools
			ItemIDs.SWORD_BONE = config.getItem(ItemStrings.SWORD_BONE_TRANSNAME, ItemIDs.SWORD_BONE_DEFAULT).getInt();
			ItemIDs.PICKAXE_BONE = config.getItem(ItemStrings.PICKAXE_BONE_TRANSNAME, ItemIDs.PICKAXE_BONE_DEFAULT).getInt();
			ItemIDs.SHOVEL_BONE = config.getItem(ItemStrings.SHOVEL_BONE_TRANSNAME, ItemIDs.SHOVEL_BONE_DEFAULT).getInt();
			ItemIDs.AXE_BONE = config.getItem(ItemStrings.AXE_BONE_TRANSNAME, ItemIDs.AXE_BONE_DEFAULT).getInt();
			ItemIDs.HAMMER_BONE = config.getItem(ItemStrings.HAMMER_BONE_TRANSNAME, ItemIDs.HAMMER_BONE_DEFAULT).getInt();
			
			//Flint tools
			ItemIDs.PICKAXE_FLINT = config.getItem(ItemStrings.PICKAXE_FLINT_TRANSNAME, ItemIDs.PICKAXE_FLINT_DEFAULT).getInt();
			ItemIDs.SHOVEL_FLINT = config.getItem(ItemStrings.SHOVEL_FLINT_TRANSNAME, ItemIDs.SHOVEL_FLINT_DEFAULT).getInt();
			ItemIDs.AXE_FLINT = config.getItem(ItemStrings.AXE_FLINT_TRANSNAME, ItemIDs.AXE_FLINT_DEFAULT).getInt();
			
			//Strong Gold tools
			ItemIDs.SWORD_STRONGGOLD = config.getItem(ItemStrings.SWORD_STRONGGOLD_TRANSNAME, ItemIDs.SWORD_STRONGGOLD_DEFAULT).getInt();
			ItemIDs.PICKAXE_STRONGGOLD = config.getItem(ItemStrings.PICKAXE_STRONGGOLD_TRANSNAME, ItemIDs.PICKAXE_STRONGGOLD_DEFAULT).getInt();
			ItemIDs.SHOVEL_STRONGGOLD = config.getItem(ItemStrings.SHOVEL_STRONGGOLD_TRANSNAME, ItemIDs.SHOVEL_STRONGGOLD_DEFAULT).getInt();
			ItemIDs.AXE_STRONGGOLD = config.getItem(ItemStrings.AXE_STRONGGOLD_TRANSNAME, ItemIDs.AXE_STRONGGOLD_DEFAULT).getInt();
			ItemIDs.HAMMER_STRONGGOLD = config.getItem(ItemStrings.HAMMER_STRONGGOLD_TRANSNAME, ItemIDs.HAMMER_STRONGGOLD_DEFAULT).getInt();
			
			//Bronze tools
			ItemIDs.SWORD_BRONZE = config.getItem(ItemStrings.SWORD_BRONZE_TRANSNAME, ItemIDs.SWORD_BRONZE_DEFAULT).getInt();
			ItemIDs.PICKAXE_BRONZE = config.getItem(ItemStrings.PICKAXE_BRONZE_TRANSNAME, ItemIDs.PICKAXE_BRONZE_DEFAULT).getInt();
			ItemIDs.SHOVEL_BRONZE = config.getItem(ItemStrings.SHOVEL_BRONZE_TRANSNAME, ItemIDs.SHOVEL_BRONZE_DEFAULT).getInt();
			ItemIDs.AXE_BRONZE = config.getItem(ItemStrings.AXE_BRONZE_TRANSNAME, ItemIDs.AXE_BRONZE_DEFAULT).getInt();
			ItemIDs.HAMMER_BRONZE = config.getItem(ItemStrings.HAMMER_BRONZE_TRANSNAME, ItemIDs.HAMMER_BRONZE_DEFAULT).getInt();
			
			//Steel tools
			ItemIDs.SWORD_STEEL = config.getItem(ItemStrings.SWORD_STEEL_TRANSNAME, ItemIDs.SWORD_STEEL_DEFAULT).getInt();
			ItemIDs.PICKAXE_STEEL = config.getItem(ItemStrings.PICKAXE_STEEL_TRANSNAME, ItemIDs.PICKAXE_STEEL_DEFAULT).getInt();
			ItemIDs.SHOVEL_STEEL = config.getItem(ItemStrings.SHOVEL_STEEL_TRANSNAME, ItemIDs.SHOVEL_STEEL_DEFAULT).getInt();
			ItemIDs.AXE_STEEL = config.getItem(ItemStrings.AXE_STEEL_TRANSNAME, ItemIDs.AXE_STEEL_DEFAULT).getInt();
			ItemIDs.HAMMER_STEEL = config.getItem(ItemStrings.HAMMER_STEEL_TRANSNAME, ItemIDs.HAMMER_STEEL_DEFAULT).getInt();
			
			//Adamant tools
			ItemIDs.SWORD_ADAMANT = config.getItem(ItemStrings.SWORD_ADAMANT_TRANSNAME, ItemIDs.SWORD_ADAMANT_DEFAULT).getInt();
			ItemIDs.PICKAXE_ADAMANT = config.getItem(ItemStrings.PICKAXE_ADAMANT_TRANSNAME, ItemIDs.PICKAXE_ADAMANT_DEFAULT).getInt();
			ItemIDs.SHOVEL_ADAMANT = config.getItem(ItemStrings.SHOVEL_ADAMANT_TRANSNAME, ItemIDs.SHOVEL_ADAMANT_DEFAULT).getInt();
			ItemIDs.AXE_ADAMANT = config.getItem(ItemStrings.AXE_ADAMANT_TRANSNAME, ItemIDs.AXE_ADAMANT_DEFAULT).getInt();
			ItemIDs.HAMMER_ADAMANT = config.getItem(ItemStrings.HAMMER_ADAMANT_TRANSNAME, ItemIDs.HAMMER_ADAMANT_DEFAULT).getInt();
			
			//Hammers
			ItemIDs.HAMMER_WOOD = config.getItem(ItemStrings.HAMMER_WOOD_TRANSNAME, ItemIDs.HAMMER_WOOD_DEFAULT).getInt();
			ItemIDs.HAMMER_STONE = config.getItem(ItemStrings.HAMMER_STONE_TRANSNAME, ItemIDs.HAMMER_STONE_DEFAULT).getInt();
			ItemIDs.HAMMER_IRON = config.getItem(ItemStrings.HAMMER_IRON_TRANSNAME, ItemIDs.HAMMER_IRON_DEFAULT).getInt();
			ItemIDs.HAMMER_GOLD = config.getItem(ItemStrings.HAMMER_GOLD_TRANSNAME, ItemIDs.HAMMER_GOLD_DEFAULT).getInt();
			ItemIDs.HAMMER_DIAMOND = config.getItem(ItemStrings.HAMMER_DIAMOND_TRANSNAME, ItemIDs.HAMMER_DIAMOND_DEFAULT).getInt();
			ItemIDs.HAMMER_MAGIC = config.getItem(ItemStrings.HAMMER_MAGIC_TRANSNAME, ItemIDs.HAMMER_MAGIC_DEFAULT).getInt();

			//Blocks
			BlockIDs.ORE_ADAMANT = config.getBlock(BlockStrings.ORE_ADAMANT_TRANSNAME, BlockIDs.ORE_ADAMANT_DEFAULT).getInt();
			BlockIDs.ORE_COPPER = config.getBlock(BlockStrings.ORE_COPPER_TRANSNAME, BlockIDs.ORE_COPPER_DEFAULT).getInt();
			BlockIDs.ORE_TIN = config.getBlock(BlockStrings.ORE_TIN_TRANSNAME, BlockIDs.ORE_TIN_DEFAULT).getInt();
			
			BlockIDs.DOUBLE_FURNACE_IDLE = config.get("Machines", BlockStrings.DOUBLE_FURNACE_IDLE_NAME, BlockIDs.DOUBLE_FURNACE_IDLE_DEFAULT).getInt();
			BlockIDs.DOUBLE_FURNACE_ACTIVE = config.get("Machines", BlockStrings.DOUBLE_FURNACE_ACTIVE_NAME, BlockIDs.DOUBLE_FURNACE_ACTIVE_DEFAULT).getInt();

		} catch(Exception e) {
			LoggerHandler.log(Level.CONFIG, Reference.MOD_NAME + " has encountered a problem loading it's config!");
		} finally {
			config.save();
		}
	}
	
}
