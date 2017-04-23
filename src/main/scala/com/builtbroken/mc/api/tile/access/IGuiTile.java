package com.builtbroken.mc.api.tile.access;

import com.builtbroken.mc.api.tile.ITile;
import cpw.mods.fml.common.Loader;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by robert on 1/8/2015.
 */
public interface IGuiTile
{
    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    Object getServerGuiElement(int ID, EntityPlayer player);

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    Object getClientGuiElement(int ID, EntityPlayer player);

    default boolean openGui(EntityPlayer player, int requestedID)
    {
        return openGui(player, null);
    }

    default boolean openGui(EntityPlayer player, Object currentGui, Object... data)
    {
        if (currentGui == null && this instanceof ITile)
        {
            player.openGui(Loader.instance().getIndexedModList().get(((ITile) this).modID()), getDefaultGuiID(player), ((ITile) this).world(), ((ITile) this).xi(), ((ITile) this).yi(), ((ITile) this).zi());
            return true;
        }
        return false;
    }


    /**
     * Called to see if right click should be handled
     * automatically and the GUI should be open.
     *
     * @param player - who is trying to open the GUI, in rare cases can be null
     * @return true if should open
     */
    default boolean shouldOpenOnRightClick(EntityPlayer player)
    {
        return true;
    }

    /**
     * Gets the default ID that should be opened
     *
     * @param player - who is trying to open the GUI, in rare cases can be null
     * @return ID of the GUI
     */
    default int getDefaultGuiID(EntityPlayer player)
    {
        return 0;
    }
}
