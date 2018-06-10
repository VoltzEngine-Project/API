package com.builtbroken.mc.api.tile.connection;

import com.builtbroken.mc.api.tile.ConnectionType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Applied to tile or node to allow connections to be adjusted
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 6/9/2018.
 */
public interface IAdjustableConnections
{
    /**
     * Called when a tool is used on the machine
     *
     * @param player         - player holding the tool
     * @param stack          - tool
     * @param side           - face of the machine clicked (pointing out of the machine)
     * @param color          - color of the tool
     * @param connectionType - type of connection being adjusted
     * @param hitX           - exact hit spot
     * @param hitY           - exact hit spot
     * @param hitZ           - exact hit spot
     * @return true to consume interaction, false will trigger default logic
     */
    default boolean onToolUsed(ItemStack stack, EntityPlayer player, ConnectionColor color, ConnectionType connectionType, ForgeDirection side, float hitX, float hitY, float hitZ)
    {
        return false; //this method is optional, by default tools will call cycleConnection
    }

    /**
     * Can the side of the machine support a connection of the type and color
     *
     * @param connectionType - type
     * @param color          - color, grey is considered generic
     * @param side           - side (pointing out of the machine)
     * @return true if the connection is supported (return true if possible, not if enabled)
     */
    default boolean supportsConnection(ConnectionType connectionType, ConnectionColor color, ForgeDirection side)
    {
        return false;
    }

    /**
     * Checks if the connection is enabled for the side
     *
     * @param connectionType - type
     * @param color          - color, grey is considered generic
     * @param side           - side (pointing out of the machine)
     * @return true if the connection is enabled
     */
    default boolean isConnectionEnabled(ConnectionType connectionType, ConnectionColor color, ForgeDirection side)
    {
        return false;
    }

    /**
     * Called to cycle the connection to the next type
     *
     * @param connectionType - type
     * @param color          - color, grey is considered generic
     * @param side           - side (pointing out of the machine)
     * @return true if the connection is enabled
     */
    default String cycleConnection(ConnectionType connectionType, ConnectionColor color, ForgeDirection side)
    {
        return null;
    }
}
