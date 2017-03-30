package com.builtbroken.mc.api.modules;

import net.minecraft.entity.Entity;

/**
 * Applied to modules that accept entity driven actions in order to function.
 *
 * DO NOT IMPLEMENT directly on a class, this is designed to be added to another interface
 * this way there is no risk of an invalid generic.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/22/2016.
 */
public abstract interface IModuleEntityDriven<E extends Entity> extends IModule
{
    /**
     * Called each time
     * {@link Entity#onUpdate()}
     * or similar is called
     *
     * @param entity - entity containing this
     *               module directly or indirectly
     *               threw another module
     */
    void update(E entity);
}
