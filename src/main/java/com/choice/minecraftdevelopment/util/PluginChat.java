package com.choice.minecraftdevelopment.util;

import org.bukkit.ChatColor;

public class PluginChat {


    public static String bold(ChatColor chatColor){
        return chatColor + "" + ChatColor.BOLD;
    }

    public static String errorMsg(String msg){
        return ChatColor.RED + "" + ChatColor.BOLD + msg;
    }

}
