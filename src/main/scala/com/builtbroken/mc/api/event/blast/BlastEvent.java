package com.builtbroken.mc.api.event.blast;

import com.builtbroken.mc.api.explosive.IBlast;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Prefab for all events involving a blast or explosion
 * <p>
 * Keep in mind that the creation of a blast is tied to {@link com.builtbroken.mc.api.event.WorldChangeActionEvent}
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/17/2016.
 */
public abstract class BlastEvent extends Event
{
    public final IBlast blast;

    public BlastEvent(IBlast blast)
    {
        this.blast = blast;
    }
}
