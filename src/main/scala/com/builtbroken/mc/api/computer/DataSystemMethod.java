package com.builtbroken.mc.api.computer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 6/18/2018.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Deprecated //Replaced with lambda expression system
public @interface DataSystemMethod
{
    /** Name of the method */
    String name();

    /** Type of the method */
    DataMethodType type();

    /**
     * Arguments for the method
     * {"double:x", "double:y", "double:z"}
     *
     * @return
     */
    String[] args() default "";
}
