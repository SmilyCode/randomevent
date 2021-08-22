package smily.plugin.randomevent.event.tnt;

import org.bukkit.entity.Player;
import smily.plugin.randomevent.event.Event;
import smily.plugin.randomevent.util.PluginContext;

public class TntEventAdapter implements Event {
    private NukeEvent nukeEvent = PluginContext.context.getBean(NukeEvent.class);
    private TntEvent tntEvent = PluginContext.context.getBean(TntEvent.class);


    @Override
    public void doEvent(Player player) {
        tntEvent.spawnOnPlayer(player);
        nukeEvent.nukeEvent(player);
    }
}
