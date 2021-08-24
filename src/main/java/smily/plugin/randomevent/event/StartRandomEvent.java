package smily.plugin.randomevent.event;

import org.bukkit.Bukkit;
import smily.plugin.randomevent.event.effects.EffectEventAdapter;
import smily.plugin.randomevent.event.lighting.LightingEventAdapter;
import smily.plugin.randomevent.event.mobs.RandomMobsAdapter;
import smily.plugin.randomevent.event.tnt.TntEventAdapter;
import smily.plugin.randomevent.event.util.EventErrorHandler;
import smily.plugin.randomevent.scoreboard.MainScoreboard;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.PluginMeta;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Arrays;

public class StartRandomEvent {

    boolean errorHandlers;
    EventErrorHandler eventErrorHandler = PluginContext.context.getBean(EventErrorHandler.class);

    Event[] events = {
            new EffectEventAdapter(),
            new RandomMobsAdapter(),
            new TntEventAdapter(),
            new LightingEventAdapter()
    };

    MainScoreboard mainScoreboard = PluginContext.context.getBean(MainScoreboard.class);

    public StartRandomEvent() {
        errorHandlers = eventErrorHandler.getAllError();

        if (!errorHandlers) {
            Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginContext.getPlugin(), () -> {
                Bukkit.getOnlinePlayers().stream().forEach(player -> {
                    Event event = (Event) Randomizer.randomListValue(Arrays.asList(events));
                    event.doEvent(player);
                    player.setScoreboard(mainScoreboard.getScoreboard());
                });
            }, 0, PluginMeta.getCooldown());
        } else {

        }
    }
}
