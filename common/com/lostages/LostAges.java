package com.lostages;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.biome.BiomeGenBase;

import com.lostages.block.LostAgesBlocks;
import com.lostages.core.creativetab.TabLostAges;
import com.lostages.core.handler.ConfigurationHandler;
import com.lostages.core.handler.LoggerHandler;
import com.lostages.core.proxy.CommonProxy;
import com.lostages.item.LostAgesItems;
import com.lostages.lib.Reference;
import com.lostages.world.BiomeWasteland;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LostAges {
	
	@Instance(Reference.MOD_ID)
	public static LostAges instance;
	
	public static CreativeTabs tabLostAgesBlocks = new TabLostAges(CreativeTabs.getNextID(), Reference.TAB_BLOCK);
	public static CreativeTabs tabLostAgesTools = new TabLostAges(CreativeTabs.getNextID(), Reference.TAB_TOOL);
	public static CreativeTabs tabLostAgesMisc = new TabLostAges(CreativeTabs.getNextID(), Reference.TAB_MISC);

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;

	public static final BiomeGenBase Wasteland = (new BiomeWasteland(100));
	
	@PreInit
	public static void preLoad(FMLPreInitializationEvent event) {
		LoggerHandler.initLog();
		ConfigurationHandler.loadConfig(event.getSuggestedConfigurationFile());
		LostAgesBlocks.initBlocks();
		LostAgesItems.initItems();
	}
	
	@Init
	public static void load(FMLInitializationEvent event) {
		LostAgesItems.initItemRecipes();
		LostAgesBlocks.initBlockRecipes();
		GameRegistry.addBiome(Wasteland);
		proxy.registerTileEntities();
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
	}
	
	@PostInit
	public static void postLoad(FMLPostInitializationEvent event) {
		LoggerHandler.log(Level.INFO, "Lost Ages has successfully loaded!");
	}
	
}
