package com.builtbroken.mc.api.tile.listeners;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/3/2017.
 */
public interface IPlacementListener extends ITileEventListener
{
    /**
     * Called when the tile is added
     */
    default void onAdded()
    {

    }

    /**
     * called when the tile is placed by an entity
     *
     * @param entityLivingBase
     * @param stack
     */
    default void onPlacedBy(EntityLivingBase entityLivingBase, ItemStack stack)
    {

    }

    /**
     * Called after the tile has been placed
     *
     * @param meta
     */
    default void onPostPlaced(int meta)
    {

    }

    /**
     * Called to see if the placement should be blocked
     *
     * @param side
     * @return
     */
    default boolean canPlaceOnSide(int side)
    {
        return true;
    }

    /**
     * Called to see if the tile can be placed
     *
     * @return
     */
    default boolean canPlaceAt()
    {
        return true;
    }

    @Override
    default String getListenerKey()
    {
        return "placement";
    }
}
