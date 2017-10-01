package com.builtbroken.mc.imp.transform.region;

import com.builtbroken.jlib.data.vector.IPos2D;
import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.mc.api.map.IMapArea;
import com.builtbroken.mc.imp.transform.vector.Point;
import com.builtbroken.mc.imp.transform.vector.Pos;
import net.minecraft.util.Vec3;

/**
 * Created by robert on 1/12/2015.
 */
public abstract class Shape2D implements IMapArea
{
    /** Rotation around the Y */
    double yaw = 0;
    Point center;

    public Shape2D(Point center)
    {
        this.center = center;
    }

    /** Distance the shape takes in the X axis */
    abstract double getSizeX();

    /** Distance the shape takes in the Y axis */
    abstract double getSizeY();

    /** Gets the area of the shape */
    abstract double getArea();

    //====================
    // Collision check methods
    //====================

    public abstract boolean isWithin(IPos2D p);

    /** Checks if the point is inside the shape */
    public boolean isWithin(double x, double y)
    {
        return isWithin(new Point(x, y));
    }

    /** Checks if the point is inside the shape */
    boolean isWithin(double x, double y, double z)
    {
        return isWithin(x, z);
    }

    /** Checks if the point is inside the shape */
    boolean isWithin(IPos3D vec)
    {
        return isWithin(vec.x(), vec.y(), vec.z());
    }

    /** Checks if the point is inside the shape */
    boolean isWithin(Vec3 vec)
    {
        return isWithin(vec.xCoord, vec.yCoord, vec.zCoord);
    }

    //====================
    // IMapArea Wrapper
    //====================

    @Override
    public IPos3D getMapAreaCenter()
    {
        return new Pos(center.x(), 0, center.y());
    }

    @Override
    public boolean isMapArea3D()
    {
        return false;
    }

    @Override
    public boolean isInsideMapArea(double x, double y, double z)
    {
        return isWithin(x, y, z);
    }

    @Override
    public boolean isInsideMapArea(int x, int y, int z)
    {
        return isWithin(x + 0.5, y + 0.5, z + 0.5); //TODO expand a little?
    }
}
