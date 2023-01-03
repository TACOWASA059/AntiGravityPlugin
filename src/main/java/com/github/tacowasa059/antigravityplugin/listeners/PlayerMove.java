package com.github.tacowasa059.antigravityplugin.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
    @EventHandler
    void onPlayerMoveEvent(PlayerMoveEvent e){
        Player p=e.getPlayer();
        if(p.getLocation().getY()>255){
            if(p.getGameMode()!= GameMode.SPECTATOR&&p.getGameMode()!=GameMode.CREATIVE) p.setHealth(0.0);
        }
    }
}
