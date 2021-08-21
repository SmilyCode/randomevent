package smily.plugin.randomevent.event.effects;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Arrays;

public class EffectEvent {

    PotionEffect potionEffect;
    PotionEffect[] potionEffectList = {
            new PotionEffect(PotionEffectType.LEVITATION, 10, Randomizer.randomValue(2)),
            new PotionEffect(PotionEffectType.CONFUSION, 10, Randomizer.randomValue(10)),
            new PotionEffect(PotionEffectType.HUNGER, 10, Randomizer.randomValue(3)),
            new PotionEffect(PotionEffectType.SATURATION, 10, Randomizer.randomValue(3)),
            new PotionEffect(PotionEffectType.SPEED, 10, Randomizer.randomValue(5)),
            new PotionEffect(PotionEffectType.JUMP, 10, Randomizer.randomValue(5)),
            new PotionEffect(PotionEffectType.POISON, 10, Randomizer.randomValue(3)),
            new PotionEffect(PotionEffectType.REGENERATION, 10, Randomizer.randomValue(2)),
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10, Randomizer.randomValue(2)),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, Randomizer.randomValue(2)),
    };

    public EffectEvent(Player p) {
        potionMessage(p);
        setRandomEffect(p);
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
