package com.builtbroken.mc.api.event;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 3/30/2017.
 */
public class PositionEvent extends Event
{
    public final World world;
    public final int x, y, z; //TODO replace with BlockPos

    public PositionEvent(World world, int x, int y, int z)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
