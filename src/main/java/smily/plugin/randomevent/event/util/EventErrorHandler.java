package smily.plugin.randomevent.event.util;

import org.bukkit.ChatColor;
import org.springframework.beans.factory.annotation.Autowired;
import smily.plugin.randomevent.event.mobs.RandomMobsLogic;

import java.util.ArrayList;
import java.util.List;

public class EventErrorHandler {
    @Autowired
    RandomMobsLogic randomMobLogicError;

    private boolean ifMaxLowerThanMin(int max,int min){
        return max < min;
    }


    public boolean getAllError(){
        List<Boolean> error = new ArrayList<>();
        if (ifMaxLowerThanMin(randomMobLogicError.getMaxValue(), randomMobLogicError.getMinValue())){
            Messager.sendGlobalMessageToAll(new String[]{
                    ChatColor.RED + "on Random Mobs Config Setting:",
                    ChatColor.RED + "Max value cannot be lower than min value, fix it than do /randomevent reload"
            });
            return error.add(false);
        } else error.add(true);


        return error.stream().anyMatch(errors -> !errors);
    }


}
