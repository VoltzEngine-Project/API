package com.builtbroken.mc.api.abstraction.data;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Used to save data to the world.
 * <p>
 * All keys are forced to lowercase to reduce errors with loading, saving, user entry, and data changes.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/16/2017.
 */
public interface ISaveData
{
    Object getData(String key);

    int getInteger(String key);

    ISaveData setInteger(String key, int value);

    byte getByte(String key);

    ISaveData setByte(String key, byte value);

    float getFloat(String key);

    ISaveData setFloat(String key, float value);

    double getDouble(String key);

    void setDouble(String key, double value);

    String getString(String key);

    void setString(String key, String value);

    ISaveData getSaveData(String key);

    ISaveData setSaveData(String key, ISaveData value);

    /**
     * Converts internal logic to NBT.
     * This is not cached but created each call.
     *
     * @return nbt representing save data
     */
    NBTTagCompound toNBT();
}
