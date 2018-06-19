package com.builtbroken.mc.api.computer;

/**
 * Handles data connection and mechanics for a machine or series of machines
 * <p>
 * This is a low level version of the system. Providing only methods that
 * can be run and a way to invoke the methods.
 * <p>
 * This is not applied to objects directly. Instead a data system is registered and then indirectly accessed.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 6/18/2018.
 */
public interface IDataSystem
{
    /**
     * Name of the system type to show when connected
     *
     * @param host - machine
     * @return name, ex: assemblyline:inserter
     */
    String getSystemType(Object host);

    /**
     * Methods to expose from the system
     *
     * @param host - machine
     * @return array of methods to expose
     */
    String[] getMethods(Object host);

    /**
     * Called to run a method with arguments
     *
     * @param host   - machine
     * @param method - name of the method to run
     * @param args   - arguments for the command, can be empty/null
     * @return data from the command, null if nothing should be returned
     * @throws Exception
     */
    Object[] runMethod(Object host, String method, Object... args) throws Exception;
}
