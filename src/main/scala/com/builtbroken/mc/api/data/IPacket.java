package com.builtbroken.mc.api.data;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Base object for all custom packets using in VoltzEngine.
 * </p>
 * Ensure that there is always a default constructor so forge can create the packet.
 * <p>
 * <p>
 * An NPE will be thrown if the packet is not registered due to PacketManager not knowing how to handle it
 * <p>
 * See PacketManager#sendToAll(IPacket) for exact usage on sending the packet
 *
 * @author tgame14, DarkCow
 * @since 26/05/14
 */
public interface IPacket
{

    /**
     * Encode the packet data into the ByteBuf stream. Complex data sets may need specific data handlers
     *
     * @param ctx    channel context
     * @param buffer the buffer to encode into
     * @see {@link cpw.mods.fml.common.network.ByteBufUtils}
     * PacketManager#writeData(io.netty.buffer.ByteBuf, Object...)
     */
    void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer);

    /**
     * Decode the packet data from the ByteBuf stream. Complex data sets may need specific data handlers
     *
     * @param ctx    channel context
     * @param buffer the buffer to decode from
     * @See {@link cpw.mods.fml.common.network.ByteBufUtils}
     */
    void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer);

    /**
     * Gets the extra data buffer that is waiting to be encoded. Can
     * be used to encode extra data to a packet that the packet
     * does not normally encoded. Should only be used on packets
     * that support IPacketIDReceiver type systems.
     * <p>
     * Not all packets support this functionality.
     *
     * @return bytebuf to write extra data to
     */
    default ByteBuf data()
    {
        return null;
    }

    /**
     * Handle a packet on the client side. Note this occurs after decoding has completed.
     *
     */
    default void handleClientSide()
    {
        handleClientSide(Minecraft.getMinecraft().thePlayer);
    }

    default void handleClientSide(EntityPlayer player)
    {
        throw new UnsupportedOperationException("Unsupported operation for Packet: " + getClass().getSimpleName());
    }

    /**
     * Handle a packet on the server side. Note this occurs after decoding has completed.
     *
     * @param player the player reference
     */
    default void handleServerSide(EntityPlayer player)
    {
        throw new UnsupportedOperationException("Unsupported operation for Packet: " + getClass().getSimpleName());
    }
}
