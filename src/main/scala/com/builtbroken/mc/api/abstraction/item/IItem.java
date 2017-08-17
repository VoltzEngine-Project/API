package com.builtbroken.mc.api.abstraction.item;

import com.builtbroken.mc.api.abstraction.data.IItemData;
import com.builtbroken.mc.api.abstraction.data.ISaveData;
import com.builtbroken.mc.api.abstraction.imp.IWrapper;
import net.minecraft.item.Item;

/** Wrapper for ItemStack
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/16/2017.
 */
public interface IItem extends IWrapper<Item>
{
    IItemData getItemData();

    int getDamage();

    ISaveData getSaveData();
}
