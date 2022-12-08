package abysm.abysm.Listeners;

import abysm.abysm.Abysm;
import lombok.var;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;


public class MobsListener implements Listener {

    ChatColor DRED = ChatColor.DARK_RED;
    ChatColor BOLD = ChatColor.BOLD;
    ChatColor GOLD = ChatColor.GOLD;


    //Bolas de ghast
    @EventHandler
    public void onMobShots(ProjectileLaunchEvent e) {
        if (e.getEntity() == null)
            return;
        if (e.getEntity().getShooter() instanceof Ghast) {
            Ghast ghast = (Ghast) e.getEntity().getShooter();
            if (ghast.getCustomName() == null){
                if (Abysm.getPl().getDias() >= 10) {
                    ((LargeFireball) e.getEntity()).setYield(8);
                }
            }
            else {

                if (Objects.requireNonNull(ghast.getCustomName()).equalsIgnoreCase(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "HANS GHAST EQUINEB") || ghast.getCustomName().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "HANS GHAST EQUINEA")) {
                    ((LargeFireball) e.getEntity()).setYield(10);
                } else if (ghast.getCustomName().equalsIgnoreCase(ChatColor.YELLOW + "" + ChatColor.BOLD + "GHAST" + " " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "DEMONIACO")) {
                    ((LargeFireball) e.getEntity()).setYield(13);
                }
            }
        }
//        else if(e.getEntity().getShooter() instanceof Skeleton){
//            Skeleton skeleton = (Skeleton) e.getEntity().getShooter();
//            if (Objects.requireNonNull(skeleton.getCustomName()).equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "SANS")){
//                World w = e.getEntity().getWorld();
//                e.setCancelled(true);
//                WitherSkull projectile = (WitherSkull) w.spawnEntity(e.getLocation(), EntityType.WITHER_SKULL);
//                projectile.setYield(8);
//                projectile.setVelocity(e.getEntity().getVelocity());
//            }
        //}
        else if (e.getEntity().getShooter() instanceof Player){
            Player player = (Player) e.getEntity().getShooter();
            if ( (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() && (Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getCustomModelData() == 132) )){
                player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH,100,-5F);
            }
        }
    }
    @EventHandler
    public void onShoot(EntityShootBowEvent e) {
        var bow = e.getBow().getItemMeta();
        if (!bow.hasCustomModelData())
            return;

        if (bow.getCustomModelData() == 201) {
            var skull = e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation().add(0, 1, 0),
                    EntityType.WITHER_SKULL);
            e.setProjectile(skull);

        }
    }

    //Explosiones de creeper y End Crystal
    @EventHandler
    public void onEntityExplotes(EntityExplodeEvent e) {
        if ((e.getEntity() instanceof Creeper)) {
            final Creeper creeper = (Creeper) e.getEntity();
            for (PotionEffect effect : creeper.getActivePotionEffects()
            ) {
                creeper.removePotionEffect(effect.getType());
            }
        }
        if (Objects.requireNonNull(e.getLocation().getWorld()).getEnvironment() == World.Environment.THE_END)
            if ((e.getEntity() instanceof EnderCrystal)) {
                World w = e.getEntity().getWorld();
                Ghast ghast = (Ghast) w.spawnEntity(e.getLocation(), EntityType.GHAST);
                ghast.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "GHAST" + " " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "DEMONIACO");
                ghast.setCustomNameVisible(true);
                AttributeInstance healthAttribute = ghast.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                assert healthAttribute != null;
                healthAttribute.setBaseValue(100);
                ghast.setHealth(100D);
            }
    }

    @EventHandler
    public void onEntityAttack(final EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() == EntityType.SMALL_FIREBALL) {
            final Fireball f = (Fireball) e.getDamager();
            if (f.getShooter() instanceof Blaze) {
                Blaze blaze = (Blaze) f.getShooter();
                if (Objects.requireNonNull(blaze.getCustomName()).equalsIgnoreCase(DRED + "" + BOLD + "Experimental " + GOLD + "" + BOLD + "InfernalDemon")) {
                    final Entity entity = e.getEntity();
                    if (entity instanceof LivingEntity) {
                        final LivingEntity liv = (LivingEntity) e.getEntity();
                        liv.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 20));
                        liv.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 400, 4));
                    }
                }
            }
        }
    }
}

