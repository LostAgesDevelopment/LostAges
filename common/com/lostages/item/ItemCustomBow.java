package com.lostages.item;

import com.lostages.LostAges;
import com.lostages.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemCustomBow extends Item {
	public static final String[] pullBackNames = {"bowJungle_pull_0", "bowJungle_pull_1", "bowJungle_pull_2"};
	private Icon[] pullBackIcons;
	private Icon bowIcon;
	
	public ItemCustomBow(int id) {
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(300);
		this.setFull3D();
		this.setCreativeTab(LostAges.tabLostAgesTools);
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int par4) {
		int j = this.getMaxItemUseDuration(itemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return;
		}
		j = event.charge;

		boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;

		if (flag || player.inventory.hasItem(Item.arrow.itemID)) {
			float f = (float)j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if ((double)f < 0.1D) {
				return;
			}

			if (f > 1.0F) {
				f = 1.0F;
			}

			EntityArrow entityarrow = new EntityArrow(world, player, f * 2.5F);
			EntityArrow entityarrow2 = new EntityArrow(world, player, f * 2.0F);

			if (f == 1.0F) {
				entityarrow.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemStack);

			if (k > 0) {
				entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack);

			if (l > 0) {
				entityarrow.setKnockbackStrength(l);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0) {
				entityarrow.setFire(100);
			}

			itemStack.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag) {
				entityarrow.canBePickedUp = 2;
			} else {
				player.inventory.consumeInventoryItem(Item.arrow.itemID);
			}
			
			if (!world.isRemote) {
				world.spawnEntityInWorld(entityarrow);
				world.spawnEntityInWorld(entityarrow2);
			}
		}
	}
	
	@Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
        return itemStack;
    }
	
	@Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 72000;
    }
    
	@Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction.bow;
    }

	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return event.result;
        }

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Item.arrow.itemID)) {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        return itemStack;
    }
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":bowJungle");
		pullBackIcons = new Icon[pullBackNames.length];
		for (int i = 0; i < pullBackIcons.length; i++) {
			pullBackIcons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + pullBackNames[i]);
		}
	}
	
	public Icon getIcon(ItemStack itemStack, int renderPass, EntityPlayer player, ItemStack itemUsing, int remainingUses) {
		if (player.getItemInUse() == null) return itemIcon;
		int pull = itemStack.getMaxItemUseDuration() - remainingUses;
		if (pull >= 18)
			return pullBackIcons[2];
		else if (pull > 13)
			return pullBackIcons[1];
		else if (pull > 0)
			return pullBackIcons[0];
		else
			return itemIcon;
	}
}
