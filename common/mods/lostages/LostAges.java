package mods.lostages;

import java.util.logging.Level;

import mods.lostages.configuration.LABlocks;
import mods.lostages.configuration.LAConfiguration;
import mods.lostages.configuration.LAItems;
import mods.lostages.configuration.LALogger;
import mods.lostages.helper.OreDictionaryHelper;
import mods.lostages.helper.RecipeHelper;
import mods.lostages.helper.TabLA;
import mods.lostages.worldgen.WorldGenLA;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "lostages", name = "Lost Ages", version = "@VERSION@")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LostAges {
	
	public static CreativeTabs tabLABlocks = new TabLA(CreativeTabs.getNextID(), "LABlockTab");
	public static CreativeTabs tabLATools = new TabLA(CreativeTabs.getNextID(), "LAToolTab");
	public static CreativeTabs tabLAMisc = new TabLA(CreativeTabs.getNextID(), "LAItemTab");
	
	@SidedProxy(clientSide = "mods.lostages.ClientProxy", serverSide = "mods.lostages.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance("lostages")
	public static LostAges instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LALogger.init();
		LAConfiguration.initConfigFile(event.getSuggestedConfigurationFile());
		LABlocks.init();
		LAItems.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RecipeHelper.init();
		OreDictionaryHelper.init();
		
		proxy.registerTileEntities();
		
		GameRegistry.registerWorldGenerator(new WorldGenLA());
		
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
	}
	 
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LALogger.log(Level.INFO, "Lost Ages has loaded!");
	}
	
}
