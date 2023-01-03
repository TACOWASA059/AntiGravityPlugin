package com.github.tacowasa059.antigravityplugin.commands;

import com.github.tacowasa059.antigravityplugin.AntiGravityPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class startPlugin implements CommandExecutor {
    private final AntiGravityPlugin plugin;

    public startPlugin(AntiGravityPlugin plugin){
        this.plugin=plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(plugin.getCMD()){
            plugin.getServer().broadcastMessage("AntiGravityPlugin is already activated.");
        }
        else{
            plugin.setScheduler();
            plugin.setCMD(true);
        }
        return true;
    }
}
