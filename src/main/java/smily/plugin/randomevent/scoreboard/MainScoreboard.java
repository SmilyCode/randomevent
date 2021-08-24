package smily.plugin.randomevent.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.*;
import org.springframework.beans.factory.annotation.Autowired;

public class MainScoreboard {
    private ScoreboardManager manager;
    private Scoreboard scoreboard;
    private Objective objective;
    private Score daysScore;

    @Autowired
    ScoreboardLogic scoreboardLogic;

    public void createScoreboard(){
        manager = Bukkit.getScoreboardManager();

        assert manager != null;
        scoreboard = manager.getNewScoreboard();
        objective = scoreboard.registerNewObjective("Days", "dummy", "Hari");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        daysScore = objective.getScore(ChatColor.RED + "ke- ");
        daysScore.setScore(scoreboardLogic.getDays());
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}
