package com.builtbroken.mc.api.data.weapon;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 7/8/2018.
 */
public enum BarrelDamageMode
{
    /**
     * Damage applied is for all current barrels. When used its assumed barrels are render only. This
     * means damage is calculated once and cast from the center of the weapon. Then each barrel is
     * triggered to render effects without applying damage.
     */
    ALL,
    /**
     * Damage applied is for each barrel. When used each barrel fires on its own, consuming a
     * single round of ammo per shot, tracing or spawning an entity per shot, and applying damage per hit.
     * Effectively each barrel acts as a single gun.... aka how it works in real life.
     */
    INDIVIDUAL
}
