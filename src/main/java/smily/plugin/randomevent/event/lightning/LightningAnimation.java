package smily.plugin.randomevent.event.lightning;

import com.google.common.annotations.Beta;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.springframework.beans.factory.annotation.Autowired;
import smily.plugin.randomevent.time.Second;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.Randomizer;

import java.util.concurrent.atomic.AtomicInteger;


public class LightningAnimation{

    @Autowired
    Second second;

    @Autowired
    LightningLogic lightningLogic;

    AtomicInteger atomicInteger;

    public void delayStrike(Player p, Location loc, int delay){
        atomicInteger = new AtomicInteger();
        Bukkit.getScheduler().scheduleSyncDelayedTask(PluginContext.getPlugin(), () -> {
            lightningLogic.summonLighting(p, loc);
            atomicInteger.getAndIncrement();
        }, second.setTick(delay));
    }

    private int[] outsideSafeAreaLocation(){
        int[] safeArea = safeArea(4, 4);

        int randomX = Randomizer.randomValue(-10, 10);
        int randomY = Randomizer.randomValue(-10, 10);

        if (randomX < safeArea[0] && randomX > safeArea[1]){
            randomX = Randomizer.randomBetweenValue(safeArea[0], safeArea[1]);
        }

        if (randomY < safeArea[2] && randomY > safeArea[3]){
            randomY = Randomizer.randomBetweenValue(safeArea[2], safeArea[3]);
        }

        return new int[]{randomX, randomY};
    }

    public int[] safeArea(int squareX, int squareY){
        int oppositeSafeAreaLocationX = -squareX;
        int oppositeSafeAreaLocationY = -squareY;

        return new int[]{squareX, oppositeSafeAreaLocationX, squareY, oppositeSafeAreaLocationY};
    }

    public void normalLightingEventAnimation(Player p){
        int howMany = Randomizer.randomValue(2,5);
        int[] randomLocation;


        for (int i = 0; i <= howMany; i++){
            randomLocation = outsideSafeAreaLocation();
            delayStrike(p, p.getLocation().add(new Vector(randomLocation[0], 0, randomLocation[1])), Randomizer.randomValue(1,5));
        }

        Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginContext.getPlugin(),() -> {
            if (atomicInteger.get() == howMany) {
            delayStrike(p, p.getLocation(), Randomizer.randomValue(1, 2));
            lightningMessage(p,"Bzzt");
        }
        }, 0, 5);

    }

    @Beta
    public void lightingEventOnMobs(Player p){
        if (!lightningLogic.getNearbyMobs(p).isEmpty()){
        int howManyMobs =  lightningLogic.getNearbyMobs(p).size();

        for (int i = 0; i <= howManyMobs; i++) {

            delayStrike(p, lightningLogic.getNearbyMobs(p).get(i).getLocation(), Randomizer.randomValue(1, 3));

            if (i == howManyMobs) {
                if (howManyMobs <= 3) {

                    int howMany = Randomizer.randomValue(1, 2);

                        for (int a = 0; a <= Randomizer.randomValue(1, 2); i++) {

                            delayStrike(p, p.getLocation().add(new Vector(Randomizer.randomValue(4, 10), 0, Randomizer.randomValue(4, 10))), Randomizer.randomValue(1, 5));

                            if (a == howMany) {
                                delayStrike(p, p.getLocation(), Randomizer.randomValue(1, 2));
                            }
                        }
                    } else {

                        delayStrike(p, p.getLocation(), Randomizer.randomValue(1, 2));

                    }
                }
            }
        }
    }

    public void lightningMessage(Player p, String message){
        p.sendMessage("[" + ChatColor.BLUE + "RandomThunder" + ChatColor.WHITE + "]" + " " + message);
    }


}
