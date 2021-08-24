package smily.plugin.randomevent;

import org.bukkit.plugin.java.JavaPlugin;
import smily.plugin.randomevent.command.RandomEventCommand;
import smily.plugin.randomevent.event.StartRandomEvent;
import smily.plugin.randomevent.util.PluginMeta;

public final class RandomEvent extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        PluginMeta.setStarted( (Boolean) ConfigPlugin.get("started"));

        if (PluginMeta.isStarted()){
            new StartRandomEvent();
        }

        getCommand("randomevent").setExecutor(new RandomEventCommand());
    }


}
