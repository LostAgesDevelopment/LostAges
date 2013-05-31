package com.lostages.core.handler;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.lostages.lib.BlockReference;
import com.lostages.lib.ItemReference;
import com.lostages.lib.Reference;

public class ConfigurationHandler {
	
	public static void loadConfig(File file) {
		Configuration config = new Configuration(file);
		try {
			config.load();
			ItemReference.INGOT_BASE_ID = config.getItem(ItemReference.INGOT_BASE_NAME, ItemReference.INGOT_BASE_DEFAULT_ID).getInt();

			//Adamant Armor
			ItemReference.HELM_ADAMANT_ID = config.getItem(ItemReference.HELMET_ADAMANT_NAME, ItemReference.HELMET_ADAMANT_DEFAULT_ID).getInt();
			ItemReference.CHEST_ADAMANT_ID = config.getItem(ItemReference.CHESTPLATE_ADAMANT_NAME, ItemReference.CHESTPLATE_ADAMANT_DEFAULT_ID).getInt();
			ItemReference.LEGS_ADAMANT_ID = config.getItem(ItemReference.LEGGINGS_ADAMANT_NAME, ItemReference.LEGGINGS_ADAMANT_DEFAULT_ID).getInt();
			ItemReference.BOOTS_ADAMANT_ID = config.getItem(ItemReference.BOOTS_ADAMANT_NAME, ItemReference.BOOTS_ADAMANT_DEFAULT_ID).getInt();
			
			//Bows
			ItemReference.BOW_JUNGLE_ID = config.getItem(ItemReference.BOW_JUNGLE_NAME, ItemReference.BOW_JUNGLE_DEFAULT_ID).getInt();
			
			//Bone tools
			ItemReference.SWORD_BONE_ID = config.getItem(ItemReference.SWORD_BONE_TRANSNAME, ItemReference.SWORD_BONE_DEFAULT_ID).getInt();
			ItemReference.PICKAXE_BONE_ID = config.getItem(ItemReference.PICKAXE_BONE_TRANSNAME, ItemReference.PICKAXE_BONE_DEFAULT_ID).getInt();
			ItemReference.SHOVEL_BONE_ID = config.getItem(ItemReference.SHOVEL_BONE_TRANSNAME, ItemReference.SHOVEL_BONE_DEFAULT_ID).getInt();
			ItemReference.AXE_BONE_ID = config.getItem(ItemReference.AXE_BONE_TRANSNAME, ItemReference.AXE_BONE_DEFAULT_ID).getInt();
			ItemReference.HAMMER_BONE_ID = config.getItem(ItemReference.HAMMER_BONE_TRANSNAME, ItemReference.HAMMER_BONE_DEFAULT_ID).getInt();
			
			//Strong Gold tools
			ItemReference.SWORD_STRONGGOLD_ID = config.getItem(ItemReference.SWORD_STRONGGOLD_TRANSNAME, ItemReference.SWORD_STRONGGOLD_DEFAULT_ID).getInt();
			ItemReference.PICKAXE_STRONGGOLD_ID = config.getItem(ItemReference.PICKAXE_STRONGGOLD_TRANSNAME, ItemReference.PICKAXE_STRONGGOLD_DEFAULT_ID).getInt();
			ItemReference.SHOVEL_STRONGGOLD_ID = config.getItem(ItemReference.SHOVEL_STRONGGOLD_TRANSNAME, ItemReference.SHOVEL_STRONGGOLD_DEFAULT_ID).getInt();
			ItemReference.AXE_STRONGGOLD_ID = config.getItem(ItemReference.AXE_STRONGGOLD_TRANSNAME, ItemReference.AXE_STRONGGOLD_DEFAULT_ID).getInt();
			ItemReference.HAMMER_STRONGGOLD_ID = config.getItem(ItemReference.HAMMER_STRONGGOLD_TRANSNAME, ItemReference.HAMMER_STRONGGOLD_DEFAULT_ID).getInt();
			
			//Bronze tools
			ItemReference.SWORD_BRONZE_ID = config.getItem(ItemReference.SWORD_BRONZE_TRANSNAME, ItemReference.SWORD_BRONZE_DEFAULT_ID).getInt();
			ItemReference.PICKAXE_BRONZE_ID = config.getItem(ItemReference.PICKAXE_BRONZE_TRANSNAME, ItemReference.PICKAXE_BRONZE_DEFAULT_ID).getInt();
			ItemReference.SHOVEL_BRONZE_ID = config.getItem(ItemReference.SHOVEL_BRONZE_TRANSNAME, ItemReference.SHOVEL_BRONZE_DEFAULT_ID).getInt();
			ItemReference.AXE_BRONZE_ID = config.getItem(ItemReference.AXE_BRONZE_TRANSNAME, ItemReference.AXE_BRONZE_DEFAULT_ID).getInt();
			ItemReference.HAMMER_BRONZE_ID = config.getItem(ItemReference.HAMMER_BRONZE_TRANSNAME, ItemReference.HAMMER_BRONZE_DEFAULT_ID).getInt();
			
			//Steel tools
			ItemReference.SWORD_STEEL_ID = config.getItem(ItemReference.SWORD_STEEL_TRANSNAME, ItemReference.SWORD_STEEL_DEFAULT_ID).getInt();
			ItemReference.PICKAXE_STEEL_ID = config.getItem(ItemReference.PICKAXE_STEEL_TRANSNAME, ItemReference.PICKAXE_STEEL_DEFAULT_ID).getInt();
			ItemReference.SHOVEL_STEEL_ID = config.getItem(ItemReference.SHOVEL_STEEL_TRANSNAME, ItemReference.SHOVEL_STEEL_DEFAULT_ID).getInt();
			ItemReference.AXE_STEEL_ID = config.getItem(ItemReference.AXE_STEEL_TRANSNAME, ItemReference.AXE_STEEL_DEFAULT_ID).getInt();
			ItemReference.HAMMER_STEEL_ID = config.getItem(ItemReference.HAMMER_STEEL_TRANSNAME, ItemReference.HAMMER_STEEL_DEFAULT_ID).getInt();
			
			//Adamant tools
			ItemReference.SWORD_ADAMANT_ID = config.getItem(ItemReference.SWORD_ADAMANT_TRANSNAME, ItemReference.SWORD_ADAMANT_DEFAULT_ID).getInt();
			ItemReference.PICKAXE_ADAMANT_ID = config.getItem(ItemReference.PICKAXE_ADAMANT_TRANSNAME, ItemReference.PICKAXE_ADAMANT_DEFAULT_ID).getInt();
			ItemReference.SHOVEL_ADAMANT_ID = config.getItem(ItemReference.SHOVEL_ADAMANT_TRANSNAME, ItemReference.SHOVEL_ADAMANT_DEFAULT_ID).getInt();
			ItemReference.AXE_ADAMANT_ID = config.getItem(ItemReference.AXE_ADAMANT_TRANSNAME, ItemReference.AXE_ADAMANT_DEFAULT_ID).getInt();
			ItemReference.HAMMER_ADAMANT_ID = config.getItem(ItemReference.HAMMER_ADAMANT_TRANSNAME, ItemReference.HAMMER_ADAMANT_DEFAULT_ID).getInt();
			
			//Hammers
			ItemReference.HAMMER_WOOD_ID = config.getItem(ItemReference.HAMMER_WOOD_TRANSNAME, ItemReference.HAMMER_WOOD_DEFAULT_ID).getInt();
			ItemReference.HAMMER_STONE_ID = config.getItem(ItemReference.HAMMER_STONE_TRANSNAME, ItemReference.HAMMER_STONE_DEFAULT_ID).getInt();
			ItemReference.HAMMER_IRON_ID = config.getItem(ItemReference.HAMMER_IRON_TRANSNAME, ItemReference.HAMMER_IRON_DEFAULT_ID).getInt();
			ItemReference.HAMMER_GOLD_ID = config.getItem(ItemReference.HAMMER_GOLD_TRANSNAME, ItemReference.HAMMER_GOLD_DEFAULT_ID).getInt();
			ItemReference.HAMMER_DIAMOND_ID = config.getItem(ItemReference.HAMMER_DIAMOND_TRANSNAME, ItemReference.HAMMER_DIAMOND_DEFAULT_ID).getInt();
			ItemReference.HAMMER_MAGIC_ID = config.getItem(ItemReference.HAMMER_MAGIC_TRANSNAME, ItemReference.HAMMER_MAGIC_DEFAULT_ID).getInt();

			//Blocks
			BlockReference.ORE_BASE = config.getBlock(BlockReference.ORE_BASE_NAME, BlockReference.ORE_BASE_DEFAULT).getInt();
			
			BlockReference.DOUBLE_FURNACE_ID = config.get("Machines",
					BlockReference.DOUBLE_FURNACE_NAME,
					BlockReference.DOUBLE_FURNACE_DEFAULT_ID).getInt();

		} catch(Exception e) {
			LoggerHandler.log(Level.CONFIG, Reference.MOD_NAME + " has encountered a problem loading it's config!");
		} finally {
			config.save();
		}
	}
	
}
