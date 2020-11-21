package pl.marcinrosol.HiplayDragon.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class SpawnCrystalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender,
                             Command command,
                             String label, String[] args) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        if (! player.isOp()){ player.sendMessage(":("); return true;}
        if (command.getName().equalsIgnoreCase("crystal")){
            prepareCrystal(player.getLocation());
        }
        return false;
    }

    private void prepareCrystal(Location location){
        EnderCrystal crystal = (EnderCrystal) location.getWorld().spawnEntity(location, EntityType.ENDER_CRYSTAL);
        
    }
}
