package org.kitteh.vanish.bukkit.player;

import org.bukkit.entity.Player;
import org.kitteh.vanish.api.player.VPlayer;

public class BukkitVPlayer extends VPlayer {
    
    Player bukkitPlayer;
    
    public BukkitVPlayer (Player player) {
        this.bukkitPlayer = player;
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
        
    }

}
