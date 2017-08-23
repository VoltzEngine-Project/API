package com.builtbroken.mc.imp.transform.vector;

import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.mc.api.IWorldPosition;
import com.builtbroken.mc.data.Direction;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.ILocation;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class Location extends AbstractLocation<Location> implements IWorldPosition, IPos3D, Comparable<IWorldPosition>
{
    public static final Location NULL = new Location(null, 0, 0, 0);

    public Location(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public Location(NBTTagCompound nbt)
    {
        this(DimensionManager.getWorld(nbt.getInteger("dimension")), nbt.getDouble("x"), nbt.getDouble("y"), nbt.getDouble("z"));
    }

    public Location(ByteBuf data)
    {
        this(DimensionManager.getWorld(data.readInt()), data.readDouble(), data.readDouble(), data.readDouble());
    }

    public Location(Entity entity)
    {
        this(entity.world, entity.posX, entity.posY, entity.posZ);
    }

    public Location(TileEntity tile)
    {
        super(tile);
    }

    public Location(IWorldPosition vec)
    {
        this(vec.oldWorld(), vec.x(), vec.y(), vec.z());
    }

    public Location(ILocation loc)
    {
        this(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
    }

    public Location(World world, IPos3D vector)
    {
        this(world, vector.x(), vector.y(), vector.z());
    }

    public Location(World world, BlockPos pos)
    {
        this(world, pos.getX(), pos.getY(), pos.getZ());
    }

    public Location(World world, Vec3d vec)
    {
        this(world, vec.x, vec.y, vec.z);
    }

    public Location(World world, RayTraceResult target)
    {
        this(world, target.hitVec);
    }

    @Override
    public Location newPos(double x, double y, double z)
    {
        return new Location(world, x, y, z);
    }

    public void playSound(SoundEvent soundIn, SoundCategory category, float volume, float pitch, boolean distanceDelay)
    {
        oldWorld().playSound(x(), y(), z(), soundIn, category, volume, pitch, distanceDelay);
    }

    public void playBreakSound(IBlockState block, Entity cause)
    {
        SoundType soundtype = block.getBlock().getSoundType(block, world, toBlockPos(), cause);
        playSound(soundtype.getBreakSound(), SoundCategory.BLOCKS, soundtype.getVolume() * 0.5F, soundtype.getPitch() * 0.75F, true);
    }

    @SideOnly(Side.CLIENT)
    public void spawnParticle(EnumParticleTypes t, double vel_x, double vel_y, double vel_z, int... parameters)
    {
        oldWorld().spawnParticle(t, x(), y(), z(), vel_x, vel_y, vel_z, parameters);
    }

    @SideOnly(Side.CLIENT)
    public void playBlockBreakAnimation()
    {
        IBlockState blockState = getBlockState();
        if (blockState != null && blockState.getMaterial() != Material.AIR)
        {
            //Play block sound
            playBreakSound(blockState, null); //TODO get entity cause

            //Spawn random particles
            Random rand = oldWorld().rand;
            for (int i = 0; i < 3 + rand.nextInt(20); i++)
            {
                Location v = addRandom(rand, 0.5);
                Pos vel = new Pos().addRandom(rand, 0.2);
                v.spawnParticle(EnumParticleTypes.BLOCK_CRACK, vel.x(), vel.y(), vel.z(), Block.getStateId(blockState)); //TODO check if this works as not sure what data is required
            }

            //this.world.playEvent(this.player, 2001, pos, Block.getStateId(iblockstate)); //TODO check if this is the event that triggers block particles
        }
    }

    public boolean isSideSolid(Direction side)
    {
        IBlockState state = getBlockState();
        if (state != null && state.getBlock() != Blocks.AIR)
        {
            BlockFaceShape shape = state.getBlockFaceShape(world, toBlockPos(), side.getEnumFacing());
            return shape != null && shape == BlockFaceShape.SOLID;
        }
        return false;
    }

    @Override
    public boolean equals(Object o)
    {
        return o instanceof IWorldPosition && this.world == ((IWorldPosition) o).oldWorld() && ((IWorldPosition) o).x() == x() && ((IWorldPosition) o).y() == y() && ((IWorldPosition) o).z() == z();
    }

    @Override
    public int compareTo(IWorldPosition that)
    {
        if (oldWorld().provider.getDimension() < that.oldWorld().provider.getDimension() || x() < that.x() || y() < that.y() || z() < that.z())
        {
            return -1;
        }

        if (oldWorld().provider.getDimension() > that.oldWorld().provider.getDimension() || x() > that.x() || y() > that.y() || z() > that.z())
        {
            return 1;
        }

        return 0;
    }
}