package smily.plugin.randomevent;

import org.bukkit.plugin.java.JavaPlugin;
import smily.plugin.randomevent.command.RandomEventCommand;

public final class RandomEvent extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("randomevent").setExecutor(new RandomEventCommand());
    }


}
