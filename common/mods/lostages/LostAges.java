package mods.lostages;

import java.util.logging.Level;

import mods.lostages.config.LABlocks;
import mods.lostages.config.LAConfig;
import mods.lostages.config.LADimensions;
import mods.lostages.config.LAItems;
import mods.lostages.config.LALogger;
import mods.lostages.config.LAOreDictionary;
import mods.lostages.config.LARecipes;
import mods.lostages.config.LATab;
import mods.lostages.worldgen.ChestGenLA;
import mods.lostages.worldgen.WorldGenLA;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "LostAges", name = "Lost Ages", version = "@VERSION@", certificateFingerprint = "@FINGERPRINT@")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LostAges {
	
	public static CreativeTabs tabLABlocks = new LATab(CreativeTabs.getNextID(), "LABlockTab");
	public static CreativeTabs tabLAItems = new LATab(CreativeTabs.getNextID(), "LAItemTab");
	
	@SidedProxy(clientSide = "mods.lostages.ClientProxy", serverSide = "mods.lostages.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance("LostAges")
	public static LostAges instance;
	
	@EventHandler
	public void invalidFingerprint(FMLFingerprintViolationEvent event) {
		LALogger.log(Level.SEVERE, "Warning: This jar has been modified!");
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LALogger.init();
		LAConfig.initConfigFile(event.getSuggestedConfigurationFile());
		LABlocks.init();
		LAItems.init();
		LADimensions.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		LARecipes.init();
		LAOreDictionary.init();
		ChestGenLA.init();
		
		proxy.registerRenderers();
		proxy.registerTileEntities();
		
		GameRegistry.registerWorldGenerator(new WorldGenLA());
		
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
	}
	 
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LALogger.log(Level.INFO, "Lost Ages has loaded!");
	}
	
}
