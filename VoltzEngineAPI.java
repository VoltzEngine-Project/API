package com.builtbroken.mc.api;

import com.builtbroken.mc.api.process.IWorkerThread;

import java.util.concurrent.ConcurrentHashMap;

public class VoltzEngineAPI
{
    /** Version of the API */
    public static final String VERSION = "0.7.4";

    /** Threads that can be tasked with completing processes out side of the main game loop */
    public static final ConcurrentHashMap<String, IWorkerThread> WORKER_THREADS = new ConcurrentHashMap();

    /**
     * Mass registry for Voltz Engine, normally loaded up by voltz engine
     * but in dire need it can be set by any mod. However, plz let Voltz engine
     * set the value to avoid issues.
     */
    public static IMassRegistry massRegistry;
}
