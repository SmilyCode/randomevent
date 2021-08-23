package smily.plugin.randomevent.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import smily.plugin.randomevent.ConfigPlugin;
import smily.plugin.randomevent.event.Event;
import smily.plugin.randomevent.event.effects.EffectEventAdapter;
import smily.plugin.randomevent.event.lighting.LightingEventAdapter;
import smily.plugin.randomevent.event.mobs.RandomMobsAdapter;
import smily.plugin.randomevent.event.tnt.NukeEvent;
import smily.plugin.randomevent.event.tnt.TntEvent;
import smily.plugin.randomevent.event.tnt.TntEventAdapter;
import smily.plugin.randomevent.event.util.EventErrorHandler;
import smily.plugin.randomevent.time.Minute;
import smily.plugin.randomevent.time.Second;
import smily.plugin.randomevent.time.Tick;
import smily.plugin.randomevent.time.Time;
import smily.plugin.randomevent.util.PluginContext;
import smily.plugin.randomevent.util.Randomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomEventCommand implements CommandExecutor, TabCompleter {

    Time second = PluginContext.context.getBean(Second.class);
    Time minute = PluginContext.context.getBean(Minute.class);
    Time tick = PluginContext.context.getBean(Tick.class);
    EventErrorHandler errorHandler = PluginContext.context.getBean(EventErrorHandler.class);

    Event[] events = {
            new EffectEventAdapter(),
            new RandomMobsAdapter(),
            new TntEventAdapter(),
            new LightingEventAdapter()
    };

    public static Integer cooldown;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1 || args.length == 2 || args.length == 3){
            switch (args[0]){
                case "time":
                    if (args[1] != null){
                        switch (args[2]) {
                            case "second":
                                sendGlobalMessage(sender, "set cooldown to " + Integer.parseInt(args[1]) + " second");
                                cooldown = second.setTick(Integer.parseInt(args[1]));
                                break;
                            case "minute":
                                sendGlobalMessage(sender, "set cooldown to " + Integer.parseInt(args[1]) + " minute");
                                cooldown = minute.setTick(Integer.parseInt(args[1]));
                                break;
                            case "tick":
                                sendGlobalMessage(sender, "set cooldown to " + Integer.parseInt(args[1]) + " tick");
                                cooldown = tick.setTick(Integer.parseInt(args[1]));
                                break;
                            default:
                                sendGlobalMessage(sender, "Unit doesn't exist");
                        }

                        if (args[2] == null){
                            sendGlobalMessage(sender, "Unit cannot be null");
                            break;
                        }

                    } else {
                        sendGlobalMessage(sender, "time cannot be null");
                    }
                    break;
                case "start":
                    if (!errorHandler.getAllError(sender)) {
                        if (cooldown == null) {
                            cooldown = minute.setTick(1);
                        } else {
                            sendGlobalMessage(sender, "Random event will happen...");
                            Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginContext.getPlugin(), () -> {
                                Bukkit.getOnlinePlayers().stream().forEach(player -> {
//                                    Event event = (Event) Randomizer.randomListValue(Arrays.asList(events));
//                                    event.doEvent(player);
                                });
                            }, 0, cooldown);
                        }
                    } else {
                        sendGlobalMessage(sender, "Random cannot start");
                    }
                    break;
                case "stop":
                    sendGlobalMessage(sender, "Random event stop happen");
                    Bukkit.getScheduler().cancelTasks(PluginContext.getPlugin());
                    break;

                case "reload":
                    ConfigPlugin.reload();
                    sendGlobalMessage(sender, "Random Event config has reloaded");
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
