package pl.marcinrosol.HiplayDragon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class KillDragonCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender,
                             Command command,
                             String label, String[] args) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        if (! player.isOp()){ player.sendMessage(":("); return true;}
        if (command.getName().equalsIgnoreCase("killdragon")){
            for(Entity en : player.getWorld().getEntities()){
                if(en instanceof EnderDragon){
                    en.remove();
                    return true;
                }
            }
        }else{
            commandSender.sendMessage("use /killdragon");
        }
        return true;
    }
}
