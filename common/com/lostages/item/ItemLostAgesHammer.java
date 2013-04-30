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
import com.lostages.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLostAgesHammer extends Item {
	
	protected int weaponDamage;
	protected ItemStack blockChange;
	protected EnumToolMaterial toolMaterial;
	//TODO Fix enchanting
	public ItemLostAgesHammer(int par1, EnumToolMaterial par2EnumToolMaterial, ItemStack itemStack) {
		super(par1);
		setCreativeTab(LostAges.tabLostAgesTools);
		setMaxDamage(par2EnumToolMaterial.getMaxUses());
		toolMaterial = par2EnumToolMaterial;
		blockChange = itemStack;
        weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
        maxStackSize = 1;
	}
	
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
    
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		if (par2Block.blockMaterial == Material.rock) {
			return toolMaterial.getEfficiencyOnProperMaterial() + 1;
		} else {
			return 1.0F;
		}
	}
	
	@Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }
	
	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer enitityplayer, World world, int X, int Y, int Z, int par7, float par8, float par9, float par10) {
            int i1 = world.getBlockId(X, Y, Z);

            if (i1 == Block.stone.blockID) {
                world.playSoundEffect((double)X + 0.5D, (double)Y + 0.5D, (double)Z + 0.5D, "dig.stone", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                world.setBlock(X, Y, Z, blockChange.itemID);
            } else {
            	return false;
            }

            par1ItemStack.damageItem(1, enitityplayer);
            return true;
    }

	@Override
    public int getDamageVsEntity(Entity par1Entity) {
    	String name = par1Entity.getEntityName();    	
    	if (name.equals("Skeleton")) {
    		return (int) (weaponDamage * (double)1.5);
    	} else if (name.equals("Spider")) {
    		return (int) (weaponDamage * (double)1.5);
    	} else {         
        	return (int) (weaponDamage * (double)0.75);    
        }
    }
	
	public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }
	
	@Override
    public boolean canHarvestBlock(Block par1Block) {
		if (par1Block.blockMaterial == Material.rock) {
			return true;
		} else if (par1Block.blockMaterial == Material.iron) {
			return true;
		} else {
			return false;
		}
    }
	
	@Override
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World world, int X, int Y, int Z, int par6, EntityLiving par7EntityLiving) {
        int i2 = world.getBlockId(X, Y, Z);
		
        if (i2 == Block.stone.blockID) {
    		par1ItemStack.damageItem(3, par7EntityLiving);
        } else if (i2 != Block.tallGrass.blockID) {
    		par1ItemStack.damageItem(1, par7EntityLiving);
        }
        return true;
    }
	
	@Override
    public int getItemEnchantability() {
        return toolMaterial.getEnchantability();
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public static void addEnchantment(Enchantment featherfalling, int i) {
		// TODO Auto-generated method stub
	}


    /**
	 * Return whether this item is repairable in an anvil.
	 */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }	
}
