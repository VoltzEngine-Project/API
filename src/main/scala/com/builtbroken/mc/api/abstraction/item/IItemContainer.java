package com.builtbroken.mc.api.abstraction.item;

import com.builtbroken.mc.data.Direction;

/**
 * Applied to an object that contains slots for items to be stored
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/16/2017.
 */
public interface IItemContainer
{
    /**
     * Called to get the slot at the index
     *
     * @param index
     * @return
     */
    IItemSlot getSlot(int index);

    /**
     * Called to add an item to the container
     *
     * @param item     - item to add
     * @param doAction - true to do the action, false to simulate (check for space)
     * @return what is left of the item, null if all items were consumed
     */
    IItem addItem(IItem item, boolean doAction);

    /**
     * Called to check if the container can accept the item
     *
     * @param item - check object
     * @param slot - slot index
     * @param side - side of the container, {@link Direction#UNKNOWN} or null is considered an internal call
     * @return true if can stored
     */
    default boolean canStoreItem(IItem item, int slot, Direction side)
    {
        return canStoreItem(item, side) && getSlot(slot) != null && getSlot(slot).canStoreItem(item, side);
    }

    /**
     * Called to check if something can remove an item from the container
     *
     * @param item - check object
     * @param slot - slot index
     * @param side - side of the container, {@link Direction#UNKNOWN} or null is considered an internal call
     * @return true if can remove
     */
    default boolean canRemoveItem(IItem item, int slot, Direction side)
    {
        return canRemoveItem(item, side) && getSlot(slot) != null && getSlot(slot).canRemoveItem(item, side);
    }

    /**
     * Called to check if the container can accept the item
     *
     * @param item - check object
     * @param side - side of the container, {@link Direction#UNKNOWN} or null is considered an internal call
     * @return true if can stored
     */
    default boolean canStoreItem(IItem item, Direction side)
    {
        return true;
    }

    /**
     * Called to check if something can remove an item from the container
     *
     * @param item - check object
     * @param side - side of the container, {@link Direction#UNKNOWN} or null is considered an internal call
     * @return true if can remove
     */
    default boolean canRemoveItem(IItem item, Direction side)
    {
        return true;
    }

    /**
     * Called when the inventory has changed from an external or internal source
     *
     * @param slot - slot that has changed
     * @param prev - item that was previously recorded in the slot
     * @param item - new entry for the slot
     */
    default void onInventoryChanged(int slot, IItem prev, IItem item)
    {
    }
}
