package com.builtbroken.mc.api.energy;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/5/2017.
 */
public interface IEMReceptiveDevice
{
    /**
     * Called to apply Electromagnetic interference to a device
     *
     * @param distance            - distance from source
     * @param power               - energy applied by EM source at location
     * @param iVoltageTransmitter - source of the energy
     * @param doAction            - if true do edits to tile and world, false do calculations only. This is used
     *                            by threaded actions to calculate logic before effecting the world.
     * @return power absorbed by the device
     */
    default double onElectromagneticRadiationApplied(IVoltageTransmitter iVoltageTransmitter, double distance, double power, boolean doAction) //TODO maybe include side hit?
    {
        return onElectromagneticRadiationApplied(power, doAction);
    }

    /**
     * Called to apply Electromagnetic interference to a device
     * <p>
     * Use {@link #onElectromagneticRadiationApplied(IVoltageTransmitter, double, double, boolean)} for external calls
     * this is provide as a simple method
     *
     * @param power    - energy in watts applied to the device as a whole. Include surface area and internal circuits.
     * @param doAction - if true do edits to tile and world, false do calculations only. This is used
     *                 by threaded actions to calculate logic before effecting the world.
     * @return power absorbed by the device
     */
    double onElectromagneticRadiationApplied(double power, boolean doAction);
}
