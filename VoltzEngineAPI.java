package com.builtbroken.mc.api;

import com.builtbroken.mc.api.process.IWorkerThread;

import java.util.concurrent.ConcurrentHashMap;

public class VoltzEngineAPI
{
    /** Version of the API */
    public static final String VERSION = "0.7.2";

    /** Threads that can be tasked with completing processes out side of the main game loop */
    public static final ConcurrentHashMap<String, IWorkerThread> WORKER_THREADS = new ConcurrentHashMap();
}
