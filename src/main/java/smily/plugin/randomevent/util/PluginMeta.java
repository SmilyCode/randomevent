package smily.plugin.randomevent.util;

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

    public static void setCooldown(Integer cooldown) {
        PluginMeta.cooldown = cooldown;
    }

    public static Integer getCooldown() {
        return cooldown;
    }
}
