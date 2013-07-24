package mods.lostages.block;

import java.util.List;

import mods.lostages.LostAges;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockCustomOre extends Block {

	private Icon[] icons;
	private String[] names = { "oreCopper", "oreTin", "oreAdamant" };
	
	public BlockCustomOre(int id, Material material) {
		super(id, material);
		this.setUnlocalizedName("oreBase");
		this.setCreativeTab(LostAges.tabLABlocks);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[names.length];
		for (int i = 0; i < icons.length; i++)
			icons[i] = iconRegister.registerIcon("lostages:" + names[i]);
	}

	@Override
	public Icon getIcon(int side, int meta) {
		return icons[meta];
	}
	
	@Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        int id = idPicked(world, x, y, z);

        if (id == 0)
            return null;

        Item item = Item.itemsList[id];
        if (item == null)
            return null;

        return new ItemStack(id, 1, getDamageValue(world, x, y, z));
    }
	
	@Override
    public int damageDropped(int metadata) {
        return metadata;
    }
	
	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < icons.length; i++)
			list.add(new ItemStack(id, 1, i));
	}
	
}
