package smily.plugin.randomevent.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.*;

public class MainScoreboard {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard scoreboard;
    Objective objective;
    Score daysScore;
    int day;

    public void createScoreboard(){
        objective = scoreboard.registerNewObjective("Days", "dummy", "Hari");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        daysScore = objective.getScore(ChatColor.RED + "ke- " + ChatColor.WHITE + day);
    }


}
