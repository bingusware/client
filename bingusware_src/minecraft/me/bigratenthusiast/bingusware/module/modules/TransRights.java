package me.bigratenthusiast.bingusware.module.modules;

import me.bigratenthusiast.bingusware.Client;
import me.bigratenthusiast.bingusware.module.Module;
import org.lwjgl.input.Keyboard;

public class TransRights extends Module {
    public TransRights() { super("TransRights", Keyboard.KEY_H, Type.RENDER); }

    @Override
    public void onEnable() {
        Client.hud.transRights = true;
    }

    @Override
    public void onDisable() {
        Client.hud.transRights = false; // :(
    }
}
