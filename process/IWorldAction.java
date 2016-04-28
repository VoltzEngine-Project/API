package com.builtbroken.mc.api.process;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.world.World;

/**
 * An action that needs to run during world tick and not outside the world tick
 * <p>
 * Mainly used for multithreading processes that can't edit the world while it's ticking
 * <p>
 * You need  to implement {@link Object#equals(Object)} method in order for the action
 * to function correctly.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/27/2016.
 */
public interface IWorldAction
{
    /**
     * Called to run the world action each tick
     * of the world.
     *
     * @param world -current world to run the action
     * @param side
     */
    void runQue(World world, Side side);

    /**
     * Called to check if the que is done
     *
     * @return true if done
     */
    boolean isQueDone();
}
