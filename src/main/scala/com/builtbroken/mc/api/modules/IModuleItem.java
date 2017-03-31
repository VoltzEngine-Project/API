package com.builtbroken.mc.api.modules;

import net.minecraft.item.ItemStack;

/**
 * Applied to {@link net.minecraft.item.Item} that contain {@link IModule} as
 * part of the {@link ItemStack} data structure.
 * <p>
 * It is suggested to use metadata when possible but NBT if the data
 * is more complex then a few values. Especially if the values can
 * be changed often and are user configured. As the amount of time to
 * read NBT is normally less then dozens of IF or Switch statements.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 *
 * Created by Dark(DarkGuardsman, Robert) on 12/28/2014.
 */
public interface IModuleItem
{
    /**
     * Gets the module contained in the ItemStack's data
     *
     * @param stack - ItemStack that is this module item
     * @return a module instance
     */
    IModule getModule(ItemStack stack);
}
