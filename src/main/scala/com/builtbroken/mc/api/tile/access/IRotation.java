package com.builtbroken.mc.api.tile.access;


import com.builtbroken.mc.data.Direction;

/** Used by blocks that have a placement direction in the world
 *
 * Created by robert on 12/9/2014.
 */
public interface IRotation
{
    /** Gets the facing direction of the TileEntity
     * @return  Front of the tile */
    Direction getDirection();
}
