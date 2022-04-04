package me.bigratenthusiast.bingusware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Cosmetics {
    public static String getSkin(String username) {
        return "https://crafatar.com/skins/" + getUUID(username);
    }

    public static String getCape(String username) {
        return "https://crafatar.com/capes/" + getUUID(username);
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
        System.out.println(UUID);
        return UUID;
    }
}
