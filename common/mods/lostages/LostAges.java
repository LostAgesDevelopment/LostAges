package mods.lostages;

import java.util.logging.Level;

import mods.lostages.configuration.LABlocks;
import mods.lostages.configuration.LAConfiguration;
import mods.lostages.configuration.LAItems;
import mods.lostages.configuration.LALogger;
import mods.lostages.helper.OreDictionaryHelper;
import mods.lostages.helper.RecipeHelper;
import mods.lostages.helper.TabLA;
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

@Mod(modid = "LostAges", name = "Lost Ages", version = "@VERSION@", certificateFingerprint="@FINGERPRINT@")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LostAges {
	
	public static CreativeTabs tabLABlocks = new TabLA(CreativeTabs.getNextID(), "LABlockTab");
	public static CreativeTabs tabLATools = new TabLA(CreativeTabs.getNextID(), "LAToolTab");
	public static CreativeTabs tabLAMisc = new TabLA(CreativeTabs.getNextID(), "LAItemTab");
	
	@SidedProxy(clientSide = "mods.lostages.ClientProxy", serverSide = "mods.lostages.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance("LostAges")
	public static LostAges instance;
	
	@EventHandler
	public void invalidFingerprint(FMLFingerprintViolationEvent event) {
		LALogger.log(Level.SEVERE, "Warning: This jar has been modified. I will not take any responsibility for anything that happens with this jar. Don't ask me if this warning appears.");
	}
	
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
		ChestGenLA.init();
		
		proxy.registerTileEntities();
		
		GameRegistry.registerWorldGenerator(new WorldGenLA());
		
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
	}
	 
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LALogger.log(Level.INFO, "Lost Ages has loaded!");
	}
	
}
