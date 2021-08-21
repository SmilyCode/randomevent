package smily.plugin.randomevent.event.mobs;

import org.bukkit.entity.Player;
import smily.plugin.randomevent.event.Event;
import smily.plugin.randomevent.util.PluginContext;

public class RandomMobsAdapter implements Event{

    private final RandomMobsLogic randomMobsSpawnLogic = PluginContext.context.getBean(RandomMobsLogic.class);

    @Override
    public void doEvent(Player player) {
        randomMobsSpawnLogic.randomSpawn(player);
    }
}
