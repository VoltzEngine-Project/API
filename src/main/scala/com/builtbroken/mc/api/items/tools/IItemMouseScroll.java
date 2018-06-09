package com.builtbroken.mc.api.items.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Allows handle scroll wheel interaction on items without implementing mouse event direclty
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 6/9/2018.
 */
public interface IItemMouseScroll
{
    /**
     * @param player          - player holding the item
     * @param stack           - the item
     * @param ctrlHeld        - was ctrl held
     * @param shiftHeld       - was shift held
     * @param scrolledForward - forward or backwards movement (dWheel > 0 is considered forward)
     * @return result, only used client side
     */
    Result onMouseWheelScrolled(EntityPlayer player, ItemStack stack, boolean ctrlHeld, boolean shiftHeld, boolean scrolledForward);

    enum Result
    {
        //Do nothing
        PASS,
        //Cancel event
        CLIENT,
        //Cancel event and send to server
        SERVER
    }
}
