package me.bigratenthusiast.bingusware.module;

import me.bigratenthusiast.bingusware.Client.EventType;
import net.minecraft.client.Minecraft;

public class Module {
    public String name;
    public boolean toggled = false;
    public int keycode;
    public Type type;

    public int percentSlidIn;


    protected final Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, int keycode, Type t) {
        this.name = name;
        this.type = t;
        this.keycode = keycode;
    }

    public boolean isEnabled() {
        return toggled;
    }

    public int getKey() {
        return this.keycode;
    }

    public void setKey(int keycode) {
        this.keycode = keycode;
    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) {
            System.out.println(name + " Enabled");
            percentSlidIn = 0;
            onEnable();
        } else {
            System.out.println(name + " Disabled");
            onDisable();
        }
    }

    public void onEnable() {}

    public void onDisable() {}

    public boolean onEvent(EventType type, Object... params) { return true; }

    public enum Type {
        MOVEMENT, RENDER, MISC
    }
}