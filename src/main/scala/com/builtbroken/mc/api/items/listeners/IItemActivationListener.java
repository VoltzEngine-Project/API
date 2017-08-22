package com.builtbroken.mc.api.items.listeners;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
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

    default boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand)
    {
        return false;
    }

    default boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        return false;
    }

    default boolean doesSneakBypassUse(ItemStack stack, IBlockAccess world, BlockPos pos, EntityPlayer player)
    {
        return false;
    }
}
