package smily.plugin.randomevent.event.mobs;

import com.google.common.annotations.Beta;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.Randomizer;

public class RandomMobsLogic {

    private final MobsList mobType = PluginContext.context.getBean(MobsList.class);
    private EntityType mob;

    // Spawn on player's feet location
    public void spawnOnPlayer(Player p, int howMany){
        mob = mobType.randomType();
        spawnEntityMessage(p);

        for (int i = 0; i < howMany; i++){
            p.getWorld().spawnEntity(p.getLocation(), mob);
        }
    }

    // Spawn randomly (on player, or arround player)
    public void randomSpawn(Player p){
        spawnOnPlayer(p, Randomizer.randomValue(10));
    }

    // call a method to spawn all the spawn message logic
    private void spawnEntityMessage(Player p){
        if (mob != null){
            setSpawnEntityMessage(p,EntityType.COW, "Mooo..");
            setSpawnEntityMessage(p,EntityType.SILVERFISH, "Psst aku dibawahmu");
            setSpawnEntityMessage(p,EntityType.TROPICAL_FISH, "Hah? Ikan?");
            setSpawnEntityMessage(p,EntityType.ZOMBIE, "Otak! aku butuh Otak!");
            setSpawnEntityMessage(p,EntityType.SHEEP, "Mbee..");
            setSpawnEntityMessage(p,EntityType.SKELETON, "Bagaimana dengan panah ku? Hahahaha!");
            setSpawnEntityMessage(p,EntityType.AXOLOTL, "Halo? aku imut kan?");
            setSpawnEntityMessage(p,EntityType.GHAST, "Ada ubur-ubur terbang!");
            setSpawnEntityMessage(p,EntityType.BLAZE, "Kubakar kalian! hahaha!");
            setSpawnEntityMessage(p,EntityType.SPIDER, "Psst! mau liat aku manjat?");
        }
    }

    // set a spawn entity message logic
    private void setSpawnEntityMessage(Player p, EntityType type, String message){
        if (mob.equals(type)){
            p.sendMessage("[" + ChatColor.RED + "RandomMobs" + ChatColor.WHITE + "]" + " " + message);
        }
    }

    // Spawn arround player
    @Beta
    public void spawnArroundPlayer(){
    }


    // Separate the spawn of hostile mobs and normal mobs
    @Beta
    private void separateSpawn(){

    }




}
