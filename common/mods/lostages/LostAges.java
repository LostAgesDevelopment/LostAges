package mods.lostages;

import mods.lostages.configuration.LABlocks;
import mods.lostages.configuration.LAConfiguration;
import mods.lostages.configuration.LAItems;
import mods.lostages.helper.OreDictionaryHelper;
import mods.lostages.helper.TabLA;
import net.minecraft.creativetab.CreativeTabs;
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

@Mod(modid = "lostages", name = "Lost Ages", version = "@VERSION@")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LostAges {
	public static CreativeTabs tabLABlocks = new TabLA(CreativeTabs.getNextID(), "LABlockTab");
	public static CreativeTabs tabLATools = new TabLA(CreativeTabs.getNextID(), "LAToolTab");
	public static CreativeTabs tabLAMisc = new TabLA(CreativeTabs.getNextID(), "LAItemTab");
	
	@Instance("lostages")
	public static LostAges instance;
	
	@SidedProxy(clientSide = "mods.lostages.ClientProxy", serverSide = "mods.lostages.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preLoad(FMLPreInitializationEvent event) {
		LAConfiguration.initConfigFile(event.getSuggestedConfigurationFile());
		LABlocks.init();
		LAItems.init();
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		OreDictionaryHelper.init();
		LABlocks.initMiningLevel();
		
		proxy.registerTileEntities();
		proxy.registerRenderer();
		
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event) {
		
	}
}
