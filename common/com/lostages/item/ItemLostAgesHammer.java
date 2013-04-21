package com.lostages.item;

import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.lostages.LostAges;
import com.lostages.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLostAgesHammer extends ItemSword {
	
	private int weaponDamage;

	public ItemLostAgesHammer(int par1, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(par1, par2EnumToolMaterial);
		setCreativeTab(LostAges.tabLostAgesTools);
        this.weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer enitityplayer, World world, int X, int Y, int Z, int par7, float par8, float par9, float par10)
    {
            int i1 = world.getBlockId(X, Y, Z);

            if (i1 == 1)
            {
                world.playSoundEffect((double)X + 0.5D, (double)Y + 0.5D, (double)Z + 0.5D, "dig.stone", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                world.setBlock(X, Y, Z, Block.cobblestone.blockID);
            }

            par1ItemStack.damageItem(1, enitityplayer);
            return true;
    }

		
    public int getDamageVsEntity(Entity par1Entity)
    {
    	String name = par1Entity.getEntityName();    	
    	if (name.equals("Skeleton")){
    		return (int) (weaponDamage * (double)1.5);
    		}
        else{         
        	return (int) (weaponDamage * (double)0.75);    
        }
    }
}
