package com.builtbroken.mc.api.modules;

import java.util.List;

/**
 * Container that holds modules, used more for internal tracking
 * and interaction.
 * <p>
 * Created by robert on 12/28/2014.
 */
public interface IModuleContainer
{
    /**
     * Can the module be installed into this module container
     *
     * @param module - instance of the module
     * @return true if it can be installed
     */
    boolean canInstallModule(IModule module);

    /**
     * Called to install the module into the container
     *
     * @param module - instance of the module
     * @return true if it was installed
     */
    boolean installModule(IModule module);

    /**
     * Gets a lit of all modules contained inside
     * of this container.
     *
     * @return
     */
    List<IModule> getSubModules();
}
