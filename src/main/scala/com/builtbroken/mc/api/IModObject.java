package com.builtbroken.mc.api;

/**
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
    String uniqueContentID();

    /**
     * Content type (Tile, Entity, Block, Item, Gun, Ammo)
     *
     * @return
     */
    String contentType();

    /**
     * Mod's register ID/Domain
     *
     * @return
     */
    String modID();
}
