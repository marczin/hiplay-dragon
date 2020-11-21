package pl.marcinrosol.HiplayDragon.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import pl.marcinrosol.HiplayDragon.HiplayDragon;
import pl.marcinrosol.HiplayDragon.entities.DragonMode;

public class PlayerKillMobListener implements Listener {

    @EventHandler
    public void mobDeathListener(EntityDeathEvent event){

        if(event.getEntity() instanceof Monster){
            if(HiplayDragon.instance.gameCfg.getDragonMode() == DragonMode.MOB){
                HiplayDragon.instance.gameCfg.incrementMobProgress();
                if (HiplayDragon.instance.gameCfg.getMobProgress() % HiplayDragon.instance.gameCfg.getMaxMobKillProgress() == 0){
                    for(Entity e : event.getEntity().getWorld().getEntities()) {
                        if (e instanceof EnderDragon){
                            ((EnderDragon) e).setHealth(((EnderDragon) e).getHealth() - 10);
                        }
                    }
                }
                changeMode();
            }
        }



    }

    static void changeMode() {
        if(HiplayDragon.instance.gameCfg.getMobProgress() % 10 == 0){ //every 10% of progress change mode
            if (HiplayDragon.instance.gameCfg.getDragonMode() == DragonMode.MOB){
                HiplayDragon.instance.gameCfg.setDragonMode(DragonMode.DRAGON);
                Bukkit.broadcastMessage("ustawiono dragon");
            } else {
                HiplayDragon.instance.gameCfg.setDragonMode(DragonMode.MOB);
                Bukkit.broadcastMessage("ustawiono mob");
            }
        }


        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(ChatColor.RED+"Game status:");
        Bukkit.broadcastMessage(ChatColor.RED+"Game mode: "+ HiplayDragon.instance.gameCfg.getDragonMode().toString());
        Bukkit.broadcastMessage(ChatColor.RED+"Progress: "+ HiplayDragon.instance.gameCfg.getMobProgress());
        Bukkit.broadcastMessage(ChatColor.RED+"modulo: " + (HiplayDragon.instance.gameCfg.getMobProgress() % 10));
        Bukkit.broadcastMessage("");
    }
}