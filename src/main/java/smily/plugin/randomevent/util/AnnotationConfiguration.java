package smily.plugin.randomevent.util;

import org.springframework.context.annotation.Bean;

import java.util.Random;

public class AnnotationConfiguration {

    @Bean
    public Random getRandom(){
        return new Random();
    }

}
