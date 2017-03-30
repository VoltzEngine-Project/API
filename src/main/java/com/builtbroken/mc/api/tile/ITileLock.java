package com.builtbroken.mc.api.tile;

import net.minecraft.item.ItemStack;

/**
 * Applied to tiles that can be locked by an item
 * Created by Dark on 9/3/2015.
 */
public interface ITileLock extends ITileLockable
{
    /**
     * Checks if the tile can be locked with the itemstack
     *
     * @param stack - lock stack
     * @return true if it can be locked
     */
    boolean canLockWithItem(ItemStack stack);

    /**
     * Grabs the current lock itemstack
     *
     * @return lock ItemStack, null if nothing is locking the tile
     */
    ItemStack getLockItemStack();

    /**
     * Call this to lock the tile with the item stack, the
     * stack may be consumed depending on the functionality of
     * the tile
     *
     * @param stack - item stack, should pass canLockWithItem if the desire is to lock the tile. Should accept null
     *              as a way to clear the lock ItemStack.
     * @return what is left of the stack, or null if the stack was consumed
     */
    ItemStack lockTileWithStack(ItemStack stack);

}
