package pl.marcinrosol.HiplayDragon.entities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class ScoreboardCfg {

    public static void prepareScoreboard(HiplayDragon instance){
        Scoreboard scoreboard =  Bukkit.getScoreboardManager().getMainScoreboard();
        instance.objective = scoreboard.getObjective("dragonboard");
        if(instance.objective != null ) HiplayDragon.instance.objective.unregister();
        instance.objective = null;
        if(instance.objective == null ){
            instance.objective = scoreboard.registerNewObjective("dragonboard", "dummy");
            instance.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            instance.objective.setDisplayName("HiPlay");
        }
        updateScoreboard(instance);
    }

    public static void updateScoreboard(HiplayDragon main){
        if(main.gameCfg.isUpdateScoreboard()){
            for(String name : main.objective.getScoreboard().getEntries()){
                Score currScore = main.objective.getScore(name );

                if(currScore.getScore() == 1){
                    String searchedName = (ChatColor.RED+"Zabite moby: "+ChatColor.GOLD+main.gameCfg.getMobProgress()+"/"+main.gameCfg.getHowManyMobKill());

                    if(currScore != main.objective.getScore(searchedName)){
                        main.objective.getScoreboard().resetScores(name);
                        main.objective.getScore(searchedName).setScore(1);
                    }
                }

            }
        }
            main.gameCfg.setUpdateScoreboard(false);
    }

}
