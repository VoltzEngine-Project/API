package com.builtbroken.mc.api.modules.weapon;

import com.builtbroken.mc.api.data.weapon.IAmmoData;
import com.builtbroken.mc.api.data.weapon.IClipData;

import java.util.Stack;

/**
 * An instant of a clip that contains ammo and other data
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/20/2016.
 */
public interface IClip
{
    /**
     * Data that drives most of the properties of the clip
     *
     * @return data
     */
    IClipData getClipData();

    /**
     * How much ammo is contained in the clip
     *
     * @return ammo
     */
    int getAmmoCount();

    /**
     * Current stack of ammo in the clip
     *
     * @return stack (Last in, First Out... same way a real clip works)
     */
    Stack<IAmmoData> getAmmo();

    /**
     * Called to consume ammo from the clip.
     * <p>
     * Make sure to call this instead of calling
     * {@link #getAmmo()) then {@link Stack#pop()}
     * as the changes may not be saved correctly
     *
     * @param count - amount of ammo to consumed, normally
     *              this should be 1 but might be more for faster firing weapons
     */
    void consumeAmmo(int count);
}
