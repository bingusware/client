package me.bigratenthusiast.bingusware;

import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;
import net.minecraft.src.ScaledResolution;
import org.lwjgl.Sys;

public class HUD {

    public Minecraft minecraft = Minecraft.getMinecraft();
    public final int offset = 4;
    public final int actionBarDuration = 1000;
    public boolean transRights;
    public boolean hideFeatures;
    public int slideSpeed = 20;


    public String actionBarText = "";
    public Long lastActionFlash = 0L;

    public void draw() {
        ScaledResolution sr = new ScaledResolution(minecraft.gameSettings, minecraft.displayWidth, minecraft.displayHeight);

        if (!hideFeatures) {
            Utils.fontRenderer.drawString(Client.name, offset, offset, -1);
            String[] enabledModules = Client.getEnabledModulesList();


            for (int i = 0; i < enabledModules.length; i++) {
                String m = enabledModules[i];

                int left = (sr.getScaledWidth() - offset) - (int) (Utils.fontRenderer.getStringWidth(m)*Client.getPercentSlidIn(m)/100f);
                int top = offset + ((Utils.fontRenderer.FONT_HEIGHT + 6) * i);

                // Background Box
                Gui.drawRect(left-3, top, sr.getScaledWidth(), top + 4 + Utils.fontRenderer.FONT_HEIGHT, Utils.Colors.transparentGray);

                // Rectangle
                Gui.drawRect(left-6, top, left-3, top + 4 + Utils.fontRenderer.FONT_HEIGHT, transRights ? Utils.transFlagColors(enabledModules.length)[i%4] : -1);

                Utils.fontRenderer.drawString(m, left, top+3, -1, true);
            }
        }

        // draw action bar
        if (lastActionFlash + actionBarDuration > System.currentTimeMillis()) {
            Utils. fontRenderer.drawString(actionBarText, (int) ((sr.getScaledWidth() / 2f) - (Utils.fontRenderer.getStringWidth(actionBarText) / 2f)), sr.getScaledHeight() - 60, -1, true);
        } else actionBarText = "";

        Client.callEvent(Client.EventType.RENDER_GUI);
    }

    public void drawActionBar(String string) {
        lastActionFlash = System.currentTimeMillis();
        actionBarText = string;
    }
}
