package com.builtbroken.mc.api.abstraction.item;

import com.builtbroken.mc.data.Direction;

/**
 * Location in an inventory for storing an {@link IItem}
 *
 * This is used to both store items and control logic. The logic is used
 * by machines, inventories, save/load code, and GUIs. So take care in
 * how the logic is crafted as one of those can fail causing all parts
 * to fail.
 *
 * Save/Load will bypass most logic for checks to prevent common mistakes. *
 *
 * GUIs will call can store/remove item using internal calls. In this future
 * this may be changed to provide more details including the entity accessing
 * the GUI.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/16/2017.
 */
public interface IItemSlot
{
    /**
     * Called to see if the slot can accept the item
     * @param item - item to store
     * @param side - side being access (unknown, internal, and null should allow access almost always)
     * @return true if can remove
     */
    default boolean canStoreItem(IItem item, Direction side)
    {
        return true;
    }

    /**
     * Called to see if the slot will release the item
     * @param item - item to remove
     * @param side - side being access (unknown, internal, and null should allow access almost always)
     * @return true if can remove
     */
    default boolean canRemoveItem(IItem item, Direction side)
    {
        return true;
    }

    IItem getItem();
}
