import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import smily.plugin.randomevent.util.Randomizer;


public class TestCode {

    InputStream inputStream ;

    @Test
    public void randomDouble(){
        try {
            inputStream = new FileInputStream("src/test/resources/test.yml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        System.out.println(data); 
    }

}
