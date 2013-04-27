package com.lostages.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.lostages.LostAges;
import com.lostages.lib.ItemIDs;
import com.lostages.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLostAgesMagicHammer extends ItemLostAgesHammer {

	
	public ItemLostAgesMagicHammer(int par1, EnumToolMaterial enumtoolmaterial) 
	{
		super(par1, toolMaterial);
		this.toolMaterial = toolMaterial.EMERALD;
        weaponDamage = 4 + toolMaterial.getDamageVsEntity();
	}

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
