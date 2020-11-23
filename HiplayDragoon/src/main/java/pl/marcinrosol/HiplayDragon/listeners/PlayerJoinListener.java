package pl.marcinrosol.HiplayDragon.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import pl.marcinrosol.HiplayDragon.HiplayDragon;
import pl.marcinrosol.HiplayDragon.entities.DragonMode;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        preparePlayer(event.getPlayer());
        event.getPlayer().sendMessage(HiplayDragon.instance.config.getString("message.hello"));
    }

    static void preparePlayer(Player player){
        if(!(player instanceof Player)) return;
        if(HiplayDragon.instance.gameCfg.getDragonMode() == DragonMode.END_GAME){
            player.setGameMode(GameMode.ADVENTURE);
        }else{
            player.setGameMode(GameMode.SURVIVAL);
            setInventory(player);
        }
    }

    private static void setInventory(Player player){
        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

        ItemStack leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
        leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

        ItemStack knife = new ItemStack(Material.DIAMOND_SWORD);
        knife.addEnchantment(Enchantment.DAMAGE_UNDEAD, 2);

        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
        bow.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

        player.getInventory().clear();
        player.getInventory().setHelmet(helmet);
        player.getInventory().setChestplate(chest);
        player.getInventory().setLeggings(leggins);
        player.getInventory().setBoots(boots);
        player.getInventory().setItem(0, knife);
        player.getInventory().setItem(1, bow);
        player.getInventory().setItem(27, new ItemStack(Material.ARROW));
        player.getInventory().setItem(8, new ItemStack(Material.COOKED_BEEF, 64));
    }

}
