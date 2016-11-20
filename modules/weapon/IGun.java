package com.builtbroken.mc.api.modules.weapon;

import com.builtbroken.mc.api.data.weapon.IGunData;

/**
 * An instance of a gun
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/20/2016.
 */
public interface IGun extends IWeapon
{
    IGunData getGunData();
}
