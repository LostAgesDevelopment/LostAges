package com.lostages.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockLostAgesOre extends Block 
{

	public BlockLostAgesOre(int par1, Material par2Material) 
	{
		super(par1, par2Material);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) 
	{
		blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}
