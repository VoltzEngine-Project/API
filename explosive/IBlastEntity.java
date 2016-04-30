package com.builtbroken.mc.api.explosive;

/**
 * Applied to blasts that spawn an entity to allow the effect to be static and duration based.
 * <p>
 * This is not designed to be used for entity that are blast containers. Instead this is designed
 * to be implemented for blasts that have duration or dynamic time based effects. For example
 * the Redmatter bomb from ICBM.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/30/2016.
 */
public interface IBlastEntity extends IBlast
{
    /**
     * Gets the entity that will spawn when the blast goes off.
     * If the entity is null the blast will trigger as
     * normal, if not then the blast will not be called. It
     * is expected that the entity will take over for the blast
     * trigger code.
     *
     * @return a new entity
     */
    IEntityBlastRunner generateBlastEntity();

    /**
     * Gets the current entity running this blast
     *
     * @return entity
     */
    IEntityBlastRunner getBlastEntity();

    /**
     * Sets the entity that will be controlling the blast
     * code
     *
     * @param entity - entity
     * @return this blast
     */
    IBlastEntity setBlastEntity(IEntityBlastRunner entity);
}
