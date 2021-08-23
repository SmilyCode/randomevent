package smily.plugin.randomevent.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScoreboardLogic {
    private Integer days;

    public Integer getDays() {
        return days;
    }

    public void isNextDay(Player p){
        if (p.getWorld().getTime() == 0){
            days++;
        }
    }
}
