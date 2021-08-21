package smily.plugin.randomevent.util;

import org.springframework.lang.NonNull;

import java.util.List;
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

    public static Object randomListValue(@NonNull List list){
        return list.get(randomValue(list.size()));
    }
}
