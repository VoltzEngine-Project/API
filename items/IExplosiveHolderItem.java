package com.builtbroken.mc.api.items;

import com.builtbroken.mc.api.explosive.IExplosiveHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Anything that can contain an explosive in a way that the explosive can be inserted/set
 * Created by robert on 2/1/2015.
 */
public interface IExplosiveHolderItem extends IExplosiveItem
{
    /**
     * Sets what explosive the container uses
     *
     * @param ex   - registered explosive handler
     * @param size - size, or load of the explosive
     * @param nbt  - data used to trigger the explosive
     * @return true if it was set, false if it was rejected
     */
    boolean setExplosive(ItemStack stack, IExplosiveHandler ex, double size, NBTTagCompound nbt);

    /**
     * Returns the NBTTag for additonal data used
     * when spawning explosive blasts.
     *
     * @return null if no data
     */
    NBTTagCompound getAdditionalExplosiveData(ItemStack stack);

    /**
     * Gets the current size of the explosive
     *
     * @return size greater than 0
     */
    double getExplosiveSize(ItemStack stack);
}