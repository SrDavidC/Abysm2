package abysm.abysm.game;

import abysm.abysm.Abysm;
import abysm.abysm.discord.DiscordManager;
import abysm.abysm.managers.PlayerData;
import abysm.abysm.utils.PlayerUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class PlayerDeath implements Listener {

    Material[] fences = new Material[]{Material.CRIMSON_FENCE, Material.WARPED_FENCE, Material.NETHER_BRICK_FENCE};
    public String serverName = "Abysm";
    PlayerUtils playerUtils = PlayerUtils.getInstance();

    @EventHandler
    public void playerDeath(EntityDeathEvent e) {
        Jugadores jugadores = new Jugadores();
        if (!(e.getEntity() instanceof Player))
            return;
        Player playerMuerto = (Player) e.getEntity();
        String name = playerMuerto.getName().toUpperCase();

        int x = (int) playerMuerto.getLocation().getX();
        int y = (int) playerMuerto.getLocation().getY();
        int z = (int) playerMuerto.getLocation().getZ();
        String coordenadas = "Coordenadas: " + x + " " + y + " " + z + " " + playerMuerto.getWorld().getName();
        String razon = e.getEntity().getLastDamageCause().getCause().name();
        DiscordManager.getInstance().deathAnnounce(name, razon, coordenadas, false, 0);

        announceMessage(serverName, razon, false, playerMuerto, playerMuerto.getLocation());
        if (jugadores.getJugadores().containsKey(name)) {
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + jugadores.getJugadores().get(name));
        } else {
            Bukkit.broadcastMessage(ChatColor.ITALIC + "" + ChatColor.GRAY + name + " ha fallecido");
        }
        setPlayerHead(e.getEntity().getLocation(), Bukkit.getOfflinePlayer(playerMuerto.getUniqueId()));

        playerUtils.jugadores.get(name).setStorageI(saveInventory(playerMuerto,true));
        playerUtils.jugadores.get(name).setArmorI(saveInventory(playerMuerto,false));
        playerUtils.jugadores.get(name).setLocation(saveLocation(playerMuerto));
        if (playerMuerto.getInventory().getItemInOffHand() != null){playerUtils.jugadores.get(name).setOffhand((playerMuerto.getInventory().getItemInOffHand()));}
    }

    @EventHandler
    public void onTotem(EntityResurrectEvent e) {
        if (!(e.getEntity() instanceof Player))
            return;
        if (isTotem((Player) e.getEntity())) {
            int random = (int) ((Math.random() * 100) + 1);
            int prob = Abysm.getPl().getProbFallo();
            Player p = (Player) e.getEntity();
            if (random <= prob)
                e.setCancelled(true);

            int x = (int) p.getLocation().getX();
            int y = (int) p.getLocation().getY();
            int z = (int) p.getLocation().getZ();
            String name = p.getName();
            String coordenadas = x + " " + y + " " + z + " " + p.getWorld().getName();
            int cantTotem = p.getStatistic(Statistic.USE_ITEM, Material.TOTEM_OF_UNDYING);

            String cause = p.getLastDamageCause().getCause().toString();
            announceMessage(this.serverName, cause, true, p, p.getLocation());
            DiscordManager.getInstance().deathAnnounce(name, cause, coordenadas, true, cantTotem);
        }
    }

    public boolean isTotem(Player player) {
        return player.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING ||
                player.getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING;
    }

    public void setPlayerHead(Location l, OfflinePlayer p) {
        l.getBlock().setType(getRandomFence());
        Block head = l.getBlock().getRelative(BlockFace.UP);
        head.setType(Material.PLAYER_HEAD);

        if (head.getState() instanceof Skull) {
            Skull skull = (Skull) head.getState();
            skull.setOwningPlayer(p);
            skull.update();
        }
    }

    private Material getRandomFence() {
        return fences[new Random().nextInt(fences.length)];
    }

    public void announceMessage(String serverName, String razon, boolean totem, Player p, Location l) {
        String anuncio;
        String secondM;
        String totems;
        String totemPorcentage;
        String BLUE = ChatColor.of("#22EDFF") + "" + ChatColor.BOLD;
        String WHITE = ChatColor.WHITE + "";
        String GOLD = ChatColor.of("#FFD700") + "" + ChatColor.BOLD;

        int x = (int) p.getLocation().getX();
        int y = (int) p.getLocation().getY();
        int z = (int) p.getLocation().getZ();

        if (totem) {
            anuncio = GOLD + " T\u00D3TEM ";
            secondM = GOLD + " USADO TOTEM ";
            totems = BLUE + " # T\u00F3tems: " + ChatColor.WHITE + (p.getStatistic(Statistic.USE_ITEM, Material.TOTEM_OF_UNDYING) + 1);
        } else {
            anuncio = BLUE + " MUERTE ";
            secondM = BLUE + " MUERTO ";
            totems = "";
            /*
            NOTA: TENES QUE AGREGAR TAMBIEN EL PORCENTAJE DEL TOTEM QUE FUE
             */
        }
        Bukkit.broadcastMessage(anuncio + ChatColor.DARK_GRAY + "\u300c" + WHITE + serverName + ChatColor.DARK_GRAY + "\u300d" + "\n\n" +
                ChatColor.of("#22EDFF") + " \u25ba " + ChatColor.WHITE + "" + ChatColor.UNDERLINE + p.getName() + WHITE + " ha" + secondM + WHITE + "en " + BLUE + " X: " + ChatColor.WHITE + x + BLUE + " Y: " + ChatColor.WHITE + y + BLUE + " Z: " +
                WHITE + z + " " + BLUE + l.getWorld().getName() + "\n" + totems + " " + BLUE + " RAZON:" + WHITE + " " + razon + "\n");
    }

    public ItemStack[] saveInventory(Player p, Boolean inv) {
        ItemStack[] inventario;
        if (inv) {inventario =  p.getInventory().getStorageContents();}
        else{inventario =  p.getInventory().getArmorContents(); }
        return inventario;
    }

    public Location saveLocation(Player p) {
        if (p != null)
            return p.getLocation();
        Location l = new Location(p.getWorld(), 0, 80, 0);
        return l;
    }


}
