package smily.plugin.randomevent.event.mobs;

import com.google.common.annotations.Beta;
import org.bukkit.entity.Player;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.Randomizer;

public class RandomMobsLogic {

    private MobsList mobType = PluginContext.context.getBean(MobsList.class);

    public void spawnOnPlayer(Player p, int howMany){
        for (int i = 0; i < howMany; i++){
            p.getWorld().spawnEntity(p.getLocation(), mobType.randomType());
        }
    }

    public void randomSpawn(Player p){
        spawnOnPlayer(p, Randomizer.randomValue(10));
    }

    @Beta
    public void spawnArroundPlayer(){
    }


    // Separate the spawn of hostile mobs and normal mobs
    @Beta
    private void separateSpawn(){

    }


}
