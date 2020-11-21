package pl.marcinrosol.HiplayDragon;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.marcinrosol.HiplayDragon.commands.GameStatusCommand;
import pl.marcinrosol.HiplayDragon.commands.KillDragonCommand;
import pl.marcinrosol.HiplayDragon.commands.SpawnCrystalCommand;
import pl.marcinrosol.HiplayDragon.commands.SpawnDragonCommand;
import pl.marcinrosol.HiplayDragon.entities.GameCfg;
import pl.marcinrosol.HiplayDragon.listeners.*;

public class HiplayDragon extends JavaPlugin {

    public static HiplayDragon instance;
    public FileConfiguration config = getConfig();
    public GameCfg gameCfg;
    @Override
    public void onEnable() {
        instance = this;
        registerEvents();
        registerCommands();
        this.gameCfg = new GameCfg();
        System.out.println("HiPlay Dragon enabled");
    }

    @Override
    public void onDisable() {
        instance = null;
        System.out.println("HiPlay Dragon disabled");
    }

    public static void main(String[] args) {

    }

    private void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerSpawnListener(), this);
        pm.registerEvents(new PlayerKillMobListener(),this);
        pm.registerEvents(new DragonSpawnListener(), this);
        pm.registerEvents(new DragonGetDamageListener(), this);
    }

    private void registerCommands(){
        getCommand("dragon").setExecutor(new SpawnDragonCommand());
        getCommand("killdragon").setExecutor(new KillDragonCommand());
        getCommand("status").setExecutor(new GameStatusCommand());
        getCommand("crystal").setExecutor(new SpawnCrystalCommand());
    }

}
