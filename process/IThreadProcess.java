package com.builtbroken.mc.api.process;

/**
 * Process that runs on the multi-threaded system
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/27/2016.
 */
public interface IThreadProcess
{
    /**
     * Called to run the process
     */
    void runProcess();

    /**
     * Called to que the process into its thread. IF the thread is
     * missing then just call the {@link #runProcess()} method instead.
     * This way any actual that has an effect will trigger. Such
     * as, placing blocks into the world, etc.
     */
    void queProcess();

    /**
     * Called to kill the process before it has finished. Make sure
     * that any loop that is running terminates with this process.
     */
    void killAction();
}
