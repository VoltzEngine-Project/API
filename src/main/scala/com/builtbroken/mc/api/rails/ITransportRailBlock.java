package com.builtbroken.mc.api.rails;

import com.builtbroken.mc.data.Direction;
import net.minecraft.world.World;

/**
 * Applied to blocks that are rails
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/9/2016.
 */
public interface ITransportRailBlock
{
    /**
     * Called each tick(sometimes every other tick) the cart is in contact with the rail
     * <p>
     * If you move the cart you need to call the recenter method to ensure the cart is
     * not sliding off the rail.
     *
     * @param cart  - cart that is calling this block
     * @param world
     * @param x
     * @param y
     * @param z
     * @param meta  - meta of the block
     */
    void tickRailFromCart(ITransportCart cart, World world, int x, int y, int z, int meta);

    /**
     * Called to check if the tile is currently
     * a rail that can be used. This will return
     * false normally if the tile is not actually
     * a rail but a supporting tile that uses
     * the same class that a normal rail uses.
     *
     * @return true if the rail can be used
     */
    boolean isUsableRail(World world, int x, int y, int z, int meta);

    /**
     * Side the rail is attached to
     *
     * @return
     */
    Direction getAttachedDirection(World world, int x, int y, int z, int meta);

    /**
     * Direction the rail is facing into
     *
     * @return
     */
    Direction getFacingDirection(World world, int x, int y, int z, int meta);

    /**
     * Height of the rail
     *
     * @return
     */
    float getRailHeight(World world, int x, int y, int z, int meta);
}
