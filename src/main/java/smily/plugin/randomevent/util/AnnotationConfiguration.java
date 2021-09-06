package smily.plugin.randomevent.util;

import org.springframework.context.annotation.Bean;

import smily.plugin.randomevent.config.PluginConfig;
import smily.plugin.randomevent.config.YamlVariable;
import smily.plugin.randomevent.event.lightning.LightningAnimation;
import smily.plugin.randomevent.event.lightning.LightningLogic;
import smily.plugin.randomevent.event.mobs.MobsList;
import smily.plugin.randomevent.event.mobs.RandomMobsLogic;
import smily.plugin.randomevent.event.tnt.NukeEvent;
import smily.plugin.randomevent.event.tnt.TntEvent;
import smily.plugin.randomevent.event.util.EventErrorHandler;
import smily.plugin.randomevent.time.Minute;
import smily.plugin.randomevent.time.Second;
import smily.plugin.randomevent.time.Tick;

import java.util.Random;

public class AnnotationConfiguration {

    @Bean
    public Random getRandom(){
        return new Random();
    }

    @Bean
    public Second getSecond(){
        return new Second();
    }

    @Bean
    public Minute getMinute(){
        return new Minute();
    }

    @Bean
    public Tick getTick(){
        return new Tick();
    }

    @Bean
    public MobsList getMobsList(){
        return new MobsList();
    }

    @Bean
    public RandomMobsLogic getRandomMobsLogic(){
        return new RandomMobsLogic();
    }

    @Bean
    public EventErrorHandler getEventErrorHandler(){
        return new EventErrorHandler();
    }

    @Bean
    public TntEvent getTntEvent(){
        return new TntEvent();
    }

    @Bean
    public NukeEvent getNukeEvent(){
        return new NukeEvent();
    }

    @Bean
    public LightningLogic getLightingLogic(){
        return new LightningLogic();
    }

    @Bean
    public LightningAnimation getLightingAnimation(){
        return new LightningAnimation();
    }

    @Bean
    public PluginConfig gPluginConfig(){
        return new PluginConfig();
    }

    @Bean
    public YamlVariable gYamlVariable(){
        return new YamlVariable();
    }

}
