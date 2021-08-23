package smily.plugin.randomevent.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PluginContext {
    public static ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfiguration.class);

    public static Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("RandomEvent");
    }
}
