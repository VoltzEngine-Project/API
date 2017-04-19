package com.builtbroken.mc.api.tile.listeners;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/17/2017.
 */
public interface IUpdateListener extends ITileEventListener
{
    default String getListenerKey()
    {
        return "update";
    }

    default void update(long ticks)
    {

    }
}
