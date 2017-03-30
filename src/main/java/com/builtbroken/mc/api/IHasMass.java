package com.builtbroken.mc.api;

/**
 * Applied to entities that have a mass
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/27/2016.
 */
public interface IHasMass
{
    /**
     * Weight of the entity
     * including everything attached to
     * or part of the entity
     * <p>
     * Such as Inventory, Armor, Weapons
     * Modules, implants, etc
     *
     * @return in grams
     */
    double getMass();
}
