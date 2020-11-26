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

    public static void removeScore(String currName, int currPos) {
        for(String name : HiplayDragon.instance.objective.getScoreboard().getEntries()){
            if ( name != currName ) {
                Score currScore = HiplayDragon.instance.objective.getScore(name);
                if ( currScore != null && currScore.getScore() == currPos ) {
                    HiplayDragon.instance.objective.getScoreboard().resetScores(name);
                }
            }
        }
    }

    public static void setScore(String name, int pos) {
        removeScore(name, pos);
        HiplayDragon.instance.objective.getScore(name).setScore(pos);
    }

    public static void updateScoreboard(){
        if(HiplayDragon.instance.gameCfg.isUpdateScoreboard()){
            //params
            String name = null;

            // 1

            name = (ChatColor.RED+"Zabite moby: "+ChatColor.GOLD+(HiplayDragon.instance.gameCfg.getMobProgress()-1)+"/"+(HiplayDragon.instance.gameCfg.getHowManyMobKill()-1));
            setScore(name,1);

            name = (ChatColor.RED+"Zniszczone krysztaly: "+ChatColor.GOLD+HiplayDragon.instance.destroyedCrystalList.size());
            setScore(name,2);

            HiplayDragon.instance.gameCfg.setUpdateScoreboard(false);
        }
    }

}
