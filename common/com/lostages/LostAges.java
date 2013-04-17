package com.lostages;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.biome.BiomeGenBase;

import com.lostages.core.creativetab.TabLostAgesBlocks;
import com.lostages.core.creativetab.TabLostAgesMisc;
import com.lostages.core.creativetab.TabLostAgesTools;
import com.lostages.core.handler.ConfigurationHandler;
import com.lostages.core.handler.LoggerHandler;
import com.lostages.core.proxy.CommonProxy;
import com.lostages.item.LostAgesItems;
import com.lostages.lib.Reference;
import com.lostages.world.BiomeWasteland;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "lostages", name = "Lost Ages", version = "MC1.5.1, LA 0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LostAges
{
	
	//we may want to make more than one tab.
	public static CreativeTabs tabLostAgesBlocks = new TabLostAgesBlocks(CreativeTabs.getNextID(), "LostAgesBlocksTab");
	public static CreativeTabs tabLostAgesTools = new TabLostAgesTools(CreativeTabs.getNextID(), "LostAgesToolsTab");
	public static CreativeTabs tabLostAgesMisc = new TabLostAgesMisc(CreativeTabs.getNextID(), "LostAgesMiscTab");

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	
	//Going to name it Wasteland for now
	public static final BiomeGenBase Wasteland = (new BiomeWasteland(100)).setColor(16421912)
							.setBiomeName("Wasteland").setDisableRain()
							.setTemperatureRainfall(2.0F, 0.0F)
							.setMinMaxHeight(0.1F, 0.2F);

	
	@PreInit
	public static void preLoad(FMLPreInitializationEvent event)
	{
		LoggerHandler.initLog();
		ConfigurationHandler.loadConfig(event.getSuggestedConfigurationFile());
	}
	
	@Init
	public static void load(FMLInitializationEvent event)
	{
		LostAgesItems.init();
		
		GameRegistry.addBiome(Wasteland);
	}
	
	@PostInit
	public static void postLoad(FMLPostInitializationEvent event)
	{
		LoggerHandler.log(Level.INFO, "Lost Ages has successfully loaded!");
	}
	
}
