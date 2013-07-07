package mods.lostages.item;

import mods.lostages.LostAges;
import mods.lostages.util.Items;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHammer extends Item {
	
	private enum HammerMode {
		STANDARD, CHARGED, ULTIMATE
	}
	
	private HammerMode hammerMode = HammerMode.STANDARD; 
	
	private int blockChange;
	
	protected float weaponDamage;
	protected EnumToolMaterial toolMaterial;
	
	public ItemHammer(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1);
		this.setCreativeTab(LostAges.tabLATools);
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
		toolMaterial = par2EnumToolMaterial;
		blockChange = Block.cobblestone.blockID;
		weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
		maxStackSize = 1;
	}
	
	public ItemHammer(int par1, EnumToolMaterial par2EnumToolMaterial, Block block) {
		super(par1);
		setCreativeTab(LostAges.tabLATools);
		setMaxDamage(par2EnumToolMaterial.getMaxUses());
		toolMaterial = par2EnumToolMaterial;
		blockChange = block.blockID;
        weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
        maxStackSize = 1;
	}
    
	@Override
	public boolean isFull3D() {
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
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase1, EntityLivingBase entityLivingBase2) {
		itemStack.damageItem(1, entityLivingBase1);
        return true;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (player.isSneaking()) {
			if (world.isRemote) {
				if (itemStack.itemID == Items.hammerMagic.itemID) {
					changeMode(world, player);
				}
			}
		}
		
		return itemStack;
	}
	
	@Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		if (itemStack.itemID == Items.hammerMagic.itemID) {
			if (hammerMode == HammerMode.STANDARD) {
				changeStandard(itemStack, world, player, x, y, z);
				return true;
			} else if (hammerMode == HammerMode.CHARGED) {
				changeCharged(itemStack, world, player, x, y, z);
				return true;
			} else if (hammerMode == HammerMode.ULTIMATE) {
				changeCharged(itemStack, world, player, x, y, z);
				return true;
			}
		} else {
			changeStandard(itemStack, world, player, x, y, z);
			return true;
		}
		
		return false;
	}

	@Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, int blockID, int x, int y, int z, EntityLivingBase entityLivingBase) {
		EntityPlayer player = (EntityPlayer) entityLivingBase;
		if (itemStack.itemID == Items.hammerMagic.itemID) {
			if (hammerMode == HammerMode.CHARGED) {
				breakCharged(itemStack, world, player, x, y, z);
				return true;
			} else if (hammerMode == HammerMode.ULTIMATE) {
				breakUltimate(itemStack, world, player, x, y, z);
				return true;
			} else {
				itemStack.damageItem(1, player);
				return true;
			}
		} else {
			itemStack.damageItem(1, player);
			return true;
		}
    }
	
	@Override
    public float getDamageVsEntity(Entity par1Entity, ItemStack itemStack) {
    	String name = par1Entity.getEntityName();    	
    	if (name.equals("Skeleton")) {
    		return (float) (weaponDamage * (double)1.5);
    	} else if (name.equals("Spider")) {
    		return (float) (weaponDamage * (double)1.5);
    	} else {         
        	return (float) (weaponDamage * (double)0.75);    
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
    public int getItemEnchantability() {
        return toolMaterial.getEnchantability();
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	
	@Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public Multimap func_111205_h() {
        Multimap multimap = super.func_111205_h();
        multimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Tool modifier", (double)this.weaponDamage, 0));
        return multimap;
    }
	
	private void changeMode(World world, EntityPlayer player) {
		if (world.isRemote) {
			if (hammerMode == HammerMode.STANDARD) {
				hammerMode = HammerMode.CHARGED;
				player.addChatMessage("Changed to charged mode.");
			} else if (hammerMode == HammerMode.CHARGED) {
				hammerMode = HammerMode.ULTIMATE;
				player.addChatMessage("Changed to ultimate mode.");
			} else {
				hammerMode = HammerMode.STANDARD;
				player.addChatMessage("Changed to standard mode.");
			}
		}
	}
	
	private void changeStandard(ItemStack itemStack, World world, EntityPlayer player, int x, int y, int z) {
		int blockID = world.getBlockId(x, y, z);
		if (blockID == Block.stone.blockID) {
			world.setBlock(x, y, z, blockChange);
			itemStack.damageItem(1, player);
		}
	}
	
	private void changeCharged(ItemStack itemStack, World world, EntityPlayer player, int x, int y, int z) {
		int blockID = world.getBlockId(x, y, z);
		Block block = Block.blocksList[blockID];
		if (block != null && block == Block.stone) {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					for (int k = -1; k <= 1; k++) {
						int bid = world.getBlockId(x + i, y + j, z + k);
						block = Block.blocksList[bid];
						if (block != null && block == Block.stone) {
							world.setBlock(x + i, y + j, z + k, blockChange);
							itemStack.damageItem(2, player);
						}
					}
				}
			}
		}
	}
	
	private void breakCharged(ItemStack itemStack, World world, EntityPlayer player, int x, int y, int z) {
		int blockId = world.getBlockId(x, y, z);
		Block block = Block.blocksList[blockId];
		if (block != null && block == Block.stone) {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					for (int k = -1; k <= 1; k++) {
						int bid = world.getBlockId(x + i, y + j, z + k);
						int meta = world.getBlockMetadata(x + i, y + j, z + k);
						block = Block.blocksList[bid];
						if (block != null && block == Block.stone) {
							block.harvestBlock(world, player, x, y, z, meta);
							itemStack.damageItem(2, player);
							world.setBlockToAir(x + i, y + j, z + k);
						}
					}
				}
			}
		}
	}
	
	private void breakUltimate(ItemStack itemStack, World world, EntityPlayer player, int x, int y, int z) {
		int blockId = world.getBlockId(x, y, z);
		Block block = Block.blocksList[blockId];
		if (block != null && block instanceof Block && block != Block.bedrock) {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					for (int k = -1; k <= 1; k++) {
						int bid = world.getBlockId(x + i, y + j, z + k);
						int meta = world.getBlockMetadata(x + i, y + j, z + k);
						block = Block.blocksList[bid];
						if (block != null && block instanceof Block && block != Block.bedrock) {
							block.harvestBlock(world, player, x, y, z, meta);
							itemStack.damageItem(3, player);
							world.setBlockToAir(x + i, y + j, z + k);
						}
					}
				}
			}
		}
	}
}
