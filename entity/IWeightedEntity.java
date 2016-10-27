package com.builtbroken.mc.api.entity;

import net.minecraft.entity.Entity;

/**
 * Applied to entities that have a mass
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/27/2016.
 */
public interface IWeightedEntity
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
    double getEntityMass();

    /**
     * Helper method to simplify interaction with this interface
     * and registries
     *
     * @param entity - entity to get the mass from
     * @return mass in grams, -1 if the entity has not mass
     * given or registered.
     */
    public static double getMassOfEntity(Entity entity)
    {
        if(entity instanceof IWeightedEntity)
        {
            double mass = ((IWeightedEntity) entity).getEntityMass();
            if(mass != -1)
            {
                return mass;
            }
        }
        //TODO implement registry
        return -1;
    }
}
