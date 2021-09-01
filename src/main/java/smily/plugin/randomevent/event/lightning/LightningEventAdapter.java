package smily.plugin.randomevent.event.lightning;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import smily.plugin.randomevent.event.Event;
import smily.plugin.randomevent.util.PluginContext;

public class LightningEventAdapter implements Event {

    LightningLogic lightingLogic = PluginContext.context.getBean(LightningLogic.class);
    LightningAnimation lightingAnimation = PluginContext.context.getBean(LightningAnimation.class);

    @Override
    public void doEvent(Player player) {
        lightingAnimation.normalLightingEventAnimation(player);
    }

    public void summonLightning(Player p){
        lightingLogic.summonLighting(p, p.getLocation());
    }

    public void summonLightning(Player p, Location location){
        lightingLogic.summonLighting(p, location);
    }

    public void summonDelayStrike(Player p, int delaySec){
        lightingAnimation.delayStrike(p, p.getLocation(), delaySec);
    }

    public void summonDelayStrike(Player p, Location location, int delaySec){
        lightingAnimation.delayStrike(p, location, delaySec);
    }
}
