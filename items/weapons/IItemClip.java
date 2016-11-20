package com.builtbroken.mc.api.items.weapons;

import com.builtbroken.mc.api.data.weapon.IAmmoData;
import net.minecraft.item.ItemStack;

import java.util.Queue;

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
    Queue<IAmmoData> getStoredAmmo(ItemStack clipStack);
}
