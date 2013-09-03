package mods.lostages.block;

import java.util.List;

import mods.lostages.LostAges;
import mods.lostages.util.LABlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockCustomStorage extends Block {
	
	public BlockCustomStorage(int id, Material material) {
		super(id, material);
		this.setUnlocalizedName("blockStorage");
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setCreativeTab(LostAges.tabLABlocks);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		for (EnumCustomStorage storage : EnumCustomStorage.VALID_BLOCKS)
			storage.loadTextures(iconRegister);
	}
	
	@Override
	public Icon getIcon(int side, int meta) {
		return EnumCustomStorage.VALID_BLOCKS[meta].texture;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		return EnumCustomStorage.VALID_BLOCKS[meta].getItemStack();
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (EnumCustomStorage storage : EnumCustomStorage.VALID_BLOCKS)
			list.add(storage.getItemStack());
	}
	
	public enum EnumCustomStorage {
		
		BLOCKCOPPER("blockCopper"),
		BLOCKTIN("blockTin"),
		BLOCKBRONZE("blockBronze"),
		BLOCKSTEEL("blockSteel"),
		BLOCKSTRONGGOLD("blockStrongGold"),
		BLOCKADAMANT("blockAdamant");
		
		public final String unlocalName;
		public final int meta = ordinal();
		
		public Icon texture;
		
		public static final EnumCustomStorage[] VALID_BLOCKS = values();
		
		private EnumCustomStorage(String unlocalName) {
			this.unlocalName = unlocalName;
		}
		
		public void loadTextures(IconRegister iconRegister) {
			texture = iconRegister.registerIcon("LostAges:" + unlocalName);
		}
		
		public ItemStack getItemStack() {
			return new ItemStack(LABlocks.blockStorage, 1, meta);
		}
		
	}
	
}
