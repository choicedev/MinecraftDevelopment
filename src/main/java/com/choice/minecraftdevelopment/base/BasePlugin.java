package com.choice.minecraftdevelopment.base;

import com.choice.minecraftdevelopment.config.LoginConfig;
import com.choice.minecraftdevelopment.config.SpawnConfig;
import com.choice.minecraftdevelopment.manager.CommandManager;
import com.choice.minecraftdevelopment.manager.EventManager;
import com.choice.minecraftdevelopment.util.ConsoleLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePlugin extends JavaPlugin implements BaseMain {

    private CommandManager commandManager;
    private EventManager eventManager;

    @Override
    public void onEnable() {
        super.onEnable();

        enablingPlugin();

        commandManager = new CommandManager(this);
        eventManager = new EventManager(this);


        setConfigs();


        initCommands(commandManager);
        initListeners(eventManager);
    }


    private void setConfigs(){

        SpawnConfig spawnConfig = new SpawnConfig(this);
        spawnConfig.getFileConfig().options().copyDefaults();
        spawnConfig.saveConfig();

        LoginConfig loginConfig = new LoginConfig(this);
        loginConfig.getFileConfig().options().copyDefaults();
        loginConfig.saveConfig();

    }

    private void enablingPlugin() {
// Crie uma lista de objetos que contenham as informações que deseja exibir
        List<Object[]> pluginInfo = new ArrayList<>();
        pluginInfo.add(new Object[]{"Choice Dev", "1.0"});

        // Defina o tamanho de cada coluna da tabela
        int colWidth = 20;

        // Imprima a linha superior da tabela
        String loggerFormat = String.format("+-%-" + (colWidth - 2) + "s-+-%" + (colWidth - 1) + "s-+", "-".repeat(colWidth - 1), "-".repeat(colWidth - 1));
        ConsoleLogger.info(loggerFormat);

        // Imprima o título da tabela
        ConsoleLogger.info(String.format("| %-" + (colWidth) + "s | ",  "Minecraft Development", ""));

        // Imprima a linha abaixo do título
        ConsoleLogger.info(loggerFormat);

        // Imprima o cabeçalho da tabela
        ConsoleLogger.info(String.format("| %-" + (colWidth-1) + "s | %-" + (colWidth-1) + "s |", "Author", "Version"));
        ConsoleLogger.info(String.format("|-%-" + (colWidth-2) + "s-+-%" + (colWidth-1) + "s-|", "-".repeat(colWidth-1), "-".repeat(colWidth-1)));

        // Imprima as linhas da tabela
        for (Object[] info : pluginInfo) {
            ConsoleLogger.info(String.format("| %-" + (colWidth-1) + "s | %-" + (colWidth-1) + "s |", info[0], info[1]));
        }

        // Imprima a linha inferior da tabela
        ConsoleLogger.info(loggerFormat);

    }
}
