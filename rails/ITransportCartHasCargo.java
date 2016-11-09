package com.builtbroken.mc.api.rails;

import com.builtbroken.mc.api.tile.node.IExternalInventory;

/** Applied to carts that have extended inventory
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/9/2016.
 */
public interface ITransportCartHasCargo extends ITransportCart, IExternalInventory
{
    //TODO implement logic to access view loader/unloader
}
