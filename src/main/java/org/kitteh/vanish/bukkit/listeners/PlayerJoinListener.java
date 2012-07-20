package org.kitteh.vanish.bukkit.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.kitteh.vanish.bukkit.VanishPlugin;
import org.kitteh.vanish.bukkit.player.BukkitVPlayer;

public class PlayerJoinListener implements Listener {

    private VanishPlugin plugin;

    public PlayerJoinListener(VanishPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        this.plugin.VPlayers.add(new BukkitVPlayer(event.getPlayer(), this.plugin));
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        this.plugin.VPlayers.remove(event.getPlayer());
    }

}
