package com.builtbroken.mc.api.event;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.world.World;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 3/30/2017.
 */
public class PositionEvent extends Event
{
    public final World world;
    public final int x, y, z;

    public PositionEvent(World world, int x, int y, int z)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
