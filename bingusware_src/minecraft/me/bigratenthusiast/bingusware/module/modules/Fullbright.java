package me.bigratenthusiast.bingusware.module.modules;


import me.bigratenthusiast.bingusware.module.Module;
import org.lwjgl.input.Keyboard;

public class Fullbright extends Module {
    public Fullbright() { super("Fullbright", Keyboard.KEY_O, Type.RENDER); }

    private static float initialGamma = 0;

    @Override
    public void onEnable() {
        initialGamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 100;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = initialGamma;
        initialGamma = 0;
    }

}