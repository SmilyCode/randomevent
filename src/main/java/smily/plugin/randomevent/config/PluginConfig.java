package smily.plugin.randomevent.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;


public class PluginConfig {
    @NotNull
    @Autowired
    private YamlVariable yamlVariable;

    @NotNull
    private Plugin plugin;

    @NotNull
    private File fileConfig;
    private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());


    // create config that store all data
    public void createDefaultConfig(){
        if (!fileConfig.isFile()){
            System.out.println("Creating file config to store your data score.");
        }
        plugin.saveDefaultConfig();
    }

    public File getFileConfig() {
        return fileConfig = new File(plugin.getDataFolder(), "config.yml");
    }

    public void setup(Plugin plugin) {
        this.plugin = plugin;
        getFileConfig();
    }

    // create config with current yaml value
    public void createConfig(){
        if (!isAnyValueNull()){
            plugin.saveDefaultConfig();
            writeAll();
        } else {
            createDefaultConfig();
        }
    }

    // override the config file with default value
    public void overrideToDefault(){
        fileConfig.delete();
        plugin.saveDefaultConfig();
    }

    // override the config file with current value
    public void override(){
        fileConfig.delete();
        createConfig();
    }

    // check if any yaml variable value is null
    public boolean isAnyValueNull(){
        Class<YamlVariable> yamlClass = YamlVariable.class;

        return Arrays.stream(yamlClass.getFields()).anyMatch(field -> {
            boolean nullExist = false;
            
            try {
                nullExist = field.get(yamlVariable) == null;
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return nullExist;
        });
    }

    // write all current value to the config file
    public void writeAll(){
        if (!isAnyValueNull()){
            try {
                objectMapper.writeValue(fileConfig, yamlVariable);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            new NullPointerException("Any value cannot be null.");
        }
    }

    // load config value
    public void load(){
        if (fileConfig.isFile()){
            System.out.println("Loading the config file...");
            try 
            {
                yamlVariable = objectMapper.readValue(fileConfig, YamlVariable.class);
            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else new FileSystemException(fileConfig.getAbsolutePath());
    }

    public YamlVariable getYamlVariable() {
        return yamlVariable;
    }

    public void autoSave(boolean eventListener){
        if (eventListener){
            writeAll();
        }
    }

}