package smily.plugin.randomevent.event.lighting;

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
}
