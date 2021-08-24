package me.bigratenthusiast.bingusware;

public class Cosmetics {
    public static String protocol = "https";
    public static String mojangSkinApi = "://mc-heads.net/skin/", mojangCloakApi = "://mc-heads.net/cape/";

    public static String getSkin(String username) {
        return protocol + mojangSkinApi + username + ".png";
    }

    public static String getCape(String username) {
        return protocol + mojangCloakApi + username;
    }
}
