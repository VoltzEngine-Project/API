package com.builtbroken.mc.api.items.weapons;

import com.builtbroken.mc.api.data.weapon.IAmmoData;
import com.builtbroken.mc.api.modules.weapon.IClip;
import net.minecraft.item.ItemStack;

import java.util.Stack;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/20/2016.
 */
public interface IItemClip extends IItemAmmo
{
    /**
     * Gets the ammo data of the clip
     *
     * @param clipStack - this
     * @return queue of ammo being fired
     */
    Stack<IAmmoData> getStoredAmmo(ItemStack clipStack);

    /**
     * Wrappers the stack in side of a clip object
     * for easier access and usability.
     *
     * @param clipStack - this
     * @return new clip instance
     */
    IClip toClip(ItemStack clipStack);
}
