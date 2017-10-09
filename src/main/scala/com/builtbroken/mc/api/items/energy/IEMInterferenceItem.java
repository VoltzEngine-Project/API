package com.builtbroken.mc.api.items.energy;

import com.builtbroken.mc.api.energy.IVoltageTransmitter;
import net.minecraft.item.ItemStack;

/**
 * Item version of {@link com.builtbroken.mc.api.energy.IEMReceptiveDevice}
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/5/2017.
 */
public interface IEMInterferenceItem
{
    /**
     * Called to apply Electromagnetic interference to a device
     *
     * @param stack               - item
     * @param host                - entity that contains the item, normal an instance of Entity or TileEntity but could be IInventory
     * @param slot                - location in inventory
     * @param held                - is the item held
     * @param distance            - distance from source
     * @param power               - how much energy hit the entity
     * @param iVoltageTransmitter - source of the energy
     * @param doAction            - true to apply effects, false to simulate
     * @return energy left after passing through entity
     */
    default double onElectromagneticRadiationApplied(ItemStack stack, Object host, int slot, boolean held, double distance, double power, IVoltageTransmitter iVoltageTransmitter, boolean doAction)
    {
        return onElectromagneticRadiationApplied(stack, distance, power, iVoltageTransmitter, doAction);
    }

    /**
     * Called to apply Electromagnetic interference to a device
     *
     * @param stack               - item
     * @param distance            - distance from source
     * @param power               - how much energy hit the entity holding the item
     * @param iVoltageTransmitter - source of the energy
     * @param doAction            - true to apply effects, false to simulate
     * @return energy left after passing through entity
     */
    default double onElectromagneticRadiationApplied(ItemStack stack, double distance, double power, IVoltageTransmitter iVoltageTransmitter, boolean doAction)
    {
        return onElectromagneticRadiationApplied(stack, power / distance, doAction);
    }

    /**
     * Called to apply Electromagnetic interference to a device
     * <p>
     * Use {@link #onElectromagneticRadiationApplied(ItemStack, double, double, IVoltageTransmitter, boolean)} for external calls
     * this is provide as a simple method
     *
     * @param stack    - item
     * @param power    - energy in watts applied to the device as a whole. Include surface area and internal circuits.
     * @param doAction - true to apply effects, false to simulate
     * @return energy left after passing through entity
     */
    default double onElectromagneticRadiationApplied(ItemStack stack, double power, boolean doAction)
    {
        return power;
    }
}
