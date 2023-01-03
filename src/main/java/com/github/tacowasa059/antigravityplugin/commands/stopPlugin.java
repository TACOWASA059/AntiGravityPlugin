package com.github.tacowasa059.antigravityplugin.commands;

import com.github.tacowasa059.antigravityplugin.AntiGravityPlugin;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class stopPlugin implements CommandExecutor {
    private final AntiGravityPlugin plugin;

    public stopPlugin(AntiGravityPlugin plugin){
        this.plugin=plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!plugin.getCMD()){
            plugin.getServer().broadcastMessage("AntiGravityPlugin is already deactivated.");
        }
        else{
            plugin.resetScheduler();
            for(Player p:plugin.getServer().getOnlinePlayers()){
                if(p.getGameMode()!=GameMode.SPECTATOR&&p.getGameMode()!=GameMode.CREATIVE) p.setGravity(true);
            }
            plugin.setCMD(false);
        }
        return true;
    }
}