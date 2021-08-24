package smily.plugin.randomevent.event.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messager {

    public static void sendGlobalMessage(CommandSender sender, String[] message){
        for (int i = 0; i <= message.length; i++) {
            if (sender instanceof Player) {
                sender.sendMessage(message[i]);
            } else {
                System.out.println(message[i]);
            }
        }
    }

    public static void sendGlobalMessageToAll(String[] message){
        for (int i = 0; i <= message.length; i++) {
            for (Player p : Bukkit.getOnlinePlayers()){
                p.sendMessage(message[i]);
            }
            System.out.println(message[i]);
        }
    }

    public static void sendGlobalMessageToAll(String message){
        for (Player p : Bukkit.getOnlinePlayers()){
            p.sendMessage(message);
        }
        System.out.println(message);
    }
    public static void sendGlobalMessage(CommandSender sender, String message){
            if (sender instanceof Player) {
                sender.sendMessage(message);
            } else {
                System.out.println(message);
        }
    }
}
