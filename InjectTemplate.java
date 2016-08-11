/**
 *
 */
package com.builtbroken.mc.api;

import net.minecraft.tileentity.TileEntity;

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
     * Used to specify which templates to inject into the class using the annotation.
     * Make sure to read up on the template before using them. As some still require
     * additonal code in order to work. Such as events to be fired from specific
     * method. For example {@link com.builtbroken.mc.api.event.tile.TileEvent.TileLoadEvent}
     * needs to be fired from {@link TileEntity#validate()} in order for IC2 power
     * template to function correctly.
     *
     * @return Return an empty string to apply all templates, or list separated by ;
     */
    String integration() default "";
    //TODO setup to act as an exclusion list as well using !templateID

    /**
     * Disabled the injection of method calls into
     * existing methods. If you disable this some
     * functionality can fail and will need to be
     * taken over by your own class. See
     * {@link com.builtbroken.mc.core.asm.template.TemplateManager}
     * for methods to call
     *
     * @return true to disable injection
     */
    boolean disableEventInjection() default false;
}
