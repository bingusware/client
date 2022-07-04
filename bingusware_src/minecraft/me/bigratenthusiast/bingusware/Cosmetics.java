package me.bigratenthusiast.bingusware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

public class Cosmetics {

    // not a huge fan of being relient on a third-party api, but it will do for the time being
    public static String getSkin(String username) {
        return "https://crafatar.com/skins/" + getUUID(username);
    }

    public static String getCape(String username) {
        return "https://crafatar.com/capes/" + getUUID(username);
    }

    public static boolean hasSmallArms(String username) {
        try {
            String UUID = getUUID(username);
            String decoded = getProfileData(UUID).split("textures\" : ")[1];
            if (decoded.contains("SKIN")) {
                return decoded.split("SKIN")[1].contains("slim");
            } else {
                return java.util.UUID.fromString(UUID).hashCode() % 2 == 1; // ...and alex is used for odd ones
            }
        } catch (Exception e) {
            System.out.println("Could not detect skin model type of player " + username);
            System.out.println("Defaulting to MHF_STEVE model.");
            return false;
        }
    }
    public static String getProfileData(String UUID) {
        try {
            BufferedReader raw = new BufferedReader(new InputStreamReader(new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + UUID).openStream()));
            String input = "";
            String value = "";
            for (String i; (i = raw.readLine()) != null; input += i) ;
            value = input.split("\"value\" : \"")[1].split("\"")[0];
            return new String(Base64.getDecoder().decode(value));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getUUID(String username) {
        String UUID = "037a1727-407c-45fd-ab29-19382764e896"; // error uuid
        try  {
            BufferedReader raw = new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/" + username).openStream()));
            String input = "";
            for (String i;(i=raw.readLine())!=null;input+=i);
            UUID = input.split("id\":\"")[1].split("\"")[0];
        } catch (Exception e) {
            System.out.println("Unable to get UUID of player " + username);
        }
        return UUID;
    }
}
