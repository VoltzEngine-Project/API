package com.builtbroken.mc.api.abstraction.tile;

import com.builtbroken.mc.api.abstraction.entity.IEntityData;
import com.builtbroken.mc.api.abstraction.world.IWorld;
import com.builtbroken.mc.data.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper object for a tile position in the world. Used to access the world with location data
 * for a smoother development process.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/12/2017.
 */
public interface ITilePosition
{
    //=====================================================
    //================ Location data ======================
    //=====================================================

    IWorld getWorld();

    int xCoord();

    int yCoord();

    int zCoord();

    //=====================================================
    //====== Helper / Wrapper methods =====================
    //=====================================================

    /**
     * Used to check if the position in the world is loaded
     *
     * @return
     */
    default boolean isLoaded()
    {
        return getWorld().isLocationLoaded(xCoord(), yCoord(), zCoord());
    }

    default ITile getTileData()
    {
        return getWorld().getTile(xCoord(), yCoord(), zCoord());
    }

    default List<IEntityData> getEntitiesInRange(double range)
    {
        return getWorld().getEntitiesInRange(xCoord() + 0.5, yCoord() + 0.5, zCoord() + 0.5, range);
    }

    default ITilePosition getPosition(int x, int y, int z)
    {
        return getWorld().getTilePosition(x, y, z);
    }

    default ITilePosition getPosition(Direction direction)
    {
        return getPosition(xCoord() + direction.offsetX, yCoord() + direction.offsetY, zCoord() + direction.offsetZ);
    }

    default List<ITilePosition> getAdjacentPositions()
    {
        List<ITilePosition> tiles = new ArrayList();

        for (Direction direction : Direction.DIRECTIONS)
        {
            ITilePosition position = getPosition(direction);
            if (position != null && position.isLoaded())
            {
                tiles.add(position);
            }
        }

        return tiles;
    }

    default ITilePosition[] getAdjacentPositions_Array()
    {
        ITilePosition[] tiles = new ITilePosition[6];

        for (Direction direction : Direction.DIRECTIONS)
        {
            ITilePosition position = getPosition(direction);
            if (position != null && position.isLoaded())
            {
                tiles[direction.ordinal()] = position;
            }
        }

        return tiles;
    }
}
