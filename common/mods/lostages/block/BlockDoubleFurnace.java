package mods.lostages.block;

import java.util.Random;

import mods.lostages.LostAges;
import mods.lostages.tile.TileDoubleFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoubleFurnace extends BlockContainer {
	public static final int META_ISACTIVE = 0x00000008;
	public static final int MASK_DIR = 0x00000007;
	public static final int META_DIR_NORTH = 0x00000001;
	public static final int META_DIR_SOUTH = 0x00000002;
	public static final int META_DIR_EAST = 0x00000003;
	public static final int META_DIR_WEST = 0x00000000;
	
	private Icon iconFrontUnlit;
	private Icon iconFrontLit;
	private Icon iconTop;
	
	public BlockDoubleFurnace(int id, Material material) {
		super(id, material);
		this.setUnlocalizedName("furnaceDouble");
		this.setHardness(3.5F);
		this.setCreativeTab(mods.lostages.LostAges.tabLABlocks);
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		return ((world.getBlockMetadata(x, y, z) >> 3) == 0 ? 0 : 15);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		iconFrontUnlit = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(5) + "_Front");
		iconFrontLit = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(5) + "_FrontLit");
		iconTop = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(5) + "_Top");
		blockIcon = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(5) + "_Side");
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		if (!world.isRemote) {
			int l = world.getBlockId(x, y, z - 1);
			int i1 = world.getBlockId(x, y, z + 1);
			int j1 = world.getBlockId(x - 1, y, z);
			int k1 = world.getBlockId(x + 1, y, z);
			byte b0 = 3;
			
			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
				b0 = 3;
			
			if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
				b0 = 2;
			
			if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
				b0 = 5;
			
			if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
				b0 = 4;
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
	@Override
	public Icon getIcon(int side, int metadata) {
		boolean isActive = ((metadata >> 3) == 1);
		int facing = (metadata + MASK_DIR);
		
		return (side == getSideFromFacing(facing) ? (isActive ? iconFrontLit : iconFrontUnlit) : (side == 0 || side == 1 ? iconTop : blockIcon));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (player.isSneaking())
			return false;
		
		TileDoubleFurnace tile = (TileDoubleFurnace)world.getBlockTileEntity(x, y, z);
		if (tile != null) {
			player.openGui(LostAges.instance, 1, world, x, y, z);
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
