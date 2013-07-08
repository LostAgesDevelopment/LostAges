package mods.lostages.tile;

import mods.lostages.block.BlockDoubleFurnace;
import mods.lostages.recipe.DoubleFurnaceRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileDoubleFurnace extends TileEntity implements ISidedInventory {
	private static final int[] sidedSlotSides = new int[] { 2 };
	private static final int[] sidedSlotBottom = new int[] { 3 };
	private static final int[] sidedSlotTop = new int[] { 0, 1 };
	
	private ItemStack[] furnaceItems = new ItemStack[4];
	public int furnaceBurnTime = 0;
	public int currentItemBurnTime = 0;
	public int furnaceCookTime = 0;
	
	@Override
	public void updateEntity() {
		boolean flag = furnaceBurnTime > 0;
		boolean flag1 = false;
		int metadata = getBlockMetadata();
		int isActive = (metadata >> 3);
		
		if (furnaceBurnTime > 0)
			furnaceBurnTime--;
		
		if (!worldObj.isRemote) {
			if (furnaceBurnTime == 0 && canSmelt()) {
				currentItemBurnTime = furnaceBurnTime = TileEntityFurnace.getItemBurnTime(furnaceItems[2]);
				
				if (furnaceBurnTime > 0) {
					flag1 = true;
					
					if (furnaceItems[2] != null) {
						furnaceItems[2].stackSize--;
						
						if (furnaceItems[2].stackSize == 0)
							furnaceItems[2] = furnaceItems[2].getItem().getContainerItemStack(furnaceItems[2]);
					}
				}
			}
			
			if (isBurning() && canSmelt()) {
				furnaceCookTime++;
				
				if (furnaceCookTime == 200) {
					furnaceCookTime = 0;
					smeltItem();
					flag1 = true;
				}
			} else {
				furnaceCookTime = 0;
			}
			
			if (isActive == 0 && furnaceBurnTime > 0) {
				flag1 = true;
				metadata = getBlockMetadata();
				isActive = 1;
				
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata, 2);
			}
		}
		
		if (flag != furnaceBurnTime > 0) {
			flag1 = true;
			BlockDoubleFurnace.updateBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
		
		if (flag1)
			onInventoryChanged();
	}
	
	@Override
	public int getSizeInventory() {
		return furnaceItems.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) {
		return furnaceItems[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int count) {
		if (furnaceItems[slot] != null) {
			ItemStack itemStack;
			
			itemStack = furnaceItems[slot].splitStack(count);
			
			return itemStack;
		}
		
		return null;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (furnaceItems[slot] != null) {
			ItemStack stack = furnaceItems[slot];
			furnaceItems[slot] = null;
			return stack;
		}
		
		return null;
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		furnaceItems[slot] = itemStack;
		
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
			itemStack.stackSize = getInventoryStackLimit();
	}
	
	@Override
	public String getInvName() {
		return "Double Furnace";
	}
	
	@Override
	public boolean isInvNameLocalized() {
		return true;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5, (double)yCoord + 0.5, (double)zCoord + 0.5) <= 64.0;
	}
	
	@Override
	public void openChest() {}
	
	@Override
	public void closeChest() {}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		return slot == 3 ? false : (slot == 2 ? TileEntityFurnace.isItemFuel(itemStack) : true); 
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? sidedSlotBottom : (par1 == 1 ? sidedSlotTop : sidedSlotSides);
	}
	
	@Override
	public boolean canInsertItem(int par1, ItemStack itemStack, int j) {
		return isItemValidForSlot(par1, itemStack);
	}
	
	@Override
	public boolean canExtractItem(int par1, ItemStack itemStack, int par3) {
		return par3 != 0 || par1 != 1 || itemStack.itemID == Item.bucketEmpty.itemID;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		
		NBTTagList itemsTag = tagCompound.getTagList("Items");
		furnaceItems = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i < itemsTag.tagCount(); i++) {
			NBTTagCompound slotTag = (NBTTagCompound)itemsTag.tagAt(i);
			byte slot = slotTag.getByte("Slot");
			
			if (slot >= 0 && slot < furnaceItems.length)
				furnaceItems[slot] = ItemStack.loadItemStackFromNBT(slotTag);
		}
		
		furnaceBurnTime = tagCompound.getShort("BurnTime");
		furnaceCookTime = tagCompound.getShort("CookTime");
		currentItemBurnTime = TileEntityFurnace.getItemBurnTime(furnaceItems[2]);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		
		tagCompound.setShort("BurnTime", (short)furnaceBurnTime);
		tagCompound.setShort("CookTime", (short)furnaceCookTime);
		NBTTagList itemsList = new NBTTagList();
		
		for (int i = 0; i < furnaceItems.length; i++) {
			if (furnaceItems[i] != null) {
				NBTTagCompound slotTag = new NBTTagCompound();
				slotTag.setByte("Slot", (byte)i);
				furnaceItems[i].writeToNBT(slotTag);
				itemsList.appendTag(slotTag);
			}
		}
		
		tagCompound.setTag("Items", itemsList);
	}
	
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int val) {
		return furnaceCookTime * val / 200;
	}
	
	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int val) {
		if (currentItemBurnTime == 0)
			currentItemBurnTime = 200;
		
		return furnaceBurnTime * val / currentItemBurnTime;
	}
	
	public boolean isBurning() {
		return furnaceBurnTime > 0;
	}
	
	private boolean canSmelt() {
		if (furnaceItems[0] == null)
			return false;
		else {
			ItemStack itemStack = DoubleFurnaceRecipes.smelting().getDoubleSmeltingResult(furnaceItems[0], furnaceItems[1]);
			if (itemStack == null) return false;
			if (furnaceItems[0].stackSize < DoubleFurnaceRecipes.smelting().getSlot1ReduceAmount(furnaceItems[0]).stackSize) return false;
			if (furnaceItems[1].stackSize < DoubleFurnaceRecipes.smelting().getSlot2ReduceAmount(furnaceItems[1]).stackSize) return false;
			if (furnaceItems[3] == null) return true;
			if (!furnaceItems[3].isItemEqual(itemStack)) return false;
			
			int resultingStackSize = furnaceItems[3].stackSize + itemStack.stackSize;
			return (resultingStackSize <= getInventoryStackLimit() && resultingStackSize <= itemStack.getMaxStackSize());
		}
	}
	
	public void smeltItem() {
		ItemStack itemStack = DoubleFurnaceRecipes.smelting().getDoubleSmeltingResult(furnaceItems[0], furnaceItems[1]);
		
		if (furnaceItems[3] == null)
			furnaceItems[3] = itemStack.copy();
		else if (furnaceItems[3].isItemEqual(itemStack))
			furnaceItems[3].stackSize += itemStack.stackSize;
		
		furnaceItems[0].stackSize -= DoubleFurnaceRecipes.smelting().getSlot1ReduceAmount(furnaceItems[0]).stackSize;
		furnaceItems[1].stackSize -= DoubleFurnaceRecipes.smelting().getSlot2ReduceAmount(furnaceItems[1]).stackSize;
		
		if (furnaceItems[0].stackSize <= 0)
			furnaceItems[0] = null;
		if (furnaceItems[1].stackSize <= 0)
			furnaceItems[1] = null;
	}
}
