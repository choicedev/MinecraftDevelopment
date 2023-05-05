package com.choice.minecraftdevelopment.commands;

import com.choice.minecraftdevelopment.base.ExecutableCommand;
import com.choice.minecraftdevelopment.config.SpawnConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.choice.minecraftdevelopment.util.PluginChat.bold;

public class SpawnCommand extends ExecutableCommand {

    private final SpawnConfig config;

    public SpawnCommand(SpawnConfig config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        super.onCommand(sender, command, label, args);

        Player p = (Player) sender;

        Location location = config.getSpawnLocation();
        if(location != null){
            p.teleport(location);
        }else{
            p.sendMessage(bold(ChatColor.RED) + "Spawn not set!");
        }

        return true;
    }
}
