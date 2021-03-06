package com.builtbroken.mc.api.items.listeners;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/8/2017.
 */
public interface IItemWithListeners
{
    /**
     * Called to get the listeners for a tile
     *
     * @param key - unique group ID
     * @return list of listeners or empty list
     */
    List<IItemEventListener> getItemListeners(String key);
}
