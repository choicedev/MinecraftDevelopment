package com.choice.minecraftdevelopment.commands;

import com.choice.minecraftdevelopment.base.ExecutableCommand;
import com.choice.minecraftdevelopment.config.LoginConfig;
import com.choice.minecraftdevelopment.model.User;
import com.choice.minecraftdevelopment.util.DateTimeUtils;
import com.choice.minecraftdevelopment.util.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static com.choice.minecraftdevelopment.util.PluginChat.bold;
import static com.choice.minecraftdevelopment.util.PluginChat.errorMsg;

public class LoginCommand extends ExecutableCommand {

    private final JavaPlugin plugin;

    public LoginCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        super.onCommand(sender, command, label, args);

        Player p = (Player) sender;
        LoginConfig config = new LoginConfig(plugin, p.getDisplayName());
        User user = config.loadUser();

        if (args.length == 0) {
            p.sendMessage(errorMsg("Use: /login <password>"));
            return true;
        }

        if(user == null){
            p.sendMessage(errorMsg("User not found"));
            return true;
        }

        String password = args[0];

        if (!password.equalsIgnoreCase(user.getPassword())) {
            p.sendMessage(errorMsg("Password incorrect."));
            return true;
        }


        p.sendMessage(bold(ChatColor.BLUE) + "Logado com sucesso!");
        config.setOnline(true);
        config.setLastLogin(DateTimeUtils.getCurrentDateTimeString());

        PlayerUtils.blockedPlayersMove.remove(p);
        return true;
    }
}
