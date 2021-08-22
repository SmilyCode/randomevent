package smily.plugin.randomevent.event.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import smily.plugin.randomevent.event.mobs.RandomMobsLogic;
import smily.plugin.randomevent.util.PluginContext;

import java.util.ArrayList;
import java.util.List;

public class EventErrorHandler {
    static RandomMobsLogic randomMobLogicError = PluginContext.context.getBean(RandomMobsLogic.class);

    private static boolean ifMaxLowerThanMin(int max,int min){
        return max < min;
    }


    public static boolean getAllError(CommandSender sender){
        List<Boolean> error = new ArrayList<>();
        if (ifMaxLowerThanMin(randomMobLogicError.getMaxValue(), randomMobLogicError.getMinValue())){
            if (sender instanceof Player){
                sender.sendMessage(ChatColor.RED + "on Random Mobs Config Setting:");
                sender.sendMessage(ChatColor.RED + "Max value cannot be lower than min value, fix it than do /randomevent reload");
            } else {
                System.err.println("on Random Mobs Config Setting:");
                System.err.println("Max value cannot be lower than min value, fix it than do /randomevent reload");
            }
            return error.add(false);
        } else error.add(true);


        return error.stream().anyMatch(errors -> !errors);
    }

}
