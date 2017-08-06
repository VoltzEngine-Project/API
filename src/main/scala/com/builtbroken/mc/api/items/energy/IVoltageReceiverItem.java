package com.builtbroken.mc.api.items.energy;

import com.builtbroken.mc.api.energy.IVoltageTransmitter;
import net.minecraft.item.ItemStack;

/**
 * Applied to items that use voltage as part of there energy operation. As well is used for control over EMP damage and effects.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/5/2017.
 */
public interface IVoltageReceiverItem
{
    /**
     * Used for data feedback for players to show
     * the recommended operating voltage of the
     * device.
     *
     * @param stack - item
     * @return non-negative voltage, 0 is assumed as no support
     */
    int getOperatingVoltage(ItemStack stack);

    /**
     * Called right before energy is transfered to the device.
     *
     * @param stack      - item
     * @param voltage    - voltage level, always positive
     * @param connection - what is providing the voltage, used mainly for sanity checks and feedback. Should not
     *                   be used as part of the actual voltage application. Can be used to get Hz if needed or other power data.
     *                   The connection can be used for protection systems and other data checks.
     * @return true if voltage can be applied, as in an internal connection exists for energy to flow. Do not
     * return false if the device can't handle the energy only if no connection exists. Examples of returning false
     * are no ability for external connection both wired or wireless. In the case of wireless shield devices are one
     * of the few cases false is acceptable.
     */
    boolean onVoltageApplied(ItemStack stack, int voltage, IVoltageTransmitter connection, boolean wired);

    //Method calls for using voltage
    //canConnect - does the device allow connection
    //onVoltageApplied - does the device allow voltage connections, or did it get destroyed from the connection
    //addEnergyToStorage - actual energy transfer call

    enum VoltageResult
    {
        /** Connection exists and power can flow */
        CONNECTED,
        /** No connection exists */
        NO_CONNECTION,
        /** Device is destroyed due to voltage */
        DESTROYED,
        /** Event or settings prevent the action */
        CANCELED
    }
}
