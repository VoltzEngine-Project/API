package com.builtbroken.mc.api.items;

import net.minecraft.item.ItemStack;

/**
 * Applied to items that have a mass value.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/28/2016.
 */
public interface IItemHasMass
{
    /**
     * Gets the mass of the item and anything
     * contained inside of the item.
     * <p>
     * Keep in mind if the item is {@link com.builtbroken.mc.api.modules.IModule}
     * if may have sub items store inside of it and should
     * return the mass of those as well. If this doesn't work
     * use the interface {@link com.builtbroken.mc.api.modules.IModuleHasMass}
     * to get better data from the module.
     *
     * @param stack
     * @return
     */
    double getMass(ItemStack stack);
}
