package com.builtbroken.mc.api.edit;

import java.util.List;

/**
 * Version of {@link IWorldChangeAction} that pops edits in layers.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/30/2015.
 */
public interface IWorldChangeLayeredAction
{
    /**
     * Number of layers, or times to call get
     * block edits.
     *
     * @return number of layers
     */
    int getLayers();

    /**
     * Called to see if the next layer should be
     * called.
     *
     * @param layer - current layer
     * @return true if next calls should be processed
     */
    boolean shouldContinueAction(int layer);

    /**
     * Called to resume the blast calculation code
     *
     * @param list  - place to add edits to
     * @param layer - current layer
     */
    void getEffectedBlocks(List<IWorldEdit> list, int layer);
}
