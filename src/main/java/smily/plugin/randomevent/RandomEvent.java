package smily.plugin.randomevent;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import smily.plugin.randomevent.command.RandomEventCommand;
import smily.plugin.randomevent.event.lighting.LightingAnimation;
import smily.plugin.randomevent.event.lighting.LightingLogic;
import smily.plugin.randomevent.event.tnt.NukeEvent;
import smily.plugin.randomevent.util.PluginContext;

import java.util.Arrays;

public final class RandomEvent extends JavaPlugin {

   LightingAnimation lightingAnimation = PluginContext.context.getBean(LightingAnimation.class);

    @Override
    public void onEnable() {
        saveDefaultConfig();


        getCommand("randomevent").setExecutor(new RandomEventCommand());
    }


}
