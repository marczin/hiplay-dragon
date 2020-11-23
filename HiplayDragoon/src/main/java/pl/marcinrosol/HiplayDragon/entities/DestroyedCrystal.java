package pl.marcinrosol.HiplayDragon.entities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import java.util.Date;

public class DestroyedCrystal {

    private Location location;
    private Date date;
    private boolean isDestroyed;

    public DestroyedCrystal(Location location) {
        this.location = location;
        this.date = new Date();
        this.isDestroyed = true;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void printObject(){
        Bukkit.broadcastMessage(ChatColor.GREEN+ "Location x y z :"+ location.getX() + " "+location.getY() + " "+location.getZ());
    }
}
