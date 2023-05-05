package com.choice.minecraftdevelopment.commands;

import com.choice.minecraftdevelopment.base.ExecutableCommand;
import com.choice.minecraftdevelopment.util.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.choice.minecraftdevelopment.util.PluginChat.bold;

public class GameModeCommand extends ExecutableCommand {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        super.onCommand(sender, command, label, args);

        Player p = (Player) sender;


        if(args.length == 0){
            p.sendMessage(ChatColor.DARK_RED + "You must use 0, 1 or 2");
            return true;
        }

        String mode_string = args[0];
        int mode;

        try {
            mode = Integer.parseInt(mode_string);
        }catch (Exception e){
            p.sendMessage(ChatColor.RED + "You must use number!");
            return true;
        }

        if(args.length > 1){
            String name = args[1];
            Player target = PlayerUtils.getTargetPlayer(name);

            if(target == null){
                p.sendMessage(bold(ChatColor.RED) + name + " has Offline.");
                return true;
            }

            changeGameMode(mode, target);
            target.sendMessage(ChatColor.DARK_GREEN + "Your game mode has been changed by the "+bold(ChatColor.DARK_BLUE) + p.getDisplayName());
            return true;
        }

        changeGameMode(mode, p);
        return true;
    }


    private void changeGameMode(int mode, Player p){
        switch (mode) {
            case 0:
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.YELLOW + "Your game mode now is "+ bold(ChatColor.AQUA) + "CREATIVE");
                break;
            case 1:
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.YELLOW + "Your game mode now is "+ bold(ChatColor.AQUA) + "SURVIVAL");
                break;
            case 2:
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ChatColor.YELLOW + "Your game mode now is "+ bold(ChatColor.AQUA) + "ADVENTURE");
                break;
            default:
                p.sendMessage(ChatColor.RED + "Choose a number between 0 and 2");
                break;
        }
    }
}
