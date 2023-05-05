package com.choice.minecraftdevelopment.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public abstract class ConfigManager {

    private final JavaPlugin plugin;
    private final String fileName;
    private File configFile;
    private FileConfiguration fileConfig;

    public ConfigManager(JavaPlugin plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
    }

    public void reloadConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), fileName);
        }
        fileConfig = YamlConfiguration.loadConfiguration(configFile);
    }

    public void saveConfig() {
        if (fileConfig == null || configFile == null) {
            return;
        }
        try {
            getFileConfig().save(configFile);
        } catch (IOException ex) {
            plugin.getLogger().severe("Could not save config file " + fileName + ": " + ex.getMessage());
        }
    }

    public FileConfiguration getFileConfig() {
        if (fileConfig == null) {
            reloadConfig();
        }
        return fileConfig;
    }
}
