package com.builtbroken.mc.api.computer;

/**
 * Object that represents a method
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 6/18/2018.
 */
public interface IDataSystemMethod
{
    /**
     * Name of the method for display
     * <p>
     * Ex:
     * fire
     * inventory
     * slot
     *
     * @return
     */
    String getName();

    /**
     * Gets the name of the method to invoke
     *
     * @return
     */
    String getInvokeName();

    /**
     * Type of method, used mainly for
     * displaying the method
     *
     * @return
     */
    DataMethodType getMethodType();


    /**
     * Calls the method
     *
     * @param target - object to call methods on
     * @param args - arguments passed into the method
     * @return
     */
    Object[] callMethod(Object target, Object... args) throws Exception;


}
