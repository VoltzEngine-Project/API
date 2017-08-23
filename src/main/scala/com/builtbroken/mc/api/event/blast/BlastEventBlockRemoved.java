package com.builtbroken.mc.api.event.blast;

import com.builtbroken.mc.api.explosive.IBlast;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * Called when a block is removed and replaced by AIR
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/17/2016.
 */
public abstract class BlastEventBlockRemoved extends BlastEventBlockEdit
{
    public BlastEventBlockRemoved(IBlast blast, World world, IBlockState state, int x, int y, int z)
    {
        super(blast, world, state, x, y, z);
    }

    /**
     * Use this to cancel the removal of a block
     */
    @Cancelable
    public static class Pre extends BlastEventBlockRemoved
    {
        public Pre(IBlast blast, World world, IBlockState state, int x, int y, int z)
        {
            super(blast, world, state, x, y, z);
        }
    }

    public static class Post extends BlastEventBlockRemoved
    {
        public Post(IBlast blast, World world, IBlockState state, int x, int y, int z)
        {
            super(blast, world, state, x, y, z);
        }
    }
}
