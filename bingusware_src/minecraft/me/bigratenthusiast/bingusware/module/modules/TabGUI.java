package me.bigratenthusiast.bingusware.module.modules;

import me.bigratenthusiast.bingusware.Client;
import me.bigratenthusiast.bingusware.Utils;
import me.bigratenthusiast.bingusware.module.Module;
import net.minecraft.src.Gui;
import org.lwjgl.input.Keyboard;

public class TabGUI extends Module {
    public TabGUI() {
        super("TabGUI", Keyboard.KEY_NONE, Type.RENDER);
    }

    public int currentTab, currentModule;
    public boolean expanded;

    // TODO: this (lol!!!)

    @Override
    public boolean onEvent(Client.EventType type, Object... params) {
        if (type == Client.EventType.RENDER_GUI) {

            int height = (Utils.fontRenderer.FONT_HEIGHT + 6);

            /* Module Types */
            // Draw Background
            Gui.drawRect(5, 30, 70, 30 + (Type.values().length * 16 + 4), Utils.Colors.transparentGray);
            // Indicate which tab we are on
            Gui.drawRect(10, 34 + (height * currentTab), 8, 46+(height * currentTab), Utils.Colors.red);
            // Text
            for (int c = 0; c < Module.Type.values().length; c++) {
                Utils.fontRenderer.drawString(Utils.prettyWord(Module.Type.values()[c].name()), 12, 36 + (height*c), Utils.Colors.white, true);
            }

            if (expanded) {
                /* Modules */
                // Draw Background
                Gui.drawRect(70, 30, 70 + 65, 30 + (Type.values().length * 16 + 4), Utils.Colors.transparentGray);
                // Indicate which tab we are on
                Gui.drawRect(10+ 70, 34 + (height * currentModule), 78, 46+(height * currentModule), Utils.Colors.red);
                // Text
                for (int c = 0; c < Module.Type.values().length; c++) {
                    Utils.fontRenderer.drawString(Utils.prettyWord(Module.Type.values()[c].name()), 12+70, 36 + (height*c), Utils.Colors.white, true);
                }
            }

        }

        if (type == Client.EventType.KEYPRESS) {
            int key = (int) params[0];
            if (!expanded) {
                currentTab = editWithKey(currentTab, Type.values().length -1, key);
            } else {

            }

            expanded = key == Keyboard.KEY_RIGHT || (key != Keyboard.KEY_LEFT && expanded);

        }
        return true;
    }
    private int editWithKey(int a, int b, int key) {
        a = key == Keyboard.KEY_UP ? a-1 : key == Keyboard.KEY_DOWN ? a+1: a;
        a = a > b -1 ? 0 : a < 0 ? b -1 : a;
        return a;
    }
}