package com.builtbroken.mc.api.explosive;

import net.minecraft.util.EnumFacing;

/**
 * Applied to tiles that can be damaged by explosives rather than destroyed.
 * <p>
 * Keep in mind most blasts are multi-threaded, this means each method call needs to
 * be thread safe to prevent the game from crashing. To do this do not edit the world
 * from methods. Instead just return data based on the current state of the tile. The
 * blast will handle all edits the the world when its done. If you need to do
 * complex actions listen for blast events.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/12/2017.
 */
public interface IExplosiveDamageable
{
    /**
     * Gets how much energy the tile consumes on impact
     *
     * @param explosive - handler for the explosive, optional
     * @param blast     - blast triggering the explosive, optional
     * @param facing      - side of the block hit
     * @param energy    - blast energy passing through the location, if negative the blast is not energy based
     * @return calculates how much energy
     */
    float getEnergyCostOfTile(IExplosiveHandler explosive, IBlast blast, EnumFacing facing, float energy, float distance);

    /**
     * Gets the world edit result of the block hitting this block.
     *
     * @param explosive - handler for the explosive, optional
     * @param blast     - blast triggering the explosive, optional
     * @param facing      - side of the block hit
     * @param energy    - blast energy passing through the location, if negative the blast is not energy based
     * @return calculates how much energy
     */
    IBlastEdit getBlockEditOnBlastImpact(IExplosiveHandler explosive, IBlast blast, EnumFacing facing, float energy, float distance);
}
