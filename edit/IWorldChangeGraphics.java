package com.builtbroken.mc.api.edit;

/**
 * Client side half of {@link IWorldChangeAction} that produces graphics as part of the world change event.
 * <p/>
 * This code is not ISided so that you can sync the effects between server and client
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/13/2015.
 */
public interface IWorldChangeGraphics
{
    /**
     * Displays an effect when an edit is called
     *
     * @param blocks
     */
    void displayEffectForEdit(IWorldEdit blocks);

    /**
     * Displays effects when the change starts
     */
    void doStartDisplay();

    /**
     * Displays effects when the change ends
     */
    void doEndDisplay();
}
