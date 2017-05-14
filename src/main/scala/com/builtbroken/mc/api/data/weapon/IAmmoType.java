package com.builtbroken.mc.api.data.weapon;

import com.builtbroken.mc.api.data.EnumProjectileTypes;

import java.util.Collections;
import java.util.List;

/**
 * Applied to an object that is used to identify ammo types
 * Created by robert on 12/28/2014.
 */
public interface IAmmoType extends IData
{
    /**
     * Gets a list of ammo data that belongs
     * to this ammo type.
     *
     * @return list of data, never null
     */
    default List<IAmmoData> getAmmoData()
    {
        return Collections.EMPTY_LIST;
    }

    /**
     * Called to add a new ammo data object to
     * this ammo type.
     *
     * @param data - ammo data
     * @return true if added
     */
    default boolean addAmmoData(IAmmoData data)
    {
        return false;
    }

    /**
     * Primary group the ammo counts as
     * for example "Rocket", "Missile", "Bullet", "Shell"
     *
     * @return valid string value
     */
    String getAmmoCategory();

    /**
     * Gets the type of the ammo
     * for example "9mm", "12Gauge", "120mm"
     *
     * @return valid string value
     */
    String getAmmoType();

    /** Name to use for translation */
    String getUnlocalizedName();

    /**
     * Type of projectile
     *
     * @return
     */
    EnumProjectileTypes getProjectileType();
}
