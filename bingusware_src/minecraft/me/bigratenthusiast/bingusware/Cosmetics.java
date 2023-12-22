package me.bigratenthusiast.bingusware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

public class Cosmetics {
	// this code sucks please fix it
	
    public static String getSkin(String username) {
        try {
            return getTextureData(username).split("\"url\" : \"")[1].split("\"")[0];
        } catch (Exception e) {
            return null;
        }
    }

    public static String getCape(String username) {
        try {
            return getTextureData(username).split("CAPE")[1].split("\"url\" : \"")[1].split("\"")[0];
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean hasSmallArms(String username) {
        try {
            try {
                String textureData = getTextureData(username);
                if (textureData.contains("\"model\" :")) {
                    return getTextureData(username).contains("\"model\" : \"slim\"");
                } else {
                    return java.util.UUID.fromString(getUUID(username)).hashCode() % 2 == 1; // steve uuids are even
                }
            } catch (Exception e) {
                return java.util.UUID.fromString(getUUID(username)).hashCode() % 2 == 1; // ...and alex is used for odd ones
            }
        } catch (Exception e) {
            System.err.println("Could not detect skin model type of player " + username);
            System.err.println("Defaulting to MHF_STEVE model.");
            return false;
        }
    }

    public static String getTextureData(String username) {
        // ugh
        try {
            String UUID = getUUID(username);
            String decoded = getProfileData(UUID).split("textures\" : ")[1];
            if (decoded.contains("SKIN")) {
                return decoded.split("SKIN")[1];
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error in trying to get texture data of player " + username);
            return null;
        }
    }

    public static String getProfileData(String UUID) {
        try {
            BufferedReader raw = new BufferedReader(new InputStreamReader(new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + UUID).openStream()));
            String input = "";
            String value = "";
            for (String i; (i = raw.readLine()) != null; input += i);
            value = input.split("\"value\" : \"")[1].split("\"")[0];
            return new String(Base64.getDecoder().decode(value));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getUUID(String username) {
        // default UUID has a steve skin
        String UUID = "1b11f093008d48ebbabc76fd75655872";
        // cool void skin
        // String UUID = "037a1727407c45fdab2919382764e896";
        try  {
            BufferedReader raw = new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/" + username).openStream()));
            String input = "";
            for (String i;(i=raw.readLine())!=null;input+=i);
            UUID = input.split("\"")[3]; // hack to circumvent not being able to parse JSON
        } catch (Exception e) {
            System.err.println("Unable to get UUID of player " + username + ": " + e);
        }
        return UUID;
    }
}
