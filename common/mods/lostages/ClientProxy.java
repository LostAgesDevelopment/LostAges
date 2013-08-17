package mods.lostages;

import mods.lostages.render.RenderCustomBow;
import mods.lostages.util.Items;
import net.minecraftforge.client.MinecraftForgeClient;


public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		MinecraftForgeClient.registerItemRenderer(Items.bowJungle.itemID, new RenderCustomBow());
	}
	
}
