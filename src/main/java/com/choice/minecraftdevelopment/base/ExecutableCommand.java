package com.choice.minecraftdevelopment.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class ExecutableCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only player command");
                return true;
            }
        } catch (CommandException ce){
            sender.sendMessage("Only player command");
            return true;
        }

        return false;
    }
}
