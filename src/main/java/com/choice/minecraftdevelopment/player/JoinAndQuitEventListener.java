package com.choice.minecraftdevelopment.player;

import com.choice.minecraftdevelopment.config.LoginConfig;
import com.choice.minecraftdevelopment.config.SpawnConfig;
import com.choice.minecraftdevelopment.model.User;
import com.choice.minecraftdevelopment.util.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static com.choice.minecraftdevelopment.util.PluginChat.bold;

public class JoinAndQuitEventListener implements Listener {

    private final SpawnConfig spawnConfig;
    private final JavaPlugin plugin;
    public JoinAndQuitEventListener(SpawnConfig spawnConfig, JavaPlugin plugin) {
        this.spawnConfig = spawnConfig;
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent quitEvent){
        Player p = quitEvent.getPlayer();
        LoginConfig loginConfig = new LoginConfig(plugin, p.getDisplayName());
        loginConfig.setOnline(false);
        PlayerUtils.blockedPlayersMove.remove(p);
        quitEvent.setQuitMessage(bold(ChatColor.AQUA) + p.getDisplayName() + bold(ChatColor.RED) + " has leave the game.");
    }



    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        LoginConfig loginConfig = new LoginConfig(plugin, p.getDisplayName());
        Location location = spawnConfig.getSpawnLocation();
        User user = loginConfig.loadUser();

        PlayerUtils.blockedPlayersMove.add(p);


        if (p.hasPlayedBefore()) {
            e.setJoinMessage(bold(ChatColor.AQUA) + p.getDisplayName() + bold(ChatColor.GREEN) + " welcome again.");
        } else {
            e.setJoinMessage(bold(ChatColor.AQUA) + p.getDisplayName() + bold(ChatColor.GREEN) + " has joined the game.");
        }

        if(location != null){
            p.teleport(location);
        }

        if (user != null) {
            p.sendTitle(bold(ChatColor.AQUA) + "Welcome " + p.getDisplayName() + "!", "" +
                    ChatColor.GREEN + "Use /login <password> to login and be able to play.", 20, 60, 20);
        } else {
            p.sendTitle(bold(ChatColor.AQUA) + "Welcome " + p.getDisplayName() + "!", "" +
                    ChatColor.DARK_GRAY + "Use /register <password> <confirm_password> to register and be able to play.", 20, 60, 20);
        }

    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        Location location = spawnConfig.getSpawnLocation();
        if(PlayerUtils.blockedPlayersMove.contains(p)){
            e.setCancelled(true);
            p.teleport(location);
        }
    }
}
