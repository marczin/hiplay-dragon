package pl.marcinrosol.HiplayDragon.listeners;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerSpawnListener implements Listener{

    @EventHandler
    void onPlayerSpawn(PlayerRespawnEvent event){
        PlayerJoinListener.preparePlayer(event.getPlayer());
    }
}
