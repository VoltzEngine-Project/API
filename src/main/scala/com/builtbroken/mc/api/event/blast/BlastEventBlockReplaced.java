package com.builtbroken.mc.api.event.blast;

import com.builtbroken.mc.api.explosive.IBlast;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * Fired when a block is replaced by another block
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/17/2016.
 */
public abstract class BlastEventBlockReplaced extends BlastEventBlockEdit
{
    public IBlockState newState;

    public BlastEventBlockReplaced(IBlast blast, World world, IBlockState oldState, IBlockState newState, int x, int y, int z)
    {
        super(blast, world, oldState, x, y, z);
        this.newState = newState;
    }

    /**
     * Uses this to cancel the replace or change the replacing data
     */
    @Cancelable
    public static class Pre extends BlastEventBlockReplaced
    {
        public Pre(IBlast blast, World world, IBlockState oldState, IBlockState newState, int x, int y, int z)
        {
            super(blast, world, oldState, newState, x, y, z);
        }
    }

    public static class Post extends BlastEventBlockReplaced
    {
        public Post(IBlast blast, World world, IBlockState oldState, IBlockState newState, int x, int y, int z)
        {
            super(blast, world, oldState, newState, x, y, z);
        }
    }
}
