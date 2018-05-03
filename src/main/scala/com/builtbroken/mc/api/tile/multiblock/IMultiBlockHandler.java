package com.builtbroken.mc.api.tile.multiblock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;

/**
 * Handles interaction for a multi-block
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/2/2018.
 */
public interface IMultiBlockHandler
{
    /**
     * Called when a peace of the structure has been added to the world
     *
     * @param tileMulti - tile that was added
     */
    default void onMultiTileAdded(IMultiTile tileMulti)
    {

    }

    /**
     * Called when a peace of the structure has been removed from the world
     *
     * @param tileMulti - tile that was destroyed
     * @param source    - what broke the block (Player or Explosion), can be null
     * @param harvest   - should the block be harvested, only used when a player breaks the tile
     */
    default boolean onMultiTileBroken(IMultiTile tileMulti, Object source, boolean harvest)
    {
        return false;
    }

    /**
     * Called when a tile has been invalidated. Most likely this is
     * called when a chunk is unloaded from the world.
     *
     * @param tileMulti - tile that was invalidated
     */
    default void onTileInvalidate(IMultiTile tileMulti)
    {

    }

    /**
     * Called when a player right clicks a tile
     *
     * @param tile   - tile clicked
     * @param player - person who clicked the tile
     * @param side   - side clicked
     * @param xHit   - hit data of where the tile was clicked
     * @param yHit   - hit data of where the tile was clicked
     * @param zHit   - hit data of where the tile was clicked
     */
    default boolean onMultiTileActivated(IMultiTile tile, EntityPlayer player, int side, float xHit, float yHit, float zHit)
    {
        return false;
    }

    /**
     * Called when the player left clicks a tile. No additional data is provided beyond
     * tile and player due to MC's methods.
     *
     * @param tile   - tile that was clicked
     * @param player - player
     */
    default void onMultiTileClicked(IMultiTile tile, EntityPlayer player)
    {

    }

    /**
     * Called to get host as an itemstack.
     * <p>
     * This is used for pick block and waila support.
     * <p>
     * This method should work on server and client
     *
     * @param player - player, can be null
     * @param target - target, can be null
     * @return
     */
    default ItemStack getHostAsStack(EntityPlayer player, MovingObjectPosition target)
    {
        if (this instanceof TileEntity)
        {
            try
            {
                Block block = ((TileEntity) this).getBlockType();
                if (block != null)
                {
                    return block.getPickBlock(target, ((TileEntity) this).getWorldObj(), ((TileEntity) this).xCoord, ((TileEntity) this).yCoord, ((TileEntity) this).zCoord, player);
                }
            }
            catch (Exception e)
            {
                //On rare case that pick block will not work
                e.printStackTrace();
            }
        }
        return null;
    }
}
