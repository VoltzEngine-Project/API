package com.builtbroken.mc.imp.transform.region;

import com.builtbroken.mc.imp.transform.vector.Pos;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert on 1/12/2015.
 */
public class Sphere extends Shape3D
{
    double r;

    public Sphere(Pos pos, double r)
    {
        super(pos);
        this.r = r;
    }

    @Override
    public double getSizeX() { return r * 2; }

    @Override
    public double getSizeY() { return r * 2; }

    @Override
    public double getSizeZ() { return r * 2; }

    @Override
    public double getArea() { return 4 * Math.PI * (r * r); }

    @Override
    public double getVolume() { return (4 * Math.PI * (r * r * r)) / 3; }

    public boolean isWithin(double x, double y, double z)
    {
        return new Pos(x, y, z).subtract(x, y, z).magnitude() <= this.r;
    }

    public <E extends Entity> List<E> getEntities(World world, Class<E> clazz) //TODO change to getChunks().forEach(e -> e.getEntities().filter().... etc)
    {
        List<E> list = new ArrayList();
        int minX = MathHelper.floor_double((r - World.MAX_ENTITY_RADIUS) / 16.0D);
        int maxX = MathHelper.floor_double((r + World.MAX_ENTITY_RADIUS) / 16.0D);
        int minZ = MathHelper.floor_double((r - World.MAX_ENTITY_RADIUS) / 16.0D);
        int maxZ = MathHelper.floor_double((r + World.MAX_ENTITY_RADIUS) / 16.0D);

        //world.getEntitiesWithinAABB()
        for (int dx = minX; dx <= maxX; dx++)
        {
            for (int dz = minZ; dz <= maxZ; dz++)
            {
                int chunkX = dx + (center.xi() >> 4);
                int chunkZ = dz + (center.zi() >> 4);
                if (world.getChunkProvider().chunkExists(chunkX, chunkZ))
                {
                    Chunk chunk = world.getChunkFromChunkCoords(chunkX, chunkZ);

                    int yStart = MathHelper.floor_double((r - World.MAX_ENTITY_RADIUS + center.yi()) / 16.0D);
                    int yEnd = MathHelper.floor_double((r + World.MAX_ENTITY_RADIUS + center.yi()) / 16.0D);
                    yStart = MathHelper.clamp_int(yStart, 0, chunk.entityLists.length - 1);
                    yEnd = MathHelper.clamp_int(yEnd, 0, chunk.entityLists.length - 1);

                    for (int k = yStart; k <= yEnd; k++)
                    {
                        List list1 = chunk.entityLists[k];

                        for (int l = 0; l < list1.size(); l++)
                        {
                            Entity entity = (Entity) list1.get(l);

                            if ((clazz == null || clazz.isAssignableFrom(entity.getClass())) && distance(new Pos(entity)) <= r)
                            {
                                list.add((E)entity);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}
