package smily.plugin.randomevent.event.util;

import smily.plugin.randomevent.util.PluginContext;

import java.util.Random;

public class Randomizer {
    static Random random = PluginContext.context.getBean(Random.class);

    public static int randomValue(int bound){
        return random.nextInt(bound);
    }

    public static int randomValue(int min, int max){
        return random.nextInt(max + 1 - min) + min;
    }

    public static double randomValue(){
        return random.nextDouble();
    }
}
