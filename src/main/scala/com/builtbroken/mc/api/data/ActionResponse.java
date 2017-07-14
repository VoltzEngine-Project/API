package com.builtbroken.mc.api.data;

/**
 * Simple feedback enum for when true and false is not valid
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 7/14/2017.
 */
public enum ActionResponse
{
    /** Do the action */
    DO,
    /** Ignore this listener */
    IGNORE,
    /** Don't do the action */
    CANCEL
}
