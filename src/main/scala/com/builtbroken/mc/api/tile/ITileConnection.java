package com.builtbroken.mc.api.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Simple interface for checking connections to an object from a direction.
 * <p>
 * Created on 11/12/2014.
 *
 * @author Darkguardsman
 */
@Deprecated //Going to be replace with capability type system
public interface ITileConnection
{
    /**
     * Simple direction based connection check.
     * Should be simple as side == side, and connection instanceof type
     *
     * @param connection - what is trying to connect, can be null
     * @param type       - what type of connector is the connection.
     *                   Make sure to check for general connection type before specific
     * @param from       - desired side to connect, may be null for internal connections.
     *                   Side going into the machine towards the center
     * @return true if the object can connect based on direction, and type
     */
    boolean canConnect(TileEntity connection, ConnectionType type, ForgeDirection from);

    /**
     * Checks if the tile has a connection on the given side
     *
     * @param type - type of connection, can be null for any connection
     * @param side - side of the tile, facing away from center
     * @return true if there is a connection of the type on the side
     */
    boolean hasConnection(ConnectionType type, ForgeDirection side);

}
