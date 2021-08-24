package smily.plugin.randomevent.util;

import org.bukkit.event.server.PluginEvent;

import smily.plugin.randomevent.ConfigPlugin;

public class PluginMeta {
    private static Boolean started;
    private static Integer cooldown;

    public static Boolean isStarted() {
        if (started == null) {
            return started = false;
        } else return started;
    }

    public static void setStarted(boolean status){
        started = status;
    }

    public static Boolean getStarted(){
        return started;
    }
    public static void setCooldown(Integer cooldown) {
        PluginMeta.cooldown = cooldown;
    }

    public static Integer getCooldown() {
        return cooldown;
    }

    public static void storeStartedToConfig(){
        ConfigPlugin.set("started", getStarted());
    }
}
