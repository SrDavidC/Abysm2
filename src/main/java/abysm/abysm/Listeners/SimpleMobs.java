package abysm.abysm.Listeners;

import abysm.abysm.Abysm;
import lombok.var;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class SimpleMobs implements Listener {
    Abysm instance = Abysm.getPl();
    Random random = new Random();

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e ) {
        var entity = e.getEntity();
        final var difficulty = instance.getGame().getDifficultyChanges();
        if (difficulty.get("dia1")) {
            if (entity instanceof Skeleton) {
                var sk = (Skeleton) entity;
                sk.addPotionEffect(new PotionEffect((PotionEffectType.JUMP), 5000, 0));
            } else if (entity instanceof Zombie) {
                var zb = (Zombie) entity;
                zb.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(26);
                zb.setHealth(26);
            }
        }
    }
}
