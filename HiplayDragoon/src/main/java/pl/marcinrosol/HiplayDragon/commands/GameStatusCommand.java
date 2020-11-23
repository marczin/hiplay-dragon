package pl.marcinrosol.HiplayDragon.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class GameStatusCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender,
                             Command command,
                             String label, String[] args) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        if (! player.isOp()){ player.sendMessage(":("); return true;}
        if (command.getName().equalsIgnoreCase("status")){
            commandSender.sendMessage(ChatColor.RED+"Game status:");
            commandSender.sendMessage(ChatColor.RED+"Game mode: "+ HiplayDragon.instance.gameCfg.getDragonMode().toString());
            commandSender.sendMessage(ChatColor.RED+"Progress: "+ HiplayDragon.instance.gameCfg.getMobProgress());
            commandSender.sendMessage(ChatColor.RED+"Destroyed cristal: "+ HiplayDragon.instance.destroyedCrystalList.size());
        }
        return true;
    }
}
