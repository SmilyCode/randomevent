package smily.plugin.randomevent.event.effects;

import org.bukkit.entity.Player;
import smily.plugin.randomevent.event.Event;

public class EffectEventAdapter implements Event {

    @Override
    public void doEvent(Player p) {
        new EffectEvent(p);
    }
}
