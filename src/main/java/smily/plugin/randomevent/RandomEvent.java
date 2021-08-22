package smily.plugin.randomevent;

import org.bukkit.plugin.java.JavaPlugin;
import smily.plugin.randomevent.command.RandomEventCommand;
import smily.plugin.randomevent.event.mobs.RandomMobsLogic;
import smily.plugin.randomevent.util.PluginContext;

public final class RandomEvent extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();



        getCommand("randomevent").setExecutor(new RandomEventCommand());
    }


}
