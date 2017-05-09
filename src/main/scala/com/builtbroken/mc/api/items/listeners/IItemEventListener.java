package com.builtbroken.mc.api.items.listeners;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/8/2017.
 */
public interface IItemEventListener
{
    /**
     * Gets the ID(s) of the listener group
     * this listener should be registered with
     *
     * @return unique key for the group
     */
    List<String> getListenerKeys();
}
