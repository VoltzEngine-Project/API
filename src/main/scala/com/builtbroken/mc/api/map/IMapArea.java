package com.builtbroken.mc.api.map;

import com.builtbroken.jlib.data.vector.IPos3D;

/**
 * Notes an area on the map that takes up a defined space
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 9/30/2017.
 */
public interface IMapArea
{
    /**
     * Gets the center of the area
     *
     * @return
     */
    IPos3D getMapAreaCenter();

    /**
     * Is the map area 3D (having defined y limits)
     * or 2D not caring about height
     *
     * @return true if 3D
     */
    default boolean isMapArea3D()
    {
        return true;
    }

    /**
     * Does the area change or move with time
     *
     * @return true if the area doesn't change
     */
    default boolean isMapAreaStatic()
    {
        return true;
    }

    /**
     * Called to check if the location is inside of the area
     *
     * @param pos
     * @return true if inside, not on edge
     */
    default boolean isInsideMapArea(IPos3D pos)
    {
        return isInsideMapArea(pos.x(), pos.y(), pos.z());
    }

    /**
     * Called to check if the location is inside of the area
     *
     * @param x
     * @param y
     * @param z
     * @return true if inside, not on edge
     */
    default boolean isInsideMapArea(double x, double y, double z)
    {
        return isInsideMapArea(Math.floor(x), Math.floor(y), Math.floor(z));
    }

    /**
     * Called to check if the location is inside of the area
     * <p>
     * Due to using integers, consider values as the center of the block rather
     * than corner. This way the check will result in less edge detection problems.
     *
     * @param x
     * @param y
     * @param z
     * @return true if inside, not on edge
     */
    default boolean isInsideMapArea(int x, int y, int z)
    {
        return false;
    }

    //TODO list of shapes

    //TODO interests between areas

}
