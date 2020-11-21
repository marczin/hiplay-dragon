package pl.marcinrosol.HiplayDragon.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class DragonSpawnListener implements Listener {


    @EventHandler
    public void dragonSpawnListener(EntitySpawnEvent event){
        if(event.getEntity() instanceof EnderDragon){
            ((EnderDragon) event.getEntity()).setMaxHealth(HiplayDragon.instance.gameCfg.getMaxDragonHealth());
            ((EnderDragon) event.getEntity()).setHealth(HiplayDragon.instance.gameCfg.getMaxDragonHealth());
            Bukkit.broadcastMessage(String.valueOf(((EnderDragon) event.getEntity()).getHealth()));
            event.getEntity().setCustomName(ChatColor.RED + ""+ ChatColor.BOLD + HiplayDragon.instance.gameCfg.getDragonName());
            event.getEntity().setCustomNameVisible(true);
        }
    }
}
