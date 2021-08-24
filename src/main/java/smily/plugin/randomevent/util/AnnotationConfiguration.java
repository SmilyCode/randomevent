package smily.plugin.randomevent.util;

import org.springframework.context.annotation.Bean;
import smily.plugin.randomevent.event.lighting.LightingAnimation;
import smily.plugin.randomevent.event.lighting.LightingLogic;
import smily.plugin.randomevent.event.mobs.MobsList;
import smily.plugin.randomevent.event.mobs.RandomMobsLogic;
import smily.plugin.randomevent.event.tnt.NukeEvent;
import smily.plugin.randomevent.event.tnt.TntEvent;
import smily.plugin.randomevent.event.util.EventErrorHandler;
import smily.plugin.randomevent.scoreboard.MainScoreboard;
import smily.plugin.randomevent.scoreboard.ScoreboardLogic;
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
    public LightingLogic getLightingLogic(){
        return new LightingLogic();
    }

    @Bean
    public LightingAnimation getLightingAnimation(){
        return new LightingAnimation();
    }

    @Bean
    public ScoreboardLogic getScoreboardLogic(){
        return new ScoreboardLogic();
    }

    @Bean
    public MainScoreboard getMainScoreboard(){
        return new MainScoreboard();
    }
}
