package com.builtbroken.mc.api.event.tile;

import com.builtbroken.mc.lib.transform.vector.Location;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

/**
 * Base for all events trigger for a tile/block at a location
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/11/2016.
 */
public class TileEvent extends Event
{
    /** Location of tile with world */
    public final Location location;
    /** Internal cache value */
    protected TileEntity tile;

    public TileEvent(TileEntity tile)
    {
        this.location = new Location(tile);
        this.tile = tile;
    }

    public TileEvent(World world, int x, int y, int z)
    {
        location = new Location(world, x, y, z);
    }

    public TileEntity tile()
    {
        if (tile == null || tile.isInvalid())
        {
            tile = location.getTileEntity();
        }
        return tile;
    }

    /**
     * Call this from your {@link TileEntity#validate()}
     * @param tile
     */
    public static void onLoad(TileEntity tile)
    {
        MinecraftForge.EVENT_BUS.post(new TileLoadEvent(tile));
    }

    public static void onUnLoad(TileEntity tile)
    {
        MinecraftForge.EVENT_BUS.post(new TileUnLoadEvent(tile));
    }

    /**
     * Trigger when a tile is loaded into the world. Normally
     * called from the {@link TileEntity#validate()} method
     */
    public static class TileLoadEvent extends TileEvent
    {
        //Make sure to call this version as world.getTileEntity may not return same result
        public TileLoadEvent(TileEntity tile)
        {
            super(tile);
        }

        public TileLoadEvent(World world, int x, int y, int z)
        {
            super(world, x, y, z);
        }
    }

    /**
     * Trigger when a tile is unloaded from the world. Normally
     * called from the {@link TileEntity#invalidate()} method
     */
    public static class TileUnLoadEvent extends TileEvent
    {
        //Make sure to call this version as world.getTileEntity may not return same result
        public TileUnLoadEvent(TileEntity tile)
        {
            super(tile);
        }

        public TileUnLoadEvent(World world, int x, int y, int z)
        {
            super(world, x, y, z);
        }
    }
}
