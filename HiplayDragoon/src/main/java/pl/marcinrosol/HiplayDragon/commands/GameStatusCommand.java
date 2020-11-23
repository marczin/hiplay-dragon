package pl.marcinrosol.HiplayDragon.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
            sendInformation();
        }
        return true;
    }

    private static void sendInformation( ) {
        Bukkit.broadcastMessage(ChatColor.GOLD+"-----------------");
        Bukkit.broadcastMessage(ChatColor.RED+"Game status:");
        Bukkit.broadcastMessage(ChatColor.RED+"Game mode: "+ChatColor.GOLD+ HiplayDragon.instance.gameCfg.getDragonMode().toString());
        Bukkit.broadcastMessage(ChatColor.RED+"Progress: "+ ChatColor.GOLD+HiplayDragon.instance.gameCfg.getMobProgress());
        Bukkit.broadcastMessage(ChatColor.RED+"Modulo: " + ChatColor.GOLD+(HiplayDragon.instance.gameCfg.getMobProgress() % HiplayDragon.instance.gameCfg.getHowManyMobKill()));
        Bukkit.broadcastMessage(ChatColor.RED+"How many mobs need to be killed: " +ChatColor.GOLD+ HiplayDragon.instance.gameCfg.getHowManyMobKill());
        Bukkit.broadcastMessage(ChatColor.GOLD+"-----------------");
    }
}
