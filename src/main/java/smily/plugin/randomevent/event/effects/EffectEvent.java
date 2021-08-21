package smily.plugin.randomevent.event.effects;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import smily.plugin.randomevent.time.Second;
import smily.plugin.randomevent.time.Time;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Arrays;
import java.util.Random;

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
            if (potionEffect.getType().equals(PotionEffectType.LEVITATION)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Wah enak ya pemandangannya!");
            } else if (potionEffect.getType().equals(PotionEffectType.CONFUSION)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Aduh kok pusing ya?");
            } else if (potionEffect.getType().equals(PotionEffectType.HUNGER)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Bunyi perut siapa itu?");
            } else if (potionEffect.getType().equals(PotionEffectType.SATURATION)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Wih udh kenyang nih.");
            } else if (potionEffect.getType().equals(PotionEffectType.REGENERATION)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Ayo Sembuh!");
            } else if (potionEffect.getType().equals(PotionEffectType.POISON)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Siapa yang racuni aku?");
            } else if (potionEffect.getType().equals(PotionEffectType.FIRE_RESISTANCE)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Aku Kebal Api Hahaha");
            } else if (potionEffect.getType().equals(PotionEffectType.DAMAGE_RESISTANCE)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Aku kebal dari serangan musuh hahaha!");
            } else if (potionEffect.getType().equals(PotionEffectType.JUMP)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Sepertinya aku tertular kelinci");
            } else if (potionEffect.getType().equals(PotionEffectType.SPEED)) {
                p.sendMessage("[" + ChatColor.GREEN + "RandomEvent" + ChatColor.WHITE + "]" + " Cepat! Cepat! Cepat!");
            }
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
}
