package mods.lostages;

import java.util.logging.Level;

import mods.lostages.config.BlockRegistry;
import mods.lostages.config.ConfigHandler;
import mods.lostages.config.DimensionRegistry;
import mods.lostages.config.ItemRegistry;
import mods.lostages.config.LogHandler;
import mods.lostages.config.OreDictionaryRegistry;
import mods.lostages.config.RecipeRegistry;
import mods.lostages.config.TabLA;
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
	
	public static CreativeTabs tabLABlocks = new TabLA(CreativeTabs.getNextID(), "LABlockTab");
	public static CreativeTabs tabLAItems = new TabLA(CreativeTabs.getNextID(), "LAItemTab");
	
	@SidedProxy(clientSide = "mods.lostages.ClientProxy", serverSide = "mods.lostages.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance("LostAges")
	public static LostAges instance;
	
	@EventHandler
	public void invalidFingerprint(FMLFingerprintViolationEvent event) {
		LogHandler.log(Level.SEVERE, "Warning: This jar has been modified!");
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LogHandler.init();
		ConfigHandler.initConfigFile(event.getSuggestedConfigurationFile());
		BlockRegistry.init();
		ItemRegistry.init();
		DimensionRegistry.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RecipeRegistry.init();
		OreDictionaryRegistry.init();
		ChestGenLA.init();
		
		proxy.registerRenderers();
		proxy.registerTileEntities();
		
		GameRegistry.registerWorldGenerator(new WorldGenLA());
		
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
	}
	 
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LogHandler.log(Level.INFO, "Lost Ages has loaded!");
	}
	
}
