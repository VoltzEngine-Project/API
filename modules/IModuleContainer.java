package com.builtbroken.mc.api.modules;

import net.minecraft.item.ItemStack;

/**
 * Container that holds modules, used more for internal tracking
 * and interaction. Currently doesn't support dynamic replacement
 * of one container for another. In other words this can't
 * be used to make a custom missile casing currently. Rather
 * its only used to create common interaction.
 * <p/>
 * Created by robert on 12/28/2014.
 */
public interface IModuleContainer
{
    /**
     * Can the module be installed into this module container
     *
     * @param stack  - stack that is the module
     * @param module - instance of the module
     * @return true if it can be installed
     */
    boolean canInstallModule(ItemStack stack, IModule module);

    /**
     * Called to install the module into the container
     *
     * @param stack  - stack that is the module
     * @param module - instance of the module
     * @return true if it was installed
     */
    boolean installModule(ItemStack stack, IModule module);
}
