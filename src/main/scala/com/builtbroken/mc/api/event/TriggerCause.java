package com.builtbroken.mc.api.event;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Contains data about how an action was triggered
 * <p>
 * Used primarily as an internal event system for explosive triggering in ICBM. However, can
 * be used for just about anything including traps, region updated, events, weapons, etc.
 *
 * Examples of use: ICBM: Warhead, ICBM: Crashed Missile, VoltzEngine: WorldTrigger, VoltzEngine: Explosive System
 * <p>
 * Note: Make sure to register a {@link TriggerCauseRegistry.TriggerNBTBuilder} so
 * that packet syncing and NBT saving work correctly. Without doing so will cause
 * save state and client to not update correctly.
 * <p>
 * Created on 11/18/2014. Last Modified 9/30/2017
 *
 * @author Darkguardsman
 */
public abstract class TriggerCause
{
    /** Name of the trigger cause, unique lookup id, and translation key. */
    public final String triggerName;
    /** Optional, Amount to change the size of the effect */
    public float effectScaleChange = 1;

    public TriggerCause(String name)
    {
        this.triggerName = name;
    }

    /** Side based Trigger */
    public abstract static class TriggerCauseSide extends TriggerCause
    {
        public final ForgeDirection triggeredSide;

        public TriggerCauseSide(String name, ForgeDirection side)
        {
            super(name);
            triggeredSide = side;
        }
    }

    /** Triggered by an entity */
    public static class TriggerCauseEntity extends TriggerCause
    {
        public final Entity source;

        public TriggerCauseEntity(Entity source)
        {
            this("entity", source);
        }

        public TriggerCauseEntity(String name, Entity source)
        {
            super(name);
            this.source = source;
        }
    }

    /** Triggered by an entity */
    public static class TriggerCauseImpact extends TriggerCauseEntity
    {
        public final float velocity;

        public TriggerCauseImpact(Entity source, float velocity)
        {
            this("entityImpact", source, velocity);
        }

        public TriggerCauseImpact(String name, Entity source, float velocity)
        {
            super(name, source);
            this.velocity = velocity;
        }
    }

    /** Triggered by an entity during impact of the ground */
    public static class TriggerBlockImpact extends TriggerCauseImpact
    {
        public final Block impactBlock;

        public TriggerBlockImpact(Block block, Entity source, float velocity)
        {
            this("entityImpactBlock", block, source, velocity);
        }

        public TriggerBlockImpact(String name, Block block, Entity source, float velocity)
        {
            super(name, source, velocity);
            this.impactBlock = block;
        }
    }

    /** Triggered by an entity during impact of an entity */
    public static class TriggerEntityImpact extends TriggerCauseImpact
    {
        /** Entity that was hit by the impacting entity. */
        public final Entity entityHit;

        public TriggerEntityImpact(Entity entityHit, Entity source, float velocity)
        {
            this("entityImpactEntity", entityHit, source, velocity);
        }

        public TriggerEntityImpact(String name, Entity entityHit, Entity source, float velocity)
        {
            super(name, source, velocity);
            this.entityHit = entityHit;
        }
    }

    /**
     * Trigger event for explosions hitting the object in question.
     */
    public static class TriggerCauseExplosion extends TriggerCause
    {
        public final Explosion source;

        public TriggerCauseExplosion(Explosion source)
        {
            super("explosion");
            this.source = source;
        }
    }

    /** Trigger by fire */
    public static class TriggerCauseFire extends TriggerCauseSide
    {
        public TriggerCauseFire(ForgeDirection side)
        {
            super("fire", side);
        }
    }

    /** Trigger by restone signal */
    public static class TriggerCauseRedstone extends TriggerCauseSide
    {
        /** 0-15 how strong the signal of the restone was */
        public final int strength;

        public TriggerCauseRedstone(ForgeDirection side, int strength)
        {
            super("redstone", side);
            this.strength = strength;
        }
    }
}
