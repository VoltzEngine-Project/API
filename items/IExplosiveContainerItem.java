package com.builtbroken.mc.api.items;

import net.minecraft.item.ItemStack;

/**
 * Container that holds an explosive item
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 2/12/2016.
 */
public interface IExplosiveContainerItem
{
    /**
     * Gets the current explosive
     *
     * @param stack - this item
     * @return item, may be null
     */
    ItemStack getExplosiveStack(ItemStack stack);

    /**
     * Sets the contained explosive item to the stack
     * provided. Should clone the stack and override
     * the existing explosive.
     * <p/>
     * Use {@link #getExplosiveStack(ItemStack stack)}
     * to confirm stacksize set.
     *
     * @param stack     - this item
     * @param explosive - item to set as the explosive.
     * @return true if the stack was accepted
     */
    boolean setExplosiveStack(ItemStack stack, ItemStack explosive);
}
