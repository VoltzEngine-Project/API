package com.builtbroken.mc.api.grid;

/**
 * Applied to objects that act as nodes for a grid.
 * <p>
 * Nodes should be dead objects in the world to best improve performance.
 * Use the grid itself to do most logic and try to ensure all actions are
 * thread safe for best results.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 2/2/2017.
 */
public interface IGridNode<G extends IGrid> extends IGridProvider<G>
{
    /**
     * Called by the grid to rebuild
     * connections to other objects.
     * <p>
     * Take this time to update physical connections and
     * to update cached data. If the connections have
     * changed ensure that you note the change and return
     * true in this method so the grid knows that the
     * connections need to be updated. The best way to handle
     * this is to cache the previous connections and compare
     * it to the new connections. A byte is one of the best
     * ways to store connections for a single tile with
     * 0 to 255 max connection possibilities.
     * <p>
     * To improve performance caching results may be suggested.
     * However, keep in mind how much is cached to reduce
     * impact of the node on the RAM usage. As nodes can
     * normally be expected to be placed 100-1000 per player.
     * Do not fear calling {@link net.minecraft.world.World#getTileEntity(int, int, int)}
     * as it is performance enough to note need cached. Additionally
     * avoid using hard references and use {@link java.lang.ref.WeakReference} when possible
     * to avoid holding on to dead {@link net.minecraft.tileentity.TileEntity}. As
     * well when checking for connections make sure to check if the chunk is loaded
     * to avoid orphan chunks and extra disk usage. This is one of the many reasons
     * why performance in Minecraft is actually bad.
     * <p>
     * Depending on the grid design you may want to check for
     * new connections and update the grid.
     * This is normally called during
     * {@link IGrid#deconstruct()} and
     * {@link IGrid#reconstruct()}
     *
     * @return true if the connections have changed
     */
    boolean refreshConnections();
}
