package com.builtbroken.mc.api;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Used to access the mass registry in Voltz Engine
 *
 * All get methods will return -1 if the value was never registered or could not be found.
 * Keep this in mind when accessing the data.
 *
 * All set methods will convert negative numbers to positive. So if -5 is passed in it will turn into positive 5.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/28/2016.
 */
public interface IMassRegistry
{
    /**
     * Sets the mass of the entity
     *
     * @param entity - entity
     * @param mass   - mass in grams
     */
    void setMass(Class<? extends Entity> entity, double mass);

    /**
     * Sets the mass of the item and
     * all of it's sub items
     *
     * @param item - item set
     * @param mass - mass in grams
     */
    void setMass(Item item, double mass);

    /**
     * Sets the mass of the item-meta
     * pair. Wrappers to ItemStack
     * call to save time.
     *
     * @param item - item set
     * @param mass - mass in grams
     */
    void setMass(Item item, int meta, double mass);

    /**
     * Sets the mass of the block and
     * all of it's sub blocks.
     *
     * @param block - block set
     * @param mass  - mass in grams
     */
    void setMass(Block block, double mass);

    /**
     * Sets the mass of the block-meta pair.
     * Wrappers to ItemStack call to save time.
     *
     * @param block - block set
     * @param mass  - mass in grams
     */
    void setMass(Block block, int meta, double mass);

    /**
     * Sets the mass of the stack, if the
     * stack contains NBT it will be
     * included in the check. However,
     * will cache to the item-meta pair
     * if none is registered.
     *
     * @param stack - stack, NBT optional
     * @param mass  - mass in grams
     */
    void setMass(ItemStack stack, double mass);

    /**
     * Gets the mass of the tile/block at the location
     *
     * @param world
     * @param x
     * @param y
     * @param z
     * @return in grams
     */
    double getMass(World world, int x, int y, int z);

    /**
     * Gets the mass of an entity
     *
     * @param entity - entity
     * @return in grams
     */
    double getMass(Entity entity);

    /**
     * Gets the mass of the stack
     *
     * @return in grams
     */
    double getMass(ItemStack stack);

    /**
     * Gets the mass of the stack
     *
     * @return in grams
     */
    double getMass(Block block);

    /**
     * Gets the mass of the block-meta pair
     *
     * @return in grams
     */
    double getMass(Block block, int meta);

    /**
     * Gets the mass of the stack
     *
     * @return in grams
     */
    double getMass(Item item);

    /**
     * Gets the mass of the item-meta pair
     *
     * @return in grams
     */
    double getMass(Item item, int meta);
}
