package com.builtbroken.mc.api.rails;

import net.minecraft.item.ItemStack;

/**
 * Applied to carts that only carry a single item
 *
 * @Deprecated use {@link ITransportCartHasCargo}
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/9/2016.
 */
@Deprecated
public interface ITransportCartHasItem extends ITransportCartCargo
{
    /**
     * Gets the item that is being transported
     *
     * @return stack being held
     */
    ItemStack getTransportedItem();

    /**
     * Sets the item that is being transported
     *
     * @param stack - stack to be set
     * @return what is left of the stack after trying to store it
     */
    ItemStack setTransportedItem(ItemStack stack);
}
