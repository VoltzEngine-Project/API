package com.builtbroken.mc.api.process;

import com.builtbroken.mc.api.VoltzEngineAPI;

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
    default void queProcess()
    {
        for (IWorkerThread thread : VoltzEngineAPI.WORKER_THREADS.values())
        {
            if (thread.contains(this))
            {
                return;
            }
        }
        int lowest = Integer.MAX_VALUE;
        IWorkerThread lowestThread = null;
        //Tries to find the most empty thread
        for (IWorkerThread thread : VoltzEngineAPI.WORKER_THREADS.values())
        {
            if (thread.containedProcesses() < lowest)
            {
                lowest = thread.containedProcesses();
                lowestThread = thread;
            }
        }
        //TODO implement priority system
        if (lowestThread != null)
        {
            lowestThread.add(this);
        }
        else
        {
            runProcess();
        }
    }

    /**
     * How important is this process
     * -2 =  cut the line
     * -1 = sooner than later
     * 0 = normal
     * 1 = can run later
     * 2 = who cares when it runs
     *
     * @return
     */
    default int getPriority()
    {
        return 0; //TODO implement priority system
    }

    /**
     * Called to kill the process before it has finished. Make sure
     * that any loop that is running terminates with this process.
     */
    void killAction();
}
