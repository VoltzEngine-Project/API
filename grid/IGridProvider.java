package com.builtbroken.mc.api.grid;

/**
 * Applied to objects that provide grids for access.
 * <p>
 * Normally this is applied to nodes in a grid. However, it
 * can be used to provide access to grid connections from other sources.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert)
 */
public interface IGridProvider<G extends IGrid>
{
    /** Sets the grid reference */
    void setGrid(G grid);

    /** Gets the grid reference */
    G getGrid();
}
