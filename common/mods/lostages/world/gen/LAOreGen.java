package mods.lostages.world.gen;

import java.util.Random;

import mods.lostages.configuration.LAConfiguration;
import mods.lostages.util.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class LAOreGen implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case 0:
				if (LAConfiguration.generateCopperOre == true)
					generateCopper(world, random, chunkX*16, chunkZ*16);
				
				if (LAConfiguration.generateTinOre == true)
					generateTin(world, random, chunkX*16, chunkZ*16);
		}
	}
	
	private void  generateCopper(World world, Random random, int blockX, int blockZ) {
		for (int i = 0; i < LAConfiguration.copperVeinAmount; i++) {
			int xCoord = blockX + random.nextInt(16);
			int yCoord = random.nextInt(64);
			int zCoord = blockZ = random.nextInt(16);
			
			new WorldGenMinable(Blocks.oreBase.blockID, 0, LAConfiguration.copperVeinSize, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	
	private void generateTin(World world, Random random, int blockX, int blockZ) {
		for (int i = 0; i < LAConfiguration.tinVeinAmount; i++) {
			int xCoord = blockX + random.nextInt(16);
			int yCoord = random.nextInt(64);
			int zCoord = blockZ + random.nextInt(16);
			
			new WorldGenMinable(Blocks.oreBase.blockID, 1, LAConfiguration.tinVeinSize, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	
}
