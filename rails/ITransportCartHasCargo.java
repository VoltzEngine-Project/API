package com.builtbroken.mc.api.rails;

import com.builtbroken.mc.api.tile.IInventoryProvider;
import com.builtbroken.mc.prefab.inventory.filters.IInventoryFilter;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Applied to carts that have extended inventory
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/9/2016.
 */
public interface ITransportCartHasCargo extends ITransportCart, IInventoryProvider
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
    default boolean canAcceptItemForTransport(ItemStack stack)
    {
        IInventoryFilter filter = getInventoryFilter();
        if (filter != null)
        {
            return filter.isStackInFilter(stack);
        }
        return canStore(stack, ForgeDirection.UNKNOWN);
    }

    /**
     * Helps filter down items that can be inserted into
     * this cart when searching large inventories.
     *
     * @return filter, or null to not care
     */
    IInventoryFilter getInventoryFilter();
}
