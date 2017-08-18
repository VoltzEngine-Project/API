package com.builtbroken.mc.imp.transform.vector;

import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.mc.data.Direction;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Pos that uses ints rather than doubles
 * <p>
 * Main use is for block location data but can be used for anything.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/17/2017.
 */
public class BlockPosition implements IPos3D, Comparable<BlockPosition> //TODO make extend blockPos to reduce overlap
{
    final BlockPos blockPos;

    public BlockPosition(int x, int y, int z)
    {
        blockPos = new BlockPos(x, y, z);
    }

    public BlockPosition(IPos3D pos3D)
    {
        this(pos3D.xi(),
                pos3D.yi(),
                pos3D.zi());
    }

    public BlockPosition(IPos3D pos3D, Direction dir)
    {
        this(pos3D.xi() + dir.offsetX,
                pos3D.yi() + dir.offsetY,
                pos3D.zi() + dir.offsetZ);
    }

    public BlockPosition(IPos3D pos3D, EnumFacing dir)
    {
        this(pos3D.xi() + dir.getFrontOffsetX(),
                pos3D.yi() + dir.getFrontOffsetY(),
                pos3D.zi() + dir.getFrontOffsetZ());
    }

    @Override
    public double x()
    {
        return blockPos.getX();
    }

    @Override
    public int xi()
    {
        return blockPos.getX();
    }

    @Override
    public double y()
    {
        return blockPos.getY();
    }

    @Override
    public int yi()
    {
        return blockPos.getY();
    }

    @Override
    public double z()
    {
        return blockPos.getZ();
    }

    @Override
    public int zi()
    {
        return blockPos.getZ();
    }

    @Override
    public int hashCode()
    {
        long hash = (xi() ^ (xi() >>> 32));
        hash = 31 * hash + yi() ^ (yi() >>> 32);
        hash = 31 * hash + zi() ^ (zi() >>> 32);
        return (int) hash;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof IPos3D)
        {
            return ((IPos3D) o).xi() == xi() && ((IPos3D) o).yi() == yi() && ((IPos3D) o).zi() == zi();
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "BlockPos[" + this.xi() + "," + this.yi() + "," + this.zi() + "]";
    }

    @Override
    public int compareTo(BlockPosition that)
    {
        return compare(that);
    }

    public int compare(IPos3D that)
    {
        if (x() < that.xi() || yi() < that.yi() || zi() < that.zi())
        {
            return -1;
        }
        if (x() > that.xi() || y() > that.yi() || zi() > that.zi())
        {
            return 1;
        }
        return 0;
    }

    public boolean isAirBlock(World world)
    {
        IBlockState state = getBlockState(world);
        if (state != null)
        {
            return state.getBlock().isAir(state, world, blockPos);
        }
        return false;
    }

    @Deprecated
    public Block getBlock(World world)
    {
        IBlockState state = getBlockState(world);
        if(state != null)
        {
            return state.getBlock();
        }
        return null;
    }

    public IBlockState getBlockState(World world)
    {
        if (world != null)
        {
            return world.getBlockState(blockPos); //TODO check if chunk is loaded
        }
        return null;
    }

    public float getHardness(World world)
    {
        IBlockState block = getBlockState(world);
        if (block != null)
        {
            return block.getBlockHardness(world, blockPos);
        }
        return -1;
    }

    public boolean isReplaceable(World world)
    {
        Block block = getBlock(world);
        if (block != null)
        {
            return block.isReplaceable(world, blockPos);
        }
        return false;
    }

    public double getResistance(Entity explosionBlameEntity, double x, double y, double z)
    {
        return 0;
    }

    public BlockPosition add(int x, int y, int z)
    {
        return new BlockPosition(this.xi() + x, this.yi() + y, this.zi() + z);
    }

    public boolean canSeeSky(World world)
    {
        return world != null && world.canSeeSky(blockPos);
    }

    public double distance(double x, double y, double z)
    {
        return new Pos(this).add(0.5).distance(x, y, z); //TODO replace with actual code
    }

    public Pos toPos()
    {
        return new Pos(xi(), yi(), zi());
    }

    public TileEntity getTileEntity(World world)
    {
        if (world != null)
        {
            return world.getTileEntity(blockPos);
        }
        return null;
    }

    public double distance(Location center)
    {
        return distance(center.x(), center.y(), center.z());
    }
}