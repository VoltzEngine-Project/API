package com.builtbroken.mc.api.tile.multiblock;

import com.builtbroken.mc.api.abstraction.world.IPosWorld;

/**
 * Supplies the data for a multi-block
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/2/2018.
 */
public interface IMultiBlockProvider extends IPosWorld
{
    /**
     * Gets the layout handler for the multiblock
     *
     * @return layout, or null if current state doesn't have a multiblock
     */
    IMultiBlockLayout getMultiBlockLayout();

    /**
     * gets the handler for the current position in the multi-block
     *
     * @param tile - multi-block component
     * @return handler
     */
    IMultiBlockHandler getMultiBlockHandler(IMultiTile tile);
}
