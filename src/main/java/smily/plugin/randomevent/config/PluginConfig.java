package smily.plugin.randomevent.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;
import org.yaml.snakeyaml.events.Event;

import smily.plugin.randomevent.util.PluginContext;

public class PluginConfig {
    private Yaml yaml = new Yaml();
    
    private YamlVariable yamlVariable = new YamlVariable();
    private File fileConfig;
    private InputStream inputStream;
    private PrintWriter writer;


    public File getFileConfig() {
        return fileConfig = new File(PluginContext.getPlugin().getDataFolder(), "config.yml");
    }

    public PrintWriter getWriter() throws FileNotFoundException {
        if (fileConfig == null){
            getFileConfig();
        }
        return writer = new PrintWriter(fileConfig);
    }

    public InputStream getInputStream() throws FileNotFoundException {
        if (fileConfig == null){
            getFileConfig();
        }
        return inputStream = new FileInputStream(fileConfig);
    }

    public DumperOptions dumperOptions(){
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setPrettyFlow(true);
        dumperOptions.setDefaultFlowStyle(FlowStyle.BLOCK);
        return dumperOptions;
    }

    // create config file with default value (See bellow method), does't work if file already created
    public void createDefaultConfig() throws FileNotFoundException{
        if (fileConfig == null){
            getFileConfig();
        }

        try {
            if (fileConfig.createNewFile()){
                System.out.println("File Created");
                
                defaultValue();
                writeAll();
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // create config with existing value
    public void createConfig(){
        if (fileConfig == null){
            getFileConfig();
        }

        try {
            if (fileConfig.createNewFile()){
                System.out.println("File Created");
                
                defaultValue();
                writeAll();
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get spesific value from yml file
    public YamlVariable get() throws FileNotFoundException{
        if (inputStream == null){
            getInputStream();
        }

        yaml = new Yaml(new CustomClassLoaderConstructor(YamlVariable.class.getClassLoader()));

        return yamlVariable = yaml.loadAs(inputStream, yamlVariable.getClass());
    }


    // write all attribute in yaml variable to yaml file
    public void writeAll() throws FileNotFoundException{
        if (writer == null){
            getWriter();
        }

        yaml = new Yaml(dumperOptions());
        yaml.dump(yamlVariable , writer);
    }

    // these are default value for the Yaml File
    public void defaultValue(){
        yamlVariable.setStarted(false);
        yamlVariable.setCooldown(1);
        yamlVariable.setDay(1);
    }

    // check if any value is empty in config file
    public void checkAnyYamlEmpty() throws IOException{
        
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

        if (map.values().stream().anyMatch(value -> value == null)){

            System.err.println("Error: an or a value is empty");
            try {
                overideDefault();
                System.err.println("Recreating file config");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // overide config file with existing value
    public void override() throws FileNotFoundException{
        if (fileConfig == null){
            getFileConfig();
        }

        if (inputStream == null){
            getInputStream();
        }

        fileConfig.delete();
        createConfig();
    }

    // overiding config file with default value
    public void overideDefault() throws FileNotFoundException{
        if (fileConfig == null){
            getFileConfig();
        }

        if (inputStream == null){
            getInputStream();
        }

        fileConfig.delete();
        createDefaultConfig();
    } 
}