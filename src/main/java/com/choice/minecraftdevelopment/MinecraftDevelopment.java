package com.choice.minecraftdevelopment;

import com.choice.minecraftdevelopment.base.BasePlugin;
import com.choice.minecraftdevelopment.commands.*;
import com.choice.minecraftdevelopment.config.SpawnConfig;
import com.choice.minecraftdevelopment.manager.CommandManager;
import com.choice.minecraftdevelopment.manager.EventManager;
import com.choice.minecraftdevelopment.player.JoinAndQuitEventListener;
import com.choice.minecraftdevelopment.player.PlayerRespawnEventListener;
import com.choice.minecraftdevelopment.util.ConsoleLogger;

public class MinecraftDevelopment extends BasePlugin {

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        ConsoleLogger.warning("Disabled");
    }


    public void initCommands(CommandManager cm) {
        cm.registerCommand("fly", new FlyCommand());
        cm.registerCommand("gamemode", new GameModeCommand());
        cm.registerCommand("setspawn", new SetSpawnCommand(new SpawnConfig(this)));
        cm.registerCommand("spawn", new SpawnCommand(new SpawnConfig(this)));
        cm.registerCommand("register", new RegisterCommand(this));
        cm.registerCommand("login", new LoginCommand(this));
    }

    @Override
    public void initListeners(EventManager cm) {
        cm.registerEvents(new JoinAndQuitEventListener(new SpawnConfig(this), this));
        cm.registerEvents(new PlayerRespawnEventListener(new SpawnConfig(this)));
    }
}
