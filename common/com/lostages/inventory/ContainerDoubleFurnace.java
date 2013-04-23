package com.lostages.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.lostages.tile.TileDoubleFurnace;

public class ContainerDoubleFurnace extends Container {

	public ContainerDoubleFurnace(InventoryPlayer inventoryPlayer, TileDoubleFurnace furnace) {
		this.addSlotToContainer(new Slot(furnace, TileDoubleFurnace.INGOT_SLOT_1_INDEX, 26, 17));
		this.addSlotToContainer(new Slot(furnace, TileDoubleFurnace.INGOT_SLOT_2_INDEX, 64, 17));
		this.addSlotToContainer(new Slot(furnace, TileDoubleFurnace.FUEL_INVENTORY_INDEX, 45, 53));
		this.addSlotToContainer(new Slot(furnace, TileDoubleFurnace.OUTPUT_INVENTORY_INDEX, 126, 35));
		
		for (int invRow = 0; invRow < 3; ++invRow) {
			for (int invCol = 0; invCol < 9; ++invCol) {
				this.addSlotToContainer(new Slot(inventoryPlayer, invCol + invRow * 9 + 9, 8 + invCol * 18, 84 + invRow * 18));
			}
		}
		
		for (int actionBar = 0; actionBar < 9; ++actionBar) {
			this.addSlotToContainer(new Slot(inventoryPlayer, actionBar, 8 + actionBar * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
		return null;
	}
	
	

}
