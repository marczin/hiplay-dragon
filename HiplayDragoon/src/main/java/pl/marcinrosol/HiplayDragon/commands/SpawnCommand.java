package pl.marcinrosol.HiplayDragon.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender,
                             Command command,
                             String label, String[] args) {
        if (!(commandSender instanceof Player)) return false;
            Player player = (Player) commandSender;
            if (! player.isOp()){ player.sendMessage(ChatColor.DARK_BLUE +":("); return true;}

            if(label.equalsIgnoreCase("spawn")){
                if(args.length == 0) player.sendMessage(ChatColor.RED +"Use /spawn dragon/crystal");
                else
                    if(args[0].equalsIgnoreCase("dragon")){
                        spawnDragon(player.getWorld(), player.getLocation());
                        player.sendMessage(String.valueOf(HiplayDragon.instance.gameCfg.getMaxMobKillProgress()));
                        player.sendMessage(String.valueOf(HiplayDragon.instance.gameCfg.getMobProgress()));
                    } else if(args[0].equalsIgnoreCase("crystal")){
                        spawnCrystal(player.getLocation());
                    }else player.sendMessage(ChatColor.RED + "Use /spawn dragon/crystal");
            }
        return true;
    }

    private void spawnDragon(World world, Location location){
        world.spawnEntity(location, EntityType.ENDER_DRAGON);
    }

    private void spawnCrystal(Location location){
        EnderCrystal crystal = (EnderCrystal) location.getWorld().spawnEntity(location, EntityType.ENDER_CRYSTAL);
    }
}

