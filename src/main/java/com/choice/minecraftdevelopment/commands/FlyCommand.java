package com.choice.minecraftdevelopment.commands;

import com.choice.minecraftdevelopment.base.ExecutableCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand extends ExecutableCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        super.onCommand(sender, command, label, args);

        Player p = (Player) sender;

        if(p.getAllowFlight()){
            p.setAllowFlight(false);
            p.sendMessage(
                    ChatColor.YELLOW + "Fly disabled."
            );
        }else{
            p.setAllowFlight(true);
            p.sendMessage(
                    ChatColor.YELLOW + "Fly enabled."
            );
        }

        return false;
    }
}
