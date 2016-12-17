package com.builtbroken.mc.api.event.blast;

import com.builtbroken.mc.api.explosive.IBlast;
import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.block.Block;
import net.minecraft.world.World;

/**
 * Fired when a block is replaced by another block
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/17/2016.
 */
public abstract class BlastEventBlockReplaced extends BlastEventBlockEdit
{
    public Block newBlock;
    public int newMeta;

    public BlastEventBlockReplaced(IBlast blast, World world, Block block, int meta, Block newBlock, int newMeta, int x, int y, int z)
    {
        super(blast, world, block, meta, x, y, z);
        this.newBlock = newBlock;
        this.newMeta = newMeta;
    }

    /**
     * Uses this to cancel the replace or change the replacing data
     */
    @Cancelable
    public static class Pre extends BlastEventBlockReplaced
    {
        public Pre(IBlast blast, World world, Block block, int meta, Block newBlock, int newMeta, int x, int y, int z)
        {
            super(blast, world, block, meta, newBlock, newMeta, x, y, z);
        }
    }

    public static class Post extends BlastEventBlockReplaced
    {
        public Post(IBlast blast, World world, Block block, int meta, Block newBlock, int newMeta, int x, int y, int z)
        {
            super(blast, world, block, meta, newBlock, newMeta, x, y, z);
        }
    }
}
