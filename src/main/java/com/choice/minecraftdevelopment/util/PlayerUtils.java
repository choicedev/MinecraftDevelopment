package com.choice.minecraftdevelopment.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerUtils {

    public static List<Player> blockedPlayersMove = new ArrayList<>();

    public static Player getTargetPlayer(String name){
        return Bukkit.getServer().getPlayerExact(name);
    }

}
