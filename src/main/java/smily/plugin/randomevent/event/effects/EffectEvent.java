package smily.plugin.randomevent.event.effects;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
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
            new PotionEffect(PotionEffectType.LEVITATION, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(2)),
            new PotionEffect(PotionEffectType.CONFUSION, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(10)),
            new PotionEffect(PotionEffectType.HUNGER, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(3)),
            new PotionEffect(PotionEffectType.SATURATION, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(3)),
            new PotionEffect(PotionEffectType.SPEED, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(5)),
            new PotionEffect(PotionEffectType.JUMP, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(5)),
            new PotionEffect(PotionEffectType.POISON, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(3)),
            new PotionEffect(PotionEffectType.REGENERATION, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(2)),
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(2)),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, second.setTick(Randomizer.randomValue(30)), Randomizer.randomValue(2)),
    };

    protected EffectEvent(Player p) {
        setRandomEffect(p);
        potionMessage(p);
        playEffectSound(p);
    }

    private void setRandomEffect(Player p) {
        p.addPotionEffect(potionEffect = (PotionEffect) Randomizer.randomListValue(Arrays.asList(potionEffectList)));
    }

    private void potionMessage(Player p) {
        if (potionEffect != null) {
            setPotionEffectMessage(p, PotionEffectType.LEVITATION, "Wah pemandangan yang indah ya!");
            setPotionEffectMessage(p, PotionEffectType.CONFUSION, "Aduh kok pusing ya?");
            setPotionEffectMessage(p, PotionEffectType.HUNGER, "Bunyi perut siapa itu?");
            setPotionEffectMessage(p, PotionEffectType.SATURATION, "Wih udh kenyang nih.");
            setPotionEffectMessage(p, PotionEffectType.REGENERATION, "Ayo Sembuh!");
            setPotionEffectMessage(p, PotionEffectType.POISON, "Siapa yang racuni aku?!");
            setPotionEffectMessage(p, PotionEffectType.FIRE_RESISTANCE, "Aku kebal Api Hahaha");
            setPotionEffectMessage(p, PotionEffectType.DAMAGE_RESISTANCE, "Aku kebal dari serangan musuh hahaha!");
            setPotionEffectMessage(p, PotionEffectType.JUMP, "Sepertinya aku tertular kelinci");
            setPotionEffectMessage(p, PotionEffectType.SPEED, "Cepat! Cepat! Cepat!");
        }
    }

    private void playEffectSound(Player p) {
        if (potionEffect != null) {
            if (potionEffect.getType().equals(PotionEffectType.JUMP) ||
                    potionEffect.getType().equals(PotionEffectType.REGENERATION) ||
                    potionEffect.getType().equals(PotionEffectType.FIRE_RESISTANCE) ||
                    potionEffect.getType().equals(PotionEffectType.DAMAGE_RESISTANCE) ||
                    potionEffect.getType().equals(PotionEffectType.SATURATION) ||
                    potionEffect.getType().equals(PotionEffectType.SPEED)){
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 0f);
            } else
                if (potionEffect.getType().equals(PotionEffectType.POISON) ||
                    potionEffect.getType().equals(PotionEffectType.LEVITATION) ||
                    potionEffect.getType().equals(PotionEffectType.CONFUSION) ||
                    potionEffect.getType().equals(PotionEffectType.HUNGER))
            {
                p.playSound(p.getLocation(), Sound.ENTITY_WITCH_AMBIENT, 1f, 2f);
            }
        }

    }

    private void setPotionEffectMessage(Player p, PotionEffectType type, String message){
        if (potionEffect.getType().equals(type)){
            p.sendMessage("[" + ChatColor.RED + "RandomEffect" + ChatColor.WHITE + "]" + " " + message);
        }
    }
}
