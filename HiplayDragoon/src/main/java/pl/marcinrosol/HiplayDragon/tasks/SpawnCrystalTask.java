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
        Bukkit.getScheduler().runTaskAsynchronously(HiplayDragon.instance, () -> {
            for (; ; ) {
                try {
                    checkCrystalLife();
                    Thread.sleep((20L));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

        });
    }

    private static void checkCrystalLife() {
        for (DestroyedCrystal dc : HiplayDragon.instance.destroyedCrystals) {
            long diffTime = (new Date().getTime() - dc.getDate().getTime()) / (60 * 1000) % 60;
            if (diffTime >= CrystalCfg.get().getInt("crystal.respawn.time")) {
                Bukkit.getScheduler().runTask(HiplayDragon.instance, () -> {
                    dc.setDestroyed(false);
                    spawnCrystal(dc.getLocation());
                });
            }
        }
        List<DestroyedCrystal> operatedList = new ArrayList<>();
        HiplayDragon.instance.destroyedCrystals.stream().filter(item -> !item.isDestroyed())
                .forEach(item -> operatedList.add(item));
        HiplayDragon.instance.destroyedCrystals.removeAll(operatedList);
    }

    private static void spawnCrystal(Location location){
        EnderCrystal crystal = (EnderCrystal) location.getWorld().spawnEntity(location, EntityType.ENDER_CRYSTAL);
    }
}
