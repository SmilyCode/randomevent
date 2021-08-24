package smily.plugin.randomevent.scoreboard;


import org.bukkit.entity.Player;

import smily.plugin.randomevent.ConfigPlugin;

public class ScoreboardLogic {
    private Integer days;
    private Integer timeSensor;

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
        System.out.println(days);

    }

    public void getDaysFromConfig(){
        days = (Integer) ConfigPlugin.get("day");
    }

    public void storeDaysToConfig(){
        ConfigPlugin.set("day", days);
    }



}
