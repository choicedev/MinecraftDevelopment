package com.choice.minecraftdevelopment.commands;

import com.choice.minecraftdevelopment.base.ExecutableCommand;
import com.choice.minecraftdevelopment.config.LoginConfig;
import com.choice.minecraftdevelopment.model.User;
import com.choice.minecraftdevelopment.util.DateTimeUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static com.choice.minecraftdevelopment.util.PluginChat.bold;
import static com.choice.minecraftdevelopment.util.PluginChat.errorMsg;

public class RegisterCommand extends ExecutableCommand {

    private final JavaPlugin plugin;

    public RegisterCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        super.onCommand(sender, command, label, args);

        Player p = (Player) sender;

        LoginConfig config = new LoginConfig(plugin, p.getDisplayName());

        if (args.length == 0) {
            p.sendMessage(errorMsg("Use: /register <password> <password>"));
            return true;
        }

        if (args.length == 1) {
            p.sendMessage(errorMsg("confirm password insert."));
            return true;
        }

        String password = args[0];
        String confirm_password = args[1];

        if (!password.equalsIgnoreCase(confirm_password)) {
            p.sendMessage(errorMsg("Senha diferente."));
            return true;
        }


        User user = new User(
                ""+p.getDisplayName(),
                password,
                true,
                DateTimeUtils.getCurrentDateTimeString(),
                DateTimeUtils.getCurrentDateTimeString()
        );

        config.saveUser(user);
        p.sendMessage(bold(ChatColor.GREEN) + "Usuário: " + ChatColor.AQUA + p.getDisplayName() + ChatColor.GREEN + "\n Registrado com sucesso!");
        return true;
    }
}
