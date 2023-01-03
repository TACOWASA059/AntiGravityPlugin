package com.github.tacowasa059.antigravityplugin;

import com.github.tacowasa059.antigravityplugin.commands.setGravity;
import com.github.tacowasa059.antigravityplugin.commands.startPlugin;
import com.github.tacowasa059.antigravityplugin.commands.stopPlugin;
import com.github.tacowasa059.antigravityplugin.listeners.ChangeGameMode;
import com.github.tacowasa059.antigravityplugin.listeners.PlayerMove;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiGravityPlugin extends JavaPlugin {
    private static Scheduler scheduler;
    private boolean CMD=false;//Onのときはtrue,OFFのときはfalse
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Plugin startup logic
        getCommand("Grav-start").setExecutor(new startPlugin(this));
        getCommand("Grav-stop").setExecutor(new stopPlugin(this));
        getCommand("setG").setExecutor(new setGravity(this));
        getServer().getPluginManager().registerEvents(new PlayerMove(),this);
        getServer().getPluginManager().registerEvents(new ChangeGameMode(this),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void setScheduler(){
        this.scheduler=new Scheduler(this);
        this.scheduler.AntiGravityEffect();
    }
    public void resetScheduler(){
        Bukkit.getScheduler().cancelTask(scheduler.getCount());
        scheduler=null;
        System.gc();
    }
    public void setCMD(boolean flag){
        CMD=flag;
    }
    public boolean getCMD(){
        return this.CMD;
    }
}
