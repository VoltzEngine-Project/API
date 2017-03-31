package com.builtbroken.mc.api.modules;

import com.builtbroken.mc.api.ISave;
import net.minecraft.item.ItemStack;

/**
 * Part representation of an Item that is inserted into container
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/28/2015.
 */
public interface IModule extends ISave
{
    /**
     * Converts the module back into an item
     *
     * @return ItemStack
     */
    ItemStack toStack();

    /**
     * Gets the unlocalized name for this module
     *
     * @return unlocalized name "item.mod:moduleName.name"
     */
    String getUnlocalizedName();

    /**
     * A unique ID that can be used to
     * save/load and transmitted the module
     * over the network.
     * <p>
     * Works about the same way as TileEntity
     * registry IDs. Make sure to register
     * this with the module builder so the
     * module can be reconstructed
     *
     * @return unique save ID
     */
    String getSaveID();

    /** Called to save the object to NBT */
    void save(ItemStack stack);

}
