package smily.plugin.randomevent.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import smily.plugin.randomevent.time.Minute;
import smily.plugin.randomevent.time.Second;
import smily.plugin.randomevent.time.Tick;
import smily.plugin.randomevent.time.Time;
import smily.plugin.randomevent.util.PluginContext;

import java.util.ArrayList;
import java.util.List;

public class RandomEventCommand implements CommandExecutor, TabCompleter {

    Time second = PluginContext.context.getBean(Second.class);
    Time minute = PluginContext.context.getBean(Minute.class);
    Time tick = PluginContext.context.getBean(Tick.class);
    public static int cooldown;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1 || args.length == 2 || args.length == 3){
            switch (args[0]){
                case "time":
                    if (args[1] != null){
                        switch (args[2]) {
                            case "second":
                                cooldown = second.setTick(Integer.parseInt(args[2]));
                                break;
                            case "minute":
                                cooldown = minute.setTick(Integer.parseInt(args[2]));
                                break;
                            case "tick":
                                cooldown = tick.setTick(Integer.parseInt(args[2]));
                                break;
                            default:
                                sendGlobalMessage(sender, "Unit cannot be null, or didn't exist");
                                break;
                        }
                    } else {
                        sendGlobalMessage(sender, "time cannot be null");
                    }
                    break;
                case "start":
                    cooldown = minute.setTick(1);
                    break;
                case "stop":
                    break;
                default:
                    sendGlobalMessage(sender, "not enough argument");
            }
        }

        return false;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> arguments = new ArrayList<>();

        if (args.length == 1){
            arguments.add("time");
            arguments.add("start");
            arguments.add("stop");
        } else if (args.length == 3){
            arguments.add("second");
            arguments.add("minute");
            arguments.add("tick");
        }

        return arguments;
    }

    private void sendGlobalMessage(CommandSender sender, String message){
        if (sender instanceof Player){
            sender.sendMessage(message);
        } else {
            System.out.println(message);
        }
    }
}
