package mods.lostages.dimension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterLostAge extends Teleporter {

	private final WorldServer worldServer;
	private final Random random;
	private final LongHashMap longHashMap = new LongHashMap();
	private final List list = new ArrayList();
	
	public TeleporterLostAge(WorldServer worldServer) {
		super(worldServer);
		this.worldServer = worldServer;
		this.random = new Random(worldServer.getSeed());
	}

	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float par8) {
		if (this.worldServer.provider.dimensionId != 1) {
			if (!this.placeInExistingPortal(entity, x, y, z, par8)) {
				this.makePortal(entity);
				this.placeInExistingPortal(entity, x, y, z, par8);
			}
		} else {
			int var9 = MathHelper.floor_double(entity.posX);
			int var10 = MathHelper.floor_double(entity.posY);
			int var11 = MathHelper.floor_double(entity.posZ);
			byte var12 = 1;
			byte var13 = 0;
			
			for (int var14 = -2; var14 <= 2; var14++) {
				for (int var15 = -2; var15 <= 2; var15++) {
					for (int var16 = -1; var16 < 3; var16++) {
						int var17 = var9 + var15 * var12 + var14 * var13;
						int var18 = var10 + var16;
						int var19 = var11 + var15 * var13 - var14 * var12;
						boolean var20 = var16 < 0;
						this.worldServer.setBlock(var17, var18, var19, var20 ? Block.sandStone.blockID : 0);
					}
				}
			}
			
			entity.setLocationAndAngles((double)var9, (double)var10, (double)var11, entity.rotationYaw, 0.0F);
		}
	}
	
	/*
	@Override
	public boolean placeInExistingPortal(Entity entity, double x, double y, double z, double par8) {
		short var9 = 128;
		  double var10 = -1.0D;
		  int var12 = 0;
		  int var13 = 0;
		  int var14 = 0;
		  int var15 = MathHelper.floor_double(entity.posX);
		  int var16 = MathHelper.floor_double(entity.posZ);
		  long var17 = ChunkCoordIntPair.chunkXZ2Int(var15, var16);
		  boolean var19 = true;
		  double var27;
		  int var48;
		  
		  if (worldServer.)
	}
	*/
	
}
