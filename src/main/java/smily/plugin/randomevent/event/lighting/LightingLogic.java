package smily.plugin.randomevent.event.lighting;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LightingLogic {

    public void summonLighting(Player p, Location location){
        p.getWorld().strikeLightning(location);
    }

    public List<Entity> getNearbyMobs(Player p){
        Collection<Entity> entity = p.getWorld().getNearbyEntities(p.getLocation(), 6, 1, 6);

        return new ArrayList<>(entity);
    }
}
