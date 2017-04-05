package com.builtbroken.mc.api.tile.listeners.client;

import com.builtbroken.mc.api.tile.listeners.ITileEventListener;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/5/2017.
 */
public interface IIconListener extends ITileEventListener
{
    @SideOnly(Side.CLIENT)
    default IIcon getTileIcon(int side, int meta)
    {
        return null;
    }

    @Override
    default String getListenerKey()
    {
        return "icon";
    }
}
