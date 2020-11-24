package pl.marcinrosol.HiplayDragon.tasks;

import org.bukkit.Bukkit;
import pl.marcinrosol.HiplayDragon.HiplayDragon;
import pl.marcinrosol.HiplayDragon.entities.ScoreboardCfg;

public class UpdateScoreboardTask {

    public static void UpdateScoreboardTask(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(HiplayDragon.instance, () -> {
            if(HiplayDragon.instance.gameCfg.isUpdateScoreboard()){
                ScoreboardCfg.updateScoreboard();
            }
        }, 0L, 20L);
    }

}

