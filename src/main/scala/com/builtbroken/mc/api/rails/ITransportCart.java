package com.builtbroken.mc.api.rails;

import com.builtbroken.mc.api.IWorldPosition;
import com.builtbroken.mc.data.Direction;

/**
 * Applied to entities that act as transport carts for cargo or other items
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/9/2016.
 */
public interface ITransportCart extends IWorldPosition
{
    /**
     * Clamps the movement of the cart and position data so the
     * cart stays on the rail.
     * <p>
     * Will cancel out motion in directions that are not valid for rail movement. This
     * includes gravity as the rails are thought of as magnetic.
     *
     * @param rail       - rail to pull data from
     * @param trueCenter - will force the cart to the very center of the rail
     */
    default void recenterCartOnRail(ITransportRail rail, boolean trueCenter)
    {
        this.recenterCartOnRail(rail.getAttachedDirection(), rail.getFacingDirection(), rail.getRailHeight(), trueCenter);
    }

    /**
     * Clamps the movement of the cart and position data so the
     * cart stays on the rail.
     * <p>
     * Will cancel out motion in directions that are not valid for rail movement. This
     * includes gravity as the rails are thought of as magnetic.
     *
     * @param rail       - rail to pull data from
     * @param trueCenter - will force the cart to the very center of the rail
     */
    default void recenterCartOnRail(ITransportRailBlock rail, int x, int y, int z, int meta, boolean trueCenter)
    {
        this.recenterCartOnRail(rail.getAttachedDirection(oldWorld(), x, y, z, meta), rail.getFacingDirection(oldWorld(), x, y, z, meta), rail.getRailHeight(oldWorld(), x, y, z, meta), trueCenter);
    }

    /**
     * Call to renter the cart based on the last know rail data.
     * This is normally internally called but might be called
     * to improve functionality if the cart is moved by mistake.
     */
    void recenterCartOnRail();

    /**
     * Clamps the movement of the cart and position data so the
     * cart stays on the rail.
     * <p>
     * Will cancel out motion in directions that are not valid for rail movement. This
     * includes gravity as the rails are thought of as magnetic.
     *
     * @param side       - side the rail is attached to
     * @param facing     - direction the movement is going into
     * @param railHeight - height of the rail the cart is on
     * @param trueCenter - will force the cart to the very center of the rail
     */
    void recenterCartOnRail(Direction side, Direction facing, double railHeight, boolean trueCenter);

    /**
     * Set the movement of the cart. Do not
     * ignore these values as some rails
     * will use this to stop the cart
     *
     * @param x
     * @param y
     * @param z
     */
    void setCartMotion(double x, double y, double z);

    /**
     * Sets the rotation of the cart
     *
     * @param yaw
     * @param pitch
     */
    void setCartRotation(float yaw, float pitch);

    /**
     * Returns the speed by which rails will try
     * to push the cart. This is an optional
     * value as the rails can ignore it. However,
     * you need to return some speed value under
     * 1m/s. Prefered is .1m/t t = 20 or 1second
     *
     * @return speed
     */
    float getDesiredPushVelocity();
}
