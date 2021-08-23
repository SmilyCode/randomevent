package smily.plugin.randomevent.event.lighting;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import smily.plugin.randomevent.event.Event;
import smily.plugin.randomevent.util.PluginContext;

public class LightingEventAdapter implements Event {

    LightingLogic lightingLogic = PluginContext.context.getBean(LightingLogic.class);
    LightingAnimation lightingAnimation = PluginContext.context.getBean(LightingAnimation.class);

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
