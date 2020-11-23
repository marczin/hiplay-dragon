package pl.marcinrosol.HiplayDragon.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import pl.marcinrosol.HiplayDragon.HiplayDragon;
import pl.marcinrosol.HiplayDragon.entities.DestroyedCrystal;

public class CrystalDestroyListener implements Listener {

    @EventHandler
    public void onCrystalDestroy(ExplosionPrimeEvent event){
        if(event.getEntity() instanceof EnderCrystal){
            HiplayDragon.instance.destroyedCrystalList.add(new DestroyedCrystal(event.getEntity().getLocation()));
            Bukkit.broadcastMessage("Zniszcozno krysztal");
        }
    }
}
