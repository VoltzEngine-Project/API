package com.builtbroken.mc.api.data.weapon;

/**
 * Enum of reload types for weapons
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/16/2016.
 */
public enum ReloadType
{
    /** Weapons that feed ammo from the front (Muskets, RPG, Motor, Cannons) */
    FRONT_LOADED,
    /** Weapons that are feed ammo from the back and only have 1 shot (Bolt actions, Civil war era breach rifles, Breach loaded cannons) */
    BREACH_LOADED,
    /** Weapons that contain an internal clip and are hand feed (Shot guns, Revolvers, Grenade Launchers) */
    HAND_FEED,
    /** Anything that slots something into the weapon (Most weapons) */
    CLIP,
    /** Same as clip but with slightly different handling (Keep in mind belts in boxes or drums are considered clips) */
    BELT;

    /**
     * Gets a type by meta
     *
     * @param clipType
     * @return
     */
    public static ReloadType get(int clipType)
    {
        if (clipType >= 0 && clipType < values().length)
        {
            return values()[clipType];
        }
        return BREACH_LOADED;
    }

    /**
     * Gets a type by string value
     *
     * @param string
     * @return
     */
    public static ReloadType get(String string)
    {
        for (ReloadType type : values())
        {
            if (type.name().equalsIgnoreCase(string))
            {
                return type;
            }
        }
        return CLIP;
    }
}
