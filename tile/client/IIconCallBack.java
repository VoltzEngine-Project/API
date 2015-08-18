package com.builtbroken.mc.api.tile.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;

/**
 * Used by a tile to provide icon objects to a block.
 * <p/>
 * Designed mainly for multiblock code to allow the host tile
 * to override the breaking block icon.
 * Created by Dark on 8/18/2015.
 */
public interface IIconCallBack
{
    /**
     * Gets the icon for the side. World x y z should already
     * be contained in the tile for getting additional information.
     * For example metadata, block connections, or adjacent blocks.
     *
     * @param side - side of the block
     * @return valid icon for side, or null for default icon
     */
    @SideOnly(Side.CLIENT)
    IIcon getIconForSide(int side);
}
