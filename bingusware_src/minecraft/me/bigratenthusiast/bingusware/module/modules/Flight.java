package me.bigratenthusiast.bingusware.module.modules;


import me.bigratenthusiast.bingusware.Client;
import me.bigratenthusiast.bingusware.module.Module;
import org.lwjgl.input.Keyboard;

public class Flight extends Module {
    public Flight() { super("Flight", Keyboard.KEY_R, Type.MOVEMENT); }

    public float flySpeed = 1f;
    private float defaultFlySpeed = 0;
    private boolean flyingAllowed;
    private boolean wasFlying;

    @Override
    public void onEnable() {
        defaultFlySpeed = mc.thePlayer.capabilities.getFlySpeed();
        flyingAllowed = mc.thePlayer.capabilities.allowFlying;
        wasFlying = mc.thePlayer.capabilities.isFlying;

        mc.thePlayer.capabilities.setFlySpeed(flySpeed);
        mc.thePlayer.capabilities.allowFlying = true;
        mc.thePlayer.capabilities.isFlying = true;
    }

    @Override
    public void onDisable() {
        mc.thePlayer.capabilities.setFlySpeed(defaultFlySpeed);
        mc.thePlayer.capabilities.allowFlying = flyingAllowed;
        mc.thePlayer.capabilities.isFlying = wasFlying;
    }

    @Override
    public boolean onEvent(Client.EventType type, Object... params) {
        if (type == Client.EventType.TICK) {
            mc.thePlayer.capabilities.allowFlying = true;
            mc.thePlayer.capabilities.isFlying = true;
        }
        return true;
    }
}