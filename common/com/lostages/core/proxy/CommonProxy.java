package com.lostages.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.lostages.client.gui.inventory.GuiDoubleFurnace;
import com.lostages.inventory.ContainerDoubleFurnace;
import com.lostages.lib.BlockStrings;
import com.lostages.lib.GuiIDs;
import com.lostages.tile.TileDoubleFurnace;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler
{
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileDoubleFurnace.class, "furnaceDoubleGui");
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GuiIDs.DOUBLE_FURNACE_GUI_ID) {
			TileDoubleFurnace tileFurnace = (TileDoubleFurnace) world.getBlockTileEntity(x, y, z);
			return new ContainerDoubleFurnace(player.inventory, tileFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GuiIDs.DOUBLE_FURNACE_GUI_ID) {
			TileDoubleFurnace tileFurnace = (TileDoubleFurnace) world.getBlockTileEntity(x, y, z);
			return new GuiDoubleFurnace(player.inventory, tileFurnace);
		}
		return null;
	}
	
	
}
