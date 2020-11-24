package pl.marcinrosol.HiplayDragon.tasks;

import org.bukkit.Bukkit;
import pl.marcinrosol.HiplayDragon.HiplayDragon;
import pl.marcinrosol.HiplayDragon.entities.DragonMode;

public final class DragonModeTask {

    public static void dragonKillTask(){
        Bukkit.broadcastMessage("run task");
        Bukkit.getScheduler().runTaskLater(HiplayDragon.instance, () -> {
            Bukkit.broadcastMessage("Before if");
            if(HiplayDragon.instance.gameCfg.getDragonMode() == DragonMode.DRAGON){
                    Bukkit.broadcastMessage("after if");
                    HiplayDragon.instance.gameCfg.setMobProgress(1);
                    HiplayDragon.instance.gameCfg.setDragonMode(DragonMode.MOB);
                    Bukkit.broadcastMessage("Changed to MOB mode");
            }
            HiplayDragon.instance.gameCfg.setUpdateScoreboard(true);
        },20L * 60);
    }

}
