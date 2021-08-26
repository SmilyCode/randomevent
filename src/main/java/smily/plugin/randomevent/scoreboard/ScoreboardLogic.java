package smily.plugin.randomevent.scoreboard;


import org.bukkit.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;

import smily.plugin.randomevent.config.YamlVariable;

public class ScoreboardLogic {
    private Integer days;
    private Integer timeSensor;
    @Autowired
    YamlVariable yamlVariable;

    public Integer getDays() {
        if (days == null){
            return days = 0;
        } else return days;

    }

    public void dayCycle(Player p){

        days = getDays();

        if (p.getWorld().getTime() >= 0 && p.getWorld().getTime() <= 300){
            if (timeSensor == null){
                timeSensor = 0;
            }

            timeSensor +=1;
        } else timeSensor = 0;

        if (timeSensor == 1){
            days += 1;
        }

    }

    // get day score from config
    public void getDaysFromConfig(){
        days = (Integer) yamlVariable.getDay();
    }

    // store day to config
    public void storeDaysToConfig(){
        yamlVariable.setDay(days);
    }



}
