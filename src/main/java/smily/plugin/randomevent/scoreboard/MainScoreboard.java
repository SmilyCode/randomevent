package smily.plugin.randomevent.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
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
        objective = scoreboard.registerNewObjective("Days", "dummy", ChatColor.AQUA + "Hari");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void updateScore(Player p){
        scoreboardLogic.dayCycle(p);

        daysScore = objective.getScore(ChatColor.WHITE + "ke- ");
        daysScore.setScore(scoreboardLogic.getDays());
    }

}
