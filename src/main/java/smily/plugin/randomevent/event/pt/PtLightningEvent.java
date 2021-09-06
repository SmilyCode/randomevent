package smily.plugin.randomevent.event.pt;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import smily.plugin.randomevent.config.YamlVariable;
import smily.plugin.randomevent.event.lightning.LightningLogic;
import smily.plugin.randomevent.time.Second;
import smily.plugin.randomevent.util.PluginContext;

public final class PtLightningEvent implements PtEvents, Timer, Listener{
    
    @NotNull
    private Player player;
    @NotNull
    private int duration;
    @NotNull
    private boolean eventSwitch;
    private Location strikelocation;
    private LightningLogic lightningLogic = PluginContext.context.getBean(LightningLogic.class);
    private final int maxDistance = 40;
    private final Plugin plugin = PluginContext.getPlugin();
    private final YamlVariable yamlVariable = PluginContext.context.getBean(YamlVariable.class);
    private final Second second = PluginContext.context.getBean(Second.class);

    
    public PtLightningEvent(Player player){
        this.player = player;
        this.strikelocation = player.getTargetBlockExact(maxDistance).getLocation();
        this.duration = second.setTick(yamlVariable.getPt_event().getPt_lightning_duration());
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

        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
        timerEvent(this.duration);
    }   

    @EventHandler
    void event(PlayerInteractEvent e){
        if (eventSwitch == true){
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) )
            {
                strikeLightning();
            }    
        }
    }

    @Override
    public void timerEvent(int duration) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> eventSwitch = false, duration);
    }
}
