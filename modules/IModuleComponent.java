package com.builtbroken.mc.api.modules;

/**
 * Applied to objects are act as part of a module
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/22/2016.
 */
public interface IModuleComponent
{
    /**
     * Called when the trigger is installed
     *
     * @param module
     */
    void addedToDevice(IModule module);

    /**
     * Called when the trigger is removed
     *
     * @param module
     */
    void removedFromDevice(IModule module);
}
