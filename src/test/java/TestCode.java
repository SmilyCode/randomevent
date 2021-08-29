import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;


import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;


public class TestCode {
    private Yaml yaml = new Yaml();
    // private YamlVariable yamlVariable = new YamlVariable();
    private File fileConfig;
    private InputStream inputStream;
    // private PrintWriter writer;

    @Test
    public void randomDouble() throws IOException{
        

        if (fileConfig == null){
            getFileConfig();
        }

        if (inputStream == null){
            getInputStream();
        }

        Reader read = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(read);

        reader.readLine();

        Map<String, Object> map = yaml.load(reader);
        System.out.println(map);
        System.out.println(map.values().stream().anyMatch(value -> value == null));
    }

    public File getFileConfig() {
        return fileConfig = new File("src/test/resources/config.yml");
    }

    public InputStream getInputStream() throws FileNotFoundException {
        if (fileConfig == null){
            getFileConfig();
        }
        return inputStream = new FileInputStream(fileConfig);
    }

}
