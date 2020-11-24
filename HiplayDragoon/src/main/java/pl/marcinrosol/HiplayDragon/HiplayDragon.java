package pl.marcinrosol.HiplayDragon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;
import pl.marcinrosol.HiplayDragon.commands.*;
import pl.marcinrosol.HiplayDragon.entities.CrystalCfg;
import pl.marcinrosol.HiplayDragon.entities.DestroyedCrystal;
import pl.marcinrosol.HiplayDragon.entities.GameCfg;
import pl.marcinrosol.HiplayDragon.entities.ScoreboardCfg;
import pl.marcinrosol.HiplayDragon.listeners.*;
import pl.marcinrosol.HiplayDragon.tasks.SpawnCrystalTask;
import pl.marcinrosol.HiplayDragon.tasks.UpdateScoreboardTask;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HiplayDragon extends JavaPlugin {

    public static HiplayDragon instance;
    public FileConfiguration config = getConfig();
    public GameCfg gameCfg;
    public List<DestroyedCrystal> destroyedCrystalList = new CopyOnWriteArrayList<>();
    public Objective objective;

    @Override
    public void onEnable() {
        instance = this;
        registerEvents();
        registerCommands();
        this.gameCfg = new GameCfg();
        CrystalCfg.setup();
        CrystalCfg.get().options().copyDefaults(true);
        SpawnCrystalTask.crystalTask();
        ScoreboardCfg.prepareScoreboard(this);
        UpdateScoreboardTask.UpdateScoreboardTask();
        System.out.println("HiPlay Dragon enabled");
    }

    @Override
    public void onDisable() {
        instance = null;
        System.out.println("HiPlay Dragon disabled");
    }

    private void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerSpawnListener(), this);
        pm.registerEvents(new PlayerKillMobListener(),this);
        pm.registerEvents(new DragonSpawnListener(), this);
        pm.registerEvents(new DragonGetDamageListener(), this);
        pm.registerEvents(new CrystalDestroyListener(), this);
    }

    private void registerCommands(){
        getCommand("killdragon").setExecutor(new KillDragonCommand());
        getCommand("status").setExecutor(new GameStatusCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
    }



}
