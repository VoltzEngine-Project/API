package com.builtbroken.mc.api.grid;

import java.util.Collection;

/**
 * Simplified layout for any object that will act as grid of node connections.
 * <p>
 * The node itself can be literally anything that can be coded to provide the layout of the grid.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert)
 */
public interface IGrid<N>
{
    /**
     * Called to access a collection of
     * all nodes in a grid.
     * <p>
     * Make sure this is backed up the actual
     * data of the grid so additions and deletions
     * can be made.
     *
     * @return collection, can be any subtype
     */
    Collection<N> getNodes();

    /**
     * Called to add the node to
     * the grid.
     * <p>
     * Make sure to check for duplication to
     * prevent several nodes of the same type
     * being added.
     *
     * @param node - node to add
     */
    void add(N node);

    /**
     * Called to remove node from
     * the grid.
     *
     * @param node - node to remove
     */
    void remove(N node);

    /**
     * This is normally called every so often
     * to ask the grid to update it's data
     * that defines logic.
     */
    void reconstruct();

    /**
     * Called when the grid has been destroyed.
     * <p>
     * This can be called on world exit, or
     * network split depending on the design.
     */
    void deconstruct();
}
