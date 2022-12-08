package abysm.abysm.Listeners;

import abysm.abysm.Abysm;
import abysm.abysm.utils.Items;
import lombok.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class Naturally implements Listener {
    Abysm instace = Abysm.getPl();
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e){
        Entity entity = e.getEntity();
        if (instace.getDias() >= 20){
            if (entity instanceof Slime){
                var slime = (Slime) entity;
                if (e.getSpawnReason() != CreatureSpawnEvent.SpawnReason.SLIME_SPLIT)
                    slime.setSize(8);
            }
        }
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e){
        Items items = new Items();
        var block = e.getBlock();
        var type = e.getBlock().getType();
        var w = e.getPlayer().getWorld();
        if (e.getBlock().getType() == Material.BEE_NEST ){
            var count = 0;
            var max = 20;
            while (count < max) {
                block.getWorld().spawnEntity(block.getLocation(), EntityType.BEE);
                count++;
            }
        }
        if (type == Material.SMOOTH_BASALT){
            e.setCancelled(true);
            block.setType(Material.AIR);
            w.dropItem(e.getBlock().getLocation(), items.getShinyNetheriteOre());
        }
    }
}
