package com.builtbroken.mc.api.explosive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent;

/**
 * Client side version of the {@link IExplosiveHandler} that allows the handler to apply textures to items
 * containing this handler.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 1/30/2016.
 */
@Deprecated //Moved to JSON system as 1.8+ does not use icons
public interface ITexturedExplosiveHandler extends IExplosiveHandler
{
    /**
     * Icon used in the bottom corner when rendering in
     * an inventory. Allows a generic texture to be
     * used for the main item. Then a more specific
     * texture to be used to ID the explosive contained.
     * Mainly used by ICBM warheads and Armor ammo types.
     * <p/>
     * </p>
     * To implement a corner texture use a large IIcon
     * then only work in the bottom corner. An example
     * is a 64x64 icon with a 16x16 TnT block texture
     * in the corner.
     *
     * @param stack - stack looking for an icon
     * @return icon, or null if you have no icon. No icon may
     * result in a default icon being used.
     */
    @SideOnly(Side.CLIENT)
    default IIcon getBottomLeftCornerIcon(ItemStack stack, int pass)
    {
        return getBottomLeftCornerIcon(stack);
    }

    @SideOnly(Side.CLIENT)
    default IIcon getBottomLeftCornerIcon(ItemStack stack)
    {
        return null;
    }

    /**
     * Called to register the icons for the explosive handler. This
     * is called every texture event by {@link com.builtbroken.mc.core.ClientProxy#onStitch(TextureStitchEvent.Pre)}
     */
    @SideOnly(Side.CLIENT)
    default void registerExplosiveHandlerIcons(IIconRegister reg, boolean blocks)
    {

    }

    @SideOnly(Side.CLIENT)
    default int getBottomLeftCornerIconColor(ItemStack item, int pass)
    {
        return 16777215;
    }
}
