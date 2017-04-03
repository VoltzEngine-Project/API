package com.builtbroken.mc.api.tile.provider;

import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidTank;

/**
 * Allows access to an internal fluid tank
 * <p>
 * Assume {@link ForgeDirection#UNKNOWN} is an internal call
 * <p>
 * Created by Dark on 8/9/2015.
 */
public interface ITankProvider
{
    /**
     * Gets fluid tank for the type, null
     * should return default tank.
     *
     * @param fluid - fluid to match, can be null
     * @return tanks, or null if can't accept fluid of type
     */
    default IFluidTank getTankForFluid(Fluid fluid)
    {
        return null;
    }

    /**
     * Gets fluid tank for the type, null
     * should return default tank.
     *
     * @param direction - side of the tile being access
     * @param fluid     - fluid to match, can be null
     * @return tanks, or null if can't accept fluid of type
     */
    default IFluidTank getTankForFluid(ForgeDirection direction, Fluid fluid)
    {
        return getTankForFluid(fluid);
    }

    /**
     * Check if the tile can be filled
     *
     * @param from
     * @param fluid
     * @return
     */
    default boolean canFill(ForgeDirection from, Fluid fluid)
    {
        return getTankForFluid(from, fluid) != null;
    }

    /**
     * Checks if the tile can be drained
     *
     * @param from
     * @param fluid
     * @return
     */
    default boolean canDrain(ForgeDirection from, Fluid fluid)
    {
        return getTankForFluid(from, fluid) != null;
    }
}
