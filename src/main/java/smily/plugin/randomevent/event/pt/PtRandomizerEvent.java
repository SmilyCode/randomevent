package smily.plugin.randomevent.event.pt;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import smily.plugin.randomevent.event.Event;
import smily.plugin.randomevent.util.Randomizer;

public final class PtRandomizerEvent implements Event{

    List<PtEvents> ptEvents = new ArrayList<>();

    @Override
    public void doEvent(Player player) {
        ptEvents.add(new PtLightningEvent(player));

        PtEvents ptEvent = (PtEvents) Randomizer.randomListValue(ptEvents);
        ptEvent.doEvent();
    }
    
}