package com.choice.minecraftdevelopment.manager;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EventManager {

    private final JavaPlugin plugin;

    public EventManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerEvents(Listener listener) {
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(listener, plugin);
    }
}

