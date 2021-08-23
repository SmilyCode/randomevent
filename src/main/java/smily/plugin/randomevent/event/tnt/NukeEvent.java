package smily.plugin.randomevent.event.tnt;

import org.bukkit.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;

public class NukeEvent{
    @Autowired
    TntEvent tntEvent;

    public void nukeEvent(Player player){


        for (double a = -4; a<=4; a++){
            for (double b = -4; b<=4; b++){
                spawnOnTopOfPlayer(player, a, 5, b);
            }
        }
    }

    public void spawnOnTopOfPlayer(Player p, double x, double y, double z){
        p.getWorld().spawnEntity(p.getLocation().add(x, y, z), tntEvent.getTnt());
    }
}
