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
			ItemIDs.SMELTEDBONE = config.getItem(ItemStrings.SMELTEDBONE_NAME, ItemIDs.SMELTEDBONE_DEFAULT).getInt();
			ItemIDs.ADAMANT_INGOT = config.getItem(ItemStrings.ADAMANT_INGOT_NAME, ItemIDs.ADAMANT_INGOT_DEFAULT).getInt();
			ItemIDs.BRONZE_INGOT = config.getItem(ItemStrings.BRONZE_INGOT_NAME, ItemIDs.BRONZE_INGOT_DEFAULT).getInt();
			ItemIDs.STEEL_INGOT = config.getItem(ItemStrings.STEEL_INGOT_NAME, ItemIDs.STEEL_INGOT_DEFAULT).getInt();
			
			ItemIDs.SWORD_BONE = config.getItem(ItemStrings.SWORD_BONE_NAME, ItemIDs.SWORD_BONE_DEFAULT).getInt();
			ItemIDs.PICKAXE_BONE = config.getItem(ItemStrings.PICKAXE_BONE_NAME, ItemIDs.PICKAXE_BONE_DEFAULT).getInt();
			ItemIDs.SHOVEL_BONE = config.getItem(ItemStrings.SHOVEL_BONE_NAME, ItemIDs.SHOVEL_BONE_DEFAULT).getInt();
			ItemIDs.AXE_BONE = config.getItem(ItemStrings.AXE_BONE_NAME, ItemIDs.AXE_BONE_DEFAULT).getInt();
			ItemIDs.HAMMER_BONE = config.getItem(ItemStrings.HAMMER_BONE_NAME, ItemIDs.HAMMER_BONE_DEFAULT).getInt();
			
			ItemIDs.SWORD_ADAMANT = config.getItem(ItemStrings.SWORD_ADAMANT_NAME, ItemIDs.SWORD_ADAMANT_DEFAULT).getInt();
			ItemIDs.PICKAXE_ADAMANT = config.getItem(ItemStrings.PICKAXE_ADAMANT_NAME, ItemIDs.PICKAXE_ADAMANT_DEFAULT).getInt();
			ItemIDs.SHOVEL_ADAMANT = config.getItem(ItemStrings.SHOVEL_ADAMANT_NAME, ItemIDs.SHOVEL_ADAMANT_DEFAULT).getInt();
			ItemIDs.AXE_ADAMANT = config.getItem(ItemStrings.AXE_ADAMANT_NAME, ItemIDs.AXE_ADAMANT_DEFAULT).getInt();
			ItemIDs.HAMMER_ADAMANT = config.getItem(ItemStrings.HAMMER_ADAMANT_NAME, ItemIDs.HAMMER_ADAMANT_DEFAULT).getInt();
			
			ItemIDs.HAMMER_WOOD = config.getItem(ItemStrings.HAMMER_WOOD_NAME, ItemIDs.HAMMER_WOOD_DEFAULT).getInt();
			ItemIDs.HAMMER_STONE = config.getItem(ItemStrings.HAMMER_STONE_NAME, ItemIDs.HAMMER_STONE_DEFAULT).getInt();
			ItemIDs.HAMMER_IRON = config.getItem(ItemStrings.HAMMER_IRON_NAME, ItemIDs.HAMMER_IRON_DEFAULT).getInt();
			ItemIDs.HAMMER_GOLD = config.getItem(ItemStrings.HAMMER_GOLD_NAME, ItemIDs.HAMMER_GOLD_DEFAULT).getInt();
			ItemIDs.HAMMER_DIAMOND = config.getItem(ItemStrings.HAMMER_DIAMOND_NAME, ItemIDs.HAMMER_DIAMOND_DEFAULT).getInt();
			
			BlockIDs.ORE_ADAMANT = config.getBlock(BlockStrings.ORE_ADAMANT_NAME, BlockIDs.ORE_ADAMANT_DEFAULT).getInt();
			BlockIDs.ORE_COPPER = config.getBlock(BlockStrings.ORE_COPPER_NAME, BlockIDs.ORE_COPPER_DEFAULT).getInt();
			BlockIDs.ORE_TIN = config.getBlock(BlockStrings.ORE_TIN_NAME, BlockIDs.ORE_TIN_DEFAULT).getInt();
			
			BlockIDs.DOUBLE_FURNACE = config.get("Machines", BlockStrings.DOUBLE_FURNACE_NAME, BlockIDs.DOUBLE_FURNACE_DEFAULT).getInt();

		} catch(Exception e) {
			LoggerHandler.log(Level.CONFIG, Reference.MOD_NAME + " has encountered a problem loading it's config!");
		} finally {
			config.save();
		}
	}
	
}
