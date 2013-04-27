package com.lostages.item;

import com.lostages.LostAges;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLostAgesMagicHammer extends ItemLostAgesHammer {
	
	public ItemLostAgesMagicHammer(int par1, EnumToolMaterial enumToolMaterial) 
	{
		super(par1, enumToolMaterial);
		setCreativeTab(LostAges.tabLostAgesTools);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer enitityplayer, World world, int X, int Y, int Z, int par7, float par8, float par9, float par10)
    {
            int i1 = world.getBlockId(X, Y, Z);

            if (i1 == Block.stone.blockID)
            {
                world.playSoundEffect((double)X + 0.5D, (double)Y + 0.5D, (double)Z + 0.5D, "dig.stone", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                world.setBlock(X, Y, Z, Block.stoneBrick.blockID);
            } 
            else 
            {
            	return false;
            }

            par1ItemStack.damageItem(1, enitityplayer);
            return true;
    }
}
