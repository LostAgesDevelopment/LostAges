package mods.lostages.dimension;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChunkProviderLostAge implements IChunkProvider {

	private Random random;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorOctaves noiseGen4;
	private NoiseGeneratorOctaves noiseGen5;
	private NoiseGeneratorOctaves noiseGen6;
	private NoiseGeneratorOctaves mobSpawnerNoise;
	
	private World worldObj;
	
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenCaves();
	
	private BiomeGenBase[] biomesForGeneration;
	
	double[] noise3;
	double[] noise1;
	double[] noise2;
	double[] noise5;
	double[] noise6;
	
	float[] parabolicField;
	int[][] field_73219_j = new int[32][32];
	
	public ChunkProviderLostAge(World world, long par2, long par4) {
		worldObj = world;
		random = new Random(par2);
		noiseGen1 = new NoiseGeneratorOctaves(random, 16);
		noiseGen2 = new NoiseGeneratorOctaves(random, 16);
		noiseGen3 = new NoiseGeneratorOctaves(random, 8);
		noiseGen4 = new NoiseGeneratorOctaves(random, 4);
		noiseGen5 = new NoiseGeneratorOctaves(random, 10);
		noiseGen6 = new NoiseGeneratorOctaves(random, 16);
		mobSpawnerNoise = new NoiseGeneratorOctaves(random, 8);
		
		NoiseGeneratorOctaves[] noiseGens = { noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise };
		noiseGens = TerrainGen.getModdedNoiseGenerators(world, random, noiseGens);
		noiseGen1 = noiseGens[0];
		noiseGen2 = noiseGens[1];
		noiseGen3 = noiseGens[2];
		noiseGen4 = noiseGens[3];
		noiseGen5 = noiseGens[4];
		noiseGen6 = noiseGens[5];
		mobSpawnerNoise = noiseGens[6];
	}
	
	public void generateTerrain(int par1, int par2, byte[] par3) {
		byte b0 = 4;
		byte b1 = 16;
		byte b2 = 63;
		int k = b0 + 1;
		byte b3 = 17;
		int l = b0 + 1;
		biomesForGeneration = worldObj.getWorldChunkManager().getBiomesForGeneration(biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, k + 5, l + 5);
		//noiseArray = initializeNoiseField(noiseArray, par1 * b0, 0, par2 * b0, k, b3, l);
		
		for (int i1 = 0; i1 < b0; i1++) {
			for (int j1 = 0; j1 < b0; j1++) {
				for (int k1 = 0; k1 < b1; k1++) {
					double d0 = 0.125D;
					double d1 = noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
					double d2 = noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
					double d3 = noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
					double d4 = noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
					double d5 = (noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d1) * d0;
					double d6 = (noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d1) * d0;
					double d7 = (noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d1) * d0;
					double d8 = (noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d1) * d0;
					
					for (int l1 = 0; l1 < 8; l1++) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						
						for (int i2 = 0; i2 < 4; i2++) {
							int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
							short short1 = 128;
							j2 -= short1;
							double d14 = 0.25D;
							double d15 = (d11 - d10) * d14;
							double d16 = d10 - d15;
							
							for (int k2 = 0; k2 < 4; k2++) {
								if ((d16 += d15) > 0.0D) {
									par3[j2 += short1] = (byte)Block.stone.blockID;
								} else if (k1 * 8 + l1 < b2) {
									par3[j2 += short1] = (byte)Block.waterStill.blockID;
								} else {
									par3[j2 += short1] = 0;
								}
							}
							
							d10 += d12;
							d11 += d13;
						}
						
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}
	
	public void replaceBlocksForBiome(int par1, int par2, byte[] par3, BiomeGenBase[] par4) {
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, par1, par2, par3, par4);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return;
		
		byte b0 = 63;
		double d0 = 0.03125D;
		stoneNoise = noiseGen4.generateNoiseOctaves(stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);
		
		for (int k = 0; k < 16; k++) {
			for (int l = 0; l < 16; l++) {
				BiomeGenBase biomeGenBase = par4[l + k * 16];
				float f = biomeGenBase.getFloatTemperature();
				int i1 = (int)(stoneNoise[k + l * 16] / 3.0D + 3.0D + random.nextDouble() * 0.25D);
				int j1 = -1;
				byte b1 = biomeGenBase.topBlock;
				byte b2 = biomeGenBase.fillerBlock;
				
				for (int k1 = 127; k1 >= 0; k1--) {
					int l1 = (l * 16 + k) * 128 + k1;
					
					if (k1 <= 0 + random.nextInt(5)) {
						par3[l1] = (byte)Block.bedrock.blockID;
					} else {
						byte b3 = par3[l1];
						
						if (b3 == 0) {
							j1 = -1;
						} else if (b3 == Block.stone.blockID) {
							if (j1 == -1) {
								if (i1 <= 0) {
									b1 = 0;
									b2 = (byte)Block.stone.blockID;
								} else if (k1 >= b0 - 4 && k1 < b0 + 1) {
									b1 = biomeGenBase.topBlock;
									b2 = biomeGenBase.fillerBlock;
								}
								
								if (k1 < b0 && b1 == 0) {
									if (f < 015F) {
										b1 = (byte)Block.ice.blockID;
									} else {
										b1 = (byte)Block.waterStill.blockID;
									}
								}
								
								j1 = i1;
								
								if (k1 >= b0 - 1) {
									par3[l1] = b1;
								} else {
									par3[l1] = b2;
								}
							}
						} else if (j1 > 0) {
							--j1;
							par3[l1] = b2;
							
							if (j1 == 0 && b2 == Block.sand.blockID) {
								j1 = random.nextInt(4);
								b2 = (byte)Block.sandStone.blockID;
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public Chunk loadChunk(int i, int j) {
		return provideChunk(i, j);
	}
	
	@Override
	public Chunk provideChunk(int i, int j) {
		random.setSeed((long)i * 341873128712L + (long)j + 132897987541L);
		byte[] abyte = new byte[32768];
		generateTerrain(i, j, abyte);
		biomesForGeneration = worldObj.getWorldChunkManager().loadBlockGeneratorData(biomesForGeneration, i * 16, j * 16, 16, 16);
		replaceBlocksForBiome(i, j, abyte, biomesForGeneration);
		
		Chunk chunk = new Chunk(worldObj, abyte, i, j);
		byte[] abyte1 = chunk.getBiomeArray();
		
		for (int k = 0; k < abyte1.length; k++) {
			abyte1[k] = (byte)biomesForGeneration[k].biomeID;
		}
		
		chunk.generateSkylightMap();
		return chunk;
	}
	
	/*private double[] initializeNoiseField(double[] par1, int par2, int par3, int par4, int par5, int par6, int par7) {
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, par1, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return event.noisefield;
		
		if (par1 == null) {
			par1 = new double[par5 * par6 * par7];
		}
		
		
	}*/
	
	@Override
	public boolean chunkExists(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadQueuedChunks() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String makeString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i,
			int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkPosition findClosestStructure(World world, String s, int i,
			int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void func_104112_b() {
		// TODO Auto-generated method stub
		
	}

}
