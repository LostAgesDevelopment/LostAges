package com.lostages.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.lostages.block.BlockDoubleFurnace;
import com.lostages.recipe.DoubleFurnaceRecipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileDoubleFurnace extends TileEntity implements IInventory {
	
	private ItemStack[] inventory;
	
	private final int INVENTORY_SIZE = 4;

	public static final int INGOT_SLOT_1_INDEX = 0;
	public static final int INGOT_SLOT_2_INDEX = 1;
	public static final int FUEL_INVENTORY_INDEX = 2;
	public static final int OUTPUT_INVENTORY_INDEX = 3;
	
	public int furnaceBurnTime = 0;
	public int currentBurnTime = 0;
	public int currentItemBurnTime = 0;
	public int furnaceCookTime = 0;
	
	public TileDoubleFurnace() {
		inventory = new ItemStack[INVENTORY_SIZE];
	}
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	@SuppressWarnings("null")
	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			setInventorySlotContents(slot, null);
		} else {
			itemStack = itemStack.splitStack(amount);
			if (itemStack.stackSize == 0) {
				setInventorySlotContents(slot, null);
			}
		}
		
		return itemStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			setInventorySlotContents(slot, null);
		}
		
		return itemStack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		inventory[slot] = itemStack;
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
			itemStack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "Double Furnace";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		NBTTagList tagList = nbtTagCompound.getTagList("Items");
		inventory = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tagCompound.getByte("Slot");
			if (slot >= 0 && slot < inventory.length) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}
		
		furnaceBurnTime = nbtTagCompound.getShort("BurnTime");
		furnaceCookTime = nbtTagCompound.getShort("CookTime");
		currentItemBurnTime = getItemBurnTime(inventory[1]);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setShort("BurnTime", (short) furnaceBurnTime);
		nbtTagCompound.setShort("CookTime", (short) furnaceCookTime);
		NBTTagList tagList = new NBTTagList();
		for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
			if (inventory[currentIndex] != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte) currentIndex);
				inventory[currentIndex].writeToNBT(tagCompound);
				tagList.appendTag(tagCompound);
			}
		}
		
		nbtTagCompound.setTag("Items", tagList);
		
		if (isInvNameLocalized()) {
			nbtTagCompound.setString("CustomName", getInvName());
		}
	}
	
	public int getCookProgressScaled(int par1) {
		return furnaceCookTime * par1 / 200;
	}
	
	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1) {
		if (currentItemBurnTime == 0) {
			currentItemBurnTime = 200;
		}
		
		return furnaceBurnTime * par1 / currentItemBurnTime;
	}
	
	public boolean isBurning() {
		return furnaceBurnTime > 0;
	}
	
    private boolean canSmelt()
    {
        if (inventory[0] == null) {
            return false;
        } else if (inventory[1] == null) {
        	return false;
        } else {
            ItemStack itemStack = DoubleFurnaceRecipes.smelting().getSmeltingResult(inventory[0], inventory[1]);
            if (itemStack == null) return false;
            if (inventory[3] == null) return true;
            if (!inventory[3].isItemEqual(itemStack)) return false;
            int result = inventory[3].stackSize + itemStack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemStack.getMaxStackSize());
        }
    }
	
	public void smeltItem() {
		if (canSmelt()) {
			ItemStack itemStack = DoubleFurnaceRecipes.smelting().getSmeltingResult(inventory[0], inventory[1]);
			if (inventory[3] == null) {
				inventory[3] = itemStack.copy();
			} else if (inventory[3].isItemEqual(itemStack)) {
				inventory[3].stackSize += itemStack.stackSize;
			}
			
			--inventory[0].stackSize;
			--inventory[1].stackSize;
			
			if (inventory[0].stackSize <= 0) {
				inventory[0] = null;
			}
			if (inventory[1].stackSize <= 0) {
				inventory[1] = null;
			}
		}
	}
	
    public void updateEntity()
    {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.inventory[2]);

                if (this.furnaceBurnTime > 0) {
                    flag1 = true;

                    if (this.inventory[2] != null) {
                        --this.inventory[2].stackSize;

                        if (this.inventory[2].stackSize == 0) {
                            this.inventory[2] = this.inventory[2].getItem().getContainerItemStack(inventory[2]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == 10) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
                
            } else {
                this.furnaceCookTime = 0;
            }

            if (flag != this.furnaceBurnTime > 0) {
                flag1 = true;
            }
        }

        if (flag1) {
            this.onInventoryChanged();
        }
    }
	
	public static int getItemBurnTime(ItemStack itemStack) {
		if (itemStack == null) {
			return 0;
		} else {
			int i = itemStack.getItem().itemID;
			Item item = itemStack.getItem();
			
			if (itemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null) {
				Block block = Block.blocksList[i];
				
				if (block == Block.woodSingleSlab) {
					return 150;
				}
				
				if (block.blockMaterial == Material.wood) {
					return 300;
				}
			}
			
			if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
			if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
			if (i == Item.stick.itemID) return 100;
			if (i == Item.coal.itemID) return 1600;
			if (i == Item.bucketLava.itemID) return 20000;
			if (i == Block.sapling.blockID) return 100;
			if (i == Item.blazeRod.itemID) return 2400;
			return GameRegistry.getFuelValue(itemStack);
		}
	}
	
	public static boolean isItemFuel(ItemStack itemStack) {
		return getItemBurnTime(itemStack) > 0;
	}
	
	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		return true;
	}
	
}
