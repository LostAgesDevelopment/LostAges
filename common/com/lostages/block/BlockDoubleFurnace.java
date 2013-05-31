package com.lostages.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.lostages.LostAges;
import com.lostages.lib.BlockReference;
import com.lostages.lib.GuiIDs;
import com.lostages.lib.Reference;
import com.lostages.tile.TileDoubleFurnace;

public class BlockDoubleFurnace extends BlockContainer {
	public static final int META_ISACTIVE = 0x00000008;
	public static final int MASK_DIR = 0x00000007;
	public static final int META_DIR_NORTH = 0x00000001;
	public static final int META_DIR_SOUTH = 0x00000002;
	public static final int META_DIR_EAST = 0x00000003;
	public static final int META_DIR_WEST = 0x00000000;
	
	private Icon faceIconUnlit;
	private Icon faceIconLit;
	private Icon topIcon;
	
	public BlockDoubleFurnace() {
		super(BlockReference.DOUBLE_FURNACE_ID, Material.rock);
		this.setUnlocalizedName(BlockReference.DOUBLE_FURNACE_NAME);
		this.setHardness(3.5F);
		this.setCreativeTab(LostAges.tabLostAgesBlocks);
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		return ((world.getBlockMetadata(x, y, z) >> 3) == 0 ? 0 : 13);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":doublefurnace_side");
		faceIconUnlit = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":doublefurnace_front");
		faceIconLit = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":doublefurnace_front_lit");
		topIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":doublefurnace_top");
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity, ItemStack itemStack) {
		int metadata = 0;
		int facing = META_DIR_WEST;
		
		int dir = MathHelper.floor_double((double)(entity.rotationYaw * 4F / 360F) + 0.5) & 3;
		if (dir == 0)
			facing = META_DIR_NORTH;
		if (dir == 1)
			facing = META_DIR_EAST;
		if (dir == 2)
			facing = META_DIR_SOUTH;
		if (dir == 3)
			facing = META_DIR_WEST;
		
		metadata |= facing;
		world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
	}
	
	@Override
	public Icon getIcon(int side, int metadata) {
		boolean isActive = ((metadata >> 3) == 1);
		int facing = (metadata & MASK_DIR);
		
		return (side == getSideFromFacing(facing) ? (isActive ? faceIconLit : faceIconUnlit) : (side == 0 || side == 1 ? topIcon : blockIcon));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (player.isSneaking())
			return false;
		
		TileDoubleFurnace tile = (TileDoubleFurnace)world.getBlockTileEntity(x, y, z);
		if (tile != null) {
			player.openGui(LostAges.instance, GuiIDs.DOUBLE_FURNACE_GUI_ID, world, x, y, z);
		}
		
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileDoubleFurnace();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}
	
	private static int getSideFromFacing(int facing) {
		switch (facing) {
			case META_DIR_WEST: return 4;
			case META_DIR_EAST: return 5;
			case META_DIR_NORTH: return 2;
			case META_DIR_SOUTH: return 3;
			default: return 4;
		}
	}
	
	private void dropItems(World world, int x, int y, int z) {
		Random rng = new Random();
		
		TileDoubleFurnace tile = (TileDoubleFurnace)world.getBlockTileEntity(x, y, z);
		if (tile == null)
			return;
		
		for (int i = 0; i < tile.getSizeInventory(); i++) {
			ItemStack item = tile.getStackInSlot(i);
			
			if (item != null && item.stackSize > 0) {
				float rx = rng.nextFloat() * 0.8F + 0.1F;
				float ry = rng.nextFloat() * 0.8F + 0.1F;
				float rz = rng.nextFloat() * 0.8F + 0.1F;
				
				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, item.copy());
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}
}
