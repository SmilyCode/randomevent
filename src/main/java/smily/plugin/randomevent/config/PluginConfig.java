package smily.plugin.randomevent.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;

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
        getInputStream();

        yaml = new Yaml(new CustomClassLoaderConstructor(YamlVariable.class.getClassLoader()));

        return yamlVariable = yaml.load(inputStream);
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

        PtEventConfigVariable ptEventVariable = new PtEventConfigVariable();
        ptEventVariable.setPt_lightning_duration(30);

        yamlVariable.setPt_event(ptEventVariable);
    }

    // check if any value is empty in config file
    public void checkAnyYamlEmpty() throws IOException{
               

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
                    System.err.println("Error : a value cannot be null");
                    overideDefault();
                    System.err.println("Recreating default config");
                }

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        });
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
}