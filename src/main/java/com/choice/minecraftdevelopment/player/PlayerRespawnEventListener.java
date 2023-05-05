package com.choice.minecraftdevelopment.player;

import com.choice.minecraftdevelopment.config.SpawnConfig;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import static com.choice.minecraftdevelopment.config.SpawnConfig.SPAWN_KEY;

public class PlayerRespawnEventListener implements Listener {


    private final SpawnConfig spawnConfig;

    public PlayerRespawnEventListener(SpawnConfig spawnConfig) {
        this.spawnConfig = spawnConfig;
    }


    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Location location = spawnConfig.getSpawnLocation();

        if(location != null){
            e.setRespawnLocation(location);
        }
    }

}
