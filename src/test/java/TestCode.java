import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;


public class TestCode {
    private Yaml yaml = new Yaml();
    private YamlVariable yamlVariable = new YamlVariable();
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

        Class<YamlVariable> yamlClass = YamlVariable.class;
        yaml = new Yaml(new CustomClassLoaderConstructor(YamlVariable.class.getClassLoader()));
        yamlVariable = yaml.load(inputStream);
        
        Arrays.stream(yamlClass.getFields()).forEach(field -> {


            try {
                if (field.get(yamlVariable) == null){
                    System.err.println("cannot be null");
                }

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        });
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

    public YamlVariable get() throws FileNotFoundException{
        getInputStream();


        return yamlVariable = yaml.load(inputStream);
    }

}
