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

public class BlockCustomOre extends Block {
	
	public BlockCustomOre(int id, Material material) {
		super(id, material);
		this.setUnlocalizedName("oreBase");
		this.setCreativeTab(LostAges.tabLABlocks);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		for (EnumCustomOre ore : EnumCustomOre.VALID_ORES) {
			ore.loadTextues(iconRegister);
		}
	}

	@Override
	public Icon getIcon(int side, int meta) {
		return EnumCustomOre.VALID_ORES[meta].texture;
	}
	
	@Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		return EnumCustomOre.VALID_ORES[meta].getItemStack();
    }
	
	@Override
    public int damageDropped(int meta) {
        return meta;
    }
	
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (EnumCustomOre ore : EnumCustomOre.VALID_ORES)
			list.add(ore.getItemStack());
	}
	
	public enum EnumCustomOre {
		ORECOPPER("oreCopper", 1),
		ORETIN("oreTin", 1),
		OREADAMANT("oreAdamant", 2);
		
		public final String unlocalName;
		public final int harvestLevel;
		public final int meta = ordinal();
		public Icon texture;
		
		public static final EnumCustomOre[] VALID_ORES = values();
		
		private EnumCustomOre(String unlocalName, int harvestLevel) {
			this.unlocalName = unlocalName;
			this.harvestLevel = harvestLevel;
		}
		
		public void loadTextues(IconRegister iconRegister) {
			texture = iconRegister.registerIcon("LostAges:" + unlocalName);
		}
		
		public ItemStack getItemStack() {
			return new ItemStack(LABlocks.oreBase.blockID, 1, meta);
		}
		
	}
	
}
