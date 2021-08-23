package smily.plugin.randomevent.event.tnt;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class TntEvent {
    private final EntityType tnt = EntityType.PRIMED_TNT;


    public EntityType getTnt() {
        return tnt;
    }

    public void spawnOnPlayer(Player p){
        p.getWorld().spawnEntity(p.getLocation(), tnt);
        tntMessage(p, "Boom! hehe");
    }

    public void tntMessage(Player p, String message){
        p.sendMessage("[" + ChatColor.RED + "RandomTNT" + ChatColor.WHITE + "]" + " " + message);
    }

}
