package smily.plugin.randomevent.event.tnt;

import org.bukkit.entity.Player;
import smily.plugin.randomevent.event.Event;
import smily.plugin.randomevent.util.PluginContext;

import java.util.Random;

public class TntEventAdapter implements Event {
    private final NukeEvent nukeEvent = PluginContext.context.getBean(NukeEvent.class);
    private final TntEvent tntEvent = PluginContext.context.getBean(TntEvent.class);


    @Override
    public void doEvent(Player player) {
        if (new Random().nextBoolean()) {
            tntEvent.spawnOnPlayer(player);
        } else {
            nukeEvent.nukeEvent(player);
        }
    }
}
