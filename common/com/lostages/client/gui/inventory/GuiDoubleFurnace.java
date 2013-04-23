package com.lostages.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.lostages.inventory.ContainerDoubleFurnace;
import com.lostages.tile.TileDoubleFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDoubleFurnace extends GuiContainer {

	private TileDoubleFurnace tileFurnace;
	
	public GuiDoubleFurnace(InventoryPlayer inventoryPlayer, TileDoubleFurnace tileFurnace) {
		super(new ContainerDoubleFurnace(inventoryPlayer, tileFurnace));
		this.tileFurnace = tileFurnace;
		xSize = 176;
		ySize = 167;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		String containerName = tileFurnace.isInvNameLocalized() ? tileFurnace.getInvName() : StatCollector.translateToLocal(tileFurnace.getInvName());
		fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
		fontRenderer.drawString("container.inventory", 8, ySize - 93, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture("/mods/lostages/textures/guis/DoubleFurnaceGUI.png");
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
	}

}
