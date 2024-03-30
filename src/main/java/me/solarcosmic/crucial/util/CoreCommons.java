package me.solarcosmic.crucial.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CoreCommons {
    public static List<String> getPlayerList()
    {
        List<String> playerNames = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()){
            playerNames.add(player.getName());
        }
        return playerNames;
    }

    public static List<String> getOnlinePlayerList() { return getPlayerList(); }

}