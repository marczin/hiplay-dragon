package pl.marcinrosol.HiplayDragon.entities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class ScoreboardCfg {

    public static void prepareScoreboard(){
        Scoreboard scoreboard =  Bukkit.getScoreboardManager().getMainScoreboard();
        HiplayDragon.instance.objective = scoreboard.getObjective("dragonboard");
        if(HiplayDragon.instance.objective != null ) HiplayDragon.instance.objective.unregister();
        if(HiplayDragon.instance.objective == null ){
            HiplayDragon.instance.objective = scoreboard.registerNewObjective("dragonboard", "dummy");
            HiplayDragon.instance.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            HiplayDragon.instance.objective.setDisplayName("HiPlay");
        }
        updateScoreboard();
    }

    public static void updateScoreboard(){

//        System.out.println(" ");
//        for(String oldString: HiplayDragon.instance.objective.getScoreboard().getEntries()){
//            System.out.println(oldString);
//
//        }
//        System.out.println(" ");

        if(HiplayDragon.instance.gameCfg.isUpdateScoreboard()){
            if(HiplayDragon.instance.gameCfg.getDragonMode() == DragonMode.END_GAME){
                HiplayDragon.instance.objective.getScore(
                        ChatColor.RED + "Tryb: "+ChatColor.GOLD + " SMOK ZABITY!").setScore(3);
            }else{
                HiplayDragon.instance.objective.getScore(
                        ChatColor.RED + "Tryb: "+ChatColor.GOLD + (HiplayDragon.instance.gameCfg.getDragonMode().toString())).setScore(3);
            }

            HiplayDragon.instance.objective.getScore(
                    ChatColor.RED + "Zniszcozne krysztaly: "+ChatColor.GOLD +(HiplayDragon.instance.destroyedCrystalList.size())).setScore(2);

            HiplayDragon.instance.objective.getScore(
                    ChatColor.RED + "Zabite moby: "
                            +ChatColor.GOLD +(HiplayDragon.instance.gameCfg.getMobProgress()-1)
                            +"/"+HiplayDragon.instance.gameCfg.getHowManyMobKill()).setScore(1);

            HiplayDragon.instance.gameCfg.setUpdateScoreboard(false);
        }


    }

}
