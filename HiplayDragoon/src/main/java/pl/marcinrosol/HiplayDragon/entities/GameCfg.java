package pl.marcinrosol.HiplayDragon.entities;

import pl.marcinrosol.HiplayDragon.HiplayDragon;

public class GameCfg{

    int mobProgress;
    int maxMobKillProgress;
    int maxDragonHealth;
    String dragonName;
    DragonMode dragonMode;
    int howManyMobKill;
    boolean updateScoreboard;
    public int countTaskId;
    public int countTime;

    public GameCfg() {
        this.mobProgress = 1;
        this.maxMobKillProgress = HiplayDragon.instance.config.getInt("event.max");
        this.maxDragonHealth = HiplayDragon.instance.config.getInt("event.maxDragonHealth");
        this.dragonName = HiplayDragon.instance.config.getString("event.dragonName");
        this.dragonMode = DragonMode.valueOf(HiplayDragon.instance.config.getString("event.dragonMode"));
        this.howManyMobKill = HiplayDragon.instance.config.getInt("event.howManyMobKill")+1;
        this.updateScoreboard = true;
        this.countTaskId = 0;
        this.countTime = 60;
    }

    public int getCountTime() {
        return countTime;
    }

    public void setCountTime(int countTime) {
        this.countTime = countTime;
    }

    public int getCountTaskId() {
        return countTaskId;
    }

    public void setCountTaskId(int countTaskId) {
        this.countTaskId = countTaskId;
    }

    public boolean isUpdateScoreboard() {
        return updateScoreboard;
    }

    public void setUpdateScoreboard(boolean updateScoreboard) {
        this.updateScoreboard = updateScoreboard;
    }

    public int getHowManyMobKill() {
        return howManyMobKill;
    }

    public void setHowManyMobKill(int howManyMobKill) {
        this.howManyMobKill = howManyMobKill;
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
