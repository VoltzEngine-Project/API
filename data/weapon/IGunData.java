package com.builtbroken.mc.api.data.weapon;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 11/20/2016.
 */
public interface IGunData extends IWeaponData
{
    /**
     * How this weapon is reloaded.
     * <p>
     * This is used to limit what types of clips can be feed
     * into the weapon. As well controls animations and ammo
     * controls.
     *
     * @return reload type
     */
    ReloadType getReloadType();

    /**
     * Type of gun
     * <p>
     * This is mainly used for display to the user
     * but in some cases can be used to modify how
     * the weapon is animated and held by the player
     * model.
     *
     * @return weapon type (Handgun, Rifle(AutoRifle, AssaultRifle SniperRifle), LMG, HMG, SMG)
     */
    String getGunType();

    /**
     * How long it takes to reload the weapon.
     * <p>
     * This is a base value for an average sized clip.
     * Different clips will modify this on the user's
     * actual reload action.
     *
     * @return time in ticks (20 ticks a second)
     */
    int getReloadTime();

    /**
     * Number of rounds the gun can fire in a min
     * ignoring reload time and other factors.
     * <p>
     * This is used most of the time to calculate
     * firing delay between rounds.
     *
     * @return rounds per min
     */
    int getRateOfFire();

    /**
     * Delay in milliseconds before
     * the next round will fire.
     * <p>
     * Used to control the firing action
     * of the weapon.
     *
     * @return delay in miliseconds
     */
    int getFiringDelay();
}
