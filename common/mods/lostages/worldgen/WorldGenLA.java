package mods.lostages.worldgen;

import java.util.Random;

import mods.lostages.config.ConfigHandler;
import mods.lostages.util.LABlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenLA implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId != 1 || world.provider.dimensionId != -1) {
			generateAdamant(world, random, chunkX, chunkZ);
			
			if (ConfigHandler.generateCopperOre)
				generateCopper(world, random, chunkX * 16, chunkZ * 16);
			
			if (ConfigHandler.generateTinOre)
				generateTin(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	private void generateCopper(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 1; i < ConfigHandler.copperVeinAmount; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(64);
			int zCoord = chunkZ + random.nextInt(16);
			
			new WorldGenMinable(LABlocks.oreBase.blockID, 0, 6, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	
	private void generateTin(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 1; i < ConfigHandler.tinVeinAmount; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(56);
			int zCoord = chunkZ + random.nextInt(16);
			
			new WorldGenMinable(LABlocks.oreBase.blockID, 1, 5, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	
	private void generateAdamant(World world, Random random, int chunkX, int chunkY) {
		for (int i = 1; i < ConfigHandler.adamantVeinAmount; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(16);
			int zCoord = chunkY + random.nextInt(16);
			
			new WorldGenMinable(LABlocks.oreBase.blockID, 2, 2, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
		}
	}

}
