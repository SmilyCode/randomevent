package smily.plugin.randomevent;

import org.bukkit.plugin.java.JavaPlugin;

import smily.plugin.randomevent.command.RandomEventCommand;
import smily.plugin.randomevent.config.PluginConfig;
import smily.plugin.randomevent.util.PluginContext;

public final class RandomEvent extends JavaPlugin {

    PluginConfig pluginConfig = PluginContext.context.getBean(PluginConfig.class);

    @Override
    public void onEnable() {
        pluginConfig.setup(this);
        pluginConfig.createDefaultConfig();
        pluginConfig.load();

        

        getCommand("randomevent").setExecutor(new RandomEventCommand());
    }

    @Override
    public void onDisable(){
        pluginConfig.writeAll();
        pluginConfig.override();
        
        System.out.println("Save progress to config");
    }

}
