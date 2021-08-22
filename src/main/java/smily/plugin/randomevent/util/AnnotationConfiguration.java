package smily.plugin.randomevent.util;

import org.springframework.context.annotation.Bean;
import smily.plugin.randomevent.event.mobs.MobsList;
import smily.plugin.randomevent.event.mobs.RandomMobsLogic;
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

}
