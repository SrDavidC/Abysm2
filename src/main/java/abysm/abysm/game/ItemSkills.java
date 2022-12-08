package abysm.abysm.game;

import abysm.abysm.Abysm;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;


public class ItemSkills implements Listener {

    @EventHandler
    public void onTotem(EntityResurrectEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (player.getInventory().getItemInOffHand().hasItemMeta()) {
                if (player.getInventory().getItemInOffHand().getItemMeta().hasCustomModelData()) {
                    if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 41) {
                        player.getInventory().addItem(new ItemStack(Material.TOTEM_OF_UNDYING));
                        player.getInventory().addItem(new ItemStack(Material.TOTEM_OF_UNDYING));
                    }
                }
            }
        }
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        if (e.getItem().hasItemMeta()) {
            if (e.getItem().getItemMeta().getDisplayName() != null) {

                if (e.getItem().getType() == Material.GOLDEN_APPLE) {
                    String name = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "SUPER GOLDEN APPLE";
                    if (Objects.requireNonNull(e.getItem().getItemMeta()).getDisplayName().equalsIgnoreCase(name)) {
                        e.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
                        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 4800, 1));
                    }
                }

            }
        }
    }

    @EventHandler
    public void SpecialShoots(EntityShootBowEvent e) {
        if (e.getProjectile() == null)
            return;

        if (Objects.requireNonNull(Objects.requireNonNull(e.getBow()).getItemMeta()).hasCustomModelData()) {
            int model = Objects.requireNonNull(e.getBow().getItemMeta()).getCustomModelData();
            Entity proj = e.getProjectile();
            switch (model) {
                case 132:
                    proj.setMetadata("explosive_arrow", new FixedMetadataValue(Abysm.getPl(), true));
                    break;
                case 133:
                    proj.setMetadata("explosiveLow_arrow", new FixedMetadataValue(Abysm.getPl(), true));
                    break;

            }
        }
    }

    @EventHandler
    public void hit(ProjectileHitEvent e) {
        if (e.getEntity() == null)
            return;

        Location loc = e.getEntity().getLocation();
        World world = loc.getWorld();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        if (e.getEntity().hasMetadata("explosive_arrow")) {
            assert world != null;
            e.getEntity().remove();
            world.createExplosion(x, y, z, 9, false, false);
        } else if (e.getEntity().hasMetadata("explosiveLow_arrow")) {
            e.getEntity().remove();
            assert world != null;
            if (Abysm.getPl().getDias() < 15) {
                world.createExplosion(x, y, z, 4, false, false);
            } else {
                world.createExplosion(x, y, z, 6, false, false);
            }
        }
    }
}


