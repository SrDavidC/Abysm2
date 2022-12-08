package abysm.abysm.game;

import abysm.abysm.Abysm;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PiglinBarterEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffectType;

public class GameListeners implements Listener {

    @EventHandler
    public void onPiglinGetGold(PiglinBarterEvent e) {
        if (Abysm.getPl().getDias() >= 15)
            e.setCancelled(true);
    }

    @EventHandler
    public void onInteractWithEntity(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() == Material.NAME_TAG || p.getInventory().getItemInOffHand().getType() == Material.NAME_TAG) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.DARK_AQUA + "[Abysm]" + ChatColor.RED + "You can't rename entities in Abysm");
        }
        if (Abysm.getPl().getDias() >= 15) {
            if (e.getRightClicked() instanceof Piglin) {
                if (p.getInventory().getItemInMainHand().getType() == Material.GOLD_INGOT || p.getInventory().getItemInOffHand().getType() == Material.GOLD_INGOT) {
                    e.setCancelled(true);
                    }
                }
            }
        }
   @EventHandler
   public void onSleep(PlayerBedEnterEvent e){
        if (Abysm.getPl().getDias() >= 15){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.DARK_AQUA + "[ABYSM] " + ChatColor.AQUA + "It's >15 day, YOU CAN'T SLEEP NOW  (\u2620Difficult Change)"  );
        }
   }

   @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e){

   }


}

