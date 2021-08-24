package smily.plugin.randomevent;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import smily.plugin.randomevent.command.RandomEventCommand;
import smily.plugin.randomevent.event.lighting.LightingAnimation;
import smily.plugin.randomevent.event.lighting.LightingLogic;
import smily.plugin.randomevent.event.tnt.NukeEvent;
import smily.plugin.randomevent.scoreboard.MainScoreboard;
import smily.plugin.randomevent.scoreboard.ScoreboardLogic;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.PluginMeta;

import java.util.Arrays;

public final class RandomEvent extends JavaPlugin {

    ScoreboardLogic scoreboardLogic = PluginContext.context.getBean(ScoreboardLogic.class);
    MainScoreboard mainScoreboard = PluginContext.context.getBean(MainScoreboard.class);
    @Override
    public void onEnable() {
        saveDefaultConfig();

        PluginMeta.setStarted(Boolean.parseBoolean((String) ConfigPlugin.get("started")));

        if (PluginMeta.isStarted()){

        }


        mainScoreboard.createScoreboard();
        Bukkit.getOnlinePlayers().forEach(players -> players.setScoreboard(mainScoreboard.getScoreboard()));


        getCommand("randomevent").setExecutor(new RandomEventCommand());
    }


}
