package com.builtbroken.mc.api.rails;

import com.builtbroken.mc.api.IInventoryFilter;
import com.builtbroken.mc.api.tile.provider.IInventoryProvider;
import com.builtbroken.mc.api.tile.node.IExternalInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Applied to carts that have extended inventory.
 * <p>
 * {@link #getInventoryFilter()} is required for this class by the rail system
 * due to the possibility of large inventories.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/9/2016.
 */
public interface ITransportCartHasCargo extends ITransportCartCargo, IInventoryProvider
{
    /** External inventory object */
    IExternalInventory getInventory();

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
}
