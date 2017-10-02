package com.builtbroken.mc.api;

/**
 * Applied to objects produced and owned by a mod
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/23/2017.
 */
public interface IModObject
{
    /**
     * Unique string based ID that is only
     * used by this object in it's content group
     *
     * @return
     */
    @Deprecated
    default String uniqueContentID()
    {
        return getUniqueID();
    }


    /**
     * Reference ID for the content
     * <p>
     * Mod:ID
     *
     * @return
     */
    default String getContentID()
    {
        return getMod() + ":" + getUniqueID();
    }

    /**
     * Unique string based ID that is only
     * used by this object in it's content group
     *
     * @return unique id of the item, can be null
     */
    default String getUniqueID()
    {
        return null;
    }


    /**
     * Content type (Tile, Entity, Block, Item, Gun, Ammo)
     *
     * @return type or content for unknown, can be null
     */
    default String contentType()
    {
        return "content";
    }


    /**
     * Gets the mod this content belongs to
     *
     * @return mod domain ID, can be null
     */
    default String getMod()
    {
        return null;
    }

    @Deprecated
    default String modID()
    {
        return getMod();
    }
}
