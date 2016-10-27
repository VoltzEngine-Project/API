package com.builtbroken.mc.api.modules;

/**
 * Applied to modules that have wieght that effects the object that contains them.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/27/2016.
 */
public interface IModuleWeighted extends IModule
{
    /**
     * Gets the weight of just this part
     *
     * @return in grams
     */
    double getMass();

    /**
     * Get the weight of part contained
     * inside of this part. Do not include
     * weight of this module.
     *
     * @return in grams
     */
    default double getSubPartMass()
    {
        if(this instanceof IModuleContainer)
        {
            double mass = 0;
            for(IModule module : ((IModuleContainer)this).getSubModules())
            {
                if(module instanceof IModuleWeighted)
                {
                    mass += ((IModuleWeighted) module).getMass();
                    mass += ((IModuleWeighted) module).getSubPartMass();
                }
            }
            return mass;
        }
        return 0;
    }

    /**
     * Gets the weight of this object
     * and all objects attacked to
     * this object. Try to call
     * the host object first.
     *
     * @return in grams
     */
    default double getObjectMass()
    {
        if(this instanceof IModuleComponent)
        {
            IModule module = ((IModuleComponent)this).getHost();
            if(module instanceof IModuleWeighted)
            {
                return ((IModuleWeighted) module).getObjectMass();
            }
        }
        return getMass() + getSubPartMass();
    }
}
