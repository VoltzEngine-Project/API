package com.builtbroken.mc.api.entity;

import com.builtbroken.mc.api.data.EnumProjectileTypes;
import net.minecraft.entity.IProjectile;
import net.minecraft.util.DamageSource;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/13/2017.
 */
public interface IBullet extends IEntity, IProjectile
{
    /**
     * Used by AI code to check if the bullet can be destroyed
     *
     * @param attacker     - object attacking, almost always an entity
     * @param damageSource - damage being used, may be null
     * @return true if the projectile can take damage
     */
    boolean canBeDestroyed(Object attacker, DamageSource damageSource);

    /**
     * Type of projectile
     *
     * @return
     */
    EnumProjectileTypes getProjectileType();
}
