package com.builtbroken.mc.api.energy;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/5/2017.
 */
public interface IVoltageTransmitter
{
    /**
     * Pressure of the power
     *
     * @return
     */
    default int getVoltage()
    {
        return 120;
    }

    /**
     * Refresh rate of power cycle
     *
     * @return
     */
    default int getVoltageHz()
    {
        return 60;
    }

    /**
     * Total amount of power being released by
     * this device on all sides and connections
     *
     * @return
     */
    double getTotalVoltagePower();
}
