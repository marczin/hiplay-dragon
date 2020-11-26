package pl.marcinrosol.HiplayDragon.listeners;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import pl.marcinrosol.HiplayDragon.HiplayDragon;
import pl.marcinrosol.HiplayDragon.entities.DragonMode;
import pl.marcinrosol.HiplayDragon.tasks.DragonModeTask;

public class PlayerKillMobListener implements Listener {

    @EventHandler
    public void mobDeathListener(EntityDeathEvent event) {

        if(event.getEntity() instanceof Monster) {
            if(event.getEntity() instanceof EnderDragon) {
                HiplayDragon.instance.gameCfg.setDragonMode(DragonMode.END_GAME);
                for (Player player : HiplayDragon.instance.getServer().getOnlinePlayers()) {
                    player.setGameMode(GameMode.ADVENTURE);
                }
            }
            if(HiplayDragon.instance.gameCfg.getDragonMode() == DragonMode.MOB){
                HiplayDragon.instance.gameCfg.incrementMobProgress();
                changeMode();
            }
            HiplayDragon.instance.gameCfg.setUpdateScoreboard(true);
        }
    }

    static void changeMode() {
        if (HiplayDragon.instance.gameCfg.getDragonMode() == DragonMode.MOB) {
            if(HiplayDragon.instance.gameCfg.getMobProgress() % HiplayDragon.instance.gameCfg.getHowManyMobKill() == 0) {
                HiplayDragon.instance.gameCfg.setDragonMode(DragonMode.DRAGON);
                Bukkit.broadcastMessage("change mode");
                DragonModeTask.dragonKillTask(); // run task that will change mode to MOD after 1 minute
                DragonModeTask.setTimerTask();
            }
        }
    }
}