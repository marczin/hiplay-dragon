package pl.marcinrosol.HiplayDragon.entities;

import pl.marcinrosol.HiplayDragon.HiplayDragon;

import java.util.Observable;

public class GameCfg{

    int mobProgress;
    int maxMobKillProgress;
    int maxDragonHealth;
    String dragonName;
    DragonMode dragonMode;

    public GameCfg() {
        this.mobProgress = HiplayDragon.instance.config.getInt("event.killMobProgress");
        this.maxMobKillProgress = HiplayDragon.instance.config.getInt("event.max");
        this.maxDragonHealth = HiplayDragon.instance.config.getInt("event.maxDragonHealth");
        this.dragonName = HiplayDragon.instance.config.getString("event.dragonName");
        this.dragonMode = DragonMode.valueOf(HiplayDragon.instance.config.getString("event.dragonMode"));
    }

    public int getMobProgress() {
        return mobProgress;
    }

    public void setMobProgress(int mobProgress) {
        this.mobProgress = mobProgress;
    }

    public int getMaxMobKillProgress() {
        return maxMobKillProgress;
    }

    public void setMaxMobKillProgress(int maxMobKillProgress) {
        this.maxMobKillProgress = maxMobKillProgress;
    }

    public int getMaxDragonHealth() {
        return maxDragonHealth;
    }

    public void setMaxDragonHealth(int maxDragonHealth) {
        this.maxDragonHealth = maxDragonHealth;
    }

    public String getDragonName() {
        return dragonName;
    }

    public void setDragonName(String dragonName) {
        this.dragonName = dragonName;
    }

    public void incrementMobProgress(){
        this.mobProgress++;
    }

    public DragonMode getDragonMode() {
        return dragonMode;
    }

    public void setDragonMode(DragonMode dragonMode) {
        this.dragonMode = dragonMode;
    }
}
