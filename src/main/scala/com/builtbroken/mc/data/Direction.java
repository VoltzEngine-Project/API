package com.builtbroken.mc.data;

import net.minecraft.util.EnumFacing;

/**
 * Based on Forge's ForgeDirection system
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/15/2017.
 */
public enum Direction
{
    /** -Y */
    DOWN(0, -1, 0),

    /** +Y */
    UP(0, 1, 0),

    /** -Z */
    NORTH(0, 0, -1),

    /** +Z */
    SOUTH(0, 0, 1),

    /** -X */
    WEST(-1, 0, 0),

    /** +X */
    EAST(1, 0, 0),

    /**
     * Used only by getOrientation, for invalid inputs
     */
    UNKNOWN(0, 0, 0),

    /**
     * Bonus check for internal calls
     */
    INTERNAL(0, 0, 0);

    public final int offsetX;
    public final int offsetY;
    public final int offsetZ;

    public static final Direction[] DIRECTIONS = {DOWN, UP, NORTH, SOUTH, WEST, EAST};

    public static final int[] OPPOSITES = {1, 0, 3, 2, 5, 4, 6};

    // Left hand rule rotation matrix for all possible axes of rotation
    public static final int[][] ROTATION_MATRIX = {
            {0, 1, 4, 5, 3, 2, 6},
            {0, 1, 5, 4, 2, 3, 6},
            {5, 4, 2, 3, 0, 1, 6},
            {4, 5, 2, 3, 1, 0, 6},
            {2, 3, 1, 0, 4, 5, 6},
            {3, 2, 0, 1, 4, 5, 6},
            {0, 1, 2, 3, 4, 5, 6},
    };

    Direction(int x, int y, int z)
    {
        offsetX = x;
        offsetY = y;
        offsetZ = z;
    }

    public static Direction getOrientation(int id)
    {
        if (id >= 0 && id < DIRECTIONS.length)
        {
            return DIRECTIONS[id];
        }
        return UNKNOWN;
    }

    public Direction getOpposite()
    {
        return getOrientation(OPPOSITES[ordinal()]);
    }

    public Direction getRotation(Direction axis)
    {
        return getOrientation(ROTATION_MATRIX[axis.ordinal()][ordinal()]);
    }

    public EnumFacing getEnumFacing()
    {
        if(ordinal() < UNKNOWN.ordinal())
        {
            return EnumFacing.values()[ordinal()];
        }
        return null;
    }
}
