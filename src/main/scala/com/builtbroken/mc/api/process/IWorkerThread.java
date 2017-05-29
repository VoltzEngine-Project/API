package com.builtbroken.mc.api.process;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 7/23/2016.
 */
public interface IWorkerThread
{
    /**
     * Checks if the thread contains the current process
     *
     * @param process - process
     * @return true if it contains the process
     */
    boolean contains(IThreadProcess process);

    /**
     * Number of processes in the queue
     *
     * @return processes
     */
    int containedProcesses();

    /**
     * Called to add a process to the end of the current queue
     *
     * @param process - process to add
     */
    void add(IThreadProcess process);

    /**
     * Called to terminate the thread after it's next cycle
     */
    void kill();

    /**
     * Called to clear all activate processes
     *
     * @return true if cleared processes
     */
    boolean clearProcesses();

    /**
     * Pauses the processes on the thread
     *
     * @return true if paused
     */
    boolean pauseWorker();

    /**
     * Resumes the processes on the thread
     *
     * @return true if resumed
     */
    boolean resumeWorker();
}
