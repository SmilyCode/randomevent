package smily.plugin.randomevent.util;

import org.springframework.context.annotation.Bean;
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
}
