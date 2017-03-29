package com.builtbroken.mc.api.data.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Information about an ammo
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/20/2016.
 */
public interface IAmmoData extends IData
{
    /**
     * Gets the type of ammo this is
     *
     * @return type
     */
    IAmmoType getAmmoType();

    /**
     * Gets the ItemStack that represents
     * this ammo data.
     *
     * @return
     */
    ItemStack toStack();

    /**
     * Gets the base damage without modifiers
     *
     * @return value > 0
     */
    float getBaseDamage();

    /**
     * How fast does the projectile that
     * this ammo represents travel when
     * fired by the weapon.
     * <p>
     * This is the base speed driven by
     * the casing of gunpowder (Or other content)
     * that actually moves the projectile.
     * <p>
     * Speed can be modified by the weapon's
     * modifications and damage.
     * <p>
     * Speed is used to determine if an entity
     * or raytrace is to be used. As well how
     * much energy is transferred into the entity
     * impacted.
     *
     * @return speed in m/s or -1 to ignore for special or default handling
     */
    default float getProjectileVelocity()
    {
        return -1;
    }

    /**
     * Called to apply the damage to the entity
     *
     * @param shooter  - what shot the round, or the round itself
     * @param entity   - what was hit by the round
     * @param hitX     - round pos
     * @param hitY     - round pos
     * @param hitZ     - round pos
     * @param velocity - how fast the projectile is going
     * @return should the projectile stop & die
     */
    default boolean onImpactEntity(Entity shooter, Entity entity, double hitX, double hitY, double hitZ, float velocity)
    {
        return true;
    }

    /**
     * Called when the round hits the ground
     *
     * @param shooter  - what shot the round, or the round itself
     * @param world    - world
     * @param x        - block pos
     * @param y        - block pos
     * @param z        - block pos
     * @param hitX     - round pos
     * @param hitY     - round pos
     * @param hitZ     - round pos
     * @param velocity - how fast the projectile is going
     * @return should the projectile stop & die
     */
    default boolean onImpactGround(Entity shooter, World world, int x, int y, int z, double hitX, double hitY, double hitZ, float velocity)
    {
        return true;
    }
}
