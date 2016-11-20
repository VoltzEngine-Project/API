package com.builtbroken.mc.api.data.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
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
     * Gets the base damage without modifiers
     *
     * @return value > 0
     */
    float getBaseDamage();

    /**
     * Called to apply the damage to the entity
     *
     * @param shooter - what shot the round, or the round itself
     * @param entity  - what was hit by the round
     */
    void onImpactEntity(Entity shooter, Entity entity);

    /**
     * Called when the round hits the ground
     *
     * @param world - world
     * @param x     - block pos
     * @param y     - block pos
     * @param z     - block pos
     * @param hitX  - round pos
     * @param hitY  - round pos
     * @param hitZ  - round pos
     */
    void onImpactGround(World world, int x, int y, int z, double hitX, double hitY, double hitZ);
}
