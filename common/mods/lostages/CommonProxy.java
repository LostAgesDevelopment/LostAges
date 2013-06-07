package mods.lostages;

import mods.lostages.gui.ContainerDoubleFurnace;
import mods.lostages.gui.GuiDoubleFurnace;
import mods.lostages.tile.TileDoubleFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileDoubleFurnace.class, "furnaceDouble");
	}
	
	public void registerRenderer() {
		
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 1) {
			TileDoubleFurnace tileFurnace = (TileDoubleFurnace)world.getBlockTileEntity(x, y, z);
			return new ContainerDoubleFurnace(player.inventory, tileFurnace);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 1) {
			TileDoubleFurnace tileFurnace = (TileDoubleFurnace)world.getBlockTileEntity(x, y, z);
			return new GuiDoubleFurnace(player.inventory, tileFurnace);
		}
		
		return null;
	}
}
