package com.builtbroken.mc.api.edit;

/**
 * Audio half of {@link IWorldChangeAction}
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/13/2015.
 */
public interface IWorldChangeAudio
{
    /**
     * Plays a sound effect when the block is edited
     *
     * @param blocks
     */
    void playAudioForEdit(IWorldEdit blocks);

    /**
     * Plays audio when the change starts
     */
    void doStartAudio();

    /**
     * Plays audio when the change ends
     */
    void doEndAudio();
}
