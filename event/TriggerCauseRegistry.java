package com.builtbroken.mc.api.event;

import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/15/2016.
 */
public class TriggerCauseRegistry
{
    private static final HashMap<String, TriggerNBTBuilder> data = new HashMap();

    /**
     * Called to register a new trigger builder
     *
     * @param id
     * @param builder
     */
    public static void register(String id, TriggerNBTBuilder builder)
    {
        data.put(id, builder);
    }

    /**
     * Called to rebuild the trigger from NBT
     *
     * @param tag
     * @return
     */
    public static TriggerCause rebuild(NBTTagCompound tag)
    {
        if (tag != null && tag.hasKey("id"))
        {
            String id = tag.getString("id");
            if (data.containsKey(id))
            {
                return data.get(id).buildCause(tag);
            }
        }
        return null;
    }

    public static NBTTagCompound cache(TriggerCause cause)
    {
        NBTTagCompound tag = new NBTTagCompound();
        if (cause != null)
        {
            tag.setString("id", cause.triggerName);
        }
        return tag;
    }

    /**
     * Allied to objects that can rebuild triggers
     */
    public interface TriggerNBTBuilder
    {
        /**
         * Called to build the trigger cause from NBT data
         *
         * @param tag - nbt data to read
         * @return new trigger cause
         */
        TriggerCause buildCause(NBTTagCompound tag);
    }
}
