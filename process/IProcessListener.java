package com.builtbroken.mc.api.process;

/**
 * Applied to objects that are waiting on feed back from a thread process
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/7/2016.
 */
public interface IProcessListener
{
    /**
     * Called when the process starts running on a thread
     *
     * @param process
     */
    void onProcessStarts(IThreadProcess process);

    /**
     * Called when a process finishes its assigned task
     *
     * @param process
     */
    void onProcessFinished(IThreadProcess process);

    /**
     * Called when a process is terminated before it could finish
     *
     * @param process
     */
    void onProcessTerminated(IThreadProcess process);
}
