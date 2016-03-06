package com.builtbroken.mc.api.items.tools;

import net.minecraft.item.ItemStack;

/**
 * Simple tool item that is used for crafting. This item does not leave the crafting grid but instead takes damage.
 * <p/>
 * This interface is designed for usage with the {@link com.builtbroken.mc.prefab.recipe.item.RecipeTool} or classes very similar too it
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/2/2015.
 */
public interface IItemTool
{
    /**
     * Gets the type of the tool as a string(shears, hammer)
     *
     * @param stack - the item
     * @return string type for the item, may be null
     */
    String getToolType(ItemStack stack);

    /**
     * Category for the tool (sheetmetal) used to sort out
     * tools without making the type contain a lot of prefixes
     *
     * @param stack - item
     * @return string Category  for the tool
     */
    String getToolCategory(ItemStack stack);

    /**
     * Sets the type of the tool
     *
     * @param stack - item
     * @param type  - valid type
     */
    void setToolType(ItemStack stack, String type);
}
