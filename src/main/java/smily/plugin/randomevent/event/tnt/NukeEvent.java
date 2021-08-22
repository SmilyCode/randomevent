package smily.plugin.randomevent.event.tnt;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class NukeEvent extends TntEvent{
    public void nukeEvent(Player player){


        for (double a = -4; a<=4; a++){
            for (double b = -4; b<=4; b++){
                spawnOnTopOfPlayer(player, a, 5, b);
            }
        }
    }

    public void spawnOnTopOfPlayer(Player p, double x, double y, double z){
        p.getWorld().spawnEntity(p.getLocation().add(x, y, z), getTnt());
    }
}
