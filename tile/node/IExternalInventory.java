package com.builtbroken.mc.api.tile.node;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import java.util.Collection;

/**
 * @author DarkGuardsman
 */
public interface IExternalInventory extends IInventory
{
	/**
	 * Gets the inventory array. ForgeDirection.UNKOWN must return all sides
	 */
	Collection<ItemStack> getContainedItems();

	/**
	 * Deletes all the items in the inventory
	 */
	void clear();
}
