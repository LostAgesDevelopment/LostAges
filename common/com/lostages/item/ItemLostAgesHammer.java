package com.lostages.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.lostages.LostAges;
import com.lostages.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLostAgesHammer extends Item {
	
	private int weaponDamage;
	private EnumToolMaterial toolMaterial;
	
	public ItemLostAgesHammer(int par1, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(par1);
		setCreativeTab(LostAges.tabLostAgesTools);
		toolMaterial = par2EnumToolMaterial;
        this.weaponDamage = 4 + toolMaterial.getDamageVsEntity();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
    
	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer enitityplayer, World world, int X, int Y, int Z, int par7, float par8, float par9, float par10)
    {
            int i1 = world.getBlockId(X, Y, Z);

            if (i1 == Block.stone.blockID)
            {
                world.playSoundEffect((double)X + 0.5D, (double)Y + 0.5D, (double)Z + 0.5D, "stone.dig", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                world.setBlock(X, Y, Z, Block.cobblestone.blockID);
            }

            par1ItemStack.damageItem(1, enitityplayer);
            return true;
    }

	@Override
    public int getDamageVsEntity(Entity par1Entity)
    {
    	String name = par1Entity.getEntityName();    	
    	if (name.equals("Skeleton")){
    		return (int) (weaponDamage * (double)1.5);
    	}
        else {         
        	return (int) (weaponDamage * (double)0.75);    
        }
    }
}
