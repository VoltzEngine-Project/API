package com.builtbroken.mc.api.entity;

import com.builtbroken.mc.api.IWorldPosition;
import com.builtbroken.mc.api.data.SensorType;
import com.builtbroken.mc.imp.transform.vector.Pos;

/**
 * Applied to entities
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/13/2017.
 */
@Deprecated //Going to be replaced by entity wrapper
public interface IEntity extends IWorldPosition
{
    /**
     * Size signature of the entity
     *
     * @param type - type of sensor being used to detect the entity
     * @return
     */
    float getGeneralSize(SensorType type);

    /**
     * How fast the entity is moving
     *
     * @return speed m/s
     */
    default float getSpeed()
    {
        return (float) getVelocity().magnitude();
    }

    /**
     * Current movement vector of the entity
     *
     * @return speed with direction m/s
     */
    Pos getVelocity();

    /**
     * Estimated pos of the entity next tick. Assuming
     * the entity does not speed up or change direction.
     *
     * @return estimated position
     */
    default Pos nextTickPos()
    {
        Pos vel = getVelocity();
        return new Pos(x() + vel.x(), y() + vel.y(), z() + vel.z());
    }
}
