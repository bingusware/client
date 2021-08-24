package me.bigratenthusiast.bingusware;

import me.bigratenthusiast.bingusware.command.CommandManager;
import me.bigratenthusiast.bingusware.module.Module;
import me.bigratenthusiast.bingusware.module.modules.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;


public class Client {
    public static String name = "Bingusware", version = "my beloved", applicationId = "865980568286003200";
    public static Module[] modules = new Module[] {
            new Flight(), new Fullbright(), new TransRights(), new NoFall(), new Franky()
    };
    public static final HUD hud = new HUD();

    public static void onStart() {
        System.err.println(name + " - " + version);
        Display.setTitle(name);
    }

    public static boolean callEvent(EventType type, Object... params) {
        for (Module module : modules) {
            // Module is toggled before added to our little makeshift "event bus"
            if (type == EventType.KEYPRESS && module.getKey() == (int) params[0]) module.toggle();
            // Make sure we don't have a GUI or chat open
            if (!(Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen() || Minecraft.getMinecraft().currentScreen != null)) {
                if (module.toggled) if (!module.onEvent(type, params)) return false;
            }
            if (type == EventType.TICK) {
                if (module.toggled && module.percentSlidIn < 100) module.percentSlidIn+=hud.slideSpeed;
                if (!module.toggled && module.percentSlidIn > 0) module.percentSlidIn-=hud.slideSpeed;
            }
        }
        if (!CommandManager.onEvent(type, params)) return false;
        return true;
    }

    public static String[] getEnabledModulesList() {
        ArrayList<String> enabledModules = new ArrayList<>();
        for (Module module : modules) {
            if (module.percentSlidIn > 0) enabledModules.add(module.name);
        }
        return enabledModules.toArray(new String[0]);
    }

    public static int getPercentSlidIn(String name) {
        for (Module module : modules) {
            if (module.name.equalsIgnoreCase(name)) return module.percentSlidIn;
        }
        return -1;
    }

    public static boolean isModuleEnabled(String name) {
        for (Module module : modules) {
            if (module.name.equalsIgnoreCase(name)) return module.toggled;
        }
        return false;
    }

    public enum EventType {
        KEYPRESS, TICK, RENDER_GUI, CHAT_EVENT
    }
}
