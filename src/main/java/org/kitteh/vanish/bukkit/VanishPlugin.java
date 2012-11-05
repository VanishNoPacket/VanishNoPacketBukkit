package org.kitteh.vanish.bukkit;

import java.util.HashSet;
import java.util.MissingResourceException;

import org.bukkit.plugin.java.JavaPlugin;
import org.kitteh.vanish.bukkit.listeners.PlayerJoinListener;
import org.kitteh.vanish.bukkit.localization.Localization;
import org.kitteh.vanish.bukkit.player.BukkitVPlayer;

public class VanishPlugin extends JavaPlugin{
    
    public HashSet<BukkitVPlayer> VPlayers = new HashSet<BukkitVPlayer>();
    
    @Override
    public void onEnable() {
        try {
            new Localization(getConfig().getString("localization.language", "english"));
        } catch (MissingResourceException e) {
            this.getLogger().severe(e.getMessage());
            this.getLogger().severe("Unknown language: " + getConfig().getString("localization.language", "english"));
            this.getLogger().severe("Defaulting to english");
            new Localization("english");
        }
        new PlayerJoinListener(this);
        this.getCommand("vanish").setExecutor(new BaseVanishCommand(this));
        
        this.getServer().getScheduler().scheduleSyncDelayedTask(this, new TockTask(this), 10);
        
        this.getLogger().info(Localization.getString("VanishPlugin.pluginEnabled", this.getDescription().getVersion()));
    }
    
    @Override
    public void onDisable() {
        this.getServer().getScheduler().cancelTasks(this);
    }

}
