package smily.plugin.randomevent.event.effects;

import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.springframework.lang.NonNull;
import smily.plugin.randomevent.command.RandomEventCommand;

public class EffectEvent {
    PotionEffect[] potionEffectList = {
            new PotionEffect(PotionEffectType.LEVITATION, RandomEventCommand.cooldown, 2)
    };
}
