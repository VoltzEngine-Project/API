package com.builtbroken.mc.api.tile.multiblock;

import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.mc.api.abstraction.world.IPosWorld;

import java.util.HashMap;

/**
 * Implemented by blocks that act as the host or logical brain for a multiblock structure
 * Created by Dark on 8/9/2015.
 */
@Deprecated //Being replaced by an object system (host -> handler)
public interface IMultiTileHost extends IPosWorld, IMultiBlockHandler
{
    /**
     * Grabs that raw data of the layout of the structure. This data will be used to generate
     * the structure
     *
     * @return map of positions to multiTile types see com.builtbroken.mc.prefab.tile.multiblock.EnumMultiblock
     */
    HashMap<IPos3D, String> getLayoutOfMultiBlock();
}
