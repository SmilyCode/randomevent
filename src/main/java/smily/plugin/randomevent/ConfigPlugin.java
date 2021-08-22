package smily.plugin.randomevent;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import smily.plugin.randomevent.util.PluginContext;

import java.io.File;

public class ConfigPlugin {
    private static File configFile = new File(PluginContext.plugin.getDataFolder(), "config.yml");
    private static FileConfiguration config;

    public static void saveConfig(){
        PluginContext.plugin.saveConfig();
    }

    public static void set(String path, Object value){
        config.set(path, value);
    }

    public static void reload(){
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static void get(String path){
        config.get(path);
    }
}
