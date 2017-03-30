package com.builtbroken.mc.api.items.weapons;

import com.builtbroken.mc.api.data.weapon.IAmmoType;
import net.minecraft.item.ItemStack;

/**
 * Normally applied to projectile weapons but can be applied to any weapon that can be reloaded.
 * Created by robert on 12/28/2014.
 */
public interface IItemReloadableWeapon
{
    /**
     * Loaded the weapon with some ammo
     *
     * @param weapon - stack that may be ammo
     * @param ammo   - stack that is ammmo
     * @return what is left of the stack, or null if it consumed
     * the entire stack
     */
    ItemStack loadAmmo(ItemStack weapon, ItemStack ammo, IAmmoType type, boolean isClip);

    /**
     * Can the weapon have a clip or ammo inserted into a feed system.
     * If a weapon can't contain ammo then it feeds off of the entity's
     * inventory to get ammo.
     *
     * @param weapon - itemstack that is the weapon
     * @return true if it can contain ammo
     */
    boolean canContainAmmo(ItemStack weapon);
}
