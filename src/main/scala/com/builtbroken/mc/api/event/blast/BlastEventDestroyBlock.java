package com.builtbroken.mc.api.event.blast;

import com.builtbroken.mc.api.explosive.IBlast;
import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.block.Block;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

/**
 * Fired when a block is physically destroyed by a blast.
 * <p>
 * {@link Block#onBlockDestroyedByExplosion(World, int, int, int, Explosion)}
 * is called during or before this event. So if you need to implement effects on a block do it
 * inside of the build int method. This way other mods can interact with you effects as well.
 * <p>
 * Different events are fired for removal or replacement of
 * the block. Destroyed means that a force hit the block
 * hard enough to remove it from the map.
 * <p>
 * Idea usage of this event is to generate effects for
 * the block being destroyed.
 */
public abstract class BlastEventDestroyBlock extends BlastEventBlockEdit
{
    /** Type of destruction. */
    public final DestructionType destructionType;

    public BlastEventDestroyBlock(IBlast blast, DestructionType type, World world, Block block, int meta, int x, int y, int z)
    {
        super(blast, world, block, meta, x, y, z);
        this.destructionType = type;
    }

    /**
     * Uses this to cancel destruction of the block
     */
    @Cancelable
    public static class Pre extends BlastEventDestroyBlock
    {
        public Pre(IBlast blast, DestructionType type, World world, Block block, int meta, int x, int y, int z)
        {
            super(blast, type, world, block, meta, x, y, z);
        }
    }

    public static class Post extends BlastEventDestroyBlock
    {
        public Post(IBlast blast, DestructionType type, World world, Block block, int meta, int x, int y, int z)
        {
            super(blast, type, world, block, meta, x, y, z);
        }
    }

    /**
     * Type of destruction for more refined data
     */
    public enum DestructionType
    {
        /**
         * Thermally melted with no drops or placement
         * Caused by nukes and thermal weapons
         */
        HEAT,
        /**
         * Atomic structure was destroyed or turned into pure energy
         * Causes by center point of a nuke or antimatter
         */
        ATOMIZED,
        /**
         * Force of the blast
         * Causes by almost all explosives
         */
        FORCE
    }
}
