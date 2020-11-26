package pl.marcinrosol.HiplayDragon.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import pl.marcinrosol.HiplayDragon.HiplayDragon;
import pl.marcinrosol.HiplayDragon.entities.DragonMode;

public class DragonGetDamageListener implements Listener {

    @EventHandler
    public void dragonGetDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof EnderDragon){
            if(HiplayDragon.instance.gameCfg.getDragonMode() == DragonMode.DRAGON){
                EnderDragon enderDragon = (EnderDragon) event.getEntity();
                Bukkit.broadcastMessage(String.valueOf(enderDragon.getHealth()));
            }else{
                event.setCancelled(true);
            }
        }
    }
}
