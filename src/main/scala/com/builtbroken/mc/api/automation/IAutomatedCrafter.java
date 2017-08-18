package com.builtbroken.mc.api.automation;

import com.builtbroken.mc.api.tile.provider.IInventoryProvider;
import com.builtbroken.mc.data.Direction;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Applied to tiles that act as auto crafting machines and need special handling for inventories.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/9/2016.
 */
public interface IAutomatedCrafter<I extends IInventory> extends IAutomation, IInventoryProvider<I>
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
     * Called by automation when inserting items without knowing
     * exactly which slot to use.
     *
     * @param stack  - stack to be inserted
     * @param entity - what is trying to insert the item
     * @return what is left of the stack after inserting
     */
    ItemStack insertRequiredItem(ItemStack stack, IAutomation entity, Direction side);

    /**
     * Called by automation when inserting items
     *
     * @param stack  - stack to be inserted
     * @param entity - what is trying to insert the item
     * @return what is left of the stack after inserting
     */
    ItemStack insertRequiredItem(ItemStack stack, int slot, IAutomation entity, Direction side);

    /**
     * Gets the slots that are used for output
     *
     * @param entity - machine accessing the crafter
     * @param side   - side being accessed from
     * @return slots, or empty array
     */
    int[] getCraftingOutputSlots(IAutomation entity, Direction side);

    /**
     * Gets the slots that are used for inputs
     *
     * @param entity - machine accessing the crafter
     * @param side-  side being accessed from
     * @return slots, or empty array
     */
    int[] getCraftingInputSlots(IAutomation entity, Direction side);
}
