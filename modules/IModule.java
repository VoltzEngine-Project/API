package com.builtbroken.mc.api.modules;

import net.minecraft.item.ItemStack;

/**
 * Part representation of an Item that is inserted into container
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/28/2015.
 */
public interface IModule
{
    /**
     * Converts the module back into an item
     *
     * @return ItemStack
     */
    ItemStack toStack();

    /**
     * Gets the unlocalized name for this module
     *
     * @return unlocalized name "item.mod:moduleName.name"
     */
    String getUnlocalizedName();

}