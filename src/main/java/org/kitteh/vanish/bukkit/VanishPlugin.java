package org.kitteh.vanish.bukkit;

import java.util.HashSet;

import org.bukkit.plugin.java.JavaPlugin;
import org.kitteh.vanish.bukkit.listeners.PlayerJoinListener;
import org.kitteh.vanish.bukkit.player.BukkitVPlayer;

public class VanishPlugin extends JavaPlugin{
    
    public HashSet<BukkitVPlayer> VPlayers = new HashSet<BukkitVPlayer>();
    
    @Override
    public void onEnable() {
        new PlayerJoinListener(this);
        
        this.getServer().getScheduler().scheduleSyncDelayedTask(this, new TockTask(this), 10);
    }
    
    @Override
    public void onDisable() {
        this.getServer().getScheduler().cancelTasks(this);
    }

}
