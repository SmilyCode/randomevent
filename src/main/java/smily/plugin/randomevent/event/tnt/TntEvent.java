package smily.plugin.randomevent.event.tnt;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class TntEvent {
    private final EntityType tnt = EntityType.PRIMED_TNT;


    public EntityType getTnt() {
        return tnt;
    }

    public void spawnOnPlayer(Player p){
        p.getWorld().spawnEntity(p.getLocation(), tnt);
    }

}
