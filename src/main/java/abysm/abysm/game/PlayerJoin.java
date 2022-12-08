package abysm.abysm.game;

import abysm.abysm.Abysm;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.sendMessage(ChatColor.DARK_AQUA + "Welcome "+ player.getName()+ " to ABYSM\n" +
                ChatColor.AQUA + "Day: " + Abysm.getPl().getDias());
        player.playSound(player.getLocation(), Sound.ITEM_TRIDENT_THUNDER, 40,1);
        player.sendTitle(ChatColor.AQUA + ""+ChatColor.BOLD + "Welcome " + player.getName()+ " to Abysm","", 10,40,50);
    }
}
