package me.bigratenthusiast.bingusware;

import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;

public class Utils {
    public static FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
    public static String screenshotUrlDesign = "\u00a7f\u00a7e";

    public static class Colors {
        public static int blue = 0xFF55CDFC;
        public static int white = -1;
        public static int pink = 0xFFF7A8B8;
        public static int red = 0xFFF03E3E;
        public static int transparentGray = 0x90000000;
    }
    public static int[] transFlagColors(int length) {
        switch (length) {
            case 1:
                return new int[]{Colors.pink};
            default:
                return new int[]{Colors.blue, Colors.pink, Colors.white, Colors.pink, Colors.blue};
        }
    }

    /**
     * Capitalizes first letter in a word and makes all others lowercase
     * @param e - Word to prettify
     * @return - Original string with first letter capitalized and all others in lowercase
     */
    public static String prettyWord(String e) {
        String str = e.toLowerCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
