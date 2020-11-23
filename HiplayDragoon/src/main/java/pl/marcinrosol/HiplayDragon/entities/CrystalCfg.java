package pl.marcinrosol.HiplayDragon.entities;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CrystalCfg {

    private static File file;
    private static FileConfiguration fileConfiguration;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("HiPlayDragon").getDataFolder(),
                "crystalConfig.yml");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                System.out.println("Path does not exist");
            }
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return fileConfiguration;
    }
    public static void save(){
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            System.out.println("File does not exist");
        }

    }

    public static void reload(){
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

}
