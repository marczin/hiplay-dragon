package pl.marcinrosol.HiplayDragon.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class SpawnDragonCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender,
                             Command command,
                             String label, String[] args) {
        if (!(commandSender instanceof Player)) return false;
            Player player = (Player) commandSender;
            if (! player.isOp()){ player.sendMessage(":("); return true;}
            if (command.getName().equalsIgnoreCase("dragon")){
                spawnDragon(player.getWorld(), player.getLocation());
                player.sendMessage(String.valueOf(HiplayDragon.instance.gameCfg.getMaxMobKillProgress()));
                player.sendMessage(String.valueOf(HiplayDragon.instance.gameCfg.getMobProgress()));
            }else{
                commandSender.sendMessage("use /dragon");
            }
        return true;
    }

    private void spawnDragon(World world, Location location){
        world.spawnEntity(location, EntityType.ENDER_DRAGON);
    }
}

