package me.bigratenthusiast.bingusware.module.modules;

import me.bigratenthusiast.bingusware.Client;
import me.bigratenthusiast.bingusware.module.Module;
import org.lwjgl.input.Keyboard;

public class HideFeatures extends Module {
    public HideFeatures() { super("HideFeatures", Keyboard.KEY_Y, Type.RENDER); }

    @Override
    public void onEnable() {
        Client.hud.hideFeatures = true;
    }

    @Override
    public void onDisable() {
        Client.hud.hideFeatures = false;
    }
}
