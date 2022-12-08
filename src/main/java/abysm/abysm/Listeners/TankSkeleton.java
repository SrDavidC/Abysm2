package abysm.abysm.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

public class TankSkeleton implements Listener {
    @EventHandler
    public void onSpawn(EntitySpawnEvent e){

        if (!(e.getEntity() instanceof Skeleton))
            return;
        if (e.getLocation().getBlock().isLiquid())
            return;
        if ((int) (Math.random()*10) == 1) {
            //e.setCancelled(true);

            Skeleton sk = (Skeleton) e.getEntity();

            sk.setCustomName(ChatColor.BOLD + "" + ChatColor.GRAY +
                    "TANK SKELETON");
            sk.setHealth(20.0);
            sk.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
            sk.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            sk.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            sk.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
            ItemStack crossbow = new ItemStack(Material.CROSSBOW);

            CrossbowMeta meta = (CrossbowMeta) crossbow.getItemMeta();
            meta.setUnbreakable(true);
            meta.addChargedProjectile(new ItemStack(Material.ARROW));
            crossbow.setItemMeta(meta);
            sk.getEquipment().setItemInMainHand(crossbow);
        }
    }

}
