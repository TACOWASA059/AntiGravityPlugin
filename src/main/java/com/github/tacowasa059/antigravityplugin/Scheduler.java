package com.github.tacowasa059.antigravityplugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.Random;

public class Scheduler {
    private final AntiGravityPlugin plugin;
    private int count;

    public Scheduler(AntiGravityPlugin plugin) {
        this.plugin = plugin;
        for(Player p :plugin.getServer().getOnlinePlayers()){
            if(p.getGameMode()!= GameMode.SPECTATOR&&p.getGameMode()!=GameMode.CREATIVE)p.setGravity(false);
        }
        count=0;
    }
    public void AntiGravityEffect(){
        BukkitScheduler scheduler= Bukkit.getServer().getScheduler();
        count =scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                Vector g=new Vector(plugin.getConfig().getDouble("g.x"),plugin.getConfig().getDouble("g.y"),plugin.getConfig().getDouble("g.z"));
                Vector dv=g.multiply((plugin.getConfig().getLong("dt")/20.0));
                for(Player p:plugin.getServer().getOnlinePlayers()){
                    if(p.getGameMode()!=GameMode.SPECTATOR&&p.getGameMode()!=GameMode.CREATIVE)p.setVelocity(p.getVelocity().add(dv));
                }
            }
        }, 0L, plugin.getConfig().getLong("dt"));
    }
    public int getCount(){
        return count;
    }
}
