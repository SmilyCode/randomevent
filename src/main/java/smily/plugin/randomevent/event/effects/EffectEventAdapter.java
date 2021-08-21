package smily.plugin.randomevent.event.effects;

import org.bukkit.entity.Player;

public class EffectEventAdapter {
    public EffectEventAdapter(Player p){
        new EffectEvent(p);
    }
}
