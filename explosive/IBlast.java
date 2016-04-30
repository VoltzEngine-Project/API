package com.builtbroken.mc.api.explosive;

import com.builtbroken.mc.api.IWorldPosition;
import com.builtbroken.mc.api.edit.IWorldChangeAction;
import com.builtbroken.mc.api.event.TriggerCause;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Applied to {@link IWorldChangeAction} that are considered as explosive blast effects
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/30/2016.
 */
public interface IBlast extends IWorldChangeAction, IWorldPosition
{
    /**
     * Sets the size or yield of the blast.
     *
     * @param size - size in meters radius of the blast
     * @return this blast
     */
    IBlast setYield(double size);

    /**
     * Sets the energy cost of the blast. Normally this
     * is set by the data stored in {@link #setAdditionBlastData(NBTTagCompound)}
     * but can optionally bet set by this method
     *
     * @param f - energy cost per block, used to estimate amount
     *          of energy to volume of the blast. Is not the actual
     *          cost per block value.
     * @return this blast
     */
    IBlast setEnergyPerBlock(float f);

    /**
     * Sets the trigger cause of the blast
     *
     * @param cause - what triggered the blast
     * @return this blast
     */
    IBlast setCause(final TriggerCause cause);

    /**
     * Sets the addition data that was stored in the explosive
     * item for triggering the blast.
     *
     * @param additionBlastData - nbt data, saved in the item as exData
     * @return this blast
     */
    IBlast setAdditionBlastData(NBTTagCompound additionBlastData);
}
