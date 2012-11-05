package org.kitteh.vanish.bukkit;

import org.kitteh.vanish.bukkit.player.BukkitVPlayer;

public class TockTask implements Runnable {
    
    VanishPlugin plugin;
    
    public TockTask(VanishPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (BukkitVPlayer player : plugin.VPlayers) {
            player.tock();
        }
    }

}
