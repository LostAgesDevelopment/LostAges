package mods.lostages;

import mods.lostages.render.RenderCustomBow;
import mods.lostages.util.LAItems;
import net.minecraftforge.client.MinecraftForgeClient;


public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		MinecraftForgeClient.registerItemRenderer(LAItems.bowJungle.itemID, new RenderCustomBow());
	}
	
}
