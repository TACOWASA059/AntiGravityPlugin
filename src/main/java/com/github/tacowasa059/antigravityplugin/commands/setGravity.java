package com.github.tacowasa059.antigravityplugin.commands;

import com.github.tacowasa059.antigravityplugin.AntiGravityPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setGravity implements CommandExecutor {
    private final AntiGravityPlugin plugin;
    public setGravity(AntiGravityPlugin plugin){
        this.plugin=plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("grav")){
                if (args.length < 3) {
                    p.sendMessage("引数が不足しています。");
                    p.sendMessage("/<command> x y z");
                }
                else{
                    double x= Double.parseDouble(args[0]);
                    double y= Double.parseDouble(args[1]);
                    double z= Double.parseDouble(args[2]);
                    plugin.getConfig().set("g.x",x);
                    plugin.getConfig().set("g.y",y);
                    plugin.getConfig().set("g.z",z);
                    plugin.saveConfig();
                    p.sendMessage("重力を設定しました。");
                }
            }
        }

        return true;
    }
}
