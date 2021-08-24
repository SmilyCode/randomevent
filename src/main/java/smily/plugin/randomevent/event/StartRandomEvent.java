package smily.plugin.randomevent.event;

import org.bukkit.Bukkit;

import smily.plugin.randomevent.event.effects.EffectEventAdapter;
import smily.plugin.randomevent.event.lighting.LightingEventAdapter;
import smily.plugin.randomevent.event.mobs.RandomMobsAdapter;
import smily.plugin.randomevent.event.tnt.TntEventAdapter;
import smily.plugin.randomevent.event.util.EventErrorHandler;
import smily.plugin.randomevent.scoreboard.MainScoreboard;
import smily.plugin.randomevent.scoreboard.ScoreboardLogic;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.PluginMeta;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Arrays;

public class StartRandomEvent {

    boolean errorHandlers;

    EventErrorHandler eventErrorHandler = PluginContext.context.getBean(EventErrorHandler.class);
    
    MainScoreboard mainScoreboard = PluginContext.context.getBean(MainScoreboard.class);
    ScoreboardLogic scoreboardLogic = PluginContext.context.getBean(ScoreboardLogic.class);

    Event[] events = {
            new EffectEventAdapter(),
            new RandomMobsAdapter(),
            new TntEventAdapter(),
            new LightingEventAdapter()
    };

    public void startEvent(){
        errorHandlers = eventErrorHandler.getAllError();

        if (!errorHandlers) {
            
            scoreboardLogic.getDaysFromConfig();
            mainScoreboard.createScoreboard();
            

            Bukkit.getOnlinePlayers().stream().forEach( 
                player -> {
                    player.setScoreboard(mainScoreboard.getScoreboard());
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginContext.getPlugin(), () -> mainScoreboard.updateScore(player), 0, 10);
            });
            
            Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginContext.getPlugin(), () -> {
                Bukkit.getOnlinePlayers().stream().forEach(player -> {
                    Event event = (Event) Randomizer.randomListValue(Arrays.asList(events));
                    event.doEvent(player);
                });
            }, 0, PluginMeta.getCooldown());

            

        } else {
            
        }
    }
}
