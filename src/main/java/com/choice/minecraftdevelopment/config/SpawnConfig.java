package com.choice.minecraftdevelopment.config;

import com.choice.minecraftdevelopment.manager.ConfigManager;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnConfig extends ConfigManager {

    public static final String SPAWN_KEY = "spawn";

    public SpawnConfig(JavaPlugin plugin) {
        super(plugin, "spawn_config.yml");
    }

    public void setSpawnLocation(Location spawnLocation) {
        getFileConfig().set(SPAWN_KEY, spawnLocation);
        saveConfig();
    }

    public Location getSpawnLocation() {
        return getFileConfig().getLocation(SPAWN_KEY);
    }
}





