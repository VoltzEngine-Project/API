package com.builtbroken.mc.api.explosive;

import net.minecraft.nbt.NBTTagCompound;

/**
 * An object that contains a reference to IExplosive. Carried by explosives, grenades and missile
 * entities etc.
 *
 * @author Calclavia, Darkguardsman
 */
public interface IExplosive
{
    /** Registered explosive handler */
    IExplosiveHandler getExplosive();


    /**
     * Returns the NBTTag for additonal data used
     * when spawning explosive blasts.
     *
     * @return null if no data
     */
    NBTTagCompound getAdditionalExplosiveData();

    /**
     * Gets the current size of the explosive
     *
     * @return size greater than 0
     */
    double getExplosiveSize();
}
