package smily.plugin.randomevent.event.effects;

import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.springframework.lang.NonNull;
import smily.plugin.randomevent.command.RandomEventCommand;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Arrays;

public class EffectEvent {
    PotionEffect[] potionEffectList = {
            new PotionEffect(PotionEffectType.LEVITATION, RandomEventCommand.cooldown, 2),
            new PotionEffect(PotionEffectType.CONFUSION, RandomEventCommand.cooldown, 10),
            new PotionEffect(PotionEffectType.HUNGER, RandomEventCommand.cooldown, 2),
            new PotionEffect(PotionEffectType.CONFUSION, RandomEventCommand.cooldown, 10),
            new PotionEffect(PotionEffectType.SPEED, RandomEventCommand.cooldown, 5),
            new PotionEffect(PotionEffectType.CONFUSION, RandomEventCommand.cooldown, 10),
            new PotionEffect(PotionEffectType.REGENERATION, RandomEventCommand.cooldown, 2),
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, RandomEventCommand.cooldown, 2),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, RandomEventCommand.cooldown, 2),
    };

    public EffectEvent(Player p){
        setRandomEffect(p);
    }

    void setRandomEffect(Player p){
        p.addPotionEffect((PotionEffect) Randomizer.randomListValue(Arrays.asList(potionEffectList)));
    }
}
