package com.builtbroken.mc.api.explosive;

import com.builtbroken.mc.api.edit.IWorldEdit;
import com.builtbroken.mc.data.Direction;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/12/2017.
 */
public interface IBlastEdit extends IWorldEdit
{
    void doDrops();

    /**
     * Direction the blast pathed during editing
     *
     * @param dir
     */
    void setBlastDirection(Direction dir);

    /**
     * Path the blast pathed during the edit
     *
     * @return
     */
    Direction getBlastDirection();

    /**
     * Amount of energy passing though the block     *
     */
    void setEnergy(float energy);

    /**
     * Gets the energy passing through the block
     *
     * @return
     */
    float getEnergy();
}
