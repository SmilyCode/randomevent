import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.Test;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Random;

public class TestCode {

    @Test
    public void randomDouble(){
        int safeAreaXPlus = 2;
        int safeAreaXMinus = -2;
        int safeAreaYPlus = 2;
        int safeAreaYMinus = -2;

        int randomX = Randomizer.randomValue(-10, 10);
        int randomY = Randomizer.randomValue(-10, 10);

        if (randomX < safeAreaXPlus && randomX > safeAreaXMinus){
            randomX = Randomizer.randomBetweenValue(safeAreaXPlus, safeAreaXMinus);
        }

        if (randomY < safeAreaYPlus && randomY > safeAreaYMinus){
            randomY = Randomizer.randomBetweenValue(safeAreaYPlus, safeAreaYMinus);
        }

        System.out.println(randomX + " " + randomY);
    }

}
