package smily.plugin.randomevent.event;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import smily.plugin.randomevent.event.effects.EffectEventAdapter;
import smily.plugin.randomevent.event.lightning.LightningEventAdapter;
import smily.plugin.randomevent.event.mobs.RandomMobsAdapter;
import smily.plugin.randomevent.event.pt.PtRandomizerEvent;
import smily.plugin.randomevent.event.tnt.TntEventAdapter;
import smily.plugin.randomevent.event.util.EventErrorHandler;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Arrays;

public class StartRandomEvent {

    private boolean errorHandlers;

    private final EventErrorHandler eventErrorHandler = PluginContext.context.getBean(EventErrorHandler.class);
    @NotNull
    private Integer eventCooldown;

    Event[] events = {
            new EffectEventAdapter(),
            new RandomMobsAdapter(),
            new TntEventAdapter(),
            new LightningEventAdapter(),
            new PtRandomizerEvent()
    };

    public void startEvent(){
        errorHandlers = eventErrorHandler.getAllError();

        if (!errorHandlers) {
            Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginContext.getPlugin(), () -> {
                Bukkit.getOnlinePlayers().stream().forEach(player -> {
                    Event event = Randomizer.randomListValue(Arrays.asList(events));
                    event.doEvent(player);
                });
            }, 0, eventCooldown);
        } else {
            
        }
    }

    public Integer getEventCooldown() {
        return eventCooldown;
    }

    public void setEventCooldown(Integer eventCooldown) {
        this.eventCooldown = eventCooldown;
    }
}
