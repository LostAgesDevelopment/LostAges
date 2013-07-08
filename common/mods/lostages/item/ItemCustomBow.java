package mods.lostages.item;

import mods.lostages.LostAges;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCustomBow extends ItemBow {

	private Icon[] pullBackIcons;
	private String[] pullBackNames = { "_pull_0", "_pull_1", "_pull_2" };
	
	public ItemCustomBow(int par1) {
		super(par1);
		this.setCreativeTab(LostAges.tabLATools);
	}
	
	@Override
	public boolean isFull3D() {
		return true;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(5));
		pullBackIcons = new Icon[pullBackNames.length];
		for (int i = 0; i < pullBackIcons.length; i++) {
			pullBackIcons[i] = iconRegister.registerIcon("lostages:" + this.getUnlocalizedName().substring(5) + pullBackNames[i]);
		}
	}
	
	@Override
	public Icon getIcon(ItemStack itemStack, int renderPass, EntityPlayer player, ItemStack itemUsing, int remainingUses) {
		if (itemUsing != null) {
			int time = 72000 - remainingUses;
			if (time < 8) return pullBackIcons[0];
			if (time < 14) return pullBackIcons[1];
			return pullBackIcons[2];
		}
		
		return getIcon(itemStack, renderPass);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getItemIconForUseDuration(int par1) {
		return pullBackIcons[par1];
	}
	
}
