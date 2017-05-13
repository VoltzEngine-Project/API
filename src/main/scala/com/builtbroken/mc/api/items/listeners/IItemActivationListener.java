package com.builtbroken.mc.api.items.listeners;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Handles any activation actions for an item. This includes left and right click of the item that would interact with the world.
 * <p>
 * Events are listened to with key "activation" by items.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/9/2017.
 */
public interface IItemActivationListener extends IItemEventListener
{
    /**
     * Called when the player right clicks the item.
     * <p>
     * This is called for each listener so the passed in stack may not be the original stack. Order
     * of listeners being called is not maintained so do not assume anything.
     *
     * @param stack  - item right clicked
     * @param world  - world the item is in
     * @param player - player holding the item
     * @return original or modified stack
     */
    default ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        return stack;
    }

    default boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hit_x, float hit_y, float hit_z)
    {
        return false;
    }
}
