package org.kitteh.vanish.bukkit.player;

import org.bukkit.entity.Player;
import org.kitteh.vanish.api.player.VPlayer;
import org.kitteh.vanish.bukkit.VanishPlugin;

public class BukkitVPlayer extends VPlayer {

    Player bukkitPlayer;
    VanishPlugin plugin;

    public BukkitVPlayer(Player player, VanishPlugin plugin) {
        this.bukkitPlayer = player;
        this.plugin = plugin;
    }

    @Override
    public void tock() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDisplayName() {
        return bukkitPlayer.getDisplayName();
    }

    @Override
    public String getName() {
        return bukkitPlayer.getName();
    }

    @Override
    public void updateVisibility() {
        for (BukkitVPlayer player : plugin.VPlayers) {
            if (this.canSee(player)) {
                this.bukkitPlayer.showPlayer(player.bukkitPlayer);
            } else {
                this.bukkitPlayer.hidePlayer(player.bukkitPlayer);
            }
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof BukkitVPlayer) {
            return this.hashCode() == ((BukkitVPlayer) object).hashCode();
        }
        if (object instanceof Player) {
            return this.bukkitPlayer.equals((Player) object);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.bukkitPlayer.hashCode();
    }

}
