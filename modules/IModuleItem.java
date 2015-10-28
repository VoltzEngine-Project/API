package com.builtbroken.mc.api.modules;

import net.minecraft.item.ItemStack;

/** Applied to {@link net.minecraft.item.Item}
 * Created by robert on 12/28/2014.
 */
public interface IModuleItem
{
    /** Gets the module that this item represents */
    IModule getModule(ItemStack stack);
}
