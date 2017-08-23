package com.builtbroken.mc.api.event.blast;

import com.builtbroken.mc.api.explosive.IBlast;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

/**
 * Fired any time a block is edited
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/17/2016.
 */
public abstract class BlastEventBlockEdit extends BlastEvent
{
    public final World world;
    public final IBlockState blockState;
    public final int x;
    public final int y;
    public final int z;

    public BlastEventBlockEdit(IBlast blast, World world, IBlockState state, int x, int y, int z)
    {
        super(blast);
        this.world = world;
        this.blockState = state;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
