package com.builtbroken.mc.api.tile.multiblock;

import com.builtbroken.jlib.data.vector.IPos3D;
import net.minecraft.world.World;

import java.util.Collection;

/**
 * Handles data about a multi-block layout
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/2/2018.
 */
public interface IMultiBlockLayout
{
    /**
     * Gets the position required to place blocks for the layout
     * <p>
     * Position are relative to the provider of the layout
     *
     * @return collection of positions in the world
     */
    Collection<IPos3D> getLayoutPositions();

    /**
     * Called to inject settings into the tile
     * <p>
     * Called after the tile has been placed into the world
     *
     * @param tile             - tile
     * @param relativePosition - position relative to the provider
     */
    default void setDataIntoBlock(IMultiTile tile, IPos3D relativePosition)
    {

    }

    /**
     * Called to allow the layout to place its open tile
     *
     * @param actualPosition   - position to place in the world
     * @param relativePosition - position relative to provider
     * @return true if placed, false to place a default tile
     */
    default boolean placeMultiTile(World world, IPos3D actualPosition, IPos3D relativePosition)
    {
        return false;
    }
}
