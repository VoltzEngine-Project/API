package com.builtbroken.mc.api.data.weapon;

import com.builtbroken.jlib.data.vector.IPos3D;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 7/9/2018.
 */
public interface IGunBarrelData
{
    /**
     * Is there any data loaded for use
     *
     * @return true if there is data for methods to function
     */
    default boolean hasData()
    {
        return true;
    }

    /**
     * Gets the next barrel index to fire
     *
     * @param index - current index
     * @return index
     */
    int nextBarrelIndex(int index);

    /**
     * Gets the offset of the barrel from
     * the gun's main firing point
     *
     * @param index - index of the barrel
     * @return position offset
     */
    IPos3D getBarrelOffset(int index);

    /**
     * Mode for applying damage
     *
     * @return barrel mode
     */
    BarrelDamageMode getDamageMode();

    /**
     * Mode for firing barrels
     *
     * @return barrel mode
     */
    BarrelFireMode getFireMode();

    /**
     * Gets all barrel index in the group
     *
     * @param index -1 is for all, else index is group id
     * @return list of barrels
     */
    int[] getBarrelsInGroup(int index);
}
