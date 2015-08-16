package com.builtbroken.mc.api;

import net.minecraft.world.World;

/**
 * Useful interface to define that an object has a 3D location, and a defined world.
 *
 * @author DarkGuardsman
 */
public interface IWorldPosition
{
	World world();

    double x();

    double y();

    double z();
}
