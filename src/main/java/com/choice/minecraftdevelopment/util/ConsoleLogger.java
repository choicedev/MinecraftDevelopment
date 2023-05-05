package com.choice.minecraftdevelopment.util;

import org.bukkit.Bukkit;

import java.util.logging.Level;

public class ConsoleLogger {

    private static final String PREFIX = "[Minecraft Development] ";

    private static void log(Level level, String message) {
        Bukkit.getLogger().log(level, PREFIX + message);
    }

    public static void info(String message) {
        log(Level.INFO, message);
    }

    public static void warning(String message) {
        log(Level.WARNING, message);
    }

    public static void severe(String message) {
        log(Level.SEVERE, message);
    }

}

