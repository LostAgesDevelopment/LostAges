package mods.lostages.dimension;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
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
	
	private double[] initializeNoiseField(double[] par1, int par2, int par3, int par4, int par5, int par6, int par7) {
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, par1, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return event.noisefield;
		
		if (par1 == null)
			par1 = new double[par5 * par6 * par7];
		
		if (parabolicField == null)
			parabolicField = new float[25];
		
		for (int k1 = -2; k1 <= 2; k1++) {
			for (int l1 = -2; l1 <= 2; l1++) {
				float f = 10.0F / MathHelper.sqrt_float((float)(k1 * k1 + l1 * l1) + 0.2F);
				parabolicField[k1 + 2 + (l1 + 2) * 5] = f;
			}
		}
		
		double d0 = 684.412D;
		double d1 = 684.412D;
		noise5 = noiseGen5.generateNoiseOctaves(noise5, par2, par4, par5, par7, 1.121D, 1.121D, 0.5D);
        noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par4, par5, par7, 200.0D, 200.0D, 0.5D);
        noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
        noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, d0, d1, d0);
        noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, d0, d1, d0);
        boolean flag = false;
        boolean flag1 = false;
        int i2 = 0;
        int j2 = 0;
        
        for (int k2 = 0; k2 < par5; k2++) {
        	for (int l2 = 0; l2 < par7; l2++) {
        		float f1 = 0.0F;
        		float f2 = 0.0F;
        		float f3 = 0.0F;
        		byte b0 = 2;
        		BiomeGenBase biomeGenBase = biomesForGeneration[k2 + 2 + (l2 + 2) * (par5 + 5)];
        		
        		for (int i3 = -b0; i3 <= b0; i3++) {
        			for (int j3 = -b0; j3 <= b0; j3++) {
        				BiomeGenBase biomeGenBase1 = biomesForGeneration[k2 + i3 + 2 + (l2 + j3 + 2) * (par5 + 5)];
        				float f4 = parabolicField[i3 + 2 + (j3 + 2) * 5] / (biomeGenBase1.minHeight + 2.0F);
        				
        				if (biomeGenBase1.minHeight > biomeGenBase.minHeight)
        					f4 /= 2.0F;
        				
        				f1 += biomeGenBase1.maxHeight * f4;
        				f2 += biomeGenBase1.minHeight * f4;
        				f3 += f4;
        			}
        		}
        		
        		f1 /= f3;
        		f2 /= f3;
        		f1 = f1 * 0.9F + 0.1F;
        		f2 = (f2 * 4.0F - 1.0F) / 8.0F;
        		double d2 = noise6[j2] / 8000.0D;
        		
        		if (d2 < 0.0D)
        			d2 = -d2 * 0.3D;
        		
        		d2 = d2 * 3.0D - 2.0D;
        		
        		if (d2 < 0.0D) {
        			d2 /= 2.0D;
        			
        			if (d2 < -1.0D)
        				d1 = -1.0D;
        			
        			d2 /= 1.4D;
        			d2 /= 2.0D;
        		} else {
        			if (d2 > 1.0D)
        				d2 = 1.0D;
        			
        			d2 /= 8.0D;
        		}
        		
        		j2++;
        		
        		for (int k3 = 0; k3 < par6; k3++) {
        			double d3 = (double)f2;
                    double d4 = (double)f1;
                    d3 += d2 * 0.2D;
                    d3 = d3 * (double)par6 / 16.0D;
                    double d5 = (double)par6 / 2.0D + d3 * 4.0D;
                    double d6 = 0.0D;
                    double d7 = ((double)k3 - d5) * 12.0D * 128.0D / 128.0D / d4;
                    
                    if (d7 < 0.0D)
                    	d7 *= 4.0D;
                    
                    double d8 = this.noise1[i2] / 512.0D;
                    double d9 = this.noise2[i2] / 512.0D;
                    double d10 = (this.noise3[i2] / 10.0D + 1.0D) / 2.0D;
                    
                    if (d10 < 0.0D)
                    	d6 = d8;
                    else if (d10 > 1.0D)
                    	d6 = d9;
                    else
                    	d6 = d8 + (d9 - d8) * d10;
                    
                    d6 -= d7;
                    
                    if (k3 > par6 - 4) {
                    	double d11 = (double)((float)(k3 - (par6 - 4)) / 3.0F);
                    	d6 = d6 * (1.0D - d11) + -10.0D * d11;
                    }
                    
                    par1[i2] = d6;
                    i2++;
        		}
        	}
        }
        
        return par1;
	}
	
	@Override
	public boolean chunkExists(int i, int j) {
		return true;
	}

    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
        BlockSand.fallInstantly = true;
        int k = par2 * 16;
        int l = par3 * 16;
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.random.setSeed(this.worldObj.getSeed());
        long i1 = this.random.nextLong() / 2L * 2L + 1L;
        long j1 = this.random.nextLong() / 2L * 2L + 1L;
        this.random.setSeed((long)par2 * i1 + (long)par3 * j1 ^ this.worldObj.getSeed());
        boolean flag = false;

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, worldObj, random, par2, par3, flag));

        int k1;
        int l1;
        int i2;

        if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.random.nextInt(4) == 0 && TerrainGen.populate(par1IChunkProvider, worldObj, random, par2, par3, flag, LAKE)) {
            k1 = k + this.random.nextInt(16) + 8;
            l1 = this.random.nextInt(128);
            i2 = l + this.random.nextInt(16) + 8;
            (new WorldGenLakes(Block.waterStill.blockID)).generate(this.worldObj, this.random, k1, l1, i2);
        }

        if (TerrainGen.populate(par1IChunkProvider, worldObj, random, par2, par3, flag, LAVA) && !flag && this.random.nextInt(8) == 0) {
            k1 = k + this.random.nextInt(16) + 8;
            l1 = this.random.nextInt(this.random.nextInt(120) + 8);
            i2 = l + this.random.nextInt(16) + 8;

            if (l1 < 63 || this.random.nextInt(10) == 0)
                (new WorldGenLakes(Block.lavaStill.blockID)).generate(this.worldObj, this.random, k1, l1, i2);
        }

        boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, random, par2, par3, flag, DUNGEON);
        for (k1 = 0; doGen && k1 < 8; ++k1) {
            l1 = k + this.random.nextInt(16) + 8;
            i2 = this.random.nextInt(128);
            int j2 = l + this.random.nextInt(16) + 8;
            (new WorldGenDungeons()).generate(this.worldObj, this.random, l1, i2, j2);
        }

        biomegenbase.decorate(this.worldObj, this.random, k, l);
        SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.random);
        k += 8;
        l += 8;

        doGen = TerrainGen.populate(par1IChunkProvider, worldObj, random, par2, par3, flag, ICE);
        for (k1 = 0; doGen && k1 < 16; ++k1) {
            for (l1 = 0; l1 < 16; ++l1) {
                i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);

                if (this.worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l))
                    this.worldObj.setBlock(k1 + k, i2 - 1, l1 + l, Block.ice.blockID, 0, 2);

                if (this.worldObj.canSnowAt(k1 + k, i2, l1 + l))
                    this.worldObj.setBlock(k1 + k, i2, l1 + l, Block.snow.blockID, 0, 2);
            }
        }

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, random, par2, par3, flag));

        BlockSand.fallInstantly = false;
    }

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "LostAgeSource";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i, int j, int k) {
		return null;
	}

	@Override
	public ChunkPosition findClosestStructure(World world, String s, int i, int j, int k) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) {}

	@Override
	public void func_104112_b() {}

}
