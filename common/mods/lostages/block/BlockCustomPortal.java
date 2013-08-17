package mods.lostages.block;

import java.util.Random;

import mods.lostages.config.LAConfig;
import mods.lostages.dimension.TeleporterLostAge;
import mods.lostages.util.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCustomPortal extends BlockPortal {

	public BlockCustomPortal(int par1) {
		super(par1);
		setUnlocalizedName("portalLostAge");
		setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		super.updateTick(world, x, y, z, random);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		float f;
		float f1;
		
		if (blockAccess.getBlockId(x - 1, y, z) != this.blockID && blockAccess.getBlockId(x + 1, y, z) != this.blockID) {
			f = 0.125F;
			f1 = 0.5F;
			setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		} else {
			f = 0.5F;
			f1 = 0.125F;
			setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
    public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4) {
		byte b0 = 0;
        byte b1 = 0;

        if (par1World.getBlockId(par2 - 1, par3, par4) == Block.cobblestoneMossy.blockID || par1World.getBlockId(par2 + 1, par3, par4) == Block.cobblestoneMossy.blockID) {
            b0 = 1;
        }

        if (par1World.getBlockId(par2, par3, par4 - 1) == Block.cobblestoneMossy.blockID || par1World.getBlockId(par2, par3, par4 + 1) == Block.cobblestoneMossy.blockID) {
            b1 = 1;
        }

        if (b0 == b1) {
            return false;
        } else {
        	if (par1World.isAirBlock(par2 - b0, par3, par4 - b1)) {
                par2 -= b0;
                par4 -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l) {
                for (i1 = -1; i1 <= 3; ++i1) {
                	boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
                    	int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1, par4 + b1 * l);
                        boolean isAirBlock = par1World.isAirBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);

                        if (flag) {
                            if (j1 != Block.cobblestoneMossy.blockID) {
                                return false;
                            }
                        } else if (!isAirBlock && j1 != Block.fire.blockID) {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l) {
                for (i1 = 0; i1 < 3; ++i1) {
                    par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, Blocks.portalLostAge.blockID, 0, 2);
                }
            }

            return true;
        }
    }
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		byte b0 = 0;
		byte b1 = 1;

		if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID) {
			b0 = 1;
			b1 = 0;
		}

		int i1;

		for (i1 = par3; par1World.getBlockId(par2, i1 - 1, par4) == this.blockID; --i1) {
			;
		}

		if (par1World.getBlockId(par2, i1 - 1, par4) != Block.cobblestoneMossy.blockID) {
			par1World.setBlockToAir(par2, par3, par4);
		} else {
			int j1;

			for (j1 = 1; j1 < 4 && par1World.getBlockId(par2, i1 + j1, par4) == this.blockID; ++j1) {
				;
			}

			if (j1 == 3 && par1World.getBlockId(par2, i1 + j1, par4) == Block.cobblestoneMossy.blockID) {
				boolean flag = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
				boolean flag1 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

				if (flag && flag1) {
					par1World.setBlockToAir(par2, par3, par4);
				} else {
					if ((par1World.getBlockId(par2 + b0, par3, par4 + b1) != Block.cobblestoneMossy.blockID || par1World.getBlockId(par2 - b0, par3, par4 - b1) != this.blockID) && (par1World.getBlockId(par2 - b0, par3, par4 - b1) != Block.cobblestoneMossy.blockID || par1World.getBlockId(par2 + b0, par3, par4 + b1) != this.blockID)) {
	                        par1World.setBlockToAir(par2, par3, par4);
					}
				}
			} else {
				par1World.setBlockToAir(par2, par3, par4);
			}
		}
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
		if (blockAccess.getBlockId(x, y, z) == this.blockID) {
			return false;
		} else {
            boolean flag = blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 2, y, z) != this.blockID;
            boolean flag1 = blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x + 2, y, z) != this.blockID;
            boolean flag2 = blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z - 2) != this.blockID;
            boolean flag3 = blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x, y, z + 2) != this.blockID;
            boolean flag4 = flag || flag1;
            boolean flag5 = flag2 || flag3;
            return flag4 && side == 4 ? true : (flag4 && side == 5 ? true : (flag5 && side == 2 ? true : flag5 && side == 3));
		}
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 0;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity.ridingEntity == null && entity.riddenByEntity == null) {
			if (entity instanceof EntityPlayerMP) {
				EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
				if (entity.dimension != LAConfig.dimensionLostAgeID) {
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, LAConfig.dimensionLostAgeID, new TeleporterLostAge(thePlayer.mcServer.worldServerForDimension(LAConfig.dimensionLostAgeID)));
				} else {
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterLostAge(thePlayer.mcServer.worldServerForDimension(0)));
				}
			}
		}
	}
	
	@Override
	public int getRenderBlockPass() {
		return 1;
	}
	
	@Override
	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}
	
}
