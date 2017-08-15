package com.builtbroken.mc.api.abstraction.world;

import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.mc.imp.transform.vector.Pos;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/12/2017.
 */
public interface IPosWorld extends IPos3D
{
    IWorld world();

    default Pos toPos()
    {
        return new Pos(x(), y(), z());
    }

    default boolean isClient()
    {
        return world().isClient();
    }

    default boolean isServer()
    {
        return world().isServer();
    }
}
