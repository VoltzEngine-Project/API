/**
 *
 */
package com.builtbroken.mc.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Apply to objects that at run time want code injected. Such as Power code, Inventory code, or other compatibility code
 *
 * @author DarkGuardsman, Original[Calclavia, class: UniversalClass from UniversalElectricity mod]
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface InjectTemplate
{
    /**
     * The template id as a command simi-colon list
     * <p>
     * e.g: "IC2;TE"
     *
     * @return Return an empty string to be compatible with all available mods, or each
     * CompatibilityType's enum.moduleName separated by semi-columns.
     */
    String integration() default "";
    //TODO setup to act as an exclusion list as well
}
