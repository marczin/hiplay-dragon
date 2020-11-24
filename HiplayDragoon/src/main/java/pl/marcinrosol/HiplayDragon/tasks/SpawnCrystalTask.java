package pl.marcinrosol.HiplayDragon.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;
import pl.marcinrosol.HiplayDragon.HiplayDragon;
import pl.marcinrosol.HiplayDragon.entities.CrystalCfg;
import pl.marcinrosol.HiplayDragon.entities.DestroyedCrystal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class SpawnCrystalTask {

    public static void crystalTask() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(HiplayDragon.instance, () -> {
                try {
                    checkCrystalLife();
                    Thread.sleep((20L));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

        }, 0, 20L);
    }

    private static void checkCrystalLife() {
        Date currentDate = new Date();
        for (DestroyedCrystal dc : HiplayDragon.instance.destroyedCrystalList) {
            if(dc.isDestroyed()) {
                long diffTime = (currentDate.getTime() - dc.getDate().getTime()) / (60 * 1000) % 60;
                if (diffTime >= CrystalCfg.get().getInt("crystal.respawn.time")) {
                    dc.setDestroyed(false);
                    Bukkit.getScheduler().runTask(HiplayDragon.instance, () -> spawnCrystal(dc.getLocation()));
                }
            }
        }
        List<DestroyedCrystal> operatedList = new ArrayList<>();
        HiplayDragon.instance.destroyedCrystalList.stream().filter(item -> !item.isDestroyed())
                .forEach(item -> operatedList.add(item));
        HiplayDragon.instance.destroyedCrystalList.removeAll(operatedList);
        HiplayDragon.instance.gameCfg.setUpdateScoreboard(true);
    }

    private static void spawnCrystal(Location location){
        EnderCrystal crystal = (EnderCrystal) location.getWorld().spawnEntity(location, EntityType.ENDER_CRYSTAL);
    }
}
