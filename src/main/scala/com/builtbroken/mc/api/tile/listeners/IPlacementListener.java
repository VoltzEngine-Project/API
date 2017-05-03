package com.builtbroken.mc.api.tile.listeners;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
     * @return true if can place
     */
    default boolean canPlaceAt()
    {
        return true;
    }

    /**
     * Called to see if the tile can be placed
     *
     * @param entity - entity trying to place the block, only
     *               used for com.builtbroken.mc.framework.block.ItemBlockBase
     * @return true if can place
     */
    default boolean canPlaceAt(Entity entity)
    {
        return canPlaceAt();
    }

    /**
     * Called to check if the block can be replace and be placed at the location.
     *
     * @param world
     * @param x
     * @param y
     * @param z
     * @param side
     * @param stack
     * @return
     */
    default boolean canReplace(World world, int x, int y, int z, int side, ItemStack stack)
    {
        return true;
    }

    @Override
    default String getListenerKey()
    {
        return "placement";
    }
}
