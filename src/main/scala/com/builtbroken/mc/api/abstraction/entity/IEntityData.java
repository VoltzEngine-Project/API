package com.builtbroken.mc.api.abstraction.entity;

import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.mc.api.abstraction.imp.IWrapper;
import com.builtbroken.mc.api.abstraction.world.IPosWorld;
import com.builtbroken.mc.imp.transform.rotation.IRotation;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import java.util.UUID;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/12/2017.
 */
public interface IEntityData extends IPosWorld, IRotation, IWrapper<Entity>
{
    IPos3D toPosition();

    IPosWorld toWorldPosition();

    boolean isPlayer();

    String getUniqueName();

    UUID getUniqueID();

    double getYOffset();

    ItemStack getRightClickItem();
}
