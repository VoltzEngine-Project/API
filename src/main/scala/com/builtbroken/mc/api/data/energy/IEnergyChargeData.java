package com.builtbroken.mc.api.data.energy;

/**
 * Data about a device used internally for information, used as a static lookup for a device group and not a single device
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/7/2017.
 */
public interface IEnergyChargeData
{
    /**
     * Gets the input limit of energy
     * <p>
     * 0 should allow connections but no energy
     * -1 should not allow connections
     *
     * @return energy
     */
    int getInputEnergyLimit();

    /**
     * Gets the output limit of energy
     * <p>
     * 0 should allow connections but no energy
     * -1 should not allow connections
     *
     * @return energy
     */
    int getOutputEnergyLimit();
}
