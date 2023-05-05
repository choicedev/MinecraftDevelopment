package com.choice.minecraftdevelopment.manager;

import com.choice.minecraftdevelopment.util.ConsoleLogger;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager {

    private final JavaPlugin plugin;

    public CommandManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommand(String commandName, CommandExecutor executor) {
        PluginCommand command = plugin.getCommand(commandName);
        if (command == null) {
            ConsoleLogger.severe("Command not found: " + commandName);
            return;
        }
        command.setExecutor(executor);
    }

}

