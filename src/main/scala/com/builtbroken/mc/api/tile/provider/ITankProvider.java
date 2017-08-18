package com.builtbroken.mc.api.tile.provider;

import com.builtbroken.mc.data.Direction;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidTank;

/**
 * Allows access to an internal fluid tank
 * <p>
 * Assume {@link Direction#UNKNOWN} is an internal call
 * <p>
 * Created by Dark on 8/9/2015.
 */
@Deprecated //Being replaced by node/capability system
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
    default IFluidTank getTankForFluid(Direction direction, Fluid fluid)
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
    default boolean canFill(Direction from, Fluid fluid)
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
    default boolean canDrain(Direction from, Fluid fluid)
    {
        return getTankForFluid(from, fluid) != null;
    }
}
