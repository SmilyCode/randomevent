package smily.plugin.randomevent;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import smily.plugin.randomevent.command.RandomEventCommand;
import smily.plugin.randomevent.config.PluginConfig;
import smily.plugin.randomevent.config.YamlVariable;
import smily.plugin.randomevent.event.StartRandomEvent;
import smily.plugin.randomevent.scoreboard.ScoreboardLogic;
import smily.plugin.randomevent.util.PluginContext;

public final class RandomEvent extends JavaPlugin {

    ScoreboardLogic scoreboardLogic = PluginContext.context.getBean(ScoreboardLogic.class);
    PluginConfig pluginConfig = PluginContext.context.getBean(PluginConfig.class);
    YamlVariable yamlVariable = PluginContext.context.getBean(YamlVariable.class);

    @Override
    public void onEnable() {
        
        
        try {
            pluginConfig.createDefaultConfig();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            pluginConfig.checkAnyYamlEmpty();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            yamlVariable.setStarted(pluginConfig.get().getStarted());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (yamlVariable.getStarted()){
            new StartRandomEvent();
        }

        getCommand("randomevent").setExecutor(new RandomEventCommand());
    }

    @Override
    public void onDisable(){
        try {
            pluginConfig.override();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Save progress to config");
    }

}
