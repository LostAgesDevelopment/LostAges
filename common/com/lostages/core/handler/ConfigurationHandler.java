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
			ItemIDs.BONE_INGOT = config.getItem(ItemStrings.BONE_INGOT_NAME, ItemIDs.BONE_INGOT_DEFAULT).getInt();
			
			ItemIDs.SWORD_BONE = config.getItem(ItemStrings.SWORD_BONE_NAME, ItemIDs.SWORD_BONE_DEFAULT).getInt();
			ItemIDs.PICKAXE_BONE = config.getItem(ItemStrings.PICKAXE_BONE_NAME, ItemIDs.PICKAXE_BONE_DEFAULT).getInt();
			ItemIDs.SHOVEL_BONE = config.getItem(ItemStrings.SHOVEL_BONE_NAME, ItemIDs.SHOVEL_BONE_DEFAULT).getInt();
			ItemIDs.AXE_BONE = config.getItem(ItemStrings.AXE_BONE_NAME, ItemIDs.AXE_BONE_DEFAULT).getInt();
			
			BlockIDs.ORE_ADAMANT = config.getBlock(BlockStrings.ORE_ADAMANT_NAME, BlockIDs.ORE_ADAMANT_DEFAULT).getInt();
		} catch(Exception e) {
			LoggerHandler.log(Level.CONFIG, Reference.MOD_NAME + " has encountered a problem loading it's config!");
		} finally {
			config.save();
		}
	}
	
}
