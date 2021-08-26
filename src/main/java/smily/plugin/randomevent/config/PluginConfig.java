package smily.plugin.randomevent.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

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

    // does't work if already created
    public void creatingConfig() throws FileNotFoundException{
        if (fileConfig == null){
            getFileConfig();
        }

        try {
            if (fileConfig.createNewFile()){
                System.out.println("File Created");
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        defaultValue();
        writeAll();
    }

    // get spesific value from yml file
    public YamlVariable get() throws FileNotFoundException{
        if (inputStream == null){
            getInputStream();
        }

        yaml = new Yaml(new CustomClassLoaderConstructor(YamlVariable.class.getClassLoader()));
        return yaml.loadAs(inputStream, yamlVariable.getClass());
    }


    // write all attribute in yaml variable to yaml file
    public synchronized void writeAll() throws FileNotFoundException{
        if (writer == null){
            getWriter();
        }

        yaml = new Yaml(dumperOptions());
        yaml.dump(yamlVariable , writer);
    }

    // reload Yaml File
    public void reload() throws FileNotFoundException{
        if (fileConfig == null){
            getFileConfig();
            creatingConfig();
        }
        if (fileConfig == null)getInputStream();

        yaml.load(inputStream);
    }

    // these are default value for the Yaml File
    public void defaultValue(){
        yamlVariable.setStarted(false);
        yamlVariable.setCooldown(1);
        yamlVariable.setDay(1);
    }

}