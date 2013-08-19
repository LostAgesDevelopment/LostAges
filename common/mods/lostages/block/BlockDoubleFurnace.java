package mods.lostages.block;

import java.util.Random;

import mods.lostages.LostAges;
import mods.lostages.tile.TileDoubleFurnace;
import mods.lostages.util.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoubleFurnace extends BlockContainer {
	
	private static boolean keepInventory;

	private Icon iconFrontUnlit;
	private Icon iconFrontLit;
	private Icon iconTop;

	public BlockDoubleFurnace(int id) {
		super(id, Material.rock);
		
		setHardness(3.5F);
		setCreativeTab(LostAges.tabLABlocks);
		setUnlocalizedName("furnaceDouble");
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		if (world.getBlockMetadata(x, y, z) >= 6)
			return 15;
		else
			return 0;
	}
	
	@Override
	public int idDropped(int par1, Random random, int par3) {
		return Blocks.furnaceDouble.blockID;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("lostages:furnaceDouble_Side");
		iconFrontUnlit = iconRegister.registerIcon("lostages:furnaceDouble_Front");
		iconFrontLit = iconRegister.registerIcon("lostages:furnaceDouble_FrontLit");
		iconTop = iconRegister.registerIcon("lostages:furnaceDouble_Top");
	}
	
	@Override
	public Icon getIcon(int side, int metadata) {
		if (side == 0 || side == 1)
			return iconTop;
		
		if (metadata <= 5) {
			if (side != metadata)
				return blockIcon;
			else
				return iconFrontUnlit;
		} else if (metadata >= 6) {
			if (side != metadata - 4)
				return blockIcon;
			else
				return iconFrontLit;
		}
		
		return blockIcon;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			int l = world.getBlockId(x, y, z - 1);
			int i1 = world.getBlockId(x, y, z + 1);
			int j1 = world.getBlockId(x - 1, y, z);
			int k1 = world.getBlockId(x + 1, y, z);
			byte b0 = 4;
			
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (player.isSneaking())
			return false;
		
		TileDoubleFurnace tile = (TileDoubleFurnace)world.getBlockTileEntity(x, y, z);
		if (tile != null)
			player.openGui(LostAges.instance, 1, world, x, y, z);
		
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if (l == 0)
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		
		if (l == 1)
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		
		if (l == 2)
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		
		if (l == 3)
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		
		if (itemStack.hasDisplayName())
			((TileDoubleFurnace)world.getBlockTileEntity(x, y, z)).setGuiDisplayName(itemStack.getDisplayName());
	}
	
	public static void updateBlockState(boolean par0, World world, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z);
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		keepInventory = true;
		
		if (par0) {
			world.setBlock(x, y, z, Blocks.furnaceDouble.blockID);
			world.setBlockMetadataWithNotify(x, y, z, l + 4, 2);
		} else {
			world.setBlock(x, y, z, Blocks.furnaceDouble.blockID);
			world.setBlockMetadataWithNotify(x, y, z, l - 4, 2);
		}
		
		keepInventory = false;
		
		if (tileEntity != null) {
			tileEntity.validate();
			world.setBlockTileEntity(x, y, z, tileEntity);
		}
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
	
	private void dropItems(World world, int x, int y, int z) {
		Random rng = new Random();
		
		if (!keepInventory) {
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
	
	@Override
	public int idPicked(World world, int x, int y, int z) {
		return Blocks.furnaceDouble.blockID;
	}
	
}
