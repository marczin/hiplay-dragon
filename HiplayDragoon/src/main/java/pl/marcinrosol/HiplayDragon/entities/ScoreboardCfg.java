package pl.marcinrosol.HiplayDragon.entities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class ScoreboardCfg {

    public static void prepareScoreboard(){
        Scoreboard scoreboard =  Bukkit.getScoreboardManager().getMainScoreboard();
        HiplayDragon.instance.objective = scoreboard.getObjective("dragonboard");
        if(HiplayDragon.instance.objective != null ) HiplayDragon.instance.objective.unregister();
        HiplayDragon.instance.objective = null;
        if(HiplayDragon.instance.objective == null ){
            HiplayDragon.instance.objective = scoreboard.registerNewObjective("dragonboard", "dummy");
            HiplayDragon.instance.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            HiplayDragon.instance.objective.setDisplayName("HiPlay");
        }
        updateScoreboard();
    }

    public static void updateScoreboard(){
        if(HiplayDragon.instance.gameCfg.isUpdateScoreboard()){
            for(String name : HiplayDragon.instance.objective.getScoreboard().getEntries()){
                Score currScore = HiplayDragon.instance.objective.getScore(name);
                System.out.println("name " +name+ " score: "+currScore.getScore());
                if(currScore.getScore() == 1){
                    String searchedName = (ChatColor.RED+"Zabite moby: "+ChatColor.GOLD+HiplayDragon.instance.gameCfg.getMobProgress()+"/"+HiplayDragon.instance.gameCfg.getHowManyMobKill());
                    System.out.println("searched name "+ searchedName);
                    if(name != searchedName){
                        HiplayDragon.instance.objective.getScoreboard().resetScores(name);
                        HiplayDragon.instance.objective.getScore(searchedName).setScore(1);
                    }
                }

                if(currScore.getScore() == 2){
                    String searchedName = (ChatColor.RED+"Zniszczone krysztaly: "+ChatColor.GOLD+HiplayDragon.instance.destroyedCrystalList.size());
                    if(name != searchedName){
                        HiplayDragon.instance.objective.getScoreboard().resetScores(name);
                        HiplayDragon.instance.objective.getScore(searchedName).setScore(2);
                    }
                }

            }
        }
        HiplayDragon.instance.gameCfg.setUpdateScoreboard(false);
    }

}
