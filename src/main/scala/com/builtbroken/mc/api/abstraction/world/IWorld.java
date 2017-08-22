package com.builtbroken.mc.api.abstraction.world;

import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.mc.api.abstraction.EffectInstance;
import com.builtbroken.mc.api.abstraction.data.ITileData;
import com.builtbroken.mc.api.abstraction.entity.IEntityData;
import com.builtbroken.mc.api.abstraction.imp.IWrapper;
import com.builtbroken.mc.api.abstraction.tile.ITile;
import com.builtbroken.mc.api.abstraction.tile.ITilePosition;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/12/2017.
 */
public interface IWorld extends IWrapper<World>
{
    /**
     * Get information about a tile from the location
     *
     * @param x - location in the world
     * @param y - location in the world
     * @param z - location in the world
     * @return
     */
    ITile getTile(int x, int y, int z);

    /**
     * Get information about a tile from the location
     *
     * @param position - location in the world
     * @return
     */
    ITile getTile(ITilePosition position);

    /**
     * Sets a tile using it's name
     *
     * @param key
     * @param x
     * @param y
     * @param z
     * @return
     */
    boolean setTile(String key, int x, int y, int z);

    /**
     * Sets a tile using it's data instance
     *
     * @param data
     * @param x
     * @param y
     * @param z
     * @return
     */
    boolean setTile(ITileData data, int x, int y, int z);

    //TODO create setTile with state data

    /**
     * Checks if the location is loaded
     * <p>
     * Should be run before any world action to
     * prevent generating new world areas or loading
     * areas not currently in use
     *
     * @param x
     * @param y
     * @param z
     * @return true if area is loaded
     */
    boolean isLocationLoaded(int x, int y, int z);

    /**
     * Get data about entities near a position
     *
     * @param range - distance to check
     * @return list of entities, or empty list
     */
    List<IEntityData> getEntitiesInRange(double x, double y, double z, double range);

    /**
     * Gets a new tile position near the location
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    ITilePosition getTilePosition(int x, int y, int z);


    IEntityData getEntityData(int id);

    /**
     * Creates a new effect instance
     *
     * @param pos
     * @return
     */
    EffectInstance newEffect(String key, IPos3D pos);

    /**
     * Handles the effect
     * <p>
     * IF server, converts to packet for network sync
     * IF client, runs the effect
     *
     * @param effectInstance
     */
    void runEffect(EffectInstance effectInstance);

    void spawnParticle(EnumParticleTypes type, double x, double y, double z, double xx, double yy, double zz, int... params);

    void playAudio(String audioKey, double x, double y, double z, float pitch, float volume);

    boolean isClient();

    boolean isServer();

    int getDimID();
}
