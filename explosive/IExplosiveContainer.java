package com.builtbroken.mc.api.explosive;

import net.minecraft.item.ItemStack;

/**
 * Container that holds an explosive item
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 2/12/2016.
 */
public interface IExplosiveContainer
{
    /**
     * Gets the current explosive
     *
     * @return item, may be null
     */
    ItemStack getExplosiveStack();

    /**
     * Sets the contained explosive item to the stack
     * provided. Should clone the stack and override
     * the existing explosive.
     * <p/>
     * Use {@link #getExplosiveStack()}
     * to confirm stacksize set.
     *
     * @param stack - item to set as the explosive.
     * @return true if the stack was accepted
     */
    boolean setExplosiveStack(ItemStack stack);
}
