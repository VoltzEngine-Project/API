package com.builtbroken.mc.api.data;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import java.util.function.Consumer;

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
     * Called to handle client side for the player
     *
     * @param player - local player
     */
    default void handleClientSide(EntityPlayer player)
    {
        handle(player);
    }

    /**
     * Handle a packet on the server side. Note this occurs after decoding has completed.
     *
     * @param player the player reference
     */
    default void handleServerSide(EntityPlayer player)
    {
        handle(player);
    }

    /**
     * Called to add object to write to the packet ByteBuf when encoding
     * <p>
     * Not all packets support this feature
     *
     * @param data - object to write
     * @param <A>  - this
     * @return this
     */
    default <A extends IPacket> A add(Object data)
    {
        return (A) this;
    }

    /**
     * Called to add a function to write to the packet ByteBuf when encoding
     * <p>
     * Not all packets support this feature
     *
     *  @param writer - function to consume the input for writing
     * @param <A>  - this
     * @return this
     */
    default <A extends IPacket> A addWriter(Consumer<ByteBuf> writer)
    {
        add(writer);
        return (A) this;
    }

    /**
     * Called to handle packet logic for both sides.
     * <p>
     * Called by interface defaults and not used externally.
     *
     * @param player - player
     */
    default void handle(EntityPlayer player)
    {
        throw new UnsupportedOperationException("Unsupported operation for Packet: " + getClass().getSimpleName());
    }
}
