package com.github.tacowasa059.antigravityplugin.listeners;

import com.github.tacowasa059.antigravityplugin.AntiGravityPlugin;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;


public class ChangeGameMode implements Listener {
    private final AntiGravityPlugin plugin;
    public ChangeGameMode(AntiGravityPlugin plugin){
        this.plugin=plugin;
    }
    @EventHandler
    void onChangeGameModeEvent(PlayerGameModeChangeEvent e){
        Player p= e.getPlayer();
        if(p.getGameMode()== GameMode.CREATIVE||p.getGameMode()==GameMode.SPECTATOR||!plugin.getCMD()){
            p.setGravity(true);
        }
        else{
            if(plugin.getCMD())p.setGravity(false);
        }
    }
}
