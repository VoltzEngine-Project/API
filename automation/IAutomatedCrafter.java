package com.builtbroken.mc.api.automation;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

/**
 * Applied to tiles that act as auto crafting machines and need special handling for inventories.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/9/2016.
 */
public interface IAutomatedCrafter extends IAutomation
{
    /**
     * Can the machine start crafting
     *
     * @return true
     */
    boolean canCraft();

    /**
     * The current progress of auto crafting
     *
     * @return 0.0 to 1.0 with 1 being completed
     */
    float getCraftingProgress();

    /**
     * Gets the current list of items needed for
     * the recipe
     * <p>
     * TODO this may be replaced with a recipe object later
     *
     * @return list, empty list if requires nothing or is not crafting
     */
    List<ItemStack> getRequiredItems();

    /**
     * Called to check if the item can be stored
     * <p>
     * This method is shared intentionally with {@link com.builtbroken.mc.api.tile.IInventoryProvider}
     * as you should be able to store the item in the inventory or crafting if this returns true.
     * Use different methods if you want to have more fine tune control over how items are inserted
     * for example {@link #insertRequiredItem(ItemStack, IAutomation)} can be used to reject
     * items that this method returned true for.
     *
     * @param stack - what is being stored
     * @param side  - side it is being stored on
     * @return true if it can be stored, regardless of inventory fullness.
     */
    boolean canStore(ItemStack stack, ForgeDirection side);

    /**
     * Called by automation when inserting items.
     * <p>
     * Make sure o
     *
     * @param stack  - stack to be inserted
     * @param entity - what is trying to insert the item
     * @return what is left of the stack after inserting
     */
    ItemStack insertRequiredItem(ItemStack stack, IAutomation entity);
}
