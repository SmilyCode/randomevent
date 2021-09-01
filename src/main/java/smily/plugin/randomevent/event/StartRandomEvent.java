package smily.plugin.randomevent.event;

import org.bukkit.Bukkit;

import smily.plugin.randomevent.config.YamlVariable;
import smily.plugin.randomevent.event.effects.EffectEventAdapter;
import smily.plugin.randomevent.event.lighting.LightingEventAdapter;
import smily.plugin.randomevent.event.mobs.RandomMobsAdapter;
import smily.plugin.randomevent.event.pt.PtRandomizerEvent;
import smily.plugin.randomevent.event.tnt.TntEventAdapter;
import smily.plugin.randomevent.event.util.EventErrorHandler;
import smily.plugin.randomevent.scoreboard.MainScoreboard;
import smily.plugin.randomevent.scoreboard.ScoreboardLogic;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Arrays;

public class StartRandomEvent {

    private boolean errorHandlers;

    private final EventErrorHandler eventErrorHandler = PluginContext.context.getBean(EventErrorHandler.class);
    private final MainScoreboard mainScoreboard = PluginContext.context.getBean(MainScoreboard.class);
    private final ScoreboardLogic scoreboardLogic = PluginContext.context.getBean(ScoreboardLogic.class);
    private final YamlVariable yamlVariable = PluginContext.context.getBean(YamlVariable.class);

    Event[] events = {
            new EffectEventAdapter(),
            new RandomMobsAdapter(),
            new TntEventAdapter(),
            new LightingEventAdapter(),
            new PtRandomizerEvent()
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
            }, 0, yamlVariable.getCooldown());
            
        } else {
            
        }
    }
}
