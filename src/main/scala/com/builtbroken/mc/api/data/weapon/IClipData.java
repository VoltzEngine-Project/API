package com.builtbroken.mc.api.data.weapon;

/**
 * Information about a clip in general but not the actual clip itself
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/20/2016.
 */
public interface IClipData extends IData
{
    /**
     * How this clip is loaded into the weapon.
     * <p>
     * Keep in mind this may be used for both internal clips
     * and external clips.
     *
     * @return reload type
     */
    ReloadType getReloadType();

    /**
     * Gets the ammo type that can fit into the clip
     *
     * @return ammo type
     */
    IAmmoType getAmmoType();

    /**
     * Max number of rounds this clip can hold
     *
     * @return value > 0
     */
    int getMaxAmmo();
}
