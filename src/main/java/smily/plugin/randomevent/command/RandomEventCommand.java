package smily.plugin.randomevent.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.md_5.bungee.api.ChatColor;
import smily.plugin.randomevent.config.PluginConfig;
import smily.plugin.randomevent.config.YamlVariable;
import smily.plugin.randomevent.event.StartRandomEvent;
import smily.plugin.randomevent.event.util.Messager;
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
    PluginConfig pluginConfig = PluginContext.context.getBean(PluginConfig.class);
    private YamlVariable yamlVariable = pluginConfig.getYamlVariable();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1 || args.length == 2 || args.length == 3){
            switch (args[0]){
                case "time":
                    if (args[1] != null){
                        switch (args[2]) {
                            case "second":
                                Messager.sendGlobalMessage(sender, "set cooldown to " + Integer.parseInt(args[1]) + " second");
                                yamlVariable.setCooldown(second.setTick(Integer.parseInt(args[1])));
                                break;
                            case "minute":
                                Messager.sendGlobalMessage(sender, "set cooldown to " + Integer.parseInt(args[1]) + " minute");
                                yamlVariable.setCooldown(minute.setTick(Integer.parseInt(args[1])));
                                break;
                            case "tick":
                                Messager.sendGlobalMessage(sender, "set cooldown to " + Integer.parseInt(args[1]) + " tick");
                                yamlVariable.setCooldown(tick.setTick(Integer.parseInt(args[1])));
                                break;
                            default:
                                Messager.sendGlobalMessage(sender, "Unit doesn't exist");
                        }

                        if (args[2] == null){
                            Messager.sendGlobalMessage(sender, "Unit cannot be null");
                            break;
                        }

                    } else {
                        Messager.sendGlobalMessage(sender, "time cannot be null");
                    }
                    break;

                case "start":
                if (!yamlVariable.getStarted()){
                    
                    if (yamlVariable.getStarted() == null) {
                    
                        yamlVariable.setCooldown(minute.setTick(1));

                    }
                    
                    Messager.sendGlobalMessage(sender, "Random event will happen...");
                    new StartRandomEvent();
                    yamlVariable.setStarted(true);
                } else {
                    
                    Messager.sendGlobalMessage(sender, "Game is already started.");
                
                }
                    break;
                
                    case "stop":
                    
                    if (yamlVariable.getStarted()){
                        Messager.sendGlobalMessage(sender, "Random event stop happen");
                        Bukkit.getScheduler().cancelTasks(PluginContext.getPlugin());
                        yamlVariable.setStarted(false);
                    } else {
                        Messager.sendGlobalMessage(sender, ChatColor.RED + "No Game is Running");
                    }
                    break;

                default:
                    Messager.sendGlobalMessage(sender, "not enough argument");
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


}
