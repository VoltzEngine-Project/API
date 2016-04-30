package com.builtbroken.mc.api.explosive;

import java.util.List;

/**
 * Applied to entities that are blast objects and run blast code. Make sure
 * to call or duplicate the existing blast running code. This way
 * blasts run as effectively as possible.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/30/2016.
 */
public interface IEntityBlastRunner
{
    /**
     * Gets a list of all blasts currently
     * being run by this entity
     *
     * @return list, or empty list
     */
    List<IBlast> getRunningBlasts();

    /**
     * Called to terminate this entity, its
     * blasts, and any other running actions
     */
    void killBlastRunner();
}
