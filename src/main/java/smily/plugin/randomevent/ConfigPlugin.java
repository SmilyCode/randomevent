package smily.plugin.randomevent;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import smily.plugin.randomevent.util.PluginContext;

import java.io.File;

public class ConfigPlugin {
    private static File configFile;
    private static FileConfiguration config = PluginContext.getPlugin().getConfig();

    public static void saveConfig(){
        PluginContext.getPlugin().saveConfig();
    }

    public static void set(String path, Object value){
        config.set(path, value);
    }

    public static void reload(){
        configFile = new File(PluginContext.getPlugin().getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static Object get(String path){
        return config.get(path);
    }
}
