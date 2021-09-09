package smily.plugin.randomevent.event.pt;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import smily.plugin.randomevent.config.PluginConfig;
import smily.plugin.randomevent.event.lightning.LightningLogic;
import smily.plugin.randomevent.time.Second;
import smily.plugin.randomevent.util.PluginContext;

public final class PtLightningEvent implements PtEvents, Timer, Listener{
    
    @NotNull
    private Player player;
    @NotNull
    private int duration;
    @NotNull
    private int configPtDuration;
    @NotNull
    private boolean eventSwitch;
    @NotNull
    private Location strikelocation;
    @NotNull
    private LightningLogic lightningLogic = PluginContext.context.getBean(LightningLogic.class);
    @NotNull
    private PluginConfig pluginConfig = PluginContext.context.getBean(PluginConfig.class);

    private final int maxDistance = 1000;
    private final Plugin plugin = PluginContext.getPlugin();
    private final Second second = PluginContext.context.getBean(Second.class);
    private final ItemStack strikerItem = new ItemStack(Material.STICK); 
    
    public PtLightningEvent(Player player){
        this.player = player;
        configPtDuration = pluginConfig.getYamlVariable().getPt_event().getPt_lightning_duration();
        this.duration = second.setTick(configPtDuration);
        strikerItem.getItemMeta().setDisplayName("Striker");
    }

    public void strikeLightning(){
        lightningLogic.summonLighting(this.player, this.strikelocation);
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public void doEvent() {
        eventSwitch = true;
        
        player.getWorld().dropItem(player.getLocation(), strikerItem).getItemStack().getItemMeta().setDisplayName("Striker");;

        player.sendMessage("Kamu dapat tongkat petir selama " + configPtDuration + " second.");

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        timerEvent(this.duration);
    }   

    @EventHandler
    public void event(PlayerInteractEvent e){
        if (eventSwitch == true){

            if (e.getItem() != null)
            {
                if (e.getItem().getItemMeta().getDisplayName().equals(strikerItem.getItemMeta().getDisplayName()))
                {
                    if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
                    {
                        this.strikelocation = player.getTargetBlock(null ,maxDistance).getLocation();
                        
                        strikeLightning();
                    }
                }
            }
        }
    }

    @Override
    public void timerEvent(int duration) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            eventSwitch = false;
            player.getInventory().remove(strikerItem);
        }, duration);
    }
}
