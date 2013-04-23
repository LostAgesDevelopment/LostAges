package com.lostages.lib;

import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class LostAgesMaterials
{
																	  //NAME(harvestlevel, uses, speed, damage, enchant)
	
																	 //GOLD(0, 32, 12.0F, 0, 22);
																	 //WOOD(0, 59, 2.0F, 0, 15),
    																 //STONE(1, 131, 4.0F, 1, 5),
	public static EnumToolMaterial FLINT = EnumHelper.addToolMaterial("FLINT", 1, 180, 5.5F, 1, 5);
	public static EnumToolMaterial BONE = EnumHelper.addToolMaterial("BONE", 1, 200, 5.0F, 1, 20);
	public static EnumToolMaterial BRONZE = EnumHelper.addToolMaterial("BRONZE", 2, 225, 6.0F, 2, 10);
    																  //IRON(2, 250, 6.0F, 2, 14),
	public static EnumToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL", 2, 500, 7.0F, 3, 16);
	public static EnumToolMaterial STRONGGOLD = EnumHelper.addToolMaterial("STRONGGOLD", 3, 800, 12.0F, 3, 18);
	public static EnumToolMaterial ADAMANT = EnumHelper.addToolMaterial("ADAMANT", 3, 1561, 8.0F, 3, 10);
    																	//EMERALD(3, 1561, 8.0F, 3, 10),	
}
