package com.builtbroken.mc.api.modules.weapon;

import com.builtbroken.mc.api.data.weapon.IAmmoData;
import com.builtbroken.mc.api.data.weapon.IGunData;
import com.builtbroken.mc.api.modules.IModule;

/**
 * An instance of a gun
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/20/2016.
 */
public interface IGun extends IWeapon, IModule
{
    /**
     * Data the drives most of the properties
     * of the weapon.
     *
     * @return data
     */
    IGunData getGunData();

    /**
     * Gets the current round chambered to fire on the
     * next trigger pull.
     * <p>
     * For weapons with multiple shots still return
     * only one value. With that value being the first
     * round that will be sent down range.
     *
     * @return
     */
    IAmmoData getChamberedRound();

    /**
     * Current clip inside of the weapon.
     * <p>
     * In some cases this may be an internal
     * clip that can not be removed.
     *
     * @return clip
     */
    IClip getLoadedClip();
}
