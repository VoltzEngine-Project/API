package com.builtbroken.mc.api.tile;

import com.builtbroken.mc.api.tile.node.ITileModule;
import com.builtbroken.mc.data.Direction;

/** Applied to a TileEntity to provide access, from outside the tile, to the TileModules contained in the tile.
 *
 */
@Deprecated //Going to be replaced with a more broad range version
public interface ITileModuleProvider
{
	/**
	 * @param nodeType - The type of node we are looking for.
	 * @param from     - The direction.
	 * @return Returns the node object.
	 */
	<N extends ITileModule> N getModule(Class<? extends N> nodeType, Direction from);
}
