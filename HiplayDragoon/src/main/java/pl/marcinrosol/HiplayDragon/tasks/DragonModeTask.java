package pl.marcinrosol.HiplayDragon.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
        Bukkit.getServer().getOnlinePlayers().stream().forEach(p -> p.setLevel(60));
        BukkitTask taskid = null;

        taskid = Bukkit.getScheduler().runTaskTimer(HiplayDragon.instance, () -> {
            int currentLevel = 60 ;

            @Override
            public void run(){
                for (Player player : Bukkit.getServer().getOnlinePlayers()){
                    player.setLevel(currentLevel);
                }
            };

            if(currentLevel <= 0){
                Bukkit.getScheduler().cancelTask(taskid.getTaskId());
            }
            currentLevel --;
        }, 0, 20L);
    }
}
