package com.builtbroken.mc.api.items.energy;

import com.builtbroken.mc.api.energy.IVoltageTransmitter;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/5/2017.
 */
public interface IEMInterferenceItem
{
    /**
     * Called to apply Electromagnetic interference to a device
     *
     * @param stack               - item
     * @param entity              - entity holding the item
     * @param slot                - location in inventory
     * @param held                - is the item held
     * @param distance            - distance from source
     * @param strength            - how powerful the signal is, calculated via line of sight from the source
     * @param iVoltageTransmitter - source of the energy
     */
    default void onElectromagneticRadiationApplied(ItemStack stack, Entity entity, int slot, boolean held, double distance, float strength, IVoltageTransmitter iVoltageTransmitter)
    {
        onElectromagneticRadiationApplied(stack, distance, strength, iVoltageTransmitter);
    }

    /**
     * Called to apply Electromagnetic interference to a device
     *
     * @param stack               - item
     * @param distance            - distance from source
     * @param strength            - how powerful the signal is, calculated via line of sight from the source
     * @param iVoltageTransmitter - source of the energy
     */
    default void onElectromagneticRadiationApplied(ItemStack stack, double distance, float strength, IVoltageTransmitter iVoltageTransmitter)
    {
        double power = iVoltageTransmitter.getTotalVoltagePower();
        onElectromagneticRadiationApplied(stack, power / distance);
    }

    /**
     * Called to apply Electromagnetic interference to a device
     * <p>
     * Use {@link #onElectromagneticRadiationApplied(ItemStack, double, float, IVoltageTransmitter)} for external calls
     * this is provide as a simple method
     *
     * @param stack - item
     * @param power - energy in watts applied to the device as a whole. Include surface area and internal circuits.
     */
    void onElectromagneticRadiationApplied(ItemStack stack, double power);
}
