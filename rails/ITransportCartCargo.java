package com.builtbroken.mc.api.rails;

import com.builtbroken.mc.prefab.inventory.filters.IInventoryFilter;
import net.minecraft.item.ItemStack;

/**
 * Applied to any cart that has an inventory
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/22/2016.
 */
public abstract interface ITransportCartCargo extends ITransportCart
{
    /**
     * Checks if the item can be transported.
     * <p>
     * This is called in place of using {@link #getInventoryFilter()} in
     * some case so using the filter in this method might
     * be useful.
     *
     * @param stack - stack to validate, ignore stacksize
     * @return true if yes
     */
    boolean canAcceptItemForTransport(ItemStack stack);

    /**
     * Helps filter down items that can be inserted into
     * this cart when searching large inventories.
     *
     * @return filter, or null to not care
     */
    IInventoryFilter getInventoryFilter();
}
