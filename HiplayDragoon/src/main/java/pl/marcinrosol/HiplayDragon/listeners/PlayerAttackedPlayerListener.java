package pl.marcinrosol.HiplayDragon.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerAttackedPlayerListener implements Listener {

    @EventHandler
    public void onPlayerAttacked(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player){
            event.setCancelled(true);
        }
    }

}
