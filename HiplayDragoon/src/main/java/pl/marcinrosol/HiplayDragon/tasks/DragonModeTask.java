package pl.marcinrosol.HiplayDragon.tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import pl.marcinrosol.HiplayDragon.HiplayDragon;
import pl.marcinrosol.HiplayDragon.entities.DragonMode;

public final class DragonModeTask {

    public static void dragonKillTask(){
        Bukkit.getScheduler().runTaskLater(HiplayDragon.instance, () -> {
            if(HiplayDragon.instance.gameCfg.getDragonMode() == DragonMode.DRAGON){
                    HiplayDragon.instance.gameCfg.setMobProgress(1);
                    HiplayDragon.instance.gameCfg.setDragonMode(DragonMode.MOB);
            }
            HiplayDragon.instance.gameCfg.setUpdateScoreboard(true);
        },20L * 60);
    }

    public static void setTimerTask(){
        HiplayDragon.instance.gameCfg.countTime = 60;
        Bukkit.getServer().getOnlinePlayers().stream().forEach(p -> p.setLevel(60));
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        HiplayDragon.instance.gameCfg.countTaskId = scheduler.scheduleSyncRepeatingTask(HiplayDragon.instance,
                new Runnable() {
            @Override
            public void run() {
                Bukkit.getServer().getOnlinePlayers().stream().forEach(p -> p.setLevel(HiplayDragon.instance.gameCfg.getCountTime()));
                if(HiplayDragon.instance.gameCfg.getCountTime() <= 0) {
                    Bukkit.broadcastMessage(ChatColor.RED + "Time is up!");
                    stopTimer();
                    return;
                }
            HiplayDragon.instance.gameCfg.countTime--;
            }
        }, 0L, 20L);
    }

    public static void stopTimer() {
        Bukkit.getScheduler().cancelTask(HiplayDragon.instance.gameCfg.countTaskId);
    }

}
