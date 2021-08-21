package smily.plugin.randomevent.event.effects;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import smily.plugin.randomevent.time.Second;
import smily.plugin.randomevent.time.Time;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Arrays;

public class EffectEvent {

    PotionEffect potionEffect;
    Time second = PluginContext.context.getBean(Second.class);
    PotionEffect[] potionEffectList = {
            new PotionEffect(PotionEffectType.LEVITATION, second.setTick(10), Randomizer.randomValue(2)),
            new PotionEffect(PotionEffectType.CONFUSION, second.setTick(10), Randomizer.randomValue(10)),
            new PotionEffect(PotionEffectType.HUNGER, second.setTick(10), Randomizer.randomValue(3)),
            new PotionEffect(PotionEffectType.SATURATION, second.setTick(10), Randomizer.randomValue(3)),
            new PotionEffect(PotionEffectType.SPEED, second.setTick(10), Randomizer.randomValue(5)),
            new PotionEffect(PotionEffectType.JUMP, second.setTick(10), Randomizer.randomValue(5)),
            new PotionEffect(PotionEffectType.POISON, second.setTick(10), Randomizer.randomValue(3)),
            new PotionEffect(PotionEffectType.REGENERATION, second.setTick(10), Randomizer.randomValue(2)),
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, second.setTick(10), Randomizer.randomValue(2)),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, second.setTick(10), Randomizer.randomValue(2)),
    };

    public EffectEvent(Player p) {
        setRandomEffect(p);
        potionMessage(p);
    }

    void setRandomEffect(Player p) {
        p.addPotionEffect(potionEffect = (PotionEffect) Randomizer.randomListValue(Arrays.asList(potionEffectList)));
    }

    void potionMessage(Player p) {
        if (potionEffect != null) {
            if (potionEffect.getType().equals(PotionEffectType.LEVITATION)) {
                p.sendMessage("Wah enak ya pemandangannya!");
            } else if (potionEffect.getType().equals(PotionEffectType.CONFUSION)) {
                p.sendMessage("Aduh kok pusing ya?");
            } else if (potionEffect.getType().equals(PotionEffectType.HUNGER)) {
                p.sendMessage("Bunyi perut siapa itu?");
            } else if (potionEffect.getType().equals(PotionEffectType.SATURATION)) {
                p.sendMessage("Wih udh kenyang nih.");
            } else if (potionEffect.getType().equals(PotionEffectType.REGENERATION)) {
                p.sendMessage("Ayo Sembuh!");
            } else if (potionEffect.getType().equals(PotionEffectType.POISON)) {
                p.sendMessage("Siapa yang racuni aku?");
            } else if (potionEffect.getType().equals(PotionEffectType.FIRE_RESISTANCE)) {
                p.sendMessage("Aku Kebal Api Hahaha");
            } else if (potionEffect.getType().equals(PotionEffectType.DAMAGE_RESISTANCE)) {
                p.sendMessage("Aku kebal dari serangan musuh hahaha!");
            } else if (potionEffect.getType().equals(PotionEffectType.JUMP)) {
                p.sendMessage("Sepertinya aku tertular kelinci");
            } else if (potionEffect.getType().equals(PotionEffectType.DAMAGE_RESISTANCE)) {
                p.sendMessage("Cepat! Cepat! Cepat!");
            }
        }
    }
}
