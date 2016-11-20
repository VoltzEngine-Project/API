package com.builtbroken.mc.api.items.weapons;

import com.builtbroken.mc.api.data.weapon.IAmmoType;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * Item used as ammo for a reloadable weapon
 * Created by robert on 12/28/2014.
 */
public interface IItemAmmo
{
    /**
     * Is the itemstack ammo for a weapon
     *
     * @param stack - stack that is ammo
     * @return true if it is ammo
     */
    default boolean isAmmo(ItemStack stack)
    {
        return getAmmoCount(stack) > 0;
    }

    /**
     * Is the ammo item a clip of ammo rather than single rounds
     * If you return true the item will be treated as a clip.
     * Stack size will not be used to count how many rounds are
     * in the stack. Instead getAmmoCount will be called to
     * get how many rounds are left in the clip.
     *
     * @return true if it is a clip item.
     */
    default boolean isClip(ItemStack stack)
    {
        return this instanceof IItemClip;
    }

    /**
     * Gets the type of ammo. For example
     *
     * @param stack - stack that is ammo
     * @return type
     */
    IAmmoType getAmmoType(ItemStack stack);

    /**
     * How many rounds are in the stack.
     * called if isClip returns true
     *
     * @return number of rounds in the stack, or stack
     * size if you don't use clip based logic
     */
    int getAmmoCount(ItemStack ammoStack);

    /**
     * Called to consume ammo from the stack. Use this to define how ammo is consumed
     * when using stack size is not enough.
     *
     * @param weapon     - weapon the round was fired from
     * @param ammoStack  - ammo that was fired
     * @param shotsFired - number of shots that were fired
     */
    void consumeAmmo(IItemReloadableWeapon weapon, ItemStack weaponStack, ItemStack ammoStack, int shotsFired);

    /**
     * Applied to ammo items that handle their own firing code
     * <p>
     * This is mainly legacy code for ICBM and will eventually be
     * removed.
     */
    @Deprecated
    public static interface IItemAmmoFireHandler extends IItemAmmo
    {
        /**
         * Called to fire the ammo from the weapon
         *
         * @param weapon       - weapon object
         * @param weaponStack  - weapon stack
         * @param ammoStack    - this
         * @param firingEntity - entity that will be used for aiming & rotation
         */
        void fireAmmo(IItemReloadableWeapon weapon, ItemStack weaponStack, ItemStack ammoStack, Entity firingEntity);
    }
}
