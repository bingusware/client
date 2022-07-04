package me.bigratenthusiast.bingusware.feature;

import me.bigratenthusiast.bingusware.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.src.KeyBinding;
import org.lwjgl.input.Keyboard;

public class ZoomFeature {
    public static Minecraft mc = Minecraft.getMinecraft();
    public static KeyBinding keyBindZoom = new KeyBinding("key.zoom", Keyboard.KEY_C);
    public static float initialFov = mc.gameSettings.fovSetting;
    public static float initialMouseSensitivity = mc.gameSettings.mouseSensitivity;
    public static float zoomDepth = 5f;
    public static boolean prevState;

    public static boolean onEvent(Client.EventType type, Object... params) {
        if (type == Client.EventType.TICK) {
            // Make sure we don't have a GUI or chat open
            boolean keyPressed = Keyboard.isKeyDown(keyBindZoom.keyCode) && !mc.ingameGUI.getChatGUI().getChatOpen() && mc.currentScreen == null;
            if (keyPressed != prevState) {
                if (keyPressed) {
                    initialFov = mc.gameSettings.fovSetting;
                    initialMouseSensitivity = mc.gameSettings.mouseSensitivity;

                    mc.gameSettings.fovSetting = translateToStupidFovFormat(translateToSensibleFovFormat(initialFov)/zoomDepth);
                    mc.gameSettings.mouseSensitivity = initialMouseSensitivity/zoomDepth;
                } else {
                    mc.gameSettings.fovSetting = initialFov;
                    mc.gameSettings.mouseSensitivity = initialMouseSensitivity;
                }
            }
            if (!keyPressed) {
                initialFov = mc.gameSettings.fovSetting;
                initialMouseSensitivity = mc.gameSettings.mouseSensitivity;
            }
            prevState = keyPressed;
        }
        return true;
    }

    private static float translateToSensibleFovFormat(float fov) {
        return (fov*40) + 70;
    }
    private static float translateToStupidFovFormat(float fov) {
        return (fov-70) / 40;
    }
}
