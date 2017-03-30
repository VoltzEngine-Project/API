package com.builtbroken.mc.api.data.weapon;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/20/2016.
 */
public interface IData
{
    /**
     * Unique ID used to save the data
     * to file and restore it to the
     * same class object
     *
     * @return unique ID
     */
    String getUniqueID();

    /**
     * Gets the type of data
     * <p>
     * This is basically a unique name
     * for the class or data set.
     * <p>
     * Examples are {Gun, Ammo, AmmoType, Clip}
     *
     * @return unique type
     */
    String getDataType();

    /**
     * Override for changing the string
     * displayed to users and in GUIs
     * when showing this data
     *
     * @return
     */
    default String getDisplayString()
    {
        return toString();
    }
}
